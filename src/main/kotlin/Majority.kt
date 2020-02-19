package main.kotlin

class Majority {
    fun majorityElement(nums: IntArray): Int {
        var count = 0
        var major = nums[0]
        for (i in nums) {
            when {
                count == 0 -> {
                    major = i
                    count++
                }
                i == major -> count++
                else -> count--
            }
        }
        return major
    }

    fun majorityElementInefficient(nums: IntArray): Int {
        val numToFreq = hashMapOf<Int, Long>()
        for (n in nums) {
            var value = numToFreq[n]
            if (value == null) {
                value = 0
            }
            value++
            numToFreq[n] = value
        }
        var majorElement = 0
        var majorCount = 0L
        for (entry in numToFreq.entries) {
            if (entry.value > nums.size / 2 && entry.value > majorCount) {
                majorElement = entry.key
                majorCount = entry.value
            }
        }
        return majorElement
    }
}

fun main() {
    val majority = Majority()
    println(majority.majorityElement(intArrayOf(3, 2, 3)) == 3)
    println(majority.majorityElement(intArrayOf(2, 2, 1, 1, 1, 2, 2)) == 2)
    println(majority.majorityElement(intArrayOf(1, 2, 1, 2, 1, 2, 2)) == 2)
    println(majority.majorityElement(intArrayOf(2, 2, 1, 2, 1, 2, 1)) == 2)
    println(majority.majorityElement(intArrayOf(2, 1, 2, 2, 1, 2, 1)) == 2)
}