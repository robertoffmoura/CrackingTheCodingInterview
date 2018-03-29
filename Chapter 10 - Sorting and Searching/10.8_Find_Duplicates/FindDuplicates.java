import java.util.Scanner;

/*
You have an array with all the numbers from 1 to N, where N is at most 32,000. The array may have duplicate entries and you do not know what N is. With only 4 kilobytes of memory available, how would you print all duplicate elements in the array?
*/

public class FindDuplicates {
    static void setBit(byte[] bitVector, int n) {
        int byteIndex = n/8;
        int bitIndex = n%8;
        bitVector[byteIndex] |= (1 << bitIndex);
    }

    static boolean getBit(byte[] bitVector, int n) {
        int byteIndex = n/8;
        int bitIndex = n%8;
        return (bitVector[byteIndex] & (1 << bitIndex)) != 0;
    }


    public static void main(String[] args) {
        byte[] bitVector = new byte[4 * 1024];
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int k = scanner.nextInt();
            if (getBit(bitVector, k)) System.out.println(k);
            else setBit(bitVector, k);
        }
    }
}
