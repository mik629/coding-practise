package main.kotlin

class CoinCounter {
    fun count(totalSum: Int, values: IntArray): Int {
        val minSum = IntArray(totalSum + 1)
        minSum[0] = 0
        minSum.fill(Int.MAX_VALUE, 1)
        for (i in 1 .. totalSum) {
            for (v in values) {
                if (v <= i && minSum[i - v] + 1 < minSum[i]) {
                    minSum[i] = minSum[i - v] + 1
                }
            }
        }
        return minSum[totalSum]
    }
}

fun main() {
    print(CoinCounter().count(11, intArrayOf(1, 3, 5)) == 3)
}