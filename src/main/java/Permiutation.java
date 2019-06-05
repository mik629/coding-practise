public class Permiutation {
    public static void main(String[] args) {
        System.out.println(new Permiutation().isPermutation("abc", "cba"));
        System.out.println(new Permiutation().isPermutation("abc", "cda"));
    }

    public boolean isPermutation(String one, String another) {
        if (one.length() != another.length()) {
            throw new IllegalArgumentException("Strings must be of the same length");
        }

        StringBuilder sbAnother = new StringBuilder(another);
        for (char ch : one.toCharArray()) {
            int found = sbAnother.indexOf(Character.toString(ch));
            if (found == -1) {
                return false;
            } else {
                sbAnother.deleteCharAt(found);
            }
        }
        return true;
    }
}
