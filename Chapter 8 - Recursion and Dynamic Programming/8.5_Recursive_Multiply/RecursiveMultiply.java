import java.util.Scanner;

/*
Write a recursive function to multiply two positive integers without using the * operator. You can use addition, subtraction, and bit shifting, but you should minimize the number of those operations.
*/

public class RecursiveMultiply {
    static int multiply(int a, int b) {
        if (a > b) return multiply(b, a);
        if (a == 1) return b;
        return b + multiply(a-1, b);
    }

    static int multiply2(int a, int b) {
        if (a == 0) return 0;
        int c = a;
        int d = b;
        while ((c & 1) != 1) {
            c >>= 1;
            d <<= 1;
        }
        return d + multiply2(a & (a-1), b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(multiply(a, b));
        System.out.println(multiply2(a, b));
    }
}
