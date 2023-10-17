fun main(args: Array<String>) {

    // Create a director object and start a game.
    val director : Director = Director()

    // Enable replayability.
    while (director.isPlaying) {
        director.playGame()
    }
}
