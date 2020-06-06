import java.util.*;

public class FireCode {
    public static String insertPairStar(String s) {
        if (s != null) {
            StringBuilder res = new StringBuilder();
            char prev = Character.MIN_VALUE;
            for (int i = 0; i < s.length(); i++) {
                char currentCh = s.charAt(i);
                if (currentCh == prev) {
                    res.append('*');
                }
                res.append(currentCh);
                prev = currentCh;
            }
            return res.toString();
        } else {
            return null;
        }
    }

    public static boolean isIsomorphic(String input1, String input2) {
        Map<Character, Character> ch1ToCh2 = new HashMap<>();
        Map<Character, Character> ch2ToCh1 = new HashMap<>();
        if (input1.length() == input2.length()) {
            for (int i = 0; i < input1.length(); i++) {
                char ch1 = input1.charAt(i);
                char ch2 = input2.charAt(i);
                if (!ch1ToCh2.containsKey(ch1)) {
                    ch1ToCh2.put(ch1, ch2);
                }
                if (!ch2ToCh1.containsKey(ch2)) {
                    ch2ToCh1.put(ch2, ch1);
                }
                if (ch1ToCh2.get(ch1) != ch2 || ch2ToCh1.get(ch2) != ch1) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public static ListNode deleteAtTail(ListNode head) {
        if (head.next == null || head.next == head) {
            return head;
        }
        ListNode next = head;
        ListNode prev = head;
        while (next.next != head) {
            prev = next;
            next = next.next;
        }
        prev.next = head;
        return head;
    }

    private static class ListNode {
        private static final String DELIMITER = " => ";
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();
            res.append(val)
                    .append(DELIMITER);
            ListNode nextN = next;
            while (nextN != this) {
                res.append(nextN.val)
                        .append(DELIMITER);
                nextN = nextN.next;
            }
            res.append("*")
                    .append(val);
            return res.toString();
        }
    }

    public static String computeBinary(int val) {
        if (val == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        while (val > 0) {
            res.insert(0, val % 2);
            val /= 2;
        }
        return res.toString();
    }

    public static boolean isAnagram(String input1, String input2) {
        if (input1 != null && input2 != null && input1.length() == input2.length()) {
            int[] allLetters = new int[256];
            for (int i = 0; i < input1.length(); i++) {
                allLetters[input1.charAt(i)]++;
                allLetters[input2.charAt(i)]--;
            }
            for (int l : allLetters) {
                if (l != 0) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public static int[] selectionSortArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int minj = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minj = j;
                }
            }
            arr[minj] = arr[i];
            arr[i] = min;
        }
        return arr;
    }

    public static int[] merge(int[] arrLeft, int[] arrRight) {
        int lLength = arrLeft.length;
        int rLength = arrRight.length;
        int[] res = new int[lLength + rLength];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < lLength && j < rLength && k < lLength + rLength) {
            if (arrLeft[i] < arrRight[j]) {
                res[k] = arrLeft[i];
                i++;
            } else {
                res[k] = arrRight[j];
                j++;
            }
            k++;
        }
        if (i < lLength) {
            System.arraycopy(arrLeft, i, res, k, lLength - i);
        }
        if (j < rLength) {
            System.arraycopy(arrRight, j, res, k, rLength - j);
        }
        return res;
    }

    public ArrayList<Integer> preorderItr(TreeNode root) {
        ArrayList<Integer> preoderedList = new ArrayList<>();
        if (root == null) {
            return preoderedList;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.push(root);

        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.pop();
            preoderedList.add(treeNode.data);
            if (treeNode.right != null) {
                queue.push(treeNode.right);
            }
            if (treeNode.left != null) {
                queue.push(treeNode.left);
            }
        }
        return preoderedList;
    }

    public int size(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + size(root.left) + size(root.right);
    }

    public static boolean validateBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.data > root.data) {
            return false;
        }
        if (root.right != null && root.right.data < root.data) {
            return false;
        }
        return isAllSmaller(root.left, root.data) && validateBST(root.left)
                && isAllBigger(root.right, root.data) && validateBST(root.right);
    }

    private static boolean isAllSmaller(TreeNode subRoot, int data) {
        if (subRoot == null) {
            return true;
        }
        if (subRoot.left != null && subRoot.left.data > data) {
            return false;
        }
        if (subRoot.right != null && subRoot.right.data > data) {
            return false;
        }
        return isAllSmaller(subRoot.left, data) && isAllSmaller(subRoot.right, data);
    }

    private static boolean isAllBigger(TreeNode subRoot, int data) {
        if (subRoot == null) {
            return true;
        }
        if (subRoot.left != null && subRoot.left.data < data) {
            return false;
        }
        if (subRoot.right != null && subRoot.right.data < data) {
            return false;
        }
        return isAllSmaller(subRoot.left, data) && isAllBigger(subRoot.right, data);
    }

    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private static class BinTreeTraverser {
        ArrayList<Integer> preorderedList = new ArrayList<Integer>();

        public void preorder(TreeNode root) {
            if (root == null) {
                return;
            }
            preorderedList.add(root.data);
            preorder(root.left);
            preorder(root.right);
        }

    }

    public static TreeNode findNode(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode next = queue.poll();
            if (next.data == val) {
                return next;
            }
            if (next.left != null) {
                queue.add(next.left);
            }
            if (next.right != null) {
                queue.add(next.right);
            }
        }
        return null;
    }

    // 1 3 2 0 5 7 4
    public static int maxGain(int[] a) {
        int maxGain = 0;
        int min = Integer.MAX_VALUE;
        for (int next : a) {
            if (next - min > maxGain) {
                maxGain = next - min;
            }
            if (next < min) {
                min = next;
            }
        }
        return maxGain;
    }

    public static boolean permutation(String str1, String str2) {
        Map<Character, Integer> chToCount1 = buildChMap(str1);
        Map<Character, Integer> chToCount2 = buildChMap(str2);
        for (Map.Entry<Character, Integer> entry : chToCount1.entrySet()) {
            if (entry.getValue() != chToCount2.get(entry.getKey())) {
                return false;
            }
        }
        return true;
    }

    private static Map<Character, Integer> buildChMap(String str) {
        Map<Character, Integer> chToCount = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            chToCount.computeIfPresent(ch, (k, v) -> v + 1);
            chToCount.putIfAbsent(ch, 1);
        }
        return chToCount;
    }

    public static Boolean isIntPalindrome(int x) {
        int num = x;
        int reverted = 0;
        while (num > 0) {
            reverted = reverted * 10 + num % 10;
            num = num / 10;
        }
        return x == reverted;
    }

    public static void transposeMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    public static int[] rotateLeft(int[] arr, int k) {
        int shift = k % arr.length;
        if (shift > 0) {
            reverse(arr, 0, arr.length - 1);
            reverse(arr, 0, arr.length - 1 - shift);
            reverse(arr, arr.length - shift, arr.length - 1);
        }
        return arr;
    }

    private static void reverse(int[] arr, int l, int r) {
        for (int i = l, j = r; i <= j && j >= l; i++, j--) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    public int minTreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int minDepth = 0;
        while (!queue.isEmpty()) {
            TreeNode next = queue.poll();
            minDepth++;
            if (next.left == null && next.right == null) {
                break;
            }
            if (next.left != null) {
                queue.add(next.left);
            }
            if (next.right != null) {
                queue.add(next.right);
            }
        }
        return minDepth;
    }

    public TreeNode findKthSmallest(TreeNode root, int k) {
        if (root == null) {
            return null;
        }
        List<TreeNode> inorder = new ArrayList<>();
        traverse(root, inorder);
        return k < inorder.size() ? inorder.get(k) : null;
    }

    private void traverse(TreeNode root, List<TreeNode> inorder) {
        if (root == null) {
            return;
        }
        traverse(root.left, inorder);
        inorder.add(root);
        traverse(root.right, inorder);
    }

    public ListNode reverseListWithStack(ListNode head) {
        if (head == null) {
            return null;
        }
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode next = head;
        while (next != null) {
            stack.push(next);
            next = next.next;
        }
        ListNode newHead = stack.pop();
        ListNode node = newHead;
        while (!stack.isEmpty()) {
            ListNode curr = stack.pop();
            node.next = curr;
            node = curr;
        }
        node.next = null;
        return newHead;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head;
        ListNode prev = null;
        while (next != null) {
            ListNode tmp = next.next;
            next.next = prev;
            prev = next;
            next = tmp;
        }
        return prev;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.equals(
                        rotateLeft(new int[]{1, 2, 3, 4, 5}, 2),
                        new int[]{3, 4, 5, 1, 2}
                )
        );
        System.out.println(
                Arrays.equals(
                        rotateLeft(new int[]{1, 5, 3}, 6),
                        new int[]{1, 5, 3}
                )
        );
        System.out.println(
                Arrays.equals(
                        rotateLeft(new int[]{1}, 6),
                        new int[]{1}
                )
        );
        System.out.println(
                Arrays.equals(
                        rotateLeft(new int[]{1, 7, 3, 5, 1}, 0),
                        new int[]{1, 7, 3, 5, 1}
                )
        );
        System.out.println(
                Arrays.equals(
                        rotateLeft(new int[]{1, 2, 3, 5, 4}, 1),
                        new int[]{2, 3, 5, 4, 1}
                )
        );
        System.out.println("------rotate------");


        int[][] orig = {
                {1, 9, 5},
                {6, 0, 2},
                {3, 4, 7}
        };
        transposeMatrix(orig);
        System.out.println(
                Arrays.deepEquals(
                        orig,
                        new int[][]{
                                {1, 6, 3},
                                {9, 0, 4},
                                {5, 2, 7},
                        }
                )
        );
        System.out.println("------transposeMatrix------");


        System.out.println(isIntPalindrome(1221));
        System.out.println(isIntPalindrome(-1) == false);
        System.out.println(isIntPalindrome(0));
        System.out.println(isIntPalindrome(12321));
        System.out.println("-------palindrome--------");


        System.out.println(permutation("C", "C"));
        System.out.println(permutation("", ""));
        System.out.println(permutation("CAT", "ACT"));
        System.out.println(permutation("hello", "aloha") == false);
        System.out.println("-----permutation-------");


        System.out.println(
                maxGain(new int[]{1, 3, 2, 0, 5, 7, 4}) == 7
        );
        System.out.println(
                maxGain(new int[]{}) == 0
        );
        System.out.println(
                maxGain(new int[]{5, 3, 2, 1, 0}) == 0
        );
        System.out.println(
                maxGain(new int[]{5, 3}) == 0
        );
        System.out.println(
                maxGain(new int[]{3, 5}) == 2
        );
        System.out.println(
                maxGain(new int[]{5}) == 0
        );
        System.out.println(
                maxGain(new int[]{5, 5, 5}) == 0
        );
        System.out.println("-------maxGain-------");

        merge(
                new int[]{2, 4, 6},
                new int[]{1, 3, 5}
        );

        System.out.println(insertPairStar("sos").equals("sos"));
        System.out.println(insertPairStar("sss").equals("s*s*s"));
        System.out.println(insertPairStar("aas").equals("a*as"));
        System.out.println(insertPairStar("a").equals("a"));
        System.out.println(insertPairStar("").equals(""));

        System.out.println("isIsomorphic");
        System.out.println(isIsomorphic("css", "dll"));
        System.out.println(isIsomorphic("css", "dle") == false);
        System.out.println(isIsomorphic("abcabc", "xyzxyz"));
        System.out.println(isIsomorphic("abcabc", "xbexyz") == false);
        System.out.println(isIsomorphic("abcabc", "xzyxyz") == false);

        ListNode head = new ListNode(1);
        ListNode next = head;
        for (int i = 2; i < 7; i++) {
            next.next = new ListNode(i);
            next = next.next;
        }
        next.next = head;
        System.out.println("deleteAtTail:");
        System.out.println(head);
        System.out.println(deleteAtTail(head));

        ListNode circled = new ListNode(1);
        circled.next = circled;
        System.out.println(circled);
        System.out.println(deleteAtTail(circled));

        System.out.println("ComputeBinary:");
        System.out.println(computeBinary(5).equals("101"));
        System.out.println(computeBinary(6).equals("110"));

        System.out.println("Anagram:");
        System.out.println(isAnagram("cam", "mac"));
        System.out.println(isAnagram("abc", "cab"));
        System.out.println(isAnagram("c", "c"));
        System.out.println(isAnagram("", ""));
        System.out.println(isAnagram("cam", "man") == false);
    }
}
