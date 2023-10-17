import java.util.Random
import java.util.Scanner

/* Create a class that contains a dictionary of words, picks one at random, and
   handles how the word is displayed to the user. */
class Keyword {

    // Create reader for getting input from the user.
    val reader : Scanner = Scanner(System.`in`)
    var value = ""
    var guesses = mutableListOf<Char>()
    var progress = ""
    var isFound = false
    var emptySlots = 0

    // Create a list of words.
    val dictionary = arrayOf("table", "travel", "less", "morning", "ten",
        "simple", "several", "vowel", "toward", "war", "lay", "against",
        "pattern", "slow", "center", "love", "person", "money", "serve",
        "appear", "road", "map", "rain", "rule", "govern", "pull", "cold",
        "notice", "voice", "unit", "power", "town", "fine", "certain", "fly",
        "fall", "lead", "cry", "dark", "machine", "note", "wait", "plan",
        "figure", "star", "box", "noun", "field", "rest", "correct", "able",
        "pound", "done", "beauty", "drive", "stood", "contain", "front",
        "teach", "week", "final", "gave", "green", "quick", "develop", "ocean",
        "warm", "free", "minute", "strong", "special", "mind", "behind",
        "clear", "tail", "produce", "fact", "street", "inch", "multiply",
        "nothing", "bed", "brother", "egg", "ride", "cell", "believe",
        "fraction", "forest", "sit", "race", "window", "store", "summer",
        "train", "sleep", "prove", "lone", "leg", "exercise", "Abalone",
        "Abandon", "Ability", "Abolish", "Abdomen", "Abraham", "Abyssal",
        "Academy", "Account", "Achieve", "Apology", "Apostle", "Appease",
        "Artists", "Artwork", "Ascetic", "Ashtray", "Asphalt", "Aspirin",
        "Assault", "Astride", "Atheist", "Athlete", "Bifocal", "Billion",
        "Bipolar", "Biscuit", "Blocker", "Century", "Certain", "Chalice",
        "Chamber", "Confide", "Confine", "Confirm", "Degrade", "Degrees",
        "Delight", "Deliver", "Deltoid", "Demerit", "Denmark", "Density",
        "Dentist", "Fastest", "Fatigue", "Feature", "Federal", "Ferment",
        "Ferried", "Fiction", "Fifteen", "Denture", "Deplete", "Deplore",
        "Deposit", "Depress", "Deprive", "Garbage", "Vintage", "Western",
        "Gateway", "General", "Genesis", "Generic", "Genetic", "Getaway",
        "Giraffe", "Glimpse", "Honesty", "Hopeful", "Hotcake", "Zealous",
        "Husband", "Hydrant", "Iceberg", "Iceland", "Icicles", "Ideally",
        "Idolize", "Illicit", "Misread", "Missile", "Mission", "Mistake",
        "Mixture", "Mobster", "Modesty", "Illness", "Imagine", "Impound",
        "Nervous", "Network", "Neurons", "Neutral", "Neutron", "Newborn",
        "Newsboy", "Upgrade", "Popcorn",)

    init {

        // Generate a random word.
        val random = Random()
        val index = random.nextInt(dictionary.size)
        value = dictionary[index].toUpperCase()
        emptySlots = value.length
        display()
    }

    // Display the progress made on the keyword.
    fun display() {
        progress = ""
        for (i in value.indices) {
            if (value[i] in guesses){
                progress += value[i]
            } else{
                progress += "-"
            }
        }
        println("Guesses: $guesses")
        println(progress)
    }

    // Handle guesses made by the player.
    fun guess() : Boolean {

        // Declare a guess variable with an invalid value.
        var guess : Char = 'ツ'
        var isValidGuess = false
        while (!isValidGuess) {
            println("Guess a letter: ")

            // Only read a single character from the next line.
            guess = reader.nextLine().trim().single().uppercaseChar()
            if (guess !in guesses){
                guesses.add(guess)
                isValidGuess = true
            } else {
                println("'$guess' has already been guessed. Try again.")
            }

            // Check guesses against the word.
            if (guess in value) {
                for (i in value) {
                    if (i == guess){
                        emptySlots--
                    }
                }

                // Is the word guessed?
                if (emptySlots == 0) {
                    isFound = true
                }
            }
        }
        if (guess !in value) {
            return false
        }
        return true

    }
}