package main.kotlin

class FreqCounter {

    fun numSmallerByFrequency(queries: Array<String>, words: Array<String>): IntArray {
        require(queries.isNotEmpty() && words.isNotEmpty())
        val res = IntArray(queries.size)
        val qFreqs = countFreqs(queries)
        val wFreqs = countFreqs(words)
        wFreqs.sortDescending()
        for (i in res.indices) {
            for (wf in wFreqs) {
                if (qFreqs[i] < wf) {
                    res[i]++
                } else {
                    break
                }
            }
        }
        return res
    }

    private fun countFreqs(strings: Array<String>): IntArray {
        val freqs = IntArray(strings.size)
        for (i in strings.indices) {
            freqs[i] = f(strings[i])
        }
        return freqs
    }

    fun f(s: String): Int {
        if (s.isEmpty()) {
            return 0
        }
        val chars = s.toCharArray()
        chars.sort()
        return s.count { ch -> ch == chars[0] }
    }
}

fun main() {
    val solution = FreqCounter()
    println(solution.f("dcce") == 2)
    println(solution.f("zaaaz") == 3)
    println(solution.f("azbc") == 1)
    println(solution.f("zabca") == 2)
    println(solution.f("z") == 1)
    println(solution.f("") == 0)

    val queries = Array(2000) { _ -> "aabbbcccc" }
    val words = Array(2000) { _ -> "aaabbbcccc" }

    println(solution.numSmallerByFrequency(arrayOf("cbd"), arrayOf("zaaaz")).joinToString() == "1")
    println(
        solution.numSmallerByFrequency(
            arrayOf("bbb", "cc"),
            arrayOf("a", "aa", "aaa", "aaaa")
        ).joinToString() == "1, 2"
    )
    println(
        solution.numSmallerByFrequency(
            arrayOf("bbb", "cccc"),
            arrayOf("a", "aa", "aaa")
        ).joinToString() == "0, 0"
    )
    println(
        solution.numSmallerByFrequency(
            arrayOf("b", "cc"),
            arrayOf("bbbb", "aaa", "ggggg")
        ).joinToString() == "3, 3"
    )
    println(
        solution.numSmallerByFrequency(
            arrayOf("", "ccc"),
            arrayOf("bbbb", "aaa", "ggggg")
        ).joinToString() == "3, 2"
    )
    println(solution.numSmallerByFrequency(arrayOf("a", "ccc"), arrayOf("", "", "bb")).joinToString() == "1, 0")
    println(
        solution.numSmallerByFrequency(
            arrayOf("a", "ccc", "bb", "ddd"),
            arrayOf("", "", "bb")
        ).joinToString() == "1, 0, 0, 0"
    )
    println(solution.numSmallerByFrequency(arrayOf("a", "ccc"), arrayOf("", "", "bc")).joinToString() == "0, 0")
    println(
        solution.numSmallerByFrequency(
            queries,
            words
        ).joinToString() == Array(2000) { _ -> 2000 }.joinToString()
    )
}