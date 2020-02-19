/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class ListsMerger {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode startNode;
        if (l1.val <= l2.val) {
            startNode = l1;
            l1 = l1.next;
        } else {
            startNode = l2;
            l2 = l2.next;
        }

        ListNode nextNode = startNode;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                nextNode.next = l2;
                l2 = l2.next;
            } else {
                nextNode.next = l1;
                l1 = l1.next;
            }
            nextNode = nextNode.next;
        }

        if (l1 == null) {
            nextNode.next = l2;
        } else {
            nextNode.next = l1;
        }
        return startNode;
    }
}

//class ListsMerger {
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        List<ListNode> res = new ArrayList<>();
//        while (l1 != null && l2 != null) {
//            if (l1.val > l2.val) {
//                res.add(l2);
//                l2 = l2.next;
//            } else {
//                res.add(l1);
//                l1 = l1.next;
//            }
//        }
//
//        if (l1 == null) {
//            while (l2 != null) {
//                res.add(l2);
//                l2 = l2.next;
//            }
//        } else {
//            while (l1 != null) {
//                res.add(l1);
//                l1 = l1.next;
//            }
//        }
//
//        if (res.isEmpty()) {
//            return l1;
//        }
//
//        ListNode root = res.get(0);
//        ListNode next = root;
//        for (int i = 1; i < res.size(); i ++) {
//            next.next = res.get(i);
//            next = next.next;
//        }
//        return root;
//    }
//}
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) { val = x; }
}