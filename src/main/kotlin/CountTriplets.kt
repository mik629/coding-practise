package main.kotlin

fun countTriplets(arr: Array<Long>, r: Long): Long {
    require(r >= 1)

    val numFreq = hashMapOf<Long, Long>()
    for (num in arr) {
        var value = numFreq[num]
        if (value == null) {
            value = 1
        } else {
            value++
        }
        numFreq[num] = value
    }

    var count: Long = 0
    for (num in numFreq.keys) {
        if (numFreq.containsKey(num * r) && numFreq.containsKey(num * r * r)) {
            count += numFreq[num]!! * numFreq[num * r]!! * numFreq[num * r * r]!!
        }
    }
    return count
}

fun generatePascalTriangle(numRows: Int): List<List<Int>> {
    val res: List<List<Int>> = mutableListOf()
    return res
}

fun main() {
    println(countTriplets(arrayOf(1, 2, 2, 4), 2) == 2L)
    println(countTriplets(arrayOf(1, 2), 2) == 0L)
    println(countTriplets(arrayOf(1, 3, 9, 9, 27, 81), 3) == 6L)
    println(countTriplets(arrayOf(1, 5, 5, 25, 125), 5) == 4L)
    println(countTriplets(arrayOf(1, 1, 5, 5, 25, 125), 5) == 6L)
    println(countTriplets(arrayOf(1, 2, 1, 2, 4), 2) == 3L)
    println(countTriplets(arrayOf(1, 1, 1, 1, 1), 1) == 10L)
}
