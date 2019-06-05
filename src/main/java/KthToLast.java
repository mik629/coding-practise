public class KthToLast {
    int printKthToLast(LinkNode head, int k) {
        if (head == null) {
            return 0;
        }

        int count = printKthToLast(head.getNext(), k) + 1;
        if (count == k) {
            System.out.println(head.getValue());
        }
        return count;
    }
}

class LinkNode {
    private int value;
    private LinkNode next;

    public LinkNode(int value, LinkNode next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public LinkNode getNext() {
        return next;
    }
}
