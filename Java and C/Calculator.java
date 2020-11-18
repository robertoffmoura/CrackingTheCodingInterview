import java.util.Scanner;
import java.util.Stack;

public class Calculator {
    static boolean numeric(char c) {
        return ('0' <= c && c <= '9');
    }

    static int calculate(String string) {
        Stack<Double> values = new Stack<Double>();
        Stack<Boolean> positive = new Stack<Boolean>();
        Stack<Character> operations = new Stack<Character>();
        int a;
        int b;
        char operation;
        int j;
        for (int i=0; i<string.length(); i++) {
            boolean signal = true;
            for (j=i; j<string.length(); j++) {
                if (!numeric(string.charAt(j))) break;
            }
            a = Integer.parseInt(string.substring(i,j));

            System.out.println(string.substring(i,j));

            if (j > string.length() - 1) {
                values.add((double) a);
                positive.add(signal);
                break;
            }
            operation = string.charAt(j);
            i = j;

            while (operation == '*' || operation == '/') {
                for (j=i; j<string.length(); j++) {
                    if (!numeric(string.charAt(j))) break;
                }
                b = Integer.parseInt(string.substring(i,j));
                if (operation == '*') a *= b;
                else if (operation == '/') a /= b;
                if (j > string.length() - 1) break;
                operation = string.charAt(j);
                i = j;
            }

            values.add((double) a);
            positive.add(signal);

            if (operation == '-') signal = false;
        }

        int sum = 0;
        while (!values.isEmpty()) {
            sum += positive.pop() ? values.pop() : -1*values.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        System.out.println(calculate(string));
    }
}
