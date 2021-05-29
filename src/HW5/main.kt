package HW5

fun main() {

    val question1 = Question(
            "What is your name?",
            "Yusuf",
            arrayOf("Ahmet", "Selim", "Hakan"))

    // TODO: Why this 'repeat' variable is declared with 'var' instead of 'val'?
    // TODO: You wont use 'while' loop in your exercise, only 'for' loop to iterate all questions.
    var repeat = true
    while (repeat) {

        println("\nTo quit, press Q\n")
        println("\t\t\t ${question1.question}")
        question1.printOptions()

        val answer = readLine()

        if (!answer.isNullOrEmpty()) {

            // TODO: Pay attention to this point. We can use the if statement as an expression.
            // TODO: We can use everything as expressions in Kotlin.
            // User can enter answer as choice number or actual String.
            val message = if (answer == "q" || answer == "Q") {
                repeat = false
                "Program terminated. See you later."
            } else if (
            // TODO: What is this 'ignoreCase' doing?
                    answer.equals(question1.correctAnswer, ignoreCase = true) ||
                    answer == (question1.options.indexOf(question1.correctAnswer) + 1).toString()) {
                "That is true."
            } else {
                "Ohh, wrong answer!"
            }
            // TODO: Mind using 'when' instead of 'if' in Kotlin. After this exercise we will always use 'when'.

            println(message)
        }
    }
}

