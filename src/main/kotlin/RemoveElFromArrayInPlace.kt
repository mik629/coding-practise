package main.kotlin

class RemoveElFromArrayInPlace {
    fun removeElement(nums: IntArray, value: Int): Int {
        nums.sort()
        val valIndex = nums.binarySearch(value)
        if (valIndex < 0) {
            return nums.size
        }

        var start = valIndex
        while (nums[start] == value && start > 0) {
            start--
        }
        if (nums[start] != value) {
            start++
        }

        var end = valIndex
        while (nums[end] == value && end < nums.size - 1) {
            end++
        }
        if (nums[end] != value) {
            end--
        }

        val range = end - start
        for (i in end + 1 until nums.size) {
            nums[i - range - 1] = nums[i]
        }
        return nums.size - (range + 1)
    }


}

fun main() {
    println(RemoveElFromArrayInPlace().removeElement(intArrayOf(3, 2, 2, 3), 3))
    println(RemoveElFromArrayInPlace().removeElement(intArrayOf(0, 1, 2, 2, 3, 0, 4, 2), 2))
}
