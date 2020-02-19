package main.kotlin

import java.math.BigInteger
import kotlin.math.min

class TrailingZeroesCounter {
    fun trailingZeroesStillNotFastEnough(n: Int): Int {
        var count2 = 0
        var count5 = 0
        for (i in 1..n) {
            var next = i
            while (next % 2 == 0) {
                count2++
                next /= 2
            }

            while (next % 5 == 0) {
                count5++
                next /= 5
            }
        }
        return min(count2, count5)
    }

    fun trailingZeroesTimeOut(n: Int): Int {
        val fac = factorial(n)
        var next = fac
        var counter = 0
        while (next.mod(BigInteger.TEN) == BigInteger.ZERO) {
            counter++
            next = next.divide(BigInteger.TEN)
        }
        return counter
    }

    fun factorial(n: Int): BigInteger {
        var res = BigInteger.ONE
        for (i in 1..n) {
            res = res.multiply(BigInteger.valueOf(i.toLong()))
        }
        return res
    }
}

fun main() {
    val counter = TrailingZeroesCounter()
    println(counter.factorial(1) == BigInteger.ONE)
    println(counter.factorial(2) == BigInteger.valueOf(2L))
    println(counter.factorial(5) == BigInteger.valueOf(120L))

    println(counter.trailingZeroesTimeOut(3) == 0)
    println(counter.trailingZeroesTimeOut(5) == 1)

    println(counter.trailingZeroesStillNotFastEnough(3) == 0)
    println(counter.trailingZeroesStillNotFastEnough(5) == 1)
}