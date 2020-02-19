package main.kotlin

import java.util.*

class PascalTriangle {
    fun generate(numRows: Int): List<List<Int>> {
        require(numRows >= 0)

        val result = mutableListOf<List<Int>>()
        if (numRows == 0) {
            return result
        }

        result.add(listOf(1))
        if (numRows == 1) {
            return result
        }

        var prev = result[0]
        for (i in 1 until numRows) {
            val row = mutableListOf<Int>()
            row.add(1)
            for (j in 0 until prev.size - 1) {
                row.add(prev[j] + prev[j + 1])
            }
            row.add(1)
            result.add(row)
            prev = row

        }
        return result
    }

    fun getRow(rowIndex: Int): List<Int> {
        require(rowIndex >= 0)

        if (rowIndex == 0) {
            return listOf(1)
        }

        var prev = listOf(1)
        for (i in 1..rowIndex) {
            val row = mutableListOf<Int>()
            row.add(1)
            for (j in 0 until prev.size - 1) {
                row.add(prev[j] + prev[j + 1])
            }
            row.add(1)
            prev = row
        }
        return prev
    }
}

fun main() {
    val triangle = PascalTriangle()
    println(Arrays.toString(triangle.generate(5).toTypedArray()))
}
