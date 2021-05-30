package HW5

class Question(
        question: String,
        correctAnswer: String,
        wrongAnswers: Array<String>) {

    // Trim all String parameters. (Remove white spaces from the start and the end of the Strings)
    val question = question.trim()
    val correctAnswer = correctAnswer.trim()

    // TODO: Pay attention to '*' (Spread Operator) before 'wrongAnswers' array.
    val options: Array<String> = arrayOf(this.correctAnswer, *wrongAnswers)

    // TODO: What is this 'init' ?
    init {
        for (index in options.indices) options[index] = options[index].trim()

        //TODO: What is this 'shuffle' doing?
        options.shuffle()
    }

    fun printOptions() {
        for (index in options.indices) {
            println("${index + 1}) ${options[index]}")
        }
    }
}
