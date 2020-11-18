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

    static Result subSortIndices2(int[] a) {//Book's solution
        int start = 0;
        int end = a.length-1;
        for (start = 0; start < a.length-1; start++) {//find longest increasing subsequence at left side
            if (a[start] > a[start+1]) break;
        }
        for (end = array.length - 1; end > 0; end--) {//find longest increasing subsquence at right side
            if (a[end] < a[end-1]) break;
        }
        start++;
        end--;
        if (start == a.length) return new Result(-1, -1);//array already sorted
        int min = start;
        int max = end;
        for (int i=start; i<array.length; i++) {//find minimum value at middle and right sides
            if (a[i] < a[min]) min = i;
        }
        for (int i=end; i>=0; i--) {//find maximum value at left and middle sides
            if (a[i] > a[max]) max = i;
        }
        for (; start>=0; start--) {//update "start" so that all elements to the left are smaller than middle and right elements
            if (a[start] < a[min]) break;
        }
        for (; end<array.length; end++) {//update "end" so that all elements to the right are bigger than left and middle elements
            if (a[end] > a[max]) break;
        }
        start++;
        end--;
        return new Result(start, end);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i=0; i<n; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println(subSortIndices2(array));
    }
}
