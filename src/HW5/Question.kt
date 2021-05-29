package HW5

class Question(
        val question: String,
        val correctAnswer: String,
        // We use this 'wrongAnswers' only in this class,
        // so we make it parameter (it is not property anymore) by deleting 'val'.
        wrongAnswers: Array<String>) {

    // TODO: Pay attention to '*' (Spread Operator) before 'wrongAnswers' array.
    val options: Array<String> = arrayOf(correctAnswer, *wrongAnswers)

    // TODO: What is this 'init' ?
    init {
        //TODO: What is this 'shuffle' doing?
        options.shuffle()
    }

    fun printOptions() {
        for(index in options.indices) {
            println("${index + 1}) ${options[index]}")
        }
    }
}
