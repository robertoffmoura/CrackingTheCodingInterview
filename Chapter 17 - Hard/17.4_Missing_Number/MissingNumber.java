import java.util.Scanner;

/*
An array A contains all the integers from 0 to n, except for one number which is missing. In this problem, we cannot access an entire integer in A with a single operation. The elements of A are represented in binary, and the only operation we can use to access them is "fetch the jth bit of A[i]", which takes constant time. Write code to find the missing integer. Can you do it in O(n) time?
*/

public class MissingNumber {
    static int missing(int n, int[] a) {
        int c = 1;
        int sum = 0;
        while (c != 0) {
            int digit = 0;
            for (int i=0; i<n; i++) {
                if ((c&a[i]) != 0) digit++;
            }
            digit *= c;
            sum += digit;
            c <<= 1;
        }
        int expectedSum = (n*(n+1))/2;
        System.out.println("exp: " + expectedSum);
        System.out.println("sum: " + sum);
        return expectedSum - sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(missing(n, a));
    }
}
