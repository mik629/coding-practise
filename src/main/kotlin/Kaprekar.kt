package main.kotlin

import kotlin.io.*
import kotlin.text.*

// Complete the main.kotlin.kaprekarNumbers function below.
fun kaprekarNumbers(p: Int, q: Int) {
    require(p in 1..100000 && q in p..100000)

    var countKaprekars = 0
    for (i in p..q) {
        val square = "" + i * i.toLong()
        val rightNumIndex = square.length - i.toString().length
        if (rightNumIndex > 0) {
            val rightNum = square.substring(rightNumIndex).toInt()
            val leftNum = square.substring(0, rightNumIndex).toInt()
            if (leftNum + rightNum == i) {
                print(i)
                print(" ")
                countKaprekars++
            }
        } else if (i == 1) {
            print(1)
            print(" ")
            countKaprekars++
        }
    }

    if (countKaprekars == 0) {
        print("INVALID RANGE")
    }
}

fun main() {
    kaprekarNumbers(1, 100)
    kaprekarNumbers(1, 99999)
}

//fun main.kotlin.main(args: Array<String>) {
//    val scan = Scanner(System.`in`)
//
//    val p = scan.nextLine().trim().toInt()
//
//    val q = scan.nextLine().trim().toInt()
//
//    main.kotlin.kaprekarNumbers(p, q)
//}
