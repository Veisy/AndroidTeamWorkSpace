package HW5

class Question(
        val question: String,
        val correctAnswer: String,
        wrongAnswers: Array<String>) {

    val options: Array<String> = arrayOf(correctAnswer, *wrongAnswers)

    // TODO: What is this 'init' ?
    init {
        //TODO: What is this 'shuffle' doing?
        options.shuffle()
    }

    fun printOptions() {
        for(index in options.indices) {
            println("${index + 1} -> ${options[index]}")
        }
    }
}
