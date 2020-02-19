package main.kotlin

class OddEvenLinkedList {
    fun oddEvenList(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }

        var odd: ListNode? = null
        val evenHead = head.next
        var even: ListNode? = null
        var count = 1
        var next = head
        while (next != null) {
            if (count % 2 == 0) {
                if (even != null) {
                    even.next = next
                }
                even = next
            } else {
                if (odd != null) {
                    odd.next = next
                }
                odd = next
            }
            next = next.next
            count++
        }
        even?.next = null
        odd?.next = evenHead
        return head
    }
}

fun main() {
    val solution = OddEvenLinkedList()
    solution.oddEvenList(initList(intArrayOf(1, 2, 3, 4, 5)))
}

fun initList(values: IntArray): ListNode {
    val head = ListNode(values[0])
    var next: ListNode? = head
    for (i in 1 until values.size) {
        next?.next = ListNode(values[i])
        next = next?.next
    }
    return head
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}