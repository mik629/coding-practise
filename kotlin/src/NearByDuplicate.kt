import kotlin.math.abs

class NearByDuplicate {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val numToIndex = mutableMapOf<Int, Int>()
        for (i in 0 until nums.size) {
            val index = numToIndex.getOrDefault(nums[i], -k - 1)
            if (abs(index - i) <= k) {
                return true
            } else {
                numToIndex[nums[i]] = i
            }
        }
        return false
    }
}

fun main() {
    println(NearByDuplicate().containsNearbyDuplicate(intArrayOf(1, 2, 3, 1), 3))
}