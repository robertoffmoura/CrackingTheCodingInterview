/*
Write a function to determine the number of bits you would need to flip to convert
integer A to integer B.
EXAMPLE
Input: 29 (or: 11101), 15 (or: 01111)
Output: 2
*/

public class Conversion {
    static int numberOfFlips(int a, int b) {
        int v = a^b;
        int result = 0;
        for (int i=0; i<Integer.SIZE; i++) {
            if ((v & 1) != 0) {
                result++;
            }
            v >>>= 1;
        }
        return result;
    }

    static int numberOfFlips2(int a, int b) {
        int result = 0;
        for (int v = a^b; v != 0; v = v >> 1) {
            result += (v & 1);
        }
        return result;
    }

    static int numberOfFlips3(int a, int b) {
        int result = 0;
        for (int v = a^b; v != 0; v = v & (v - 1)) {
            result++;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(numberOfFlips3(29, 15));
    }
}
