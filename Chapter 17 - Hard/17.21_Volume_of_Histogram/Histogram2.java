import java.util.Scanner;
import java.util.ArrayList;

/*
Imagine a histogram (bar graph). Design an algorithm to compute the volume of water it could hold if someone poured water across the top. You can assume that each histogram bar has width 1.
EXAMPLE
Input: {0, 0, 4, 0, 0, 6, 0, 0, 3, 0, 5, 0, 1, 0, 0, 0}
Output: 26
*/

public class Histogram2 {
    static int getVolume(int[] array) {
        int left = 0;
        int right = array.length - 1;
        int maxLeft = array[left];
        int maxRight = array[right];
        int result = 0;
        while (left < right) {
            if (array[left] < array[right]) {
                if (array[left] > maxLeft) maxLeft = array[left];
                result += maxLeft - array[left];
                left++;
            } else {
                if (array[right] > maxRight) maxRight = array[right];
                result += maxRight - array[right];
                right--;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i=0; i<n; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println(getVolume(array));
    }
}
