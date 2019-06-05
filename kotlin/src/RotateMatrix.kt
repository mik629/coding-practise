fun rotate(matrix: Array<IntArray>): Boolean {
    val n = matrix.size
    if (n == 0 || n != matrix[0].size) {
        return false
    }

    for (layer in 0 until n / 2) {
        val last = n - 1 - layer
        for (i in layer until last) {
            val offset = i - layer
            val top = matrix[layer][i]

            matrix[layer][i] = matrix[last - offset][layer]
            matrix[last - offset][layer] = matrix[last][last - offset]
            matrix[last][last - offset] = matrix[i][last]
            matrix[i][last] = top
        }
    }
    return true
}


fun main() {
    val matrix = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 6, 7, 8),
            intArrayOf(9, 10, 11, 12),
            intArrayOf(13, 14, 15, 16)
    )
    println(matrix.asSequence().flatMap { it.asSequence() }.joinToString(separator = " "))

    println(rotate(matrix))

    println(matrix.asSequence().flatMap { it.asSequence() }.joinToString(separator = " "))
}