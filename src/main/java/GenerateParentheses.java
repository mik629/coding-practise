import java.util.ArrayList;
import java.util.List;

class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> solutions = new ArrayList<>();
        recursion(n, "", solutions);
        return solutions;
    }

    private void recursion(int n, String str, List<String> sol) {
        if (str.length() == 2 * n)
            sol.add(str);
        else {
            int left = 0;
            int right = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(')
                    left++;
                if (str.charAt(i) == ')')
                    right++;
            }
            if (left == right)
                recursion(n, str + "(", sol);
            else if (right < left) {
                if (left < n)
                    recursion(n, str + "(", sol);
                recursion(n, str + ")", sol);
            }
        }
    }
}