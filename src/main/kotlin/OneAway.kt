package main.kotlin

fun isOneAway(one: String, two: String): Boolean {
    val oneCharSet = one.toList()
    val twoCharSet = two.toList()
    val symmetricSub = oneCharSet.minus(twoCharSet)
//    val subtraction1 = oneCharSet - twoCharSet
//    val subtraction2 = twoCharSet - oneCharSet
//    val symmetricSub = subtraction1.union(subtraction2)
    return one.length == two.length && symmetricSub.size == 2 || symmetricSub.size == 1
}

operator fun List<Char>.minus(other: List<Char>): List<Char> {
    val listA = this.toMutableList()
    val listB = other.toMutableList()
    for (e in this) {
        listB.remove(e)
    }

    for (e in other) {
        listA.remove(e)
    }
    return listA + listB
}

fun main() {
    println(isOneAway("palale", "palle"))
    println(isOneAway("ppale", "pale"))
    println(isOneAway("pale", "pales"))
    println(isOneAway("pale", "spale"))
    println(isOneAway("pale", "bale"))
    println(isOneAway("pale", "bake"))

    println(oneEditAway("pale", "palel"))
}

fun oneEditAway(first: String, second: String): Boolean {
    if (first.length == second.length) {
        return oneEditReplace(first, second)
    } else if (first.length + 1 == second.length) {
        return oneEditInsert(first, second)
    } else if (first.length - 1 == second.length) {
        return oneEditInsert(second, first)
    }
    return false
}

fun oneEditReplace(s1: String, s2: String): Boolean {
    var foundDifference = false
    for (i in 0 until s1.length) {
        if (s1[i] != s2[i]) {
            if (foundDifference) {
                return false
            }

            foundDifference = true
        }
    }
    return true
}

/* Check if you can insert a character into s1 to make s2. */
fun oneEditInsert(s1: String, s2: String): Boolean {
    var index1 = 0
    var index2 = 0
    while (index2 < s2.length && index1 < s1.length) {
        if (s1[index1] != s2[index2]) {
            if (index1 != index2) {
                return false
            }
            index2++
        } else {
            index1++
            index2++
        }
    }
    return true
}
