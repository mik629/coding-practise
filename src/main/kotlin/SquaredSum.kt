package main.kotlin

import java.math.BigInteger

class SquaredSum {
    fun judgeSquareSum(c: Int): Boolean {
        val longC = c.toLong()
        for (i in 0 .. longC) {
            val iSq: Long = i * i
            if (iSq <= longC) {
                for (j in 0 .. longC) {
                    val sqSum: Long = iSq + j * j
                    if (sqSum == longC) {
                        return true
                    } else if (sqSum > longC) {
                        break
                    }
                }
            }
        }
        return false
    }
}