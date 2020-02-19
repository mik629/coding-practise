package main.kotlin

import kotlin.math.max

class MaxTurbulence {
    fun maxTurbulenceSize(arr: IntArray): Int {
        if (arr.isEmpty() || arr.size == 1) {
            return arr.size
        }

        var count1 = 1
        var count2 = 1
        var maxCount = 1
        for (i in 0 until arr.size - 1) {
            if (arr[i + 1] > arr[i]) {
                count1 = count2 + 1
                count2 = 1
                maxCount = max(count1, maxCount)
            } else if (arr[i + 1] < arr[i]) {
                count2 = count1 + 1
                count1 = 1
                maxCount = max(count2, maxCount)
            } else {
                count1 = 1
                count2 = 1
            }
        }
        return maxCount
    }
}

fun main() {
    print(MaxTurbulence().maxTurbulenceSize(intArrayOf(9, 9)))
}