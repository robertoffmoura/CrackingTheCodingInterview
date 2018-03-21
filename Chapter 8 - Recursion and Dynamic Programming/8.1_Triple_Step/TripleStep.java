import java.util.Scanner;

/*
A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time. Implement a method to count how many possible ways the child can run up the stairs.
*/

public class TripleStep {
    static int count(int n) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        int count1 = count(n-1);
        int count2 = count(n-2);
        int count3 = count(n-3);
        return count1 + count2 + count3;
    }

    static int[] countMemory;

    static int beginCount2(int n) {
        countMemory = new int[n+1];
        for (int i=0; i<=n; i++) countMemory[i] = 0;
        return count2(n);
    }

    static int count2(int n) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        if (countMemory[n] != 0) return countMemory[n];
        int count1 = count2(n-1);
        int count2 = count2(n-2);
        int count3 = count2(n-3);
        countMemory[n] = count1 + count2 + count3;
        return countMemory[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(beginCount2(n));
    }
}
