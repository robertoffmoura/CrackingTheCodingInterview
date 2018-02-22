import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class SubArrayWithSum {
    static void printSubArraysWithSum(ArrayList<Integer> array, int targetSum) {
        for (int i=0; i<array.size(); i++) {
            int sum = array.get(i);
            for (int j=i+1; j<array.size(); j++) {
                sum += array.get(j);
                if (sum == targetSum) printArray(array, i, j);
            }
        }
    }

    static void printSubArraysWithSum2(ArrayList<Integer> array, int targetSum) {
        HashMap<Integer, Integer> sum = new HashMap<Integer, Integer>;
        int count = 0;
        for (int i=0; i<array.size(); i++) {
            count += array.get(i);
            hash.put(i, count);
            if (hash.containsValue())
        }
    }

    static void printArray(ArrayList<Integer> array, int i, int j) {
        for (int k=i; k<j+1; k++) {
            System.out.print(array.get(k) + ", ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        int n = scanner.nextInt();
        ArrayList<Integer> array = new ArrayList<Integer>();
        for (int i=0; i<n; i++) {
            array.add(scanner.nextInt());
        }
        printSubArraysWithSum(array, sum);
    }
}
