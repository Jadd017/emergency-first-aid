package com.example.firstaid.logic

import com.example.firstaid.data.Emergency
import com.example.firstaid.data.allEmergencies
import kotlin.math.abs

/** Result of matching what the user typed. */
sealed class MatchOutcome {
    /** One clear winner: show its instructions. */
    data class Single(val emergency: Emergency) : MatchOutcome()

    /** Two or three close candidates: let the user choose. */
    data class Close(val options: List<Emergency>) : MatchOutcome()

    /** Nothing matched: show Call button + list of all emergencies. */
    data object None : MatchOutcome()
}

/**
 * Offline keyword matcher. No internet, no AI, so it can never invent advice.
 *
 * What it understands:
 *  - word forms:    burn / burns / burned / burning / burnt
 *  - small typos:   "choaking", "bleading", "drowing"
 *  - word order:    "pain in my chest" matches the keyword "chest pain"
 *  - long sentences: "my friend is burning and screaming"
 */
object Matcher {

    // A runner-up must score at least this fraction of the winner to be offered as a choice.
    private const val CLOSE_RATIO = 0.7

    // Extra words around a multi-word keyword that are still allowed ("pain in my chest").
    private const val WINDOW_SLACK = 3

    private fun normalize(s: String): String =
        s.lowercase()
            .replace("'", "")
            .replace("’", "")
            .replace(Regex("[^a-z0-9 ]"), " ")
            .replace(Regex("\\s+"), " ")
            .trim()

    /** Very light word-ending cleanup: plural "s" and a final "e". */
    private fun base(w: String): String {
        var x = w
        if (x.length > 3 && x.endsWith("s") && !x.endsWith("ss")) x = x.dropLast(1)
        if (x.length >= 5 && x.endsWith("e")) x = x.dropLast(1)
        return x
    }

    private fun distance(a: String, b: String): Int {
        var prev = IntArray(b.length + 1) { it }
        for (i in 1..a.length) {
            val cur = IntArray(b.length + 1)
            cur[0] = i
            for (j in 1..b.length) {
                val cost = if (a[i - 1] == b[j - 1]) 0 else 1
                cur[j] = minOf(cur[j - 1] + 1, prev[j] + 1, prev[j - 1] + cost)
            }
            prev = cur
        }
        return prev[b.length]
    }

    /** True when two single words should be treated as the same word. */
    private fun sameWord(a: String, b: String): Boolean {
        if (a == b) return true
        val ba = base(a)
        val bb = base(b)
        if (ba == bb) return true

        // burn / burning / burned, bleed / bleeding, choke / choking
        val shortLen = minOf(ba.length, bb.length)
        val longLen = maxOf(ba.length, bb.length)
        if (shortLen >= 4 && longLen - shortLen <= 3 && (ba.startsWith(bb) || bb.startsWith(ba))) return true

        // typos in longer words
        if (a[0] == b[0] && abs(a.length - b.length) <= 2) {
            val m = minOf(a.length, b.length)
            val d = distance(a, b)
            if (m >= 5 && d <= 1) return true
        }
        return false
    }

    /**
     * Positions in [words] covered by [phrase], or null when the phrase is not there.
     * A multi-word phrase matches in any order inside a short stretch of the sentence.
     */
    private fun positions(words: List<String>, phrase: List<String>): List<Int>? {
        val n = words.size
        val k = phrase.size
        if (k == 0 || k > n) return null

        if (k == 1) {
            val hits = words.indices.filter { sameWord(words[it], phrase[0]) }
            return if (hits.isEmpty()) null else hits
        }

        val win = minOf(n, k + WINDOW_SLACK)
        for (start in 0..(n - win)) {
            val used = BooleanArray(win)
            val found = ArrayList<Int>()
            var ok = true
            for (pw in phrase) {
                var hit = -1
                for (i in 0 until win) {
                    if (!used[i] && sameWord(words[start + i], pw)) {
                        hit = i
                        break
                    }
                }
                if (hit < 0) {
                    ok = false
                    break
                }
                used[hit] = true
                found.add(start + hit)
            }
            if (ok) return found
        }
        return null
    }

    private class Entry(val emergency: Emergency, val phrases: List<List<String>>)

    // Keywords from the content file + the extra vocabulary, normalized once.
    private val entries: List<Entry> by lazy {
        allEmergencies.map { e ->
            val all = e.keywords + (ExtraKeywords.map[e.id] ?: emptyList())
            val phrases = all
                .map { normalize(it) }
                .filter { it.isNotEmpty() }
                .distinct()
                .map { it.split(" ") }
            Entry(e, phrases)
        }
    }

    fun match(input: String): MatchOutcome {
        val words = normalize(input).split(" ").filter { it.isNotEmpty() }
        if (words.isEmpty()) return MatchOutcome.None

        val scored = entries
            .map { entry ->
                val covered = HashSet<Int>()
                var multiWordHits = 0
                for (phrase in entry.phrases) {
                    val pos = positions(words, phrase) ?: continue
                    covered.addAll(pos)
                    if (phrase.size > 1) multiWordHits++
                }
                // More covered words = better; multi-word hits are more specific.
                entry.emergency to (covered.size + multiWordHits)
            }
            .filter { it.second > 0 }
            .sortedWith(
                compareByDescending<Pair<Emergency, Int>> { it.second }
                    .thenByDescending { it.first.callNow } // life-threatening first on ties
            )

        if (scored.isEmpty()) return MatchOutcome.None

        val top = scored.first().second
        val close = scored
            .filter { it.second >= top * CLOSE_RATIO }
            .take(3)
            .map { it.first }

        return if (close.size == 1) MatchOutcome.Single(close.first())
        else MatchOutcome.Close(close)
    }
}