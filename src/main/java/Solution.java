import java.util.*;
import java.util.Scanner;

import com.sun.jmx.remote.internal.ArrayQueue;

// Write your code here. DO NOT use an access modifier in your class declaration.
class Solution {

    public static void main(String[] args) {
        Parser parser = new Parser();

        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            System.out.println(parser.isBalanced(in.next()));
        }

        in.close();
    }
}

class Parser {
    public boolean isBalanced(String s) {
        int sLength = s.length();
        if (sLength % 2 > 0) {
            return false;
        }
        int i = 0;
        int j = 0;
        // {}()
        // {({})}
        while (i < sLength) {
            char next = s.charAt(i);
            if (isClosed(next) && j > 0 && !matches(s.charAt(--j), next)) {
                return false;
            } else {
                j++;
            }
            i++;
        }
        return true;
    }

    private boolean isClosed(char ch) {
        return ch == '}' || ch == ')';
    }

    private boolean matches(char open, char closed) {
        switch (open) {
            case '(':
                return closed == ')';
            case '{':
                return closed == '}';
            default:
                throw new UnsupportedOperationException();
        }
    }
}
