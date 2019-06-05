import java.util.HashMap;
import java.util.Map;

class IntToRoman {
    private static Map<Integer, String> INT_TO_ROMAN;

    static {
        INT_TO_ROMAN = new HashMap<>();
        INT_TO_ROMAN.put(1, "I");
        INT_TO_ROMAN.put(5, "V");
        INT_TO_ROMAN.put(10, "X");
        INT_TO_ROMAN.put(50, "L");
        INT_TO_ROMAN.put(100, "C");
        INT_TO_ROMAN.put(500, "D");
        INT_TO_ROMAN.put(1000, "M");
    }

    public static void main(String[] args) {
        System.out.println(new IntToRoman().intToRoman(1994));
    }

    public String intToRoman(int num) {
        StringBuilder romanumber = new StringBuilder();
        int next = num;
        int tens = 1;
        while (next > 0) {
            int i = next % 10;
            if (i > 0) {
                int iTenth = i * tens;
                String roman = INT_TO_ROMAN.get(iTenth);
                if (roman != null) {
                    romanumber.insert(0, roman);
                } else {
                    String corner = INT_TO_ROMAN.get((i + 1) * tens);
                    if (corner != null) {
                        romanumber.insert(0, corner);
                        switch (corner) {
                            case "V":
                            case "X":
                                romanumber.insert(0, "I");
                                break;
                            case "C":
                            case "L":
                                romanumber.insert(0, "X");
                                break;
                            case "D":
                            case "M":
                                romanumber.insert(0, "C");
                                break;
                        }
                    } else if (iTenth > 1 && iTenth < 5) {
                        iterativeInsert(romanumber, iTenth, "I", 1);
                    } else if (iTenth > 5 && iTenth < 10) {
                        iterativeInsert(romanumber, iTenth - 5, "I", 1);
                        iterativeInsert(romanumber, iTenth, "V", 5);
                    } else if (iTenth > 10 && iTenth < 50) {
                        iterativeInsert(romanumber, iTenth, "X", 10);
                    } else if (iTenth > 50 && iTenth < 100) {
                        iterativeInsert(romanumber, iTenth - 50, "X", 10);
                        iterativeInsert(romanumber, iTenth, "L", 50);
                    } else if (iTenth > 100 && iTenth < 500) {
                        iterativeInsert(romanumber, iTenth, "C", 100);
                    } else if (iTenth > 500 && iTenth < 1000) {
                        iterativeInsert(romanumber, iTenth - 500, "C", 100);
                        iterativeInsert(romanumber, iTenth, "D", 500);
                    } else {
                        iterativeInsert(romanumber, iTenth, "M", 1000);
                    }
                }
            }
            next /= 10;
            tens *= 10;
        }
        return romanumber.toString();
    }

    private void iterativeInsert(StringBuilder romanumber, int iTenth, String roman, int decrement) {
        int count = iTenth;
        while ((count = count - decrement) >= 0) {
            romanumber.insert(0, roman);
        }
    }
}