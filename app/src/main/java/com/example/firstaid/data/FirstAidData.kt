package com.example.firstaid.data

// DRAFT CONTENT: must be checked against current Red Cross / AHA guidance
// by you (ideally a certified first aid instructor) before release.
// Items marked VERIFY are the ones most worth double-checking.

const val EMERGENCY_NUMBER = "140" // Lebanese Red Cross. VERIFY before release.

data class Step(
    val text: String,
    val imageName: String? = null // name of a vector drawable, added in the illustration step
)

data class Emergency(
    val id: String,
    val title: String,
    val keywords: List<String>,
    val callNow: Boolean,
    val steps: List<Step>,
    val donts: List<String>,
    val callWhen: List<String>
)

val emergencies = listOf(

    Emergency(
        id = "choking",
        title = "Choking",
        keywords = listOf(
            "choke", "choking", "choked", "cant breathe", "can't breathe",
            "cannot breathe", "swallowed", "stuck in throat", "food stuck",
            "cant talk", "can't talk", "gasping", "turning blue"
        ),
        callNow = true,
        steps = listOf(
            Step("Ask: \"Are you choking?\" If they can cough, speak, or breathe, encourage them to keep coughing. Do nothing else.", "ic_choking_cough"),
            Step("If they cannot cough, speak, or breathe: have someone call 140 now.", null),
            Step("Lean them forward. Give 5 firm back blows between the shoulder blades with the heel of your hand.", "ic_choking_back_blows"),
            Step("Then give 5 abdominal thrusts: stand behind them, fist just above the belly button, pull sharply inward and upward.", "ic_choking_thrusts"),
            Step("Alternate 5 back blows and 5 thrusts until the object comes out or they become unresponsive.", null),
            Step("If they become unresponsive: lower them to the floor and start CPR (see Heart attack).", null),
            Step("Choking alone? Lean hard over a chair back or counter edge and push your upper belly onto it.", "ic_choking_chair"),
            Step("Infant under 1 year: lay face down along your forearm, 5 back blows, then turn over and give 5 chest thrusts with two fingers. Do NOT do belly thrusts. VERIFY", null)
        ),
        donts = listOf(
            "Do not slap the back if they are coughing forcefully.",
            "Do not give water, food, or bread to push it down.",
            "Do not put your fingers in their mouth unless you can see the object.",
            "Do not hang a child upside down."
        ),
        callWhen = listOf(
            "Immediately, if they cannot cough, speak, or breathe.",
            "Even if the object comes out, if they still have trouble breathing or the belly thrusts were used."
        )
    ),

    Emergency(
        id = "bleeding",
        title = "Severe bleeding",
        keywords = listOf(
            "bleed", "bleeding", "blood", "cut", "wound", "stab", "stabbed",
            "gash", "laceration", "gunshot", "hemorrhage", "won't stop bleeding"
        ),
        callNow = true,
        steps = listOf(
            Step("Call 140 for heavy bleeding. If someone is with you, ask them to call while you help.", null),
            Step("Press firmly on the wound with a clean cloth: a t-shirt, towel, or scarf. Use your hands and your body weight.", "ic_bleeding_pressure_tshirt"),
            Step("Keep pressing without stopping. If blood soaks through, add more cloth ON TOP. Do not remove the first layer.", "ic_bleeding_add_layer"),
            Step("When bleeding slows, wrap a strip of cloth or a scarf snugly over the pad. It should be firm, not cutting off blood flow.", "ic_bleeding_bandage"),
            Step("Lay the person down and cover them with a blanket or coat to keep them warm. Raise the legs if there is no head, neck, or back injury.", "ic_bleeding_blanket"),
            Step("Life-threatening bleeding on an arm or leg that will not stop: tie a wide strip of cloth (belt or folded t-shirt, never thin string) tightly about 5 cm above the wound, twist it tighter with a stick, and note the time. VERIFY", "ic_bleeding_tourniquet")
        ),
        donts = listOf(
            "Do not remove an object stuck in the wound. Press around it.",
            "Do not lift the cloth to check if it stopped.",
            "Do not wash out a deep wound or apply powders.",
            "Do not give food or drink.",
            "Do not loosen a tourniquet once it is on."
        ),
        callWhen = listOf(
            "Immediately, if blood is spurting, soaking through cloth, or won't stop after 10 minutes of pressure.",
            "If the person feels faint, pale, cold, or confused.",
            "If the wound is deep, from a stab or gunshot, or on the head, chest, or belly."
        )
    ),

    Emergency(
        id = "burns",
        title = "Burns",
        keywords = listOf(
            "burn", "burned", "burnt", "scald", "scalded", "boiling", "hot oil",
            "fire", "flame", "hot water", "hot stove", "chemical burn"
        ),
        callNow = false,
        steps = listOf(
            Step("Move the person away from the heat source. Put out any flames on clothing: stop, drop, roll, or smother with a blanket.", "ic_burns_smother_blanket"),
            Step("Cool the burn under cool (not ice-cold) running tap water for at least 10 minutes, up to 20. VERIFY duration", "ic_burns_running_water"),
            Step("No running water? Soak a clean towel or t-shirt in cool water and lay it on the burn. Re-wet it as it warms.", "ic_burns_wet_cloth"),
            Step("Gently remove rings, watches, and tight clothing near the burn before it swells, unless stuck to the skin.", null),
            Step("Cover loosely with clean plastic cling film, or a clean non-fluffy cloth such as a pillowcase. Do not wrap tightly.", "ic_burns_cover"),
            Step("For a large burn, keep the person warm with a blanket over the unburned areas.", "ic_burns_blanket")
        ),
        donts = listOf(
            "Do not use ice or ice water.",
            "Do not apply butter, oil, toothpaste, or honey.",
            "Do not pop blisters.",
            "Do not pull off clothing stuck to the burn.",
            "Do not use fluffy cotton or tissue that sticks to the skin."
        ),
        callWhen = listOf(
            "The burn is larger than the person's palm, deep, white, or charred.",
            "It is on the face, hands, feet, genitals, or a joint, or goes around a limb.",
            "It is a chemical or electrical burn, or they inhaled smoke.",
            "The person is a baby, a child, or an elderly person."
        )
    ),

    Emergency(
        id = "heart_attack",
        title = "Heart attack",
        keywords = listOf(
            "heart attack", "chest pain", "chest pressure", "chest tight",
            "pain in arm", "pain in jaw", "cardiac", "sweating and pain"
        ),
        callNow = true,
        steps = listOf(
            Step("Call 140 immediately. Do not wait to see if it passes.", null),
            Step("Help them sit down and rest, half-sitting with knees bent. Support their back with pillows, cushions, or a folded blanket.", "ic_heart_sit_pillows"),
            Step("Loosen tight clothing around the neck and chest.", null),
            Step("Cover with a blanket if they feel cold. Stay with them and keep them calm.", "ic_heart_blanket"),
            Step("If they collapse and are not breathing normally: lay them flat on a firm floor and start CPR.", null),
            Step("CPR: heel of one hand on the center of the chest, other hand on top. Push hard and fast, about 5 cm deep, 100 to 120 times a minute, without stopping until help arrives.", "ic_heart_cpr_hands")
        ),
        donts = listOf(
            "Do not let them walk around, or drive themselves.",
            "Do not give food or drink.",
            "Do not leave them alone."
        ),
        callWhen = listOf(
            "Immediately, for chest pain or pressure lasting more than a few minutes.",
            "Pain spreading to the arm, jaw, neck, or back, with sweating, nausea, or shortness of breath.",
            "Immediately, if the person is unresponsive and not breathing normally."
        )
    ),

    Emergency(
        id = "stroke",
        title = "Stroke",
        keywords = listOf(
            "stroke", "face drooping", "face droop", "slurred", "slurring",
            "cant speak", "can't speak", "arm weak", "arm numb", "numb",
            "sudden confusion", "cant see", "can't see", "sudden headache",
            "lost balance", "one side"
        ),
        callNow = true,
        steps = listOf(
            Step("Check FAST. Face: ask them to smile. Is one side drooping?", "ic_stroke_face"),
            Step("Arm: ask them to raise both arms. Does one drift down?", "ic_stroke_arm"),
            Step("Speech: ask them to repeat a sentence. Is it slurred or strange?", null),
            Step("Time: if you see ANY of these signs, call 140 immediately.", null),
            Step("Note the exact time the symptoms started. Doctors need this.", null),
            Step("Keep them comfortable, sitting or lying with head and shoulders slightly raised on a pillow or folded blanket.", "ic_stroke_pillow"),
            Step("If they are unconscious but breathing, roll them onto their side (recovery position) and support with a blanket or pillow. Stay with them.", "ic_stroke_recovery"),
            Step("If they stop breathing normally, start CPR (see Heart attack).", null)
        ),
        donts = listOf(
            "Do not give aspirin or any medicine.",
            "Do not give food or drink; they may not be able to swallow.",
            "Do not let them drive or walk around.",
            "Do not wait to see if it gets better."
        ),
        callWhen = listOf(
            "Immediately, if you see ANY FAST sign, even if it seems to go away.",
            "Sudden severe headache, sudden loss of vision, balance, or confusion."
        )
    ),

    Emergency(
        id = "cpr",
        title = "Unresponsive / not breathing",
        keywords = listOf(
            "unresponsive", "not breathing", "stopped breathing", "wont wake",
            "won't wake", "unconscious", "collapsed", "no pulse", "cpr",
            "not moving", "lifeless"
        ),
        callNow = true,
        steps = listOf(
            Step("Check the area is safe. Tap their shoulders firmly and shout: \"Are you OK?\"", null),
            Step("No response: shout for help and call 140 now. Put the phone on speaker. Send someone to find a defibrillator (AED) if there is one.", null),
            Step("Lay them on their back on a firm surface, such as the floor, not a bed or sofa. Tilt the head back slightly and check breathing for no more than 10 seconds.", "ic_cpr_check"),
            Step("Not breathing, or only gasping: kneel beside them. Put the heel of one hand on the center of the chest, the other hand on top, arms straight.", "ic_cpr_hands"),
            Step("Push hard and fast, about 5 cm deep, 100 to 120 times a minute. Let the chest rise fully between pushes. Do not stop.", "ic_cpr_push"),
            Step("If you are trained: after every 30 pushes, give 2 rescue breaths. If not trained, keep pushing without breaths.", null),
            Step("If an AED arrives, turn it on and follow its voice instructions.", null),
            Step("Child: use one or two hands, push about 5 cm. Infant: use two fingers on the center of the chest, push about 4 cm. VERIFY", null),
            Step("Keep going until help arrives, they start breathing normally, or you are too exhausted to continue. Swap with someone every 2 minutes if you can.", null),
            Step("If they start breathing normally but stay unresponsive, roll them onto their side and cover with a blanket.", "ic_cpr_recovery")
        ),
        donts = listOf(
            "Do not stop to check the pulse again and again.",
            "Do not give water, food, or medicine.",
            "Do not worry about hurting them. Cracked ribs can happen and are better than not helping.",
            "Do not do CPR on someone who is breathing normally."
        ),
        callWhen = listOf(
            "Immediately. Anyone who is unresponsive and not breathing normally needs 140 now."
        )
    ),

    Emergency(
        id = "fainting",
        title = "Fainting",
        keywords = listOf(
            "faint", "fainted", "fainting", "passed out", "blackout",
            "black out", "dizzy", "lightheaded", "light headed",
            "about to faint", "going to faint"
        ),
        callNow = false,
        steps = listOf(
            Step("Lay them flat on their back right away. If they are only feeling faint, have them sit or lie down before they fall.", "ic_faint_lie_down"),
            Step("Raise their legs about 30 cm on a backpack, cushions, or a folded blanket.", "ic_faint_legs_up"),
            Step("Loosen tight clothing: collar, belt, scarf. Make sure they have fresh air.", null),
            Step("Check they are breathing. If they are not, start CPR (see Unresponsive).", null),
            Step("They should wake within a minute. Keep them lying down for a few minutes, then help them sit up slowly, then stand.", null),
            Step("Once fully awake and able to swallow, give small sips of water.", null)
        ),
        donts = listOf(
            "Do not sit or stand them up quickly.",
            "Do not give anything to drink until fully awake.",
            "Do not splash water on the face or slap them.",
            "Do not leave them alone."
        ),
        callWhen = listOf(
            "They do not wake within 1 minute.",
            "They hit their head or are injured in the fall.",
            "They have chest pain, trouble breathing, or an irregular heartbeat.",
            "They are pregnant, diabetic, or over 50, or this keeps happening."
        )
    ),

    Emergency(
        id = "seizure",
        title = "Seizure",
        keywords = listOf(
            "seizure", "convulsion", "convulsing", "fit", "epilepsy",
            "epileptic", "shaking uncontrollably", "jerking", "twitching",
            "foaming"
        ),
        callNow = false,
        steps = listOf(
            Step("Stay calm. Note the time the seizure started.", null),
            Step("Clear hard or sharp objects and furniture away from them.", "ic_seizure_clear"),
            Step("Cushion their head with a folded jacket, towel, or pillow.", "ic_seizure_cushion"),
            Step("Loosen anything tight around the neck. Remove glasses.", null),
            Step("When the jerking stops, roll them onto their side (recovery position) so fluid can drain from the mouth.", "ic_seizure_side"),
            Step("Stay with them until fully awake. Speak gently and calmly. Cover with a blanket if they feel cold.", null)
        ),
        donts = listOf(
            "Do not hold them down or try to stop the movements.",
            "Do not put anything in their mouth: no spoon, wallet, or fingers. They cannot swallow their tongue.",
            "Do not give food, drink, or pills until fully alert.",
            "Do not crowd them. Ask onlookers to step back."
        ),
        callWhen = listOf(
            "The seizure lasts more than 5 minutes.",
            "A second seizure follows, or they do not wake up afterward.",
            "It is their first seizure, or they are pregnant, diabetic, injured, or in water.",
            "They have trouble breathing after the seizure."
        )
    ),

    Emergency(
        id = "allergic",
        title = "Allergic reaction",
        keywords = listOf(
            "allergic", "allergy", "anaphylaxis", "anaphylactic", "hives",
            "swollen lips", "swollen face", "swollen tongue", "swollen throat",
            "epipen", "auto-injector", "peanut", "nut allergy", "rash and swelling",
            "swelling lips", "swelling face", "swelling tongue", "throat closing",
            "cant breathe", "can't breathe", "cannot breathe", "trouble breathing"
        ),
        callNow = true,
        steps = listOf(
            Step("Severe signs (trouble breathing, swelling of face, lips, tongue or throat, dizziness, vomiting): call 140 immediately.", null),
            Step("Lay them flat with legs raised and cover with a blanket. If breathing is hard, let them sit up instead. Pregnant: lay on the left side.", "ic_allergy_lie_down"),
            Step("Stay with them and keep talking to them calmly. Follow the instructions of the 140 operator. If they stop breathing, start CPR.", null),
            Step("Insect sting with the stinger left in: scrape it out sideways with the edge of a card. Wash the area, then apply a cold pack wrapped in a cloth.", "ic_allergy_scrape")
        ),
        donts = listOf(
            "Do not wait to see if it gets better.",
            "Do not give food, drink, or pills by mouth if breathing is difficult.",
            "Do not let them stand up or walk suddenly.",
            "Do not squeeze the stinger with tweezers or fingers."
        ),
        callWhen = listOf(
            "Immediately, for any trouble breathing or swelling of face, lips, tongue, or throat.",
            "Always. They must be checked at a hospital even if they feel better afterwards.",
            "Hives together with dizziness, vomiting, or fainting."
        )
    ),

    Emergency(
        id = "asthma",
        title = "Asthma attack",
        keywords = listOf(
            "asthma", "wheezing", "wheeze", "short of breath", "shortness of breath",
            "inhaler", "ventolin", "puffer", "hard to breathe", "difficulty breathing",
            "tight breathing", "cant breathe", "can't breathe", "cannot breathe",
            "trouble breathing"
        ),
        callNow = true,
        steps = listOf(
            Step("Sit them upright, leaning slightly forward, and keep them calm. Do not lay them down.", "ic_asthma_sit"),
            Step("Call 140 if the attack is severe, it is their first attack, or they do not clearly improve within a few minutes.", null),
            Step("Loosen tight clothing and move them away from triggers such as smoke, dust, or pets. Open a window for fresh air.", "ic_asthma_air"),
            Step("Encourage slow, calm breathing in through the nose and out through pursed lips. Stay with them.", null)
        ),
        donts = listOf(
            "Do not lay them flat.",
            "Do not leave them alone.",
            "Do not let them hold their breath, panic, or exercise.",
            "Do not give pills or drinks if breathing is very hard."
        ),
        callWhen = listOf(
            "It is a first attack, or they do not clearly improve within a few minutes of resting.",
            "They cannot speak in full sentences, or their lips or fingertips turn blue or gray.",
            "They are very tired, drowsy, or struggling for every breath.",
            "It is a first attack or they are unsure it is asthma."
        )
    ),

    Emergency(
        id = "poisoning",
        title = "Poisoning",
        keywords = listOf(
            "poison", "poisoned", "poisoning", "swallowed", "drank bleach",
            "ate pills", "took too many", "overdose", "cleaning product",
            "chemical", "carbon monoxide", "gas leak", "fumes", "toxic",
            "swallowed battery"
        ),
        callNow = true,
        steps = listOf(
            Step("Call 140 right away. Tell them what was taken, how much, when, and the person's age and weight if you know.", null),
            Step("Fumes or gas (including carbon monoxide): get everyone outside into fresh air right away. Open windows only if you cannot leave.", "ic_poison_fresh_air"),
            Step("Keep the container, pills, or product label. Take it with you to show responders.", "ic_poison_container"),
            Step("Chemical on skin: take off contaminated clothing (cut a t-shirt off if needed) and rinse the skin with running water for 15 to 20 minutes.", "ic_poison_rinse_skin"),
            Step("Chemical in eyes: rinse with cool running water for 15 minutes (see Eye injury).", null),
            Step("If they are unresponsive and not breathing, start CPR. If unresponsive but breathing, roll them onto their side.", null)
        ),
        donts = listOf(
            "Do not make them vomit.",
            "Do not give milk, water, or food unless told to by emergency services.",
            "Do not wait for symptoms to appear.",
            "Do not try home remedies or neutralize the poison."
        ),
        callWhen = listOf(
            "Immediately, for any suspected poisoning, even if they seem fine.",
            "Always, for children, button batteries, medicine overdoses, or unknown substances."
        )
    ),

    Emergency(
        id = "drowning",
        title = "Drowning",
        keywords = listOf(
            "drown", "drowning", "drowned", "pulled from water", "fell in water",
            "pool", "sea", "underwater", "swallowed water", "water rescue"
        ),
        callNow = true,
        steps = listOf(
            Step("Call 140 or have someone call. Do not jump in unless you are trained: panicking people can pull you under.", null),
            Step("Reach them with a towel, stick, or rope while staying on solid ground. Or throw something that floats: a cooler, bottle, ball, or life ring.", "ic_drown_reach"),
            Step("Once out of the water, check for breathing. If they are not breathing, start CPR. If trained, begin with 2 rescue breaths, then 30 pushes and 2 breaths. Untrained: push hard and fast. VERIFY", "ic_drown_cpr"),
            Step("If breathing, roll them onto their side. If they vomit, keep them on their side.", null),
            Step("Take off wet clothing and wrap them in dry towels or blankets.", "ic_drown_blanket")
        ),
        donts = listOf(
            "Do not enter the water unless trained.",
            "Do not press on the belly to push water out.",
            "Do not stop CPR until help arrives.",
            "Do not leave them alone, even if they seem fine."
        ),
        callWhen = listOf(
            "Immediately, for anyone pulled from water who was unconscious, not breathing, or struggling.",
            "Always, even if they recover. Breathing problems can appear hours later and they need a medical check."
        )
    ),

    Emergency(
        id = "heatstroke",
        title = "Heatstroke",
        keywords = listOf(
            "heatstroke", "heat stroke", "heat exhaustion", "sunstroke",
            "sun stroke", "overheated", "too hot", "stopped sweating",
            "hot and confused", "left in car", "dehydrated"
        ),
        callNow = true,
        steps = listOf(
            Step("Call 140 if they are confused, very drowsy, unconscious, or have hot dry skin.", null),
            Step("Move them to a cool, shaded place or an air-conditioned room. Remove extra clothing.", "ic_heat_shade"),
            Step("Cool them quickly: lay wet towels or t-shirts on the neck, armpits, groin, and head, and fan them. Re-wet as they warm.", "ic_heat_wet_towels"),
            Step("Wrap ice or cold packs in a cloth and place them on the neck, armpits, and groin. A cool bath or shower works too if they are alert.", "ic_heat_ice_cloth"),
            Step("If they are fully awake and able to swallow, give small sips of cool water.", null),
            Step("Lay them down with legs slightly raised. Keep cooling until help arrives.", null)
        ),
        donts = listOf(
            "Do not give drinks to someone who is confused or unconscious.",
            "Do not give aspirin or paracetamol to bring the temperature down.",
            "Do not put ice directly against bare skin for long.",
            "Do not give alcohol or caffeine.",
            "Do not leave them alone."
        ),
        callWhen = listOf(
            "Confusion, fainting, fits, or hot dry skin.",
            "They stop sweating, vomit repeatedly, or do not improve within about 15 minutes of cooling.",
            "Always, if a child or elderly person was left in a hot car or room."
        )
    ),

    Emergency(
        id = "fracture",
        title = "Broken bone or sprain",
        keywords = listOf(
            "broken", "fracture", "fractured", "sprain", "sprained",
            "twisted ankle", "dislocated", "dislocation", "broken bone",
            "swollen leg", "cant move arm", "can't move arm", "fell and",
            "cant walk", "can't walk"
        ),
        callNow = false,
        steps = listOf(
            Step("Keep them still. Do not move the injured part unless they are in danger.", null),
            Step("If there is bleeding, press a clean cloth around the wound (not on a protruding bone) and cover it.", null),
            Step("Splint it where it is, in the position found: pad a rolled magazine, folded cardboard, or stick with a towel and place it along the limb, past the joints above and below.", "ic_fracture_splint"),
            Step("Tie it with scarves or strips of t-shirt, snug but not tight, with the knots on the splint, not over the injury.", "ic_fracture_tie"),
            Step("Arm: support it in a sling made from a scarf or folded t-shirt tied behind the neck.", "ic_fracture_sling"),
            Step("Apply a cold pack (ice wrapped in a cloth) for 20 minutes to reduce swelling.", "ic_fracture_ice"),
            Step("Check the fingers or toes beyond the splint: warm, normal color, can feel? Loosen if not. Cover the person with a blanket if they feel faint or cold.", null)
        ),
        donts = listOf(
            "Do not try to straighten the limb or push a bone back in.",
            "Do not move them if you suspect a neck, back, head, hip, or pelvis injury.",
            "Do not put ice directly on the skin.",
            "Do not tie the splint too tight.",
            "Do not let them eat or drink if they may need surgery."
        ),
        callWhen = listOf(
            "A bone is visible through the skin, or there is heavy bleeding.",
            "The limb looks deformed, or the fingers or toes are blue, cold, or numb.",
            "Suspected injury to the neck, back, head, hip, pelvis, or thigh.",
            "They cannot bear weight or move the limb, or are in severe pain."
        )
    ),

    Emergency(
        id = "nosebleed",
        title = "Nosebleed",
        keywords = listOf(
            "nosebleed", "nose bleed", "nose bleeding", "bleeding nose",
            "blood from nose", "blood from my nose"
        ),
        callNow = false,
        steps = listOf(
            Step("Sit upright and lean slightly forward.", "ic_nose_lean"),
            Step("Pinch the soft part of the nose, just below the bone, firmly with thumb and finger. Breathe through the mouth.", "ic_nose_pinch"),
            Step("Keep pinching for a full 10 minutes without letting go to check.", null),
            Step("Spit out any blood that runs into the mouth. Hold a cloth or tissue under the nose.", null),
            Step("A cold pack wrapped in a cloth on the bridge of the nose can help.", null),
            Step("After it stops, rest, and avoid blowing, picking, or bending over for several hours.", null)
        ),
        donts = listOf(
            "Do not tilt the head back. Blood will run down the throat.",
            "Do not lie flat.",
            "Do not stuff tissue deep into the nose.",
            "Do not pinch the hard, bony part."
        ),
        callWhen = listOf(
            "It does not stop after 20 minutes of proper pressure.",
            "It follows a head injury or a fall.",
            "They are on blood thinners, or the bleeding is heavy.",
            "They feel faint, or have trouble breathing."
        )
    ),

    Emergency(
        id = "head_injury",
        title = "Head injury",
        keywords = listOf(
            "head injury", "hit head", "hit his head", "hit her head",
            "bumped head", "head trauma", "concussion", "knocked out",
            "fell on head", "head bleeding", "head wound", "skull"
        ),
        callNow = false,
        steps = listOf(
            Step("Keep them still. After a serious fall, car crash, or sports collision, assume a neck injury: hold the head steady with both hands or place rolled towels on either side.", "ic_head_hold_steady"),
            Step("Check they are awake and breathing. If unresponsive and not breathing, start CPR.", null),
            Step("Bleeding: gently press a clean cloth around the wound. If the skull feels dented or soft, do not press on it.", null),
            Step("Apply a cold pack (ice in a cloth) to a bump for 20 minutes.", "ic_head_ice"),
            Step("If they vomit, roll them onto their side as one unit, supporting the head and neck.", null),
            Step("Stay with them and watch closely for 24 hours.", null)
        ),
        donts = listOf(
            "Do not move the head or neck unless there is danger.",
            "Do not remove a helmet unless it blocks breathing.",
            "Do not give aspirin, ibuprofen, or alcohol.",
            "Do not press on a dent in the skull.",
            "Do not leave them alone."
        ),
        callWhen = listOf(
            "They lost consciousness, even briefly, or are drowsy or confused.",
            "Repeated vomiting, seizure, severe headache, or weakness.",
            "Clear fluid or blood from the nose or ears, or unequal pupils.",
            "A major fall or crash, any child under 2, or bleeding that will not stop."
        )
    ),

    Emergency(
        id = "electric_shock",
        title = "Electric shock",
        keywords = listOf(
            "electric shock", "electrocuted", "electrocution", "shocked",
            "live wire", "power line", "got shocked", "electric current",
            "stuck to wire"
        ),
        callNow = true,
        steps = listOf(
            Step("Do NOT touch them while they are still in contact with the electricity. Call 140.", null),
            Step("Switch off the power at the switch or breaker, or unplug the device.", "ic_shock_switch_off"),
            Step("If you cannot turn it off, standing on something dry, push their contact away using a dry wooden broom handle, dry rope, or dry wooden chair.", "ic_shock_broom"),
            Step("Power lines or high voltage: stay at least 10 meters away and wait for the authorities. VERIFY distance", null),
            Step("Once safe, check breathing. If they are not breathing, start CPR.", null),
            Step("Cool any burns under running water and cover loosely with a clean cloth. Cover them with a blanket to keep warm.", null)
        ),
        donts = listOf(
            "Do not touch them with bare hands while the power is on.",
            "Do not use metal or wet objects to move them.",
            "Do not go near fallen power lines.",
            "Do not move them unless they are in danger.",
            "Do not throw water on an electrical fire."
        ),
        callWhen = listOf(
            "Always. Electric shock can disturb the heart rhythm even if they seem fine.",
            "Immediately, for any burns, confusion, chest pain, or loss of consciousness."
        )
    ),

    Emergency(
        id = "bites",
        title = "Bites and stings",
        keywords = listOf(
            "bite", "bitten", "dog bite", "cat bite", "snake", "snakebite",
            "snake bite", "scorpion", "sting", "stung", "spider", "jellyfish",
            "bee", "wasp", "hornet", "rabies", "tick"
        ),
        callNow = false,
        steps = listOf(
            Step("Move away from the animal or insect to a safe place.", null),
            Step("Animal bite (dog, cat): wash well with soap and running water for at least 5 minutes. Press with a clean cloth to stop bleeding, then cover.", "ic_bite_wash"),
            Step("Snake, scorpion, or spider: call 140. Keep them calm and still. Remove rings, watches, and tight clothing near the bite.", null),
            Step("Keep a bitten arm or leg still, at or slightly below heart level, and wrap loosely. Follow local first aid advice for the snake type. VERIFY", "ic_bite_immobilize"),
            Step("Remember the time and what the animal looked like. Do not try to catch it.", null),
            Step("Bee or wasp: scrape the stinger out with the edge of a card, wash, and apply a cold pack wrapped in a cloth.", "ic_bite_scrape"),
            Step("Watch for allergic signs: swelling, hives, trouble breathing (see Allergic reaction).", null)
        ),
        donts = listOf(
            "Do not cut the wound or try to suck out venom.",
            "Do not apply a tight tourniquet.",
            "Do not apply ice to a snake bite.",
            "Do not chase or catch the animal or snake.",
            "Do not squeeze the stinger with tweezers."
        ),
        callWhen = listOf(
            "Any snake, scorpion, or spider bite.",
            "Bites to the face, neck, or hands, deep or heavy bleeding wounds.",
            "A wild or unknown animal, since rabies and tetanus shots may be needed. Always get animal bites checked.",
            "Any sign of allergic reaction."
        )
    ),

    Emergency(
        id = "eye_injury",
        title = "Eye injury",
        keywords = listOf(
            "eye injury", "something in eye", "something in my eye",
            "chemical in eye", "eye burn", "hit in the eye", "scratch eye",
            "scratched eye", "eye pain", "splash in eye", "eye hurts",
            "poked in eye", "cant see out of"
        ),
        callNow = false,
        steps = listOf(
            Step("Do not rub the eye.", null),
            Step("Chemical in the eye: immediately rinse with cool running water for 15 to 20 minutes. Tilt the head so water runs away from the other eye and hold the eyelid open. Call 140.", "ic_eye_rinse"),
            Step("Small particle: blink a few times, or rinse with clean water. Try pulling the upper lid over the lower lid. If it stays, do not dig.", null),
            Step("Object stuck in the eye: do not remove it. Place a clean paper cup or folded cardboard cone over the eye, taped around the edge without pressing on it. Cover the other eye too to keep both still. VERIFY", "ic_eye_cup"),
            Step("Blow to the eye: apply a cold pack in a cloth very gently, without pressing on the eye.", null)
        ),
        donts = listOf(
            "Do not rub or press on the eye.",
            "Do not remove an object stuck in the eye.",
            "Do not use tweezers, cotton swabs, drops, or ointments.",
            "Do not delay rinsing a chemical splash to look for a bottle."
        ),
        callWhen = listOf(
            "Any chemical splash, after rinsing.",
            "An object stuck in the eye, or a cut to the eye or eyelid.",
            "Vision loss, double vision, blood in the eye, or severe pain.",
            "A blow to the eye with any change in vision, or no improvement after rinsing."
        )
    ),

    Emergency(
        id = "low_blood_sugar",
        title = "Low blood sugar (diabetic emergency)",
        keywords = listOf(
            "diabetic", "diabetes", "low blood sugar", "hypoglycemia",
            "sugar low", "shaky and sweating", "insulin", "glucose",
            "confused diabetic", "blood sugar"
        ),
        callNow = false,
        steps = listOf(
            Step("Signs: shaky, sweaty, pale, hungry, confused, or acting drunk. If unsure whether sugar is high or low, treat as low.", null),
            Step("If awake and able to swallow: give fast sugar, about 15 to 20 g: half a cup of juice or regular soda (not diet), or 1 tablespoon of sugar or honey in water.", "ic_sugar_juice"),
            Step("Wait 15 minutes. If they are not better, give the same amount again. VERIFY", null),
            Step("When better, give a snack such as bread, crackers, or fruit.", null),
            Step("Drowsy, cannot swallow, or unconscious: put nothing in the mouth. Call 140. Roll them onto their side.", "ic_sugar_recovery")
        ),
        donts = listOf(
            "Do not give food or drink to someone who is not alert.",
            "Do not give insulin.",
            "Do not assume it is just tiredness or drunkenness.",
            "Do not leave them alone."
        ),
        callWhen = listOf(
            "They are unconscious, cannot swallow, or have a seizure.",
            "They are not better 15 minutes after the second sugar dose.",
            "You are unsure what is wrong. Give sugar and call."
        )
    )
)

// The matcher and screens use this list (20 emergencies).
val allEmergencies = emergencies