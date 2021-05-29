package HW5

fun main() {

    val question1 = Question(
            "What is your name?",
            "Yusuf",
            arrayOf("Ahmet", "Selim", "Hakan"))

    println(question1.question)
    question1.printOptions()

    val answer = readLine()

    if (!answer.isNullOrEmpty()) {

        // TODO: Pay attention to this point. We can use the if statement as an expression.
        // TODO: We can use everything as expressions in Kotlin.
        // User can enter answer as choice number or actual String.
        val message = if (
                answer == question1.correctAnswer ||
                answer == (question1.options.indexOf(question1.correctAnswer) + 1).toString()
        ) {
            "That is true."
        } else {
            "Ohh, wrong answer!"
        }

        println(message)
    }
}

