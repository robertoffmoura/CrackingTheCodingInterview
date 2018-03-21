import java.util.Scanner;

/*
Implement an algorithm to print all valid (e.g., properly opened and closed) combinations of n pairs of parentheses.
EXAMPLE
Input: 3
Output: ((())), (()()), (())(), ()(()), ()()()
*/

public class Parens {
    static void printAllCombinations(int n) {
        printAllCombinations(n, 0, 0, 0, "");
    }

    static void printAllCombinations(int n, int i, int openCount, int closedCount, String stringSoFar) {
        if (i == 2*n) {
            System.out.println(stringSoFar);
            return;
        }
        if (openCount > closedCount) printAllCombinations(n, i+1, openCount, closedCount+1, stringSoFar + ")");
        if (openCount < n) printAllCombinations(n, i+1, openCount+1, closedCount, stringSoFar + "(");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printAllCombinations(n);
    }
}
