import java.util.Scanner;

/*
Search in Rotated Array: Given a sorted array of n integers that has been rotated an unkown number of times, write code to find an element in the array. You may assume that the array was originally sorted in increasing order.
EXAMPLE
Input: find 5 in {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}
Output: 8 (the index of 5 in the array)
*/

public class SearchInRotatedArray {
    static int findStart(int[] array) {
        return findStart(array, 0, array.length - 1);
    }

    static int findStart(int[] array, int left, int right) {
        if (right - left == 1) return array[left] < array[right] ? left : right;
        int mid = (left + right)/2;
        if (array[left] > array[mid]) return findStart(array, left, mid);
        else if (array[mid] > array[right]) return findStart(array, mid, right);
        return left;
    }

    static int search(int[] array, int n) {
        int start = findStart(array);
        return search(array, n, start, start, start + array.length - 1, array.length);
    }

    static int search(int[] array, int n, int start, int left, int right, int length) {
        if (left > right) return -1;
        int mid = (left + right)/2;
        if (n < array[mid%length]) return search(array, n, start, left, mid - 1, length);
        else if (array[mid%length] < n) return search(array, n, start, mid + 1, right, length);
        else return mid%length;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, -3, -2, -1, 0};
        int[] b = {0, 1};
        int[] c = {1, 0};
        int[] d = {0, 1, 2};
        int[] e = {1, 2 , 0};
        int[] f = {2, 0, 1};
        int[] g = {0, 1, 2, 3};
        int[] h = {1, 2, 3, 0};
        int[] i = {2, 3, 0, 1};
        int[] j = {3, 0, 1, 2};
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(search(j, n));
    }
}
