import java.util.Scanner;

/*
A magic index in an array A[0..n-1] is defined to be an index such that A[i] = i. Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.
FOLLOW UP
What if the values are not distinct?
*/

public class MagicIndex {
    public static class Result {
        int value;
        boolean found;
        public Result(int value, boolean found) {
            this.value = value;
            this.found = found;
        }
    }

    static int getMagicIndex(int[] array) {
        return getMagicIndex(array, 0, array.length-1);
    }

    static int getMagicIndex(int[] array, int left, int right) {
        if (left > right) return -1;
        int mid = (left+right)/2;
        if (array[mid] == mid) return mid;
        if ((array[left] - left < 0) && (array[mid] - mid > 0)) {
            return getMagicIndex(array, left, mid-1);
        }
        if ((array[mid] - left < 0) && (array[right] - right > 0)) {
            return getMagicIndex(array, mid+1, right);
        }
        return -1;
    }

    static Result getMagicIndex2(int[] array) {
        return getMagicIndex2(array, 0, array.length-1);
    }

    static Result getMagicIndex2(int[] array, int left, int right) {
        if (left > right) return new Result(0, false);
        int mid = (left+right)/2;
        if (array[mid] == mid) return new Result(mid, true);
        if ((array[left] - left > 0) != (array[mid] - mid > 0)) {
            Result leftResult = getMagicIndex2(array, left, mid-1);
            if (leftResult.found) return leftResult;
        }
        if ((array[mid] - mid > 0) != (array[right] - right > 0)) {
            Result rightResult = getMagicIndex2(array, mid+1, right);
            if (rightResult.found) return rightResult;
        }
        if ((array[left] - left > 0) == (array[mid] - mid > 0)) {
            Result leftResult = getMagicIndex2(array, left, mid-1);
            if (leftResult.found) return leftResult;
        }
        if ((array[mid] - mid > 0) == (array[right] - right > 0)) {
            Result rightResult = getMagicIndex2(array, mid+1, right);
            if (rightResult.found) return rightResult;
        }
        return new Result(0, false);
    }
    public static void main(String[] args) {
        int[] array;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        array = new int[n];
        for (int i=0; i<n; i++) {
            array[i] = sc.nextInt();
        }
        int r = getMagicIndex(array);
        System.out.println(r);
        Result result = getMagicIndex2(array);
        if (result.found) System.out.println(result.value);
    }
}
