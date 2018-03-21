import java.util.Scanner;

/*
Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents), and pennies (1 cent), write code to calculate the number of ways of representing n cents.
*/

public class Coins {
    static int count(int n) {
        return count(n, 4);
    }
    //25, 10, 5, 1;
    static int count(int n, int i) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        int result = 0;
        switch (i) {
            case 4:
                result += count(n-25, 4);
            case 3:
                result += count(n-10, 3);
            case 2:
                result += count(n-5, 2);
            case 1:
                result += count(n-1, 1);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(count(n));
    }
}
