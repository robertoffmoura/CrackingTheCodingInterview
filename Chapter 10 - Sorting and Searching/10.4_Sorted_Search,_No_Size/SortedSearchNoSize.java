import java.util.Scanner;

/*
You are given an array-like data structure Listy which lacks a size method. It does, however, have an elementAt(i) method that returns the element at index i in O(1) time. If i is beyond the bounds of the data structure, it returns -1. (For this reason, the data structure only supports positive integers.) Given a Listy which contains sorted, psitive integers, find the index at which an element x occurs. If x occurs multiple times, you may return any index.
*/

public class SortedSearchNoSize {
    static int search(int[] array, int n) {
        int end = findEnd(array);
        return binarySearch(array, n, end);
    }

    static int findEnd(int[] array) {
        int i;
        for (i=1; array[i] != -1; i*=2) {
            ;
        }
        return recursiveFindEnd(array, i/2, i);
    }

    static int recursiveFindEnd(int[] array, int left, int right) {
        if (right - left == 1) return right;
        int mid = (left + right)/2;
        if (array[mid] == -1) {
            return recursiveFindEnd(array, left, mid);
        } else {
            return recursiveFindEnd(array, mid, right);
        }
    }

    static int binarySearch(int[] array, int n, int length) {
        return binarySearch(array, n, 0, length - 1);
    }

    static int binarySearch(int[] array, int n, int left, int right) {
        if (left > right) return -1;
        int mid = (left + right)/2;
        if (array[mid] < n) return binarySearch(array, n, mid + 1, right);
        else if (n < array[mid]) return binarySearch(array, n, left, mid - 1);
        else return mid;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(search(array,n));
    }
}
