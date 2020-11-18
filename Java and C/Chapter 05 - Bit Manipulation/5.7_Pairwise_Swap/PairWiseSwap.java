import java.util.Scanner;

/*
Write a program to swap odd and even bits in an integer with as few instructions as possible (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on).
*/

public class PairWiseSwap {
    static void printByte(int b) {
        int mask = (1 << Integer.SIZE - 1);
        for (int i=0; i<Integer.SIZE; i++) {
            System.out.print((b & (mask)) != 0 ? 1 : 0);
            mask >>>= 1;
        }
        System.out.println("");
        //System.out.println(Integer.toBinaryString(b));
    }

    static int swap(int a) {
        for (int b = 1; b != 0; b = b << 2) {
            if ((((a & b) << 1) ^ (a & (b << 1))) != 0) {
                if ((a & b) != 0) a += b;
                else a -= b;
            }
        }
        return a;
    }

    static int swap2(int a) {
        return ((a & 0xaaaaaaaa) >>> 1) | ((a & 0x55555555) << 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        printByte(a);
        printByte(swap2(a));
    }
}
