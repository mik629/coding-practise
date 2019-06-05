class RemoveElFromArrayInPlace {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        nums.sort()
        val valIndex = nums.binarySearch(`val`)
        if (valIndex < 0) {
            return nums.size
        }

        var start = valIndex
        while (nums[start] == `val` && start > 0) {
            start--
        }
        if (nums[start] != `val`) {
            start++
        }

        var end = valIndex
        while (nums[end] == `val` && end < nums.size - 1) {
            end++
        }
        if (nums[end] != `val`) {
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
