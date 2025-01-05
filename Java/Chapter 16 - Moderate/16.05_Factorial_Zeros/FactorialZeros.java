import java.util.Scanner;

/*
Write an algorithm which computes the number of trailing zeros in n factorial
*/

public class FactorialZeros {
    static int countFactorialZeros(int n) {
        int result = 0;
        for (int i=5; i<=n; i*=5) {
            result += n/i;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(countFactorialZeros(n));
    }
}
