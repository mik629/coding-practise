package main.kotlin

import kotlin.math.sqrt

class PerfectSquare {
    fun isPerfectSquare(num: Int): Boolean {
        val root = sqrt(num.toDouble())
        return (root - root.toInt()) == 0.0
    }
}