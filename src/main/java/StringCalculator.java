public class StringCalculator {

    private static final String CUSTOM_DELIMITER_MARKER = "//";
    private static final String DELIMITER_SEPARATOR = "\n";
    private static final String SEPARATOR = "[,\n]";

    public static int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        String[] strings;
        if (numbers.startsWith(CUSTOM_DELIMITER_MARKER)) {
            String[] delToStrings = numbers.substring(CUSTOM_DELIMITER_MARKER.length()).split(DELIMITER_SEPARATOR);
            String delimiter = delToStrings[0];
            strings = delToStrings[1].split(delimiter);
        } else {
            strings = numbers.split(SEPARATOR);
        }

        StringBuilder negatives = new StringBuilder();
        int res = 0;
        for (String str : strings) {
            int num = Integer.parseInt(str);
            if (num < 0) {
                negatives.append(num).append(',');
            } else if (num <= 1000) {
                res += num;
            }
        }

        if (negatives.length() > 0) {
            negatives.deleteCharAt(negatives.length() - 1);
            throw new UnsupportedOperationException(String.format("negatives %s are not allowed", negatives.toString()));
        }
        return res;
    }
}
