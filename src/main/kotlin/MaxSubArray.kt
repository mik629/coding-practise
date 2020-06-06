package main.kotlin

import kotlin.math.max

class MaxSubArray {
    fun maxSubArrayBF(nums: IntArray): Int {
        var max = 0
        for (i in 0 until nums.size) {
            var sum = 0
            for (j in i until nums.size) {
                sum += nums[j]
                if (sum > max) {
                    max = sum
                }
            }
        }
        return max
    }

    fun maxSubArray(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }

        var max = nums[0]
        var nextMaxStart = nums[0]
        for (i in 1 until nums.size) {
            nextMaxStart = max(nextMaxStart + nums[i], nums[i])
            max = max(max, nextMaxStart)
        }
        return max
    }

    fun maxSubArrayDivAndConq(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }

        var max = nums[0]
        var nextMaxStart = nums[0]
        for (i in 1 until nums.size) {
            nextMaxStart = max(nextMaxStart + nums[i], nums[i])
            max = max(max, nextMaxStart)
        }
        return max
    }
}

fun main() {
    val solution = MaxSubArray()
    println(solution.maxSubArrayBF(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)) == 6)
    println(solution.maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)) == 6)
}