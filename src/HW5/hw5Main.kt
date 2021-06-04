package HW5

fun main() {

    val allQuestions = getQuestions()
    allQuestions.shuffle()

    // TODO: Why this 'correctAnswerCounter' variable is declared with 'var' instead of 'val' ?
    var correctAnswerCounter = 0

    for (question in allQuestions) {

        println("\n${question.question}")
        question.printOptions()

        var answer = readLine()

        if (!answer.isNullOrEmpty()) {

            answer = answer.trim()

            // TODO: Pay attention to this point. We can use the if statement as an expression.
            // TODO: We can use everything as expressions in Kotlin.
            // User can enter answer as choice number or actual String.
            val message = if (
            // TODO: What is this 'ignoreCase' doing?
                    answer.equals(question.correctAnswer, ignoreCase = true) ||
                    answer == (question.options.indexOf(question.correctAnswer) + 1).toString()) {
                correctAnswerCounter++
                "That is true."
            } else {
                "Ohh, wrong answer!"
            }
            // TODO: Mind using 'when' instead of 'if' in Kotlin. After this exercise we will always use 'when'.

            println(message)
        }
    }
    println("\nOverall, you got $correctAnswerCounter out of ${allQuestions.size} correct.\n" +
            "Thanks for playing!")

}

fun getQuestions(): Array<Question> = arrayOf(
        Question(
                "How old is the Universe? (in billion years)",
                "13.8",
                arrayOf("0.77", "5.6", "2.2")),
        Question(
                "How old is Planet Earth? (in billion years)",
                "4.5",
                arrayOf("3.7", "15.5", "450")),
        Question(
                "How many years ago did the meteor that killed the dinosaurs hit the earth? (in million years)",
                "66",
                arrayOf("42", "181", "265")),

        Question(
                "What is the scientific name of human being?",
                "Homo sapiens",
                arrayOf("Homo erectus", "Homo neanderthalensis", "Homo habilis")),
        Question(
                "What is the most distant human-made object?",
                "Voyager 1",
                arrayOf("Voyager 2", "ISS", "Helios Satellites"))
)



