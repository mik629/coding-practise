package main.kotlin

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val seq = IntArray(n)

    for (i in 0 until n) {
        seq[i] = readLine()!!.toInt()
    }

    println(countOnes(seq))
}

fun countOnes(seq: IntArray): Int {
    var maxOnesCounter = 0
    var currentOnesCounter = 0
    for (num in seq) {
        if (num == 1) {
            currentOnesCounter++
        } else {
            currentOnesCounter = 0
        }
        if (currentOnesCounter > maxOnesCounter) {
            maxOnesCounter = currentOnesCounter
        }
    }
    return maxOnesCounter
}

//fun main.kotlin.main() {
//    println(main.kotlin.countOnes(intArrayOf(1, 1, 0, 0, 1, 1, 1, 0)) == 3)
//    println(main.kotlin.countOnes(intArrayOf(0, 1, 1, 1, 0, 0, 1, 1, 1, 0)) == 3)
//    println(main.kotlin.countOnes(intArrayOf(5, 1, 0, 1, 0, 1, 0, 1, 0, 1)) == 1)
//    println(main.kotlin.countOnes(intArrayOf(0, 1, 0, 0, 1, 1, 1)) == 3)
//    println(main.kotlin.countOnes(intArrayOf(1, 1, 0, 0, 0, 1)) == 2)
//    println(main.kotlin.countOnes(intArrayOf(1, 1, 1, 1, 1)) == 5)
//    println(main.kotlin.countOnes(intArrayOf()) == 0)
//    println(main.kotlin.countOnes(intArrayOf(0, 0, 0)) == 0)
//}
