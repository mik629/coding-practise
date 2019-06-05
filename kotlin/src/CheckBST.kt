fun checkBST(root: BSTNode): Boolean {
    return checkBST(root, null, null)
}

fun checkBST(root: BSTNode?, min: Int?, max: Int?): Boolean {
    if (root == null) {
        return true
    }

    if ((min != null && root.data < min) || (max != null && root.data > max)) {
        return false
    }

    if (!checkBST(root.left, min, root.data) || !checkBST(root.right, root.data, max)) {
        return false
    }

    return true
}

fun main() {
    val r6 = BSTNode(6, null, null)
    val r5 = BSTNode(4, null, null)
    val r4 = BSTNode(5, r5, r6)
    val l3 = BSTNode(2, null, null)
    val l2 = BSTNode(0, null, null)
    val l1 = BSTNode(1, l2, l3)
    val root = BSTNode(3, l1, r4)

    println(checkBST(root))
}