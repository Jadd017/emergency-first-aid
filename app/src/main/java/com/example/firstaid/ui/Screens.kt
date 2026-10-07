package com.example.firstaid.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstaid.data.EMERGENCY_NUMBER
import com.example.firstaid.data.Emergency
import com.example.firstaid.data.Step
import com.example.firstaid.data.allEmergencies

private val CardShape = RoundedCornerShape(16.dp)

/** Removes the developer "VERIFY ..." markers so users never see them. */
private fun cleanText(s: String): String =
    s.replace(Regex("\\s*VERIFY(\\s+\\w+)?\\s*$"), "")

private fun iconFor(id: String): String = when (id) {
    "choking" -> "😮"
    "bleeding" -> "🩸"
    "burns" -> "🔥"
    "heart_attack" -> "❤️"
    "stroke" -> "🧠"
    "cpr" -> "💓"
    "fainting" -> "😵"
    "seizure" -> "🌀"
    "allergic", "allergic_reaction" -> "🤧"
    "asthma" -> "🌬️"
    "poisoning" -> "☠️"
    "drowning" -> "🌊"
    "heatstroke" -> "🌡️"
    "fracture" -> "🦴"
    "nosebleed" -> "👃"
    "head_injury" -> "🤕"
    "electric_shock" -> "🔌"
    "bites", "bites_stings" -> "🐍"
    "eye_injury" -> "👁️"
    "low_blood_sugar" -> "🍬"
    else -> "🚑"
}

// ------------------------------------------------------------ Building blocks

/** Page frame: white top bar, scrolling content, fixed bottom bar. */
@Composable
private fun Page(
    title: String,
    onBack: (() -> Unit)?,
    bottom: @Composable () -> Unit,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(Modifier.fillMaxSize()) {
        Row(
            Modifier.fillMaxWidth().background(Brand.Card).padding(horizontal = 8.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (onBack != null) {
                TextButton(onClick = onBack) {
                    Text("← Back", fontSize = 17.sp, fontWeight = FontWeight.SemiBold, color = Brand.Ink)
                }
                Spacer(Modifier.width(4.dp))
            } else {
                Spacer(Modifier.width(8.dp))
            }
            Text(title, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Brand.Ink)
        }
        Box(Modifier.fillMaxWidth().height(1.dp).background(Brand.Border))

        Column(
            Modifier.weight(1f).fillMaxWidth().verticalScroll(rememberScrollState()).padding(16.dp),
            content = content
        )

        Box(Modifier.fillMaxWidth().height(1.dp).background(Brand.Border))
        Column(Modifier.fillMaxWidth().background(Brand.Card).padding(12.dp)) { bottom() }
    }
}

@Composable
private fun Card(
    modifier: Modifier = Modifier,
    background: Color = Brand.Card,
    border: Color = Brand.Border,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier.fillMaxWidth()
            .background(background, CardShape)
            .border(1.dp, border, CardShape)
            .padding(16.dp),
        content = content
    )
}

@Composable
private fun SectionLabel(text: String, color: Color) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(Modifier.size(10.dp).background(color, CircleShape))
        Spacer(Modifier.width(8.dp))
        Text(text, fontSize = 15.sp, fontWeight = FontWeight.Bold, color = color, letterSpacing = 0.8.sp)
    }
    Spacer(Modifier.height(10.dp))
}

@Composable
private fun EmergencyTile(e: Emergency, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Row(
        modifier
            .heightIn(min = 68.dp)
            .clip(CardShape)
            .background(Brand.Card)
            .border(1.dp, Brand.Border, CardShape)
            .clickable { onClick() }
            .padding(horizontal = 14.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(iconFor(e.id), fontSize = 26.sp)
        Spacer(Modifier.width(10.dp))
        Text(e.title, fontSize = 16.sp, fontWeight = FontWeight.SemiBold, color = Brand.Ink, lineHeight = 20.sp)
    }
}

@Composable
private fun EmergencyRow(e: Emergency, onClick: () -> Unit) {
    Row(
        Modifier.fillMaxWidth()
            .heightIn(min = 64.dp)
            .clip(CardShape)
            .background(Brand.Card)
            .border(1.dp, Brand.Border, CardShape)
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(iconFor(e.id), fontSize = 26.sp)
        Spacer(Modifier.width(14.dp))
        Text(
            e.title, fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Brand.Ink,
            modifier = Modifier.weight(1f)
        )
        Text("›", fontSize = 28.sp, color = Brand.InkSoft)
    }
}

@Composable
private fun EmergencyList(items: List<Emergency>, onPick: (Emergency) -> Unit) {
    items.forEach { e ->
        EmergencyRow(e) { onPick(e) }
        Spacer(Modifier.height(10.dp))
    }
}

// ---------------------------------------------------------------- Home

@Composable
fun HomeScreen(
    onSend: (String) -> Unit,
    onPick: (Emergency) -> Unit,
    onShowAll: () -> Unit
) {
    var text by remember { mutableStateOf("") }
    val quickIds = listOf("choking", "bleeding", "burns", "heart_attack", "stroke", "allergic_reaction", "allergic")
    val quick = quickIds
        .mapNotNull { id -> allEmergencies.find { it.id == id } }
        .distinctBy { it.id }
        .take(6)

    Column(Modifier.fillMaxSize()) {
        // Branded top bar
        Row(
            Modifier.fillMaxWidth().background(Brand.Card).padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                Modifier.size(40.dp).background(Brand.Red, RoundedCornerShape(10.dp)),
                contentAlignment = Alignment.Center
            ) { Text("+", fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Color.White) }
            Spacer(Modifier.width(12.dp))
            Column {
                Text("First Aid", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Brand.Ink)
                Text("Works offline", fontSize = 13.sp, color = Brand.InkSoft)
            }
        }
        Box(Modifier.fillMaxWidth().height(1.dp).background(Brand.Border))

        Column(
            Modifier.weight(1f).fillMaxWidth().verticalScroll(rememberScrollState()).padding(16.dp)
        ) {
            Card {
                Text("What happened?", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Brand.Ink)
                Spacer(Modifier.height(4.dp))
                Text("Describe it in a few words.", fontSize = 15.sp, color = Brand.InkSoft)
                Spacer(Modifier.height(12.dp))
                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    placeholder = { Text("e.g. my friend is choking") },
                    textStyle = TextStyle(fontSize = 18.sp, color = Brand.Ink),
                    minLines = 2
                )
                Spacer(Modifier.height(12.dp))
                Button(
                    onClick = { if (text.isNotBlank()) onSend(text) },
                    enabled = text.isNotBlank(),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Brand.Ink,
                        contentColor = Color.White,
                        disabledContainerColor = Brand.Border,
                        disabledContentColor = Brand.InkSoft
                    ),
                    modifier = Modifier.fillMaxWidth().height(54.dp)
                ) { Text("Get help", fontSize = 18.sp, fontWeight = FontWeight.Bold) }
            }

            Spacer(Modifier.height(22.dp))
            Text("Common emergencies", fontSize = 17.sp, fontWeight = FontWeight.Bold, color = Brand.Ink)
            Spacer(Modifier.height(10.dp))
            quick.chunked(2).forEach { pair ->
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    pair.forEach { e ->
                        EmergencyTile(e, onClick = { onPick(e) }, modifier = Modifier.weight(1f))
                    }
                    if (pair.size == 1) Spacer(Modifier.weight(1f))
                }
                Spacer(Modifier.height(10.dp))
            }
            Spacer(Modifier.height(4.dp))
            Box(
                Modifier.fillMaxWidth()
                    .heightIn(min = 52.dp)
                    .clip(CardShape)
                    .border(1.dp, Brand.Border, CardShape)
                    .clickable { onShowAll() },
                contentAlignment = Alignment.Center
            ) {
                Text("See all emergencies", fontSize = 16.sp, fontWeight = FontWeight.SemiBold, color = Brand.Ink)
            }
            Spacer(Modifier.height(8.dp))
        }

        Box(Modifier.fillMaxWidth().height(1.dp).background(Brand.Border))
        Column(Modifier.fillMaxWidth().background(Brand.Card).padding(12.dp)) { CallButton() }
    }
}

// ---------------------------------------------------------------- Result

@Composable
fun ResultScreen(e: Emergency, onBack: () -> Unit) {
    Page(
        title = e.title,
        onBack = onBack,
        bottom = { CallButton(big = e.callNow) }
    ) {
        if (e.callNow) {
            Card(background = Brand.RedSoft, border = Brand.Red) {
                Text(
                    "Call $EMERGENCY_NUMBER now",
                    fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Brand.RedDark
                )
                Spacer(Modifier.height(2.dp))
                Text("Then follow the steps below while you wait.", fontSize = 16.sp, color = Brand.Ink)
            }
            Spacer(Modifier.height(14.dp))
        }

        Card {
            SectionLabel("DO THIS FIRST", Brand.Green)
            e.steps.forEachIndexed { i, step ->
                if (i > 0) {
                    Box(Modifier.fillMaxWidth().height(1.dp).background(Brand.Border))
                }
                StepRow(i + 1, step)
            }
        }

        Spacer(Modifier.height(14.dp))
        Card(background = Brand.RedSoft, border = Color(0xFFF2C6C6)) {
            SectionLabel("DON'T", Brand.Red)
            e.donts.forEach { BulletLine("✕", cleanText(it), Brand.Red) }
        }

        Spacer(Modifier.height(14.dp))
        Card(background = Brand.AmberSoft, border = Color(0xFFF1DDA6)) {
            SectionLabel("CALL $EMERGENCY_NUMBER WHEN", Brand.Amber)
            e.callWhen.forEach { BulletLine("•", cleanText(it), Brand.Amber) }
        }

        Spacer(Modifier.height(16.dp))
        Text(
            "This is first aid guidance, not a substitute for professional medical care.",
            fontSize = 13.sp, color = Brand.InkSoft, lineHeight = 18.sp
        )
        Spacer(Modifier.height(8.dp))
    }
}

@Composable
private fun BulletLine(bullet: String, text: String, color: Color) {
    Row(Modifier.fillMaxWidth().padding(vertical = 5.dp)) {
        Text(
            bullet, fontSize = 18.sp, color = color, fontWeight = FontWeight.Bold,
            modifier = Modifier.width(26.dp)
        )
        Text(text, fontSize = 18.sp, lineHeight = 25.sp, color = Brand.Ink, modifier = Modifier.weight(1f))
    }
}

@Suppress("DiscouragedApi")
@Composable
private fun StepRow(number: Int, step: Step) {
    val context = LocalContext.current
    // Looks up the drawable by name; a missing image is simply not shown.
    val resId = remember(step.imageName) {
        step.imageName?.let { context.resources.getIdentifier(it, "drawable", context.packageName) } ?: 0
    }
    Row(Modifier.fillMaxWidth().padding(vertical = 12.dp), verticalAlignment = Alignment.Top) {
        Box(
            Modifier.size(30.dp).background(Brand.Green, CircleShape),
            contentAlignment = Alignment.Center
        ) { Text("$number", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White) }
        Spacer(Modifier.width(12.dp))
        Text(
            cleanText(step.text),
            fontSize = 18.sp, lineHeight = 25.sp, color = Brand.Ink,
            modifier = Modifier.weight(1f)
        )
        if (resId != 0) {
            Spacer(Modifier.width(10.dp))
            Box(
                Modifier.size(84.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.White)
                    .border(1.dp, Brand.Border, RoundedCornerShape(12.dp))
            ) {
                Image(
                    painterResource(resId),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize().padding(2.dp)
                )
            }
        }
    }
}

// ---------------------------------------------------------------- Close matches

@Composable
fun ChooseScreen(options: List<Emergency>, onPick: (Emergency) -> Unit, onBack: () -> Unit) {
    Page(title = "Which is closest?", onBack = onBack, bottom = { CallButton() }) {
        Text("Tap the one that fits best.", fontSize = 16.sp, color = Brand.InkSoft)
        Spacer(Modifier.height(14.dp))
        EmergencyList(options, onPick)
    }
}

// ---------------------------------------------------------------- No match / all

@Composable
fun NoMatchScreen(onPick: (Emergency) -> Unit, onBack: () -> Unit) {
    Page(title = "Not sure", onBack = onBack, bottom = { CallButton(big = true) }) {
        Card(background = Brand.AmberSoft, border = Color(0xFFF1DDA6)) {
            Text(
                "I'm not sure what this is.",
                fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Brand.Ink
            )
            Spacer(Modifier.height(4.dp))
            Text("If it's serious, call $EMERGENCY_NUMBER now.", fontSize = 17.sp, color = Brand.Ink)
        }
        Spacer(Modifier.height(18.dp))
        Text("Or choose an emergency", fontSize = 17.sp, fontWeight = FontWeight.Bold, color = Brand.Ink)
        Spacer(Modifier.height(10.dp))
        EmergencyList(allEmergencies, onPick)
    }
}

@Composable
fun AllScreen(onPick: (Emergency) -> Unit, onBack: () -> Unit) {
    Page(title = "All emergencies", onBack = onBack, bottom = { CallButton() }) {
        EmergencyList(allEmergencies, onPick)
    }
}