import java.util.Scanner;
import java.util.HashMap;

public class BooleanEvaluation {
    static int count(String string, boolean result) {
        return count(0, string, result);
    }
    static int count(int last, String string, boolean result) {
        if (string.length() == 1) {
            return string.equals("1") == result ? 1 : 0;
        }
        int c = 0;
        if (last < 0) last = 0;
        for (int i=last; i<string.length()-2; i+= 2) {
            boolean a = (string.charAt(i) == '1');
            boolean b = (string.charAt(i + 2) == '1');
            if (string.charAt(i + 1) == '^') {
                int r = a^b ? 1 : 0;
                c += count(i-2, string.substring(0, i) + r + string.substring(i + 3), result);
            } else if (string.charAt(i + 1) == '|') {
                int r = a|b ? 1 : 0;
                c += count(i-2, string.substring(0, i) + r + string.substring(i + 3), result);
            } else if (string.charAt(i + 1) == '&') {
                int r = a&b ? 1 : 0;
                c += count(i-2, string.substring(0, i) + r + string.substring(i + 3), result);
            }
        }
        return c;
    }

    static int count2(String string, boolean result) {
        HashMap<String, Integer> memory = new HashMap<String, Integer>();
        return count2(0, string, result, memory);
    }
    static int count2(int last, String string, boolean result, HashMap<String, Integer> memory) {
        if (string.length() == 1) {
            return string.equals("1") == result ? 1 : 0;
        }
        if (memory.containsKey(string + result)) return memory.get(string + result);
        int c = 0;
        if (last < 0) last = 0;
        for (int i=last; i<string.length()-2; i+=2) {
            boolean a = (string.charAt(i) == '1');
            boolean b = (string.charAt(i + 2) == '1');
            if (string.charAt(i + 1) == '^') {
                int r = a^b ? 1 : 0;
                c += count2(i-2, string.substring(0, i) + r + string.substring(i + 3), result, memory);
            } else if (string.charAt(i + 1) == '|') {
                int r = a|b ? 1 : 0;
                c += count2(i-2, string.substring(0, i) + r + string.substring(i + 3), result, memory);
            } else if (string.charAt(i + 1) == '&') {
                int r = a&b ? 1 : 0;
                c += count2(i-2, string.substring(0, i) + r + string.substring(i + 3), result, memory);
            }
        }
        memory.put(string + result, c);
        return c;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        boolean result = scanner.nextLine().equals("true");
        System.out.println(count2(string, result));
        System.out.println(count(string, result));
    }
}
