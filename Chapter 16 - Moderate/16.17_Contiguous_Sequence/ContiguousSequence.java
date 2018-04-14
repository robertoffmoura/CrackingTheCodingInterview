import java.util.Scanner;

/*
You are given an array of integers (both positive and negative). Find the contiguous sequence with the largest sum. Return the sum.
EXAMPLE
Input: 2, -8, 3, -2, 4, -10
Output: 5 (i.e., {3, -2, 4})
*/

public class ContiguousSequence {
    static int largestSum(int[] array) {
        int[] sums = new int[array.length+1];
        sums[0] = 0;
        for (int i=1; i<=array.length; i++) {
            sums[i] = sums[i-1] + array[i-1];
        }
        int minIndex = 0;
        int maxIndex = 0;
        int maxSum = 0;
        for (int i=0; i<array.length; i++) {
            for (int j=i; j<array.length; j++) {
                if (sums[j+1] - sums[i] > maxSum) {
                    maxSum = sums[j+1] - sums[i];
                    minIndex = i;
                    maxIndex = j;
                }
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i=0; i<n; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println(largestSum(array));
    }
}
