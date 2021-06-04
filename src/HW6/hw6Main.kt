package HW6

fun main() {

    val input = readLine()
    if (!input.isNullOrEmpty()) {

        // TODO: Why we needed to use .filter, and what it is filtering?
            // TODO: Hint -> Consider the case when there are more than one white spaces between words.
        val words = input.split(" ").filter { it.isNotEmpty() }
        val sortedWords = words.sortedBy { it.length}
        println(sortedWords)
    }
}