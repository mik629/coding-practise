package main.kotlin

fun main(args: Array<String>) {
    val j = readLine()!!
    val s = readLine()!!

    val jMap: MutableMap<Char, Int> = countChars(j)
    val sMap: Map<Char, Int> = countChars(s)
    var res = 0
    for (jKey in jMap.keys) {
        val sVal = sMap[jKey]
        if (sVal != null) {
            res += sVal
        }
    }
    println(res)
}

private fun countChars(str: String): MutableMap<Char, Int> {
    val chMap = mutableMapOf<Char, Int>()
    for (ch in str.toCharArray()) {
        var chCount = chMap[ch]
        if (chCount != null) {
            chCount++
        } else {
            chCount = 1
        }
        chMap[ch] = chCount
    }
    return chMap
}