import java.util.Scanner;

/*
Given a positive integer, print the next smallest and the next largest number that have the same number of 1 bits in their binary representation
*/

public class NextNumber {
    public static void printByte(int b) {
        int mask = ~(~0 >>> 1);
        while (mask != 0) {
            System.out.print((b & (mask)) != 0 ? 1 : 0);
            mask >>>= 1;
        }
        System.out.println("");
        //System.out.println(Integer.toBinaryString(b));
    }

    static int nextInt(int n) {//Book's Solution
        if (n == 0) return 0;
        int c0 = 0;
        int c1 = 0;
        int a = 1;
        for (; (a & n) == 0; a <<= 1) {
            c0++;
        }
        for (; (a & n) != 0; a <<= 1) {
            c1++;
        }
        return n + (1 << c0) + (1 << c1 - 1) - 1;
    }

    static int previousInt2(int n) {
        return ~nextInt(~n);
    }

    static int previousInt(int n) {
        if (n == ~0) return 0;
        int c0 = 0;
        int c1 = 0;
        int a = 1;
        for (; (a & n) != 0; a <<= 1) {
            c1++;
        }
        for (; (a & n) == 0; a <<= 1) {
            c0++;
        }
        return n - (1 << c1) - (1 << c0 - 1) + 1;
    }

    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        printByte(n);
        printByte(previousInt2(n));
    }
}
