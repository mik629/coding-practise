package main.kotlin

class LastWordLength {
    fun lengthOfLastWord(s: String): Int {
        if (s.isEmpty() || s.isBlank()) {
            return 0
        }
        var lastWord = ""
        for (word in s.split(" ")) {
            if (word.isNotEmpty()) {
                lastWord = word
            }
        }
        return lastWord.length
    }
}

fun main() {
    val solution = LastWordLength()
    println(solution.lengthOfLastWord("Hello World") == 5)
    println(solution.lengthOfLastWord("Hello ") == 0)
    println(solution.lengthOfLastWord("Hello you hey you") == 3)
    println(solution.lengthOfLastWord("") == 0)
    println(solution.lengthOfLastWord(" ") == 0)
    println(solution.lengthOfLastWord("           ") == 0)
    println(solution.lengthOfLastWord("blah") == 0)
    println(solution.lengthOfLastWord(" blah") == 4)
    println(solution.lengthOfLastWord(" blah ") == 0)
}