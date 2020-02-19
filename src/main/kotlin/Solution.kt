package main.kotlin

class Solution {
//    fun numberOfArithmeticSlices(a: IntArray): Int {
//
//    }

    fun isArithmetic(seq: IntArray): Boolean {
        if (seq.size < 3 || seq[0] > seq[1]) {
            return false
        }
        val d = seq[1] - seq[0]
        for (i in 1 until seq.size) {
            if (seq[i] - seq[i - 1] != d) {
                return false
            }
        }
        return true
    }
}

fun main() {
    val solution = Solution()
    println(!solution.isArithmetic(intArrayOf(1)))
    println(solution.isArithmetic(intArrayOf(1, 3)))
    println(solution.isArithmetic(intArrayOf(1, 3, 5, 7, 9)))
    println(solution.isArithmetic(intArrayOf(7, 7, 7, 7)))
    println(!solution.isArithmetic(intArrayOf(3, -1, -5, -9))) // wrong subsequence: each next should be bigger than previous
    println(!solution.isArithmetic(intArrayOf(1, 1, 2, 5, 7)))
}