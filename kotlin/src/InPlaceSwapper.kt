fun swap(n1: Int, n2: Int): Pair<Int, Int> {
    var num1 = n1
    var num2 = n2
    num1 += num2
    num2 = num1 - num2
    num1 -= num2
    return num1 to num2
}

fun main() {
    print(swap(1, 4))
}