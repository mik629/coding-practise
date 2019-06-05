class Palindrome {
    public boolean isPalindrome(int x) {
        StringBuilder queue = new StringBuilder();
        if (x < 0) {
            queue.append('-');
        }
        int next = x == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(x);
        while (next > 0) {
            int digit = next % 10;
            queue.append(digit);
            next /= 10;
        }

        for (int i = 0, j = queue.length() - 1; i < queue.length() && j >= 0; i++, j--) {
            if (queue.charAt(i) != queue.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}