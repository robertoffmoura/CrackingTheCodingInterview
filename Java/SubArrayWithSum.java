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

    static int countSubArraysWithSum(ArrayList<Integer> array, int targetSum) {
        int result = 0;
        for (int i=0; i<array.size(); i++) {
            int sum = array.get(i);
            for (int j=i+1; j<array.size(); j++) {
                sum += array.get(j);
                if (sum == targetSum) result++;
            }
        }
        return result;
    }

    static void printSubArraysWithSum2(ArrayList<Integer> array, int targetSum) {
        HashMap<Integer, ArrayList<Integer>> hash = new HashMap<Integer, ArrayList<Integer>>();
        int count = 0;
        for (int i=0; i<array.size(); i++) {
            count += array.get(i);
            if (hash.get(count) == null) {
                hash.put(count, new ArrayList<Integer>());
            }
            hash.get(count).add(i);

            if (count == targetSum) printArray(array, 0, i);

            int searchedSum = count - targetSum;
            if (hash.containsKey(searchedSum)) {
                for (int index : hash.get(searchedSum)) {
                    printArray(array, index + 1, i);
                }
            }
        }
    }

    static int countSubArraysWithSum2(ArrayList<Integer> array, int targetSum) {
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        int result = 0;
        int count = 0;
        for (int i=0; i<array.size(); i++) {
            count += array.get(i);
            if (hash.get(count) == null) {
                hash.put(count, 0);
            }
            hash.replace(count, hash.get(count)+1);

            if (count == targetSum) result++;

            int searchedSum = count - targetSum;
            if (hash.containsKey(searchedSum)) result += hash.get(searchedSum)
        }
        return result;
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
        printSubArraysWithSum2(array, sum);
        System.out.println(countSubArraysWithSum(array, sum));
        System.out.println(countSubArraysWithSum2(array, sum));
    }
}
