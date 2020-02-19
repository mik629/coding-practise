package main.kotlin

fun compress(input: String): String {
    val sb = StringBuilder()
    var count = 0
    for (i in 0 until input.length) {
        count++

        if (i + 1 >= input.length || input[i] != input[i + 1]) {
            sb.append(input[i])
                    .append(count)
            count = 0
        }
    }

    return if (sb.length < input.length) sb.toString() else input
}

fun main() {
    println(compress("aabcccccaaa"))
}