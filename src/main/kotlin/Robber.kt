package main.kotlin

import kotlin.math.max

class Robber {
    fun rob(nums: IntArray): Int {
        var prevRobbed = 0
        var prevNotRobbed = 0
        for (n in nums) {
            val temp = prevRobbed
            prevRobbed = max(prevRobbed, prevNotRobbed)
            prevNotRobbed = n + temp
        }
        return max(prevRobbed, prevNotRobbed)
    }
}

fun main() {
    val robber = Robber()
    println(robber.rob(intArrayOf(1, 2, 3, 1)) == 4)
    println(robber.rob(intArrayOf(1, 3, 1, 1, 1, 1, 5, 1, 1, 1, 1, 7, 1)) == 17)
    println(robber.rob(intArrayOf(1, 3, 1, 1, 5, 1, 1, 7, 1)) == 15)
    println(robber.rob(intArrayOf(2, 7, 9, 3, 1)) == 12)
}
