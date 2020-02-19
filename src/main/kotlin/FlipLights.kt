package main.kotlin

import java.lang.StringBuilder

class FlipLights {
    val cache = hashMapOf<Int, Int>()

    fun flipLights(n: Int, m: Int): Int {
        require(n in 0..1000 && m in 0..1000)
        if (n == 0) {
            return 0
        }
        if (m == 0) {
            return 1
        }

        val bulb = if (n <= 6) n else n % 6 + 6

        val binary = StringBuilder()
        for (i in 0 until bulb) {
            binary.append(1)
        }
        val result = HashSet<Int>()
        flipLights(binary.toString().toInt(2), bulb, result, m)
        return result.size
    }

    private fun flipLights(statuses: Int, n: Int, result: MutableSet<Int>, m: Int) {
        if (m == 0) {
            return
        }

        val flippedAll = statuses.inv()
        result.add(flippedAll)
        flipLights(flippedAll, n, result, m - 1)
        val flippedEven = flipEven(statuses, n)
        result.add(flippedEven)
        flipLights(flippedEven, n, result, m - 1)
        val flippedOdd = flipOdd(statuses, n)
        result.add(flippedOdd)
        flipLights(flippedOdd, n, result, m - 1)
        val flipped3kPlus1 = flip3k1(statuses, n)
        result.add(flipped3kPlus1)
        flipLights(flipped3kPlus1, n, result, m - 1)
    }

    private fun flipEven(s: Int, n: Int): Int {
        var res = s
        var i = 0
        while (i < n) {
            res = res xor (1 shl i)
            i += 2
        }
        return res
    }

    private fun flipOdd(s: Int, n: Int): Int {
        var res = s
        var i = 1
        while (i < n) {
            res = res xor (1 shl i)
            i += 2
        }
        return res
    }

    private fun flip3k1(s: Int, n: Int): Int {
        var res = s
        var i = 0
        while (i < n) {
            res = res xor (1 shl i)
            i += 3
        }
        return res
    }





    fun flipLightsSlow(n: Int, m: Int): Int {
        require(n in 0..1000 && m in 0..1000)
        if (n == 0) {
            return 0
        }
        if (m == 0) {
            return 1
        }

        val statuses = arrayListOf<Boolean>()
        for (i in 0 until n) {
            statuses.add(true)
        }
        val result = HashSet<List<Boolean>>()
        flipLightsSlow(statuses, result, m)
        return result.size
    }

    // too slow O(4^N)
    private fun flipLightsSlow(statuses: List<Boolean>, result: MutableSet<List<Boolean>>, m: Int) {
        if (m == 0) {
            return
        }

        val flippedAll = statuses.map { v -> !v }.toList()
        result.add(flippedAll)
        flipLightsSlow(flippedAll, result, m - 1)
        val flippedEven = statuses.withIndex()
            .map { iv -> if ((iv.index + 1) % 2 == 0) !iv.value else iv.value }
            .toList()

        result.add(flippedEven)
        flipLightsSlow(flippedEven, result, m - 1)
        val flippedOdd = statuses.withIndex()
            .map { iv -> if ((iv.index + 1) % 2 > 0) !iv.value else iv.value }
            .toList()
        result.add(flippedOdd)
        flipLightsSlow(flippedOdd, result, m - 1)
        val flipped3kPlus1 = statuses.withIndex()
            .map { iv -> if (iv.index % 3 == 0) !iv.value else iv.value }
            .toList()
        result.add(flipped3kPlus1)
        flipLightsSlow(flipped3kPlus1, result, m - 1)
    }
}

fun main() {
    val solution = FlipLights()
    println(solution.flipLights(1, 1) == 2)
    println(solution.flipLights(2, 1) == 3)
    println(solution.flipLights(3, 1) == 4)
    println(solution.flipLights(1, 0) == 1)
    println(solution.flipLights(1000, 100))
}