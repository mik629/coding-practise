package main.kotlin

/**
 * Example:
 * var li = main.kotlin.ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class main.kotlin.ListNode(var `val`: Int) {
 *     var next: main.kotlin.ListNode? = null
 * }
 */
class DeduplicateLinkedList {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head == null) {
            return head
        }

        var next = head
        var prev = head
        while (next != null) {
            if (prev!!.`val` != next.`val`) {
                prev.next = next
                prev = next
            }
            next = next.next
        }
        prev!!.next = null
        return head
    }
}

fun main() {
    val solution = DeduplicateLinkedList()
    solution.deleteDuplicates(initList(intArrayOf(1, 1, 2, 3, 4, 5)))
}