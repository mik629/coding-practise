package main.kotlin

class OddValuesCounter {
    fun oddCells(n: Int, m: Int, indices: Array<IntArray>): Int {
        val matrix: Array<IntArray> = Array(n) { IntArray(m) { 0 } }
        for (index in indices) {
            require(index.size == 2)
            require(index[0] in 0 until n)
            require(index[1] in 0 until m)
            for (j in 0 until m) {
                matrix[index[0]][j] += 1
            }
            for (i in 0 until n) {
                matrix[i][index[1]] += 1
            }
        }

        return matrix.flatMap { it.asList() }
            .filter { it % 2 == 1 }
            .count()
    }
}

fun main() {
    println(OddValuesCounter().oddCells(2, 3, arrayOf(intArrayOf(0, 1), intArrayOf(1, 1))))
    println(OddValuesCounter().oddCells(3, 2, arrayOf(intArrayOf(1, 1), intArrayOf(1, 1))))
    println(OddValuesCounter().oddCells(2, 2, arrayOf(intArrayOf(1, 1), intArrayOf(0, 0))))
}