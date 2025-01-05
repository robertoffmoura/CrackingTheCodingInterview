import java.util.Scanner;

/*
In an array of integers, a "peak" is an element which is greater than or equal to the adjacent integers and a "valley" is an element which is less than or equal to the adjacent integers. For example, in the array {5, 8, 6, 2, 3, 4, 6}, {8, 6} are peaks and {5, 2} are valleys. Given an array of integers, sort the array into an alternating sequence of peaks and valleys.
*/

public class PeaksAndValleys {
    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    static void sort(int[] array) {
        for (int i=1; i<array.length-1; i++) {
            if (array[i-1] <= array[i]) {
                if (array[i] < array[i+1]) {
                    swap(array, i, i+1);
                }
            }
            if (array[i-1] >= array[i]) {
                if (array[i] > array[i+1]) {
                    swap(array, i, i+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i=0; i<n; i++) {
            array[i] = scanner.nextInt();
        }
        sort(array);
        for (int i=0; i<n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }
}
