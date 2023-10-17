/* Create a person class to hold the image of the person and how many lives are
    left. */
class Person {
    var lives = 5
    var isDead= false

    // Picture from GitHub: chrishorton/hangmanwordbank.py
    val picture = arrayOf<String>(
        "  +---+",
        "  |   |",
        "  O   |",
        "      |",
        "      |",
        "=========")

    init {
        display()
    }

    fun missed() {
        lives--
        if (lives == 0){
            isDead = true
        }
        when (lives) {
            4 -> picture[3] = "  |   |"
            3 -> picture[3] = " /|   |"
            2 -> picture[3] = " /|\\  |"
            1 -> picture[4] = " /    |"
            0 -> picture[4] = " / \\  |"
        }
    }

    fun display() {
        for (line in picture) {
            println(line)
        }
    }
}