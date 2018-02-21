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
    public static void main(String[] args) {
        System.out.println(numberOfFlips(29, 15));
    }
}
