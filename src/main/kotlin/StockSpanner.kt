package main.kotlin

import java.util.Stack

class StockSpanner() {
    private val cache = Stack<Pair<Int, Int>>()

    fun next(price: Int): Int {
        var count = 1
        while (!cache.isEmpty() && cache.peek().first <= price) {
            count += cache.pop().second
        }
        cache.push(Pair(price, count))
        return count
    }
}

fun main() {
    val stockSpanner = StockSpanner()
    println(stockSpanner.next(100) == 1)
    println(stockSpanner.next(80) == 1)
    println(stockSpanner.next(60) == 1)
    println(stockSpanner.next(70) == 2)
    println(stockSpanner.next(60) == 1)
    println(stockSpanner.next(75) == 4)
    println(stockSpanner.next(85) == 6)

    val stockSpanner2 = StockSpanner()
    println(stockSpanner2.next(60) == 1)
    println(stockSpanner2.next(80) == 2)
    println(stockSpanner2.next(100) == 3)

    val stockSpanner3 = StockSpanner()
    println(stockSpanner3.next(60) == 1)
    println(stockSpanner3.next(60) == 2)
    println(stockSpanner3.next(60) == 3)

    val stockSpanner4 = StockSpanner()
    println(stockSpanner4.next(80) == 1)
    println(stockSpanner4.next(60) == 1)
    println(stockSpanner4.next(80) == 3)
    println(stockSpanner4.next(60) == 1)
}