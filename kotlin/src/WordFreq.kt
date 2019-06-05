fun freq(book: String): Map<String, Int> {
    return book.splitToSequence(" ")
            .groupingBy { it }
            .eachCount()
}

fun main() {
    print(freq("I do learn quickly I really do"))
}