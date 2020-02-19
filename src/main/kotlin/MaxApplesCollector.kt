package main.kotlin

import kotlin.math.max

class MaxApplesCollector {
    fun collect(a: Array<IntArray>): Int {
        require(a.isNotEmpty())
        val n = a.size
        val m = a[0].size
        val aSum = Array(n) { IntArray(m) { 0 } }
        for (i in 0 until n) {
            for (j in 0 until m) {
                aSum[i][j] = a[i][j] + max(if (i - 1 >= 0) aSum[i - 1][j] else 0, if (j - 1 >= 0) aSum[i][j - 1] else 0)
            }
        }
        return aSum[n - 1][m - 1]
    }
}

fun main() {
    val collector = MaxApplesCollector()
    println(collector.collect(
        arrayOf(
            intArrayOf(1, 2, 5, 0),
            intArrayOf(0, 7, 5, 3),
            intArrayOf(0, 1, 2, 1),
            intArrayOf(0, 0, 5, 3)
        )
    ) == 25)
}