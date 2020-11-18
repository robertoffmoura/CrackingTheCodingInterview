import java.util.Scanner;

/*
You are given an array with all the numbers from 1 to N appearing exactly once, except for one number that is missing. How can you find the missing number in O(N) time and O(1) space? What if there were two numbers missing?
*/

public class MissingTwo {
    static class Pair {
        int value1, value2;
        public Pair(int value1, int value2) {
            this.value1 = value1;
            this.value2 = value2;
        }
        @Override
        public String toString() {
            return "(" + value1 + ", " + value2 + ")";
        }
    }
    static int[] scan() {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] result = new int[length];
        for (int i=0; i<length; i++) {
            result[i] = sc.nextInt();
        }
        return result;
    }

    static int missing1(int[] array) {
        int n = array.length + 1;
        int sum = 0;
        for (int i=0; i<n-1; i++) {
            sum += array[i];
        }
        int expectedSum = (n*(1+n))/2;
        return expectedSum - sum;
    }

    static Pair missing2(int[] array) {
        int n = array.length + 2;
        int sum = 0;
        int sumOfSquares = 0;
        for (int i=0; i<n-2; i++) {
            sum += array[i];
            sumOfSquares += array[i]*array[i];
        }
        int expectedSum = (n*(1+n))/2;
        int expectedSumOfSquares = (n*(n+1)*(2*n+1))/6;

        int aPlusB = expectedSum - sum;
        int a2PlusB2 = expectedSumOfSquares - sumOfSquares;
        int aTimesB = (aPlusB*aPlusB - a2PlusB2)/2;

        int a0 = 1;
        int a1 = -aPlusB;
        int a2 = aTimesB;

        int sqrtdelta = (int) Math.sqrt(a1*a1 - 4*a0*a2);
        return new Pair((-a1 + sqrtdelta)/(2*a0), (-a1 - sqrtdelta)/(2*a0));
    }

    public static void main(String[] args) {
        int[] array = scan();
        System.out.println("missing one = " + missing1(array));
        System.out.println("missing two = " + missing2(array));
    }
}
