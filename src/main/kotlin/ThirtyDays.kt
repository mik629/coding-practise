package main.kotlin

import java.util.*


fun singleNumber(nums: IntArray): Int {
    var sumNs = 0
    for (n in nums) {
        sumNs = sumNs.xor(n)
    }
    return sumNs
}

fun moveZeroesInPlace(nums: IntArray): Unit {
    var i = 0
    val arrSize = nums.size
    while (true) {
        while (i < arrSize && nums[i] != 0) {
            i++
        }
        if (i >= arrSize) {
            return
        }

        var j = i + 1
        while (j < arrSize && nums[j] == 0) {
            j++
        }
        if (j >= arrSize) {
            return
        }

        var k = j
        while (k < arrSize && nums[k] != 0) {
            k++
        }
        for (l in j until k) {
            nums[i] = nums[l]
            nums[l] = 0
            i++
        }
    }
}

//["eat", "tea", "tan", "ate", "nat", "bat"]

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    strs.sortByDescending { it.length }
    val res: MutableList<MutableList<String>> = mutableListOf()
    val alreadyProcessed: HashSet<String> = hashSetOf()
    val arrSize = strs.size
    for (i in 0 until arrSize) {
        val word1 = strs[i]
        if (!alreadyProcessed.contains(word1)) {
            val anagramGroup: MutableList<String> = mutableListOf(word1)
            for (j in i + 1 until arrSize) {
                val word2 = strs[j]
                if (word1.length != word2.length) {
                    break
                }
                if (isAnagram(word1, word2)) {
                    anagramGroup.add(word2)
                    alreadyProcessed.add(word2)
                }
            }
            if (anagramGroup.isNotEmpty()) {
                res.add(anagramGroup)
            }
            alreadyProcessed.add(word1)
        }
    }
    return res
}

fun divide(a: Long, b: Long): Double {
    return a / b.toDouble()
}

fun isAnagram(input1: String?, input2: String?): Boolean {
    return if (input1 != null && input2 != null && input1.length == input2.length) {
        val allLetters = IntArray(256)
        for (i in input1.indices) {
            allLetters[input1[i].toInt()]++
            allLetters[input2[i].toInt()]--
        }
        for (l in allLetters) {
            if (l != 0) {
                return false
            }
        }
        true
    } else {
        false
    }
}

fun simpleSearch(key: String, text: String): Int {
    val searchKey = key.toLowerCase()
    var pos = 0
    for (word in text.split(" ")) {
        pos++
        if (word.toLowerCase() == searchKey) {
            return pos
        }
    }
    return -1
}

fun countElements(arr: IntArray): Int {
    if (arr.size <= 1) {
        return 0
    }

    arr.sort()
    var countPairs = 0
    var prevSiblingIndex = 0
    for (a in arr) {
        val siblingIndex = arr.binarySearch(a + 1, prevSiblingIndex)
        if (siblingIndex > 0) {
            countPairs++
            prevSiblingIndex = siblingIndex + 1
        }
    }
    return countPairs
}

fun backspaceCompare(S: String, T: String): Boolean {
    val backspace = '#'
    var sBackspaces = 0
    var tBackspaces = 0
    var si = S.length - 1
    var ti = T.length - 1
    while (si >= 0 || ti >= 0) {
        while (si >= 0 && S[si] == backspace) {
            sBackspaces++
            si--
        }
        while (si >= 0 && sBackspaces > 0) {
            if (S[si] == backspace) {
                sBackspaces++
            } else {
                sBackspaces--
            }
            si--
        }

        while (ti >= 0 && T[ti] == backspace) {
            tBackspaces++
            ti--
        }
        while (ti >= 0 && tBackspaces > 0) {
            if (T[ti] == backspace) {
                tBackspaces++
            } else {
                tBackspaces--
            }
            ti--
        }

        if ((si >= 0 && S[si] == backspace) || (ti >= 0 && T[ti] == backspace)) {
            continue
        }

        if (si < 0 && ti < 0) {
            return true;
        } else if (si >= 0 && ti >= 0 && S[si] == T[ti]) {
            si--
            ti--
        } else {
            return false
        }
    }
    return true
}

fun main() {
    println(
        backspaceCompare(
            "x#end##outp###twoyc#nj###h#ozx##qy#m##cwjdrmn##wtje###v#r##nhew#k#xh#wsjc##",
            "j#x#g#end##outp#o###twoyc#l#l#nj###p#h#oa#zx##qyz##m##cwjdci##rmn##wtje###v#rq###nhew#kw##xh#wsjc##"
        )
    )
    println(backspaceCompare("########abc##", "ab#"))
    println(!backspaceCompare("########abc##", "#"))
    println(backspaceCompare("isfcow#", "isfcog#w#"))
    println(backspaceCompare("ab#c", "ad#c"))
    println(backspaceCompare("ab##", "c#d#"))
    println(backspaceCompare("a##c", "#a#c"))
    println(backspaceCompare("a####c", "#a#c"))
    println(backspaceCompare("##ac", "ac"))
    println(backspaceCompare("#####", ""))
    println(backspaceCompare("#####", "##"))
    println(backspaceCompare("", "aa##"))
    println(backspaceCompare("", ""))
    println(!backspaceCompare("", "aa#"))
    println(!backspaceCompare("aba", "aaa"))
    println(!backspaceCompare("##aba", "aaa"))
    println(!backspaceCompare("a#c", "b"))
    println("-----backspace end-----")

    println(countElements(intArrayOf()) == 0)
    println(countElements(intArrayOf(1)) == 0)
    println(countElements(intArrayOf(1, 2, 3)) == 2)
    println(countElements(intArrayOf(1, 1, 2)) == 1)
    println(countElements(intArrayOf(1, 2, 2, 2, 3)) == 2)
    println(countElements(intArrayOf(1, 1, 1, 1, 2, 3)) == 2)
    println(countElements(intArrayOf(1, 2, 3, 3, 3, 3)) == 2)
    println(countElements(intArrayOf(1, 1, 3, 3, 5, 5, 7, 7)) == 0)
    println(countElements(intArrayOf(1, 3, 2, 3, 5, 0)) == 3)
    println(countElements(intArrayOf(1, 1, 2, 2)) == 2)
    println(countElements(intArrayOf(1, 1, 2, 2, 3, 3)) == 4)
    println("---------------")

//    val scanner = Scanner(System.`in`)
//    val text = scanner.nextLine()
//    val key = scanner.nextLine()
//    val keyPosition = simpleSearch(key, text)
//    println(if (keyPosition > 0) keyPosition else "Not found")
//    println("%d %d".format(scanner.nextInt(), scanner.nextInt()))

//    val a = scanner.nextInt()
//    val b = scanner.nextInt()
//    val c = scanner.nextInt()
//    val d = scanner.nextInt()
//    val x = scanner.nextInt()
//    print(x in a..b || x in c..d)
//    print(scanner.nextDouble().toLong())

//    val sb = StringBuilder()
//    val inputSize = 4
//    for (i in 0 until inputSize) {
//        sb.append(scanner.next().matches("\\d".toRegex()))
//        if (i < inputSize - 1) {
//            sb.append("\\")
//        }
//    }
//    println(sb.toString())

    println(singleNumber(intArrayOf(2, 2, 1)) == 1)
    println(singleNumber(intArrayOf(4, 2, 1, 2, 1)) == 4)

    val severalZeroesInMiddle = intArrayOf(0, 1, 0, 0, 0, 2, 4, 3)
    moveZeroesInPlace(severalZeroesInMiddle)
    println(severalZeroesInMiddle.contentEquals(intArrayOf(1, 2, 4, 3, 0, 0, 0, 0)))

    val severalZeroesOnFront = intArrayOf(0, 0, 0, 2, 5, 3, 1)
    moveZeroesInPlace(severalZeroesOnFront)
    println(severalZeroesOnFront.contentEquals(intArrayOf(2, 5, 3, 1, 0, 0, 0)))

    val severalZeroesInTheEnd = intArrayOf(3, 5, 3, 7, 0, 0, 0)
    moveZeroesInPlace(severalZeroesInTheEnd)
    println(severalZeroesInTheEnd.contentEquals(intArrayOf(3, 5, 3, 7, 0, 0, 0)))

    val zeroesEverywhere = intArrayOf(0, 2, 0, 9, 0, 2, 0, 7, 0)
    moveZeroesInPlace(zeroesEverywhere)
    println(zeroesEverywhere.contentEquals(intArrayOf(2, 9, 2, 7, 0, 0, 0, 0, 0)))

    val emptyArray = intArrayOf()
    moveZeroesInPlace(emptyArray)
    println(emptyArray.contentEquals(intArrayOf()))
}
