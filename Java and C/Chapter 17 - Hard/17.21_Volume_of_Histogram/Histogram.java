import java.util.Scanner;
import java.util.ArrayList;

/*
Imagine a histogram (bar graph). Design an algorithm to compute the volume of water it could hold if someone poured water across the top. You can assume that each histogram bar has width 1.
EXAMPLE
Input: {0, 0, 4, 0, 0, 6, 0, 0, 3, 0, 5, 0, 1, 0, 0, 0}
Output: 26
*/

public class Histogram {
    static int fill(int[] array, int height, int start, int end) {
        if (height == 0) return 0;
        int result = 0;
        for (int i=start+1; i<end; i++) {
            result += height - array[i];
        }
        //System.out.println("volume between " + start + " and " + end + " is " + result);
        return result;
    }

    static int getVolume(int[] array) {
        int max = 0;
        for (int i=0; i<array.length; i++) {
            if (array[i] > array[max]) max = i;
        }
        return getVolume(0, array, 0, max-1, max) + getVolume(0, array, max+1, array.length-1, max);
    }

    static int getVolume(int stack, int[] array, int start, int end, int max) {
        if (array[max] == 0) return 0;
        //for (int i=0; i<stack; i++) System.out.print("\t");
        //System.out.println(start + " " + end + " " + max);
        if (start >= end) return 0;
        int result = 0;
        int secondMax = start;
        for (int i=start; i<=end; i++) {
            if (array[i] > array[secondMax]) secondMax = i;
        }
        result += fill(array, array[secondMax], min(max, secondMax), max(max, secondMax));
        if (max == end+1) {
            result += getVolume(stack+1, array, start, secondMax-1, secondMax);
        }
        if (max == start-1) {
            result += getVolume(stack+1, array, secondMax+1, end, secondMax);
        }
        return result;
    }

    static int min(int a, int b) {
        return a < b ? a : b;
    }

    static int max(int a, int b) {
        return a > b ? a : b;
    }

    static int getVolume2(int[] array) {// Book's Solution
        int[] tallestLeft = new int[array.length];
        int[] tallestRight = new int[array.length];
        int sum = 0;
        int tallest = 0;
        for (int i=0; i<array.length; i++) {
            if (array[i] > array[tallest]) tallest = i;
            tallestLeft[i] = array[tallest];
        }
        tallest = array.length-1;
        for (int i=array.length-1; i>=0; i--) {
            if (array[i] > array[tallest]) tallest = i;
            tallestRight[i] = array[tallest];
        }
        for (int i=0; i<array.length; i++) {
            sum += min(tallestRight[i], tallestLeft[i]) - array[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i=0; i<n; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println(getVolume2(array));
    }
}
