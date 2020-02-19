package main.kotlin

class UnresolvedCombinationSum {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        sum(0, candidates, target, mutableListOf(), result)
        return result
    }

    private fun sum(
        i: Int,
        candidates: IntArray,
        target: Int,
        combo: MutableList<Int>,
        result: MutableList<List<Int>>
    ) {
        if (target == 0) {
            result.add(combo)
            combo.clear()
            return
        } else if (target < 0) {
            val lastNumber = combo.removeAt(combo.size - 1)
            sum(i + 1, candidates, target + lastNumber, combo, result)
            return
        }
        combo.add(candidates[i])
        sum(i, candidates, target - candidates[i], combo, result)
    }
}

fun main() {
    val solution = UnresolvedCombinationSum()
    println(solution.combinationSum(intArrayOf(2, 3, 6, 7), 7))
}