/*
You are given two sorted arrays, A and B, where A has a large enough buffer at the end to hold B. Write a method to merge B into A in sorted order.
*/

public class SortedMerge {
    static void sortAndMerge(int[] a, int[] b, int sizeOfA, int sizeOfB) {
        int i = sizeOfA + sizeOfB - 1;
        int j = sizeOfA - 1;
        int k = sizeOfB - 1;
        while (j >= 0 && k >= 0) {
            a[i--] = a[j] > b[k] ? a[j--] : b[k--];
        }
        while (k >= 0) a[i--] = b[k--];
    }

    public static void main(String[] args) {
        int[] arrayA = {1, 2, 3, 4, 6, 8, 10, 12, 14, 16, 0, 0, 0};
        int sizeOfA = 10;
        int[] arrayB = {11, 13, 15};
        int sizeOfB = 3;
        sortAndMerge(arrayA, arrayB, sizeOfA, sizeOfB);
        for (int i=0; i< arrayA.length; i++) {
            System.out.print(arrayA[i] + " ");
        }
        System.out.println("");
    }
}
