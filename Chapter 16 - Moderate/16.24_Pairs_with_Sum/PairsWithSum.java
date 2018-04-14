import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

/*
Design an algorithm to find all pairs of integers within an array which sum to a specified value.
*/

public class PairsWithSum {
    public static class Pair {
        int a;
        int b;
        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
        public String toString() {
            return "(" + a + ", " + b + ")";
        }
    }

    static ArrayList<Pair> getPairs(int[] array, int sum) {
        ArrayList<Pair> result = new ArrayList<Pair>();
        Arrays.sort(array);
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            if (array[i] + array[j] == sum) {
                result.add(new Pair(array[i], array[j]));
                i++;
                j--;
            } else if (array[i] + array[j] < sum) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }

    static void printPairs(ArrayList<Pair> array) {
        for (int i=0; i<array.size(); i++) {
            System.out.println(array.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i=0; i<n; i++) {
            array[i] = sc.nextInt();
        }
        int sum = sc.nextInt();
        printPairs(getPairs(array, sum));
    }
}
