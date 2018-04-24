import java.util.HashMap;
import java.util.Scanner;

public class ShortestSupersequence {
    public static class Pair {
        int start;
        int end;
        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }

    static Pair shortest(int[] shorterArray, int[] array) {
        int start = 0;
        int end = 0;
        boolean valid = false;
        Pair result = new Pair(-1, -1);
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int i=0; i<shorterArray.length; i++) {
            hash.put(shorterArray[i], 0);
        }
        int min = Integer.MAX_VALUE;
        while (end < array.length) {
            if (!valid) {
                valid = hashElement(hash, array[end], valid);
                end++;
            } else {
                valid = unHashElement(hash, array[start], valid);
                start++;
            }
            if (valid && end - start < min) {
                min = end - start;
                result.start = start;
                result.end = end - 1;
            }
        }
        return result;
    }

    static boolean unHashElement(HashMap<Integer, Integer> hash, int element, boolean valid) {
        if (hash.containsKey(element)) {
            hash.put(element, hash.get(element) - 1);
            if (valid) valid = (hash.get(element) != 0);
        }
        return valid;
    }

    static boolean hashElement(HashMap<Integer, Integer> hash, int element, boolean valid) {
        if (hash.containsKey(element)) {
            hash.put(element, hash.get(element) + 1);
            if (!valid) valid = validHash(hash);
        }
        return valid;
    }

    static boolean validHash(HashMap<Integer, Integer> hash) {
        for (Integer count : hash.values()) {
            if (count == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] shortArray = new int[n];
        for (int i=0; i<n; i++) {
            shortArray[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] array = new int[m];
        for (int i=0; i<m; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println(shortest(shortArray, array));
    }
}
