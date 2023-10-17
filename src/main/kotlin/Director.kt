import java.util.Scanner

/* Create a Director class to handle how the game is played. */
class Director {


    // Create a Boolean for replayability.
    var isPlaying = true
    val reader : Scanner = Scanner(System.`in`)

    fun playGame(){

        // Create a man to display.
        val person : Person = Person()

        // Create a keyword.
        val keyword : Keyword = Keyword()

        var isGameOver = false

            while (!isGameOver) {

                // Guess a letter
                if (!keyword.guess()) {

                    // If it was wrong, lose a life.
                    person.missed()
                }
                person.display()
                keyword.display()

                // Stop the game if the keyword is guessed or the person dies.
                isGameOver = person.isDead or keyword.isFound

                // When the word is guessed, congratulate the player.
                if (keyword.isFound) {
                    println("\nYou found the word! (^_^) ♥")
                }

                // When the person is dead, inform the player.
                if (person.isDead) {
                    println("\nHe died! Too bad. (ಥ﹏ಥ) ")
                    println("The word was '${keyword.value}'")
                }
                }

                var userInput : Char= 'ツ'
                var isValidInput = false
                while (!isValidInput){
                    println("\nWould you like to play again? (y/n)")
                    userInput = reader.nextLine().trim().single()
                        .uppercaseChar()
                    if (userInput in arrayOf('Y', 'N')){
                        isValidInput = true
                    } else {
                        println("I'm sorry, that wasn't an option. Please " +
                                "type 'y' or 'n'.")
                    }
                }
                if (userInput == 'N') {
                    isPlaying = false
                }
            return
    }
}