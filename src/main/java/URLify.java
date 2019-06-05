public class URLify {
    public static void main(String[] args) {
        System.out.println(new URLify().encode("Mr John Smith0000"));
        System.out.println(new URLify().replaceSpaces("Mr John Smith0000".toCharArray(), 13));
    }

    private String replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0;
        for (int i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }

        if (trueLength < str.length) {
            str[trueLength] = '\0';
        }

        int index = trueLength + spaceCount * 2 - 1;
        for (int i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index] = '0';
                str[index - 1] = '2';
                str[index - 2] = '%';
                index = index - 3;
            } else {
                str[index] = str[i];
                index--;
            }
        }
        return String.copyValueOf(str);
    }

    public String encode(String source) {
        char[] sourceChars = source.toCharArray();
        for (int i = 0; i < source.length(); i++) {
            if (sourceChars[i] == ' ') {
                sourceChars[i] = '%';
                shift(sourceChars, i + 1, 2);
                sourceChars[i + 1] = '2';
                sourceChars[i + 2] = '0';
            }
        }
        return String.copyValueOf(sourceChars);
    }

    private void shift(char[] arr, int start, int offset) {
        int i = arr.length - 1;
        while (arr[i] == '0' && i > start) {
            i--;
        }

        for (; i >= start; i--) {
            arr[i + offset] = arr[i];
        }
    }
}
