package main.kotlin

class IntArrayPlusOne {
    fun plusOne(digits: IntArray): IntArray {
        require(digits.isNotEmpty())
        val increased = digits.joinToString(separator = "").toBigInteger().inc().toString()
        val result = IntArray(increased.length)
        for ((i, digit) in increased.toCharArray().withIndex()) {
            result[i] = Character.getNumericValue(digit)
        }
        return result
    }
}

fun main() {
    val solution = IntArrayPlusOne()
    println(solution.plusOne(intArrayOf(1, 2, 3)).joinToString())
    println(solution.plusOne(intArrayOf(1, 0, 3)).joinToString())
    println(solution.plusOne(intArrayOf(1)).joinToString())
    println(solution.plusOne(intArrayOf(1, 2, 9)).joinToString())
    println(solution.plusOne(intArrayOf(9, 9, 9)).joinToString())
}