package main.kotlin

import kotlin.math.max

class MaxProfit {
    fun maxProfitSingleOp(prices: IntArray): Int {
        var minPrice = Int.MAX_VALUE
        var maxProfit = 0
        for (p in prices) {
            if (p < minPrice) {
                minPrice = p
            } else if (p - minPrice > maxProfit) {
                maxProfit = p - minPrice
            }
        }
        return maxProfit
    }

    fun maxProfit(prices: IntArray): Int {
        if (prices.size < 2) {
            return 0
        }

        var minPrice = prices[0]
        var maxPrice = prices[0]
        var maxProfit = 0
        for (i in 1 until prices.size) {
            val p = prices[i]
            when {
                p < maxPrice -> {
                    maxProfit += maxPrice - minPrice
                    minPrice = p
                    maxPrice = p
                }
                p > maxPrice -> {
                    maxPrice = p
                }
                p < minPrice -> {
                    minPrice = p
                }
            }
        }
        return if (maxPrice > minPrice) maxProfit + maxPrice - minPrice else maxProfit
    }

    fun maxProfitBad(prices: IntArray): Int {
        if (prices.size == 2) {
            return max(0, prices[1] - prices[0])
        }

        var minPrice = Int.MAX_VALUE
        var maxPrice = 0
        var maxProfit = 0
        var iMin = 0
        var iMax = 0
        for (p in prices) {
            if (p < maxPrice && maxPrice > minPrice) {
                maxProfit += maxPrice - minPrice
                minPrice = p
                maxPrice = p
            } else if (p < minPrice) {
                minPrice = p
                iMin++
            } else if (p > maxPrice) {
                maxPrice = p
                iMax++
            }
        }
        return if (iMax > iMin && maxPrice > minPrice) maxProfit + maxPrice - minPrice else maxProfit
    }
}

fun main() {
    println(MaxProfit().maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)) == 7)
    println(MaxProfit().maxProfit(intArrayOf(1, 2, 3, 4, 5)) == 4)
    println(MaxProfit().maxProfit(intArrayOf(7, 6, 4, 3, 1)) == 0)
    println(MaxProfit().maxProfit(intArrayOf(2, 4, 1)) == 2)
    println(MaxProfit().maxProfit(intArrayOf(1, 1, 0)) == 0)
    println(MaxProfit().maxProfit(intArrayOf(1, 2)) == 1)
}