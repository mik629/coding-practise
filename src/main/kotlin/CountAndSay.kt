package main.kotlin

class CountAndSay {
    fun countAndSay(n: Int): String {
        if (n == 1) {
            return "1"
        }

        var memo = "1"
        for (i in 1 until n) {
            var counter = 1
            var prevChar = memo[0]
            val currentSay = StringBuilder()
            for (j in 1 until memo.length) {
                if (memo[j] == prevChar) {
                    counter++
                } else {
                    currentSay.append(counter).append(prevChar)
                    prevChar = memo[j]
                    counter = 1
                }
            }
            currentSay.append(counter).append(prevChar)
            memo = currentSay.toString()
        }
        return memo
    }
}

fun main() {
    val solution = CountAndSay()
    println(solution.countAndSay(1))
    println(solution.countAndSay(2))
    println(solution.countAndSay(4))
}
