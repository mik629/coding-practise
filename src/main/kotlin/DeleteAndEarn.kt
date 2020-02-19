package main.kotlin

class DeleteAndEarn {
    fun deleteAndEarn(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        } else if (nums.size == 1) {
            return nums.first()
        }

        return countIncome(nums)
    }

    private fun countIncome(nums: IntArray): Int {
        var size = nums.size
        var res = 0
        while (size >= 0) {
            var max = 0
            var maxIndex = 0
            for (i in 0 until nums.size) {
                if (nums[i] > max) {
                    max = nums[i]
                    maxIndex = i
                }
            }
            res += max
            nums[maxIndex] = 0
            size--

            val prev = max - 1
            for (i in 0 until nums.size) {
                if (nums[i] == prev) {
                    nums[i] = 0
                    size--
                }
            }
        }
        return res
    }
}
