package main.kotlin

class FrequencySort {
    fun frequencySort(s: String): String {
        val charFreq = hashMapOf<Char, Int>()
        for (ch in s) {
            var count = charFreq[ch]
            if (count == null) {
                count = 0
            }
            count++
            charFreq[ch] = count
        }

        val charFreqSorted = charFreq.toList().sortedBy { (_, value) -> -value }

        val res = StringBuilder()
        for (i in 0 until charFreq.size) {
            val next = charFreqSorted[i]
            var count = next.second
            while (count > 0) {
                res.append(next.first)
                count--
            }
        }
        return res.toString()
    }
}

fun main() {
    println(FrequencySort().frequencySort("Aabb"))
}