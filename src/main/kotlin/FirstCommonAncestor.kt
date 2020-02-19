package main.kotlin

fun findFirstCommonAncestor(one: BTNode, other: BTNode): BTNode? {
    val delta = getDepth(one.parent) - getDepth(other.parent)
    var first: BTNode?
    var second: BTNode?
    if (delta > 0) {
        first = goUp(one, delta)
        second = other
    } else {
        first = goUp(other, delta)
        second = one
    }

    while (first != null && second != null && first != second) {
        first = first.parent
        second = second.parent
    }
    return if (first == null || second == null) {
        null
    } else {
        first
    }
}

private fun getDepth(parent: BTNode?): Int {
    var next = parent
    var depth = 0
    while (next != null) {
        depth++
        next = next.parent
    }
    return depth
}

private fun goUp(node: BTNode, delta: Int): BTNode {
    var steps = delta
    var next = node
    while (steps > 0) {
        next = next.parent!!
        steps--
    }
    return next
}

data class BTNode(val data: Int, val left: BTNode?, val right: BTNode?, val parent: BTNode?)