import java.util.Scanner;

/*
You have an integer and you can flip exactly one bit from a 0 to a 1. Write code to find the length of the longest sequence of 1s you could create.
EXAMPLE
Input: 1775 (or: 11011101111)
Output: 8
*/

public class FlipBitToWin {
    static int longestLength(int a) {
        int max = 0;
        while (a != 0) {
            int count = 0;
            for (int b = a | (a + 1); (b & 1) != 0; b = b >> 1) {
                //flips the first 0 and counts how many 1s there are in sequence
                count++;
            }
            if (count > max) {
                max = count;
            }
            for (a = a & (a + 1); (a & 1) != 1; a = a >> 1) {
                //removes the first sequence of 1s and shifts left
                if (a == 0) break;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.println(longestLength(a));
    }
}
