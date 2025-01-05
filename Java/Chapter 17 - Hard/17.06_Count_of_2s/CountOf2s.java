import java.util.Scanner;

/*
Write a method to count the number of 2s that appear in all the numbers between 0 and n (inclusive).
EXAMPLE
Input: 25
Output: 9 (2, 12, 20, 21, 22, 23, 24 and 25. Note that 22 counts for tow 2s.)
*/

public class CountOf2s {
    static int digits(int n) {
        int result = 0;
        while (n != 0) {
            n /= 10;
            result++;
        }
        return result;
    }

    static int power(int b, int e) {
        int result = 1;
        for (int i=0; i<e; i++) {
            result *= b;
        }
        return result;
    }

    static int count(int n) {
        int digits = digits(n);
        int start = 2*power(10,digits-1);
        int end = 3*power(10, digits-1) - 1;
        int mod = power(10, digits);
        int result = 0;
        while (mod > 1) {
            result += ((n-start)/mod)*(mod/10);
            if (start <= n && n <= end) result += n - start + 1;
            if (end < n) result += mod/10;
            mod /= 10;
            start /= 10;
            end /= 10;
        }
        return result;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(count(n));
    }
}
