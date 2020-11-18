import java.util.Arrays;
import java.util.Scanner;
import java.util.HashSet;

/*
Given two arrays of integers, find a pair of values (one value from each array) that you can swap to give the two arrays the same sum.
EXAMPLE
Input: {4, 1, 2, 1, 1, 2} and {3, 6, 3, 3}
Output: {1, 3}
*/

public class SumSwap {
    public static class Pair {
        int a;
        int b;
        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
        public String toString() {
            return "(" + a + ", " + b + ")";
        }
    }

    static Pair swapSum(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int sumA = 0;
        int sumB = 0;
        for (int i=0; i<a.length; i++) sumA += a[i];
        for (int i=0; i<b.length; i++) sumB += b[i];
        if (sumA%2 != sumB%2) return new Pair(-1, -1);
        int diff = (sumB - sumA)/2;
        int i = 0;
        int j = 0;
        while (i<b.length && j<a.length) {
            if (b[i] - a[j] < diff) i++;
            else if (b[i] - a[j] > diff) j++;
            else return new Pair(a[j], b[i]);
        }
        return new Pair(-1, -1);
    }

    static Pair swapSum2(int[] a, int[] b) { //Book's Solution
        int sumA = 0;
        int sumB = 0;
        for (int i=0; i<a.length; i++) sumA += a[i];
        for (int i=0; i<b.length; i++) sumB += b[i];
        if (sumA%2 != sumB%2) return new Pair(-1, -1);
        int diff = (sumB - sumA)/2;
        HashSet<Integer> hash = new HashSet<Integer>();
        for (int i=0; i<a.length; i++) hash.add(a[i]);
        for (int i=0; i<b.length; i++) {
            if (hash.contains(b[i] - diff)) return new Pair(b[i] - diff, b[i]);
        }
        return new Pair(-1, -1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aLength = sc.nextInt();
        int[] a = new int[aLength];
        for (int i=0; i<aLength; i++) {
            a[i] = sc.nextInt();
        }
        int bLength = sc.nextInt();
        int[] b = new int[bLength];
        for (int i=0; i<bLength; i++) {
            b[i] = sc.nextInt();
        }
        System.out.println(swapSum2(a, b));
    }
}
