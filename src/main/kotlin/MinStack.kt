package main.kotlin

import java.util.*

class MinStack {
    private val stack: Stack<Int> = Stack()
    private val mins: TreeMap<Int, Int> = TreeMap()

    fun push(x: Int) {
        stack.push(x)
        mins.computeIfPresent(x) { _, v -> v + 1 }
        mins.computeIfAbsent(x) { _ -> 1 }
    }

    fun pop() {
        val topEl = stack.pop()
        var minCount = mins[topEl]
        minCount = minCount!! - 1
        if (minCount <= 0) {
            mins.remove(topEl)
        } else {
            mins[topEl] = minCount
        }
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return mins.firstKey()
    }
}