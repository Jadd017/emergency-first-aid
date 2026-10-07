package com.example.firstaid.logic

/**
 * Extra words and phrases people type for each emergency.
 * The keys are the emergency ids from FirstAidData.kt.
 * These are ADDED to the keywords already written in FirstAidData.kt.
 * To teach the app a new word, just add it to the right list.
 * Apostrophes are ignored, so "can't" and "cant" are the same.
 */
object ExtraKeywords {
    private val base: Map<String, List<String>> = mapOf(

        "choking" to listOf(
            "choking", "choke", "choked", "chocking", "choaking", "chokeing",
            "cant breathe", "cannot breathe", "not able to breathe", "cant swallow",
            "something stuck in throat", "stuck in throat", "stuck in his throat", "stuck in her throat",
            "food stuck", "food in throat", "swallowed wrong", "went down the wrong way",
            "swallowed something", "swallowed a coin", "swallowed a toy", "swallowed a bone",
            "fish bone", "bone stuck", "coin stuck", "toy stuck", "candy stuck",
            "gagging", "gasping", "cant talk", "cant speak", "cant cough", "not coughing",
            "turning blue", "hands on throat", "grabbing throat",
            "holding throat", "clutching throat", "lodged in throat", "baby choking", "child choking",
            "something in throat", "stuck in windpipe", "airway blocked", "blocked airway"
        ),

        "bleeding" to listOf(
            "bleeding", "bleed", "bleeds", "bleading", "bleeding heavily", "bleeding a lot",
            "bleeding badly", "bleeding too much", "bleeding wont stop", "wont stop bleeding",
            "blood", "bloody", "blood everywhere", "lots of blood", "a lot of blood", "losing blood",
            "blood loss", "blood pouring", "blood gushing", "blood spurting", "blood flowing",
            "cut", "cuts", "deep cut", "big cut", "bad cut", "cut himself", "cut herself", "cut my hand", "cut his hand",
            "cut finger", "cut leg", "cut arm", "gash", "wound", "wounded", "open wound",
            "stab", "stabbed", "stabbing", "knife", "knife cut", "glass cut", "cut by glass", "broken glass",
            "gunshot", "gun shot", "shot", "shot in", "got shot", "bullet", "sliced", "slashed",
            "laceration", "severed", "amputated", "finger cut off", "cut off finger", "hemorrhage", "haemorrhage",
            "bleeding from head", "bleeding from leg", "bleeding from arm", "scalp bleeding"
        ),

        "burns" to listOf(
            "burn", "burns", "burned", "burnt", "burning", "burnin",
            "on fire", "caught fire", "catching fire", "set on fire", "in flames", "fire", "flames", "flame",
            "scald", "scalded", "scalding", "hot water", "boiling water", "boiling", "boiled", "hot oil",
            "oil splashed", "hot stove", "stove", "hot pan", "hot pot", "kettle", "hot tea", "hot coffee", "hot soup",
            "spilled hot", "spilled boiling", "hot iron", "iron burn", "steam burn", "steam", "sunburn", "sun burn",
            "blister", "blisters", "blistered", "exploded", "explosion", "gas explosion", "gas cylinder",
            "candle", "firework", "fireworks", "lighter", "skin burning", "skin burnt", "skin peeling",
            "acid burn", "heater", "burned by", "burnt by", "touched hot", "hot metal", "grease fire", "kitchen fire"
        ),

        "heart_attack" to listOf(
            "heart attack", "hart attack", "heartattack", "heart attacks", "having a heart attack",
            "chest pain", "chest pains", "chest hurts", "chest hurting", "chest ache", "chest aching",
            "pain in chest", "pain in my chest", "pain in his chest", "pain in her chest",
            "chest pressure", "pressure in chest", "chest tightness", "squeezing chest", "crushing chest",
            "crushing pain", "heavy chest", "heart pain", "heart hurts", "heart problem", "heart racing",
            "heart pounding", "cardiac", "pain in left arm", "left arm pain", "pain in arm", "arm pain and sweating",
            "pain in jaw", "jaw pain", "pain in neck", "pain spreading", "pain spreading to arm",
            "cold sweat", "cold sweats", "sweating and pain", "sweating and chest pain", "chest and arm",
            "nausea and chest", "short of breath and chest", "not feeling well chest"
        ),

        "stroke" to listOf(
            "stroke", "strokes", "having a stroke", "mini stroke",
            "face drooping", "face droop", "face drops", "face dropping", "droopy face", "drooping face",
            "mouth drooping", "mouth droop", "crooked smile", "uneven smile", "one side of face", "half of face",
            "slurred", "slurring", "slurred speech", "speech slurred", "speaking strange", "talking strange",
            "cant speak properly", "trouble speaking", "difficulty speaking", "words wrong", "confused speech",
            "arm weak", "arm weakness", "weak arm", "arm numb", "numb arm", "numbness", "numb", "numb face", "face numb",
            "one side weak", "weakness on one side", "one side numb", "cant lift arm", "cant raise arm",
            "arm drifting", "sudden confusion", "suddenly confused", "sudden headache", "worst headache",
            "sudden dizziness", "cant see", "vision loss", "lost vision", "blurred vision", "double vision",
            "lost balance", "cant walk straight", "paralyzed", "paralysis", "cant move one side", "fast test"
        ),

        "cpr" to listOf(
            "unresponsive", "not responding", "wont respond", "no response", "not breathing", "stopped breathing",
            "isnt breathing", "no breathing", "stopped breathing completely", "wont wake", "wont wake up",
            "cant wake", "cant wake him", "cant wake her", "not waking", "not waking up", "unconscious",
            "lost consciousness", "passed out and not breathing", "no pulse", "cpr", "cardiac arrest",
            "heart stopped", "heart stopping", "not moving", "lifeless", "collapsed and not breathing",
            "looks dead", "dead", "dying", "blue and not breathing", "out cold", "limp", "not responsive"
        ),

        "fainting" to listOf(
            "faint", "fainted", "fainting", "faints", "passed out", "pass out", "passing out", "blackout",
            "blacked out", "black out", "blacking out", "dizzy", "dizziness", "lightheaded", "light headed",
            "feel faint", "feeling faint", "about to faint", "going to faint", "going to pass out", "woozy",
            "everything went black", "vision going dark", "vision went dark", "fell down dizzy",
            "collapsed suddenly", "suddenly collapsed", "collapsed", "fell unconscious", "lost consciousness briefly",
            "feeling weak and dizzy", "spinning", "room spinning", "knees buckled"
        ),

        "seizure" to listOf(
            "seizure", "seizures", "seizing", "convulsion", "convulsions", "convulsing", "convulse",
            "having a fit", "had a fit", "a fit", "epilepsy", "epileptic", "epilepsia", "shaking uncontrollably",
            "jerking", "jerks", "twitching", "foaming", "foaming at mouth", "foam from mouth",
            "shaking and unconscious", "eyes rolled back", "eyes rolling back", "body stiff", "stiff and shaking",
            "trembling uncontrollably", "spasm", "spasms", "fell and shaking", "shaking all over", "limbs shaking"
        ),

        "allergic" to listOf(
            "allergic", "allergy", "allergies", "anaphylaxis", "anaphylactic", "allergic reaction",
            "swollen lips", "swollen face", "swollen tongue", "swollen throat", "swelling lips", "swelling face",
            "swelling tongue", "throat closing", "throat swelling", "throat tight", "throat itchy",
            "hives", "rash", "rash all over", "itchy rash", "itchy all over", "itching all over", "swelling all over",
            "peanut", "peanuts", "nut allergy", "nuts", "food allergy", "ate nuts", "shellfish", "reaction to",
            "allergic to", "epipen", "auto injector", "cant breathe after eating", "bee allergy", "medicine allergy",
            "puffy face", "puffy lips", "red and itchy", "swollen eyes", "lips swelling"
        ),

        "asthma" to listOf(
            "asthma", "asthmatic", "asthma attack", "wheeze", "wheezing", "wheezy", "inhaler", "ventolin",
            "puffer", "short of breath", "shortness of breath", "out of breath", "hard to breathe",
            "difficulty breathing", "trouble breathing", "cant breathe", "cannot breathe", "cant catch breath",
            "cant catch my breath", "breathing hard", "breathless", "struggling to breathe", "tight chest",
            "chest tight", "gasping for air", "breathing fast", "fast breathing", "breathing problem",
            "breathing problems", "panting", "whistling breath", "wheeze when breathing", "tight breathing"
        ),

        "poisoning" to listOf(
            "poison", "poisoned", "poisoning", "poisonous", "swallowed bleach", "drank bleach", "bleach",
            "drank cleaning", "swallowed cleaning", "swallowed chemicals", "swallowed medicine", "swallowed pills",
            "swallowed poison", "swallowed battery", "button battery", "took too many pills", "took too many",
            "overdose", "overdosed", "ate pills", "ate medicine", "too many tablets", "cleaning product",
            "chemical", "chemicals", "toxic", "gas leak", "carbon monoxide", "fumes", "inhaled fumes",
            "breathed fumes", "smoke inhalation", "drank gasoline", "drank petrol", "drank kerosene", "ate poison",
            "wild mushroom", "ate mushroom", "pesticide", "rat poison", "insecticide", "detergent", "drank chemicals",
            "drank something", "ate something toxic", "smell of gas", "gas poisoning"
        ),

        "drowning" to listOf(
            "drown", "drowning", "drowned", "drowing", "nearly drowned", "almost drowned", "about to drown",
            "fell in water", "fell into water", "fell in the pool", "fell in the sea", "fell in the river",
            "fell in the lake", "pulled from water", "pulled out of water", "underwater", "under water",
            "swallowed water", "swimming", "cant swim", "sinking", "pool", "sea", "river", "lake", "bathtub",
            "bath tub", "water in lungs", "rescued from water", "stuck in water", "went under water",
            "child in pool", "baby in bath", "waves", "swept away"
        ),

        "heatstroke" to listOf(
            "heatstroke", "heat stroke", "heat exhaustion", "heat exhausted", "sunstroke", "sun stroke",
            "overheated", "overheating", "too hot", "very hot", "extremely hot", "hot and confused",
            "hot dry skin", "stopped sweating", "left in car", "left in hot car", "locked in car", "dehydrated",
            "dehydration", "sun", "heat", "hot weather", "working in sun", "exhausted in heat", "dizzy in heat",
            "hot sun", "heat wave", "heatwave", "fainted in the sun", "collapsed in the sun", "high body temperature"
        ),

        "fracture" to listOf(
            "broken", "broke", "break", "fracture", "fractured", "broken bone", "broken arm", "broken leg",
            "broken wrist", "broken ankle", "broken finger", "broken rib", "broken ribs", "broke his arm", "broke her leg",
            "bone sticking out", "bone showing", "bone visible", "sprain", "sprained", "twisted ankle", "twisted",
            "twisted knee", "dislocated", "dislocation", "swollen leg", "swollen arm", "swollen ankle", "swollen wrist",
            "cant move arm", "cant move leg", "cant walk", "cant stand", "cant put weight", "fell and hurt",
            "fell down stairs", "fell from", "fell off", "fell off a bike", "hurt leg", "hurt arm", "hurt ankle",
            "hurt wrist", "leg pain", "limp", "limping", "bone", "bones", "deformed", "crooked arm", "crooked leg",
            "knee injury", "ankle injury", "wrist injury", "shoulder dislocated", "car accident", "accident", "crash",
            "motorbike accident", "hit by car", "fell from ladder", "fell from roof"
        ),

        "nosebleed" to listOf(
            "nosebleed", "nosebleeds", "nose bleed", "nose bleeding", "bleeding nose", "bloody nose",
            "blood from nose", "blood from my nose", "blood from his nose", "blood from her nose",
            "blood coming from nose", "nose is bleeding", "nose blood", "nose wont stop bleeding", "nose started bleeding"
        ),

        "head_injury" to listOf(
            "head injury", "hit head", "hit his head", "hit her head", "hit my head", "hit the head",
            "bumped head", "bumped his head", "bump on head", "head trauma", "concussion", "concussed",
            "knocked out", "fell on head", "fell on his head", "head bleeding", "head wound", "head hurts after fall",
            "skull", "head blow", "blow to head", "banged head", "banged his head", "head bang", "struck head",
            "head pain after fall", "dizzy after hit", "head hit", "hit by something on head", "head cut",
            "head injured", "injured head", "head is bleeding", "cracked head", "cracked skull", "fell and hit"
        ),

        "electric_shock" to listOf(
            "electric shock", "electrocuted", "electrocution", "electric", "electricity", "shocked", "got shocked",
            "live wire", "power line", "power lines", "electric current", "stuck to wire", "stuck to electric",
            "touched wire", "touched a wire", "exposed wire", "socket", "electric socket", "plug", "lightning",
            "struck by lightning", "electric wire", "current passed", "high voltage", "high tension", "short circuit",
            "electric cable", "fallen wire", "wire fell", "electric pole"
        ),

        "bites" to listOf(
            "bite", "bites", "bitten", "biting", "dog bite", "cat bite", "snake", "snakes", "snakebite", "snake bite",
            "scorpion", "scorpions", "sting", "stings", "stung", "stinging", "spider", "spiders", "jellyfish",
            "bee", "bees", "wasp", "wasps", "hornet", "rabies", "tick", "insect", "insect bite", "animal bite",
            "rat bite", "dog attacked", "attacked by dog", "bitten by dog", "bitten by snake", "bitten by", "stinger",
            "ant bites", "mosquito", "bug bite", "bit by", "stung by", "monkey bite", "bat bite", "sea urchin"
        ),

        "eye_injury" to listOf(
            "eye injury", "eye injured", "something in eye", "something in my eye", "something in his eye",
            "chemical in eye", "eye burn", "hit in the eye", "hit in eye", "scratch eye", "scratched eye",
            "eye pain", "splash in eye", "eye hurts", "poked in eye", "poked eye", "eye", "eyes", "bleach in eye",
            "dust in eye", "sand in eye", "stuck in eye", "red eye", "eye bleeding", "glass in eye", "lost vision in eye",
            "eyeball", "eyelid", "eye swollen", "cant open eye", "eye water", "eye watering", "punched in the eye",
            "spray in eye", "paint in eye", "soap in eye", "cant see out of"
        ),

        "low_blood_sugar" to listOf(
            "diabetic", "diabetes", "low blood sugar", "low sugar", "hypoglycemia", "hypoglycaemia", "hypo",
            "sugar low", "sugar drop", "sugar dropped", "blood sugar", "blood sugar low", "shaky and sweating",
            "sweaty and shaky", "trembling and sweating", "shaking and hungry", "insulin", "glucose",
            "confused diabetic", "diabetic collapsed", "diabetic unconscious", "diabetes shaky", "sugar level",
            "sugar is low", "didnt eat diabetic", "skipped meal diabetic", "type 1", "type 2 diabetes"
        )
    )

    /** Same lists, also under the older ids in case your content file still uses them. */
    val map: Map<String, List<String>> = base + mapOf(
        "allergic_reaction" to (base["allergic"] ?: emptyList()),
        "bites_stings" to (base["bites"] ?: emptyList())
    )
}