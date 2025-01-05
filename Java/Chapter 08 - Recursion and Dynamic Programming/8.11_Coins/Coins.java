import java.util.Scanner;

/*
Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents), and pennies (1 cent), write code to calculate the number of ways of representing n cents.
*/

public class Coins {
    static int count(int n) {
        return count(n, 4);
    }
    static int count(int n, int numberOfTypesOfCoins) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        int result = 0;
        switch (numberOfTypesOfCoins) {
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

    static int count2(int n) {
        int[][] memory = new int[n+1][4+1];
        return count2(n, 4, memory);
    }
    static int count2(int n, int numberOfTypesOfCoins, int[][] memory) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (memory[n][numberOfTypesOfCoins] != 0) {
            return memory[n][numberOfTypesOfCoins];
        }
        int result = 0;
        switch (numberOfTypesOfCoins) {
            case 4:
                result += count2(n-25, 4, memory);
            case 3:
                result += count2(n-10, 3, memory);
            case 2:
                result += count2(n-5, 2, memory);
            case 1:
                result += count2(n-1, 1, memory);
        }
        memory[n][numberOfTypesOfCoins] = result;
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(count2(n));
        System.out.println(count(n));
    }
}
