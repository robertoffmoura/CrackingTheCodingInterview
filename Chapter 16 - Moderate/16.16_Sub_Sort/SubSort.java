import java.util.Arrays;
import java.util.Scanner;

/*
Given an array of integers, write a method to find indices m and n such that if you sorted elements m through n, the entire array would be sorted. Minimize n - m (that is, find the smallest such sequence).
EXAMPLE
Input: 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19
Output: (3, 9)
*/

public class SubSort {
    public static class Result {
        int start;
        int end;
        public Result(int start, int end) {
            this.start = start;
            this.end = end;
        }
        public String toString() {
            return "(" + start +", " + end + ")";
        }
    }

    static Result subSortIndices(int[] array) {
        int start = array.length;
        int end = -1;
        int[] sortedArray = new int[array.length];
        for (int i=0; i<array.length; i++) {
            sortedArray[i] = array[i];
        }
        Arrays.sort(sortedArray);
        for (int i=0; i<array.length; i++) {
            if (sortedArray[i] != array[i]) {
                start = i;
                break;
            }
        }
        for (int i=array.length-1; i>=0; i--) {
            if (sortedArray[i] != array[i]) {
                end = i;
                break;
            }
        }
        if (start < end) {
            return new Result(start, end);
        }
        else return new Result(-1, -1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i=0; i<n; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println(subSortIndices(array));
    }
}
