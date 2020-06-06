package main.kotlin

class HappyNumber {
    private val cache: MutableMap<Int, Int> = mutableMapOf()

    fun isHappy(n: Int): Boolean {
        if (n <= 0) {
            return false
        }
        var next = n
        for (i in 0 until 1000) {
            next = sumSquaredDigits(next)
            if (next == 1) {
                return true
            }
        }
        return false
    }

    private fun sumSquaredDigits(num: Int): Int {
        val existing = cache[num]
        if (existing != null) {
            return existing
        }

        var sum = 0
        var next = num
        while (next > 0) {
            val digit = next % 10
            sum += digit * digit
            next /= 10
            val existingSubSum = cache[next]
            if (existingSubSum != null) {
                sum += existingSubSum
                break
            }
        }
        cache[num] = sum
        return sum
    }
}

fun main() {
    println(HappyNumber().isHappy(19))
    println(HappyNumber().isHappy(1))
    println(HappyNumber().isHappy(101))
    println(HappyNumber().isHappy(-1))
    println(HappyNumber().isHappy(0))
}