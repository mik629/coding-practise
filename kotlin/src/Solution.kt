import kotlin.math.sqrt

class Solution {
    fun isPerfectSquare(num: Int): Boolean {
        val root = sqrt(num.toDouble())
        return (root - root.toInt()) == 0.0
    }
}