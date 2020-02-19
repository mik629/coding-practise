package main.kotlin

import kotlin.math.max
import kotlin.math.min

/*
 * Complete the 'main.kotlin.taumBday' function below.
 *
 * The function is expected to return a LONG_INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER b
 *  2. INTEGER w
 *  3. INTEGER bc
 *  4. INTEGER wc
 *  5. INTEGER z
 */

fun taumBday(blackCount: Int, whiteCount: Int, blackCost: Int, whiteCost: Int, conversionPrice: Int): Long {
    // Write your code here
    require(
        blackCount in 0..1000000000
                && whiteCount in 0..1000000000
                && blackCost in 0..1000000000
                && whiteCost in 0..1000000000
                && conversionPrice in 0..1000000000
    )

    val defaultResult = blackCount.toLong() * blackCost + whiteCount.toLong() * whiteCost
    return if (blackCost == whiteCost || min(blackCost, whiteCost) + conversionPrice >= max(blackCost, whiteCost)) {
        defaultResult
    } else if (blackCost > whiteCost) {
        blackCount.toLong() * (whiteCost + conversionPrice) + whiteCount.toLong() * whiteCost
    } else {
        blackCount.toLong() * blackCost + whiteCount.toLong() * (blackCost + conversionPrice)
    }
}

fun main() {
    println(taumBday(3, 5, 3, 4, 1) == 29L)
    println(taumBday(10, 10, 1, 1, 1) == 20L)
    println(taumBday(5, 9, 2, 3, 4) == 37L)
    println(taumBday(3, 6, 9, 1, 1) == 12L)
    println(taumBday(7, 7, 4, 2, 1) == 35L)
    println(taumBday(3, 3, 1, 9, 2) == 12L)
    println(taumBday(3, 3, 1, 9, 0) == 6L)
    println(taumBday(1000000000, 1000000000, 1000000000, 1000000000, 1000000000) == 2000000000000000000L)
}

//fun main.kotlin.main(args: Array<String>) {
//    val t = readLine()!!.trim().toInt()
//    require(t in 1..10)
//
//    for (tItr in 1..t) {
//        val first_multiple_input = readLine()!!.trimEnd().split(" ")
//
//        val b = first_multiple_input[0].toInt()
//
//        val w = first_multiple_input[1].toInt()
//
//        val second_multiple_input = readLine()!!.trimEnd().split(" ")
//
//        val bc = second_multiple_input[0].toInt()
//
//        val wc = second_multiple_input[1].toInt()
//
//        val z = second_multiple_input[2].toInt()
//
//        val result = main.kotlin.taumBday(b, w, bc, wc, z)
//
//        println(result)
//    }
//}
