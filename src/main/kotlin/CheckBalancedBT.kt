package main.kotlin

import kotlin.math.abs
import kotlin.math.max

fun isBalanced(root: BSTNode?): Boolean {
    if (root == null) {
        return true
    }
    return isBalanced(root.left) && isBalanced(root.right)
            && abs(countNodes(root.left) - countNodes(root.right)) <= 1
}

fun countNodes(root: BSTNode?): Int {
    if (root == null) {
        return -1
    }
    return max(
        countNodes(root.left),
        countNodes(root.right)
    ) + 1
}

fun main() {
    val r5 = BSTNode(5, null, null)
    val r6 = BSTNode(6, null, null)
    val r4 = BSTNode(4, r5, r6)
    val l3 = BSTNode(3, null, null)
//    val l3 = null
//    val l2 = null
//    val l1 = null
    val l2 = BSTNode(2, null, null)
    val l1 = BSTNode(1, l2, l3)
    val root = BSTNode(0, l1, r4)

    println(isBalanced(root))
    println(checkHeight(root) != Int.MIN_VALUE)
}

fun checkHeight(root: BSTNode?): Int {
    if (root == null) {
        return -1
    }

    val left = checkHeight(root.left)
    if (left == Int.MIN_VALUE) {
        return Int.MIN_VALUE
    }
    val right = checkHeight(root.right)
    if (right == Int.MIN_VALUE) {
        return Int.MIN_VALUE
    }

    val diff = abs(left - right)
    if (diff > 1) {
        return Int.MIN_VALUE
    } else {
        return max(left, right) + 1
    }
}