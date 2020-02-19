package main.kotlin

class UniqueNumFinder {
    fun singleNumber(nums: IntArray): Int {
        var res = 0
        for (n in nums) {
            res = res.xor(n)
        }
        return res
    }
}

fun main() {
    val numFinder = UniqueNumFinder()
    println(numFinder.singleNumber(intArrayOf(2, 2, 1)) == 1)
    println(numFinder.singleNumber(intArrayOf(1, 2, 1)) == 2)
    println(numFinder.singleNumber(intArrayOf(1, 2, 3, 1, 3)) == 2)
    println(numFinder.singleNumber(intArrayOf(4, 1, 2, 1, 2)) == 4)
}