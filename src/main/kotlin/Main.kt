fun main(args: Array<String>) {

    // Create a man to display.
    val person : Person = Person()

    // Create a keyword.
    val keyword : Keyword = Keyword()

    var isPlaying = true
    while (isPlaying) {
        
        // Guess a letter
        if (!keyword.guess()) {
            
            // If it was wrong, lose a life.
            person.missed()
        }
        person.display()
        keyword.display()

        // Stop the game if the keyword is guessed or the person dies.
        isPlaying = !person.isDead and keyword.isFound

        // When the word is guessed, congratulate the player.
        if (keyword.isFound) {
            println("You found the word! ^_^")
        }
        // When the person is dead, inform the player.
        if (person.isDead) {
            println("He died! Too bad. ;-; ")
        }
    }


}
