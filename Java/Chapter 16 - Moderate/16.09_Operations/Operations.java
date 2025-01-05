import java.util.Scanner;

/*
Write methods to implement the multiply, subtract, and divide operations for integers. The results of all of these are integers. Use only the add operator.
*/

public class Operations {
    static int subtract(int a, int b) {
        if (b > a) return -1*subtract(b, a);
        int result = 0;
        for (int i=b; i<a; i++) {
            result++;
        }
        return result;
    }

    static int multiply(int a, int b) {
        if (a > b) return multiply(b, a);
        if (a < 0) return -1*multiply(-a, b);
        int result = 0;
        for (int i=0; i<a; i++) {
            result += b;
        }
        return result;
    }

    static int divide(int a, int b) {
        if (b == 0) return Integer.MAX_VALUE;
        if (a < 0) return -1*multiply(-a, b);
        if (b < 0) return -1*multiply(a, -b);
        int result = 0;
        for (int i = b; i <= a; i += b) {
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println("- :" + subtract(a, b));
        System.out.println("* :" + multiply(a, b));
        System.out.println("/ :" + divide(a, b));
    }
}
