import java.util.Scanner;

/*
Write a method that finds the maximum of two numbers. You should not use if-else or any other comparison operator
*/

public class NumberMax {
    static int max(int a, int b) {
        double mid = (a + b)/2.0;
        double diff = Math.abs(b-a)/2.0;
        return (int) (mid + diff);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(max(a,b));
    }
}
