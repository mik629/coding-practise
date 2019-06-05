public class IsStringUnique {
    public static void main(String[] args) {
        System.out.println(new IsStringUnique().isUnique("abcd"));
    }

    public boolean isUnique(String str) {
        StringBuilder alphabet = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (alphabet.indexOf(Character.toString(ch)) > 0) {
                return false;
            }
            alphabet.append(ch);
        }
        return true;
    }
}
