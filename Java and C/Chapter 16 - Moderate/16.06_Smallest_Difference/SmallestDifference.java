import java.util.Scanner;

/*
Given two arrays of integers, compute the pair of values (one value in each array) with the smallest (non-negative) difference. Return the difference.
EXAMPLE
Input: {1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
Output: 3. That is, the pair (11, 8).
*/

public class SmallestDifference {
    static int abs(int i) {
        return i > 0 ? i : -i;
    }

    static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    static void sort(int[] a, int start, int end) {
        if (start == end) return;
        int mid = (start+end)/2;
        sort(a, start, mid);
        sort(a, mid+1, end);
        merge(a, start, end);
    }

    static void merge(int[] a, int start, int end) {
        int mid = (start+end)/2;
        int[] temp = new int[end-start+1];
        for (int i=0; i<end-start+1; i++) {
            temp[i] = a[start+i];
        }
        int i = 0;
        int j = mid+1-start;
        int k = start;
        while (i <= mid-start && j <= end-start) {
            if (temp[i] > temp[j]) a[k++] = temp[j++];
            else a[k++] = temp[i++];
        }
        while (i <= mid-start) {
            a[k++] = temp[i++];
        }
    }

    static int difference(int[] a, int[] b) {
        sort(a);
        sort(b);
        int min = Integer.MAX_VALUE;
        int i, j;
        for (i=0, j=0; i<a.length && j<b.length;) {
            int dif = abs(a[i] - b[j]);
            if (dif < min) min = dif;
            if (a[i] < b[j]) i++;
            else j++;
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i=0; i<n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(difference(a, b));
    }
}
