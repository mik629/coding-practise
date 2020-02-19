package main.kotlin

fun createList(root: BSTNode): MutableList<MutableList<Int>> {
    val lists = mutableListOf<MutableList<Int>>()
    createList(root, lists, 0)
    return lists
}

fun createList(root: BSTNode, lists: MutableList<MutableList<Int>>, level: Int) {
    if (lists.size == level) {
        lists.add(mutableListOf(root.data))
    } else {
        lists[level].add(root.data)
    }

    if (root.left != null) {
        createList(root.left, lists, level + 1)
    }
    if (root.right != null) {
        createList(root.right, lists, level + 1)
    }
}

fun main() {
    val r5 = BSTNode(5, null, null)
    val r6 = BSTNode(6, null, null)
    val r4 = BSTNode(4, r5, r6)
    val l3 = BSTNode(3, null, null)
    val l2 = BSTNode(2, null, null)
    val l1 = BSTNode(1, l2, l3)
    val root = BSTNode(0, l1, r4)

    print(
            createList(root).asSequence()
                    .map { it.joinToString(" ") }
                    .joinToString(separator = ",")
    )
}

data class BSTNode(val data: Int, val left: BSTNode?, val right: BSTNode?)