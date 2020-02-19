package main.kotlin

class MergeSortedArrays {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        for (i in m - 1 downTo 0) {
            nums1[i + n] = nums1[i]
        }

        var i = n
        var j = 0
        var k = 0
        while (k < m + n) {
            if (j < n && (i >= m + n || nums1[i] > nums2[j])) {
                nums1[k] = nums2[j]
                j++
                k++
            } else {
                nums1[k] = nums1[i]
                i++
                k++
            }
        }
    }
}

fun main() {
    val solution = MergeSortedArrays()
    val res1 = intArrayOf(1, 2, 3, 0, 0, 0, 0)
    solution.merge(res1, 3, intArrayOf(4, 5, 6, 7), 4)
    println(res1.contentToString())

    val res2 = intArrayOf(1, 2, 3, 4, 0, 0, 0)
    solution.merge(res2, 4, intArrayOf(5, 6, 7), 3)
    println(res2.contentToString())

    val res3 = intArrayOf(-1, 3, 5, 0, 0)
    solution.merge(res3, 3, intArrayOf(1, 3), 2)
    println(res3.contentToString())

    val res4 = intArrayOf(-1, 3, 5)
    solution.merge(res4, 3, intArrayOf(), 0)
    println(res4.contentToString())

    val res5 = intArrayOf()
    solution.merge(res5, 0, intArrayOf(), 0)
    println(res5.contentToString())

    val res6 = intArrayOf(0, 0, 0)
    solution.merge(res6, 0, intArrayOf(1, 3, 7), 3)
    println(res6.contentToString())
}