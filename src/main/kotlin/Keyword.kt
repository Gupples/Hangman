import java.util.Random
import java.util.Scanner

class Keyword {

    // Create reader for getting input from the user.
    val reader : Scanner = Scanner(System.`in`)
    var keyword = ""
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
        "train", "sleep", "prove", "lone", "leg", "exercise")

    init {

        // Generate a random word.
        val random = Random()
        val index = random.nextInt(dictionary.size)
        keyword = dictionary[index].toUpperCase()
        emptySlots = keyword.length
        display()

        /**/
        println("Keyword: $keyword")
    }

    fun display() {
        for ((counter, i) in keyword.indices.withIndex()) {
            progress = ""
            if (keyword[i] in guesses){
                progress += keyword[i]
            } else{
                progress += "-"
                if (counter != keyword.length - 1) {
                    progress += " "
                }
            } // exit if


        } // exit for
        println("Guesses: $guesses")
        println(progress)
    } // exit display()

    fun guess() : Boolean {
        println("Guess a letter: ")

        // Only read a single character from the next line.
        var guess = reader.nextLine().single().toUpperCase()
        var isValidGuess = false
        while (!isValidGuess) {
            if (guess !in guesses){
                guesses.add(guess)
                isValidGuess = true
            } else {
                println("'$guess' has already been guessed. Try again.")
            }

            // Check guesses against the word.
            if (guess in keyword) {
                for (i in keyword) {
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
        if (guess !in keyword) {
            return false
        }
        return true

    }
}