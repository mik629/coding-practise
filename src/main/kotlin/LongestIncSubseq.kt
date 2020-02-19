package main.kotlin

import kotlin.math.min

class LongestIncSubseq {
    fun lengthOfLIS(nums: IntArray): Int {
        val sums = IntArray(nums.size)
        var maxSoFar = min(1, nums.size)
        for (i in nums.indices) {
            sums[i] = 1
            for (j in i - 1 downTo 0) {
                if (nums[j] < nums[i] && sums[j] + 1 > sums[i]) {
                    sums[i] = sums[j] + 1
                    if (sums[i] > maxSoFar) {
                        maxSoFar = sums[i]
                        break
                    }
                }
            }
        }
        return maxSoFar
    }
}

fun main() {
    val longestIncSubseq = LongestIncSubseq()
    println(
        longestIncSubseq.lengthOfLIS(
            intArrayOf(10, 9, 2, 5, 3, 7, 101, 18)
        ) == 4
    )
    println(
        longestIncSubseq.lengthOfLIS(
            intArrayOf(3, 4, 2, 5)
        ) == 3
    )
    println(
        longestIncSubseq.lengthOfLIS(
            intArrayOf(5, 3, 4, 8, 6, 7, 9, 2)
        ) == 5
    )
    println(
        longestIncSubseq.lengthOfLIS(
            intArrayOf(10, 9, 4, 5, 3, 7)
        ) == 3
    )
    println(
        longestIncSubseq.lengthOfLIS(
            intArrayOf(5)
        ) == 1
    )
    println(
        longestIncSubseq.lengthOfLIS(
            intArrayOf(5, 3)
        ) == 1
    )
    println(
        longestIncSubseq.lengthOfLIS(
            intArrayOf(3, 4)
        ) == 2
    )
}