import java.util.ArrayList;
import java.util.HashMap;

/*
Write a method to randomly generate a set of m integers from an array of size n. Each element must have an equal probability of being chosen.
*/

public class RandomSet {
    static int[] subset(int[] set, int m) {// No repetitions O(n)
        int[] result = new int[m];
        int n = set.length;
        int[] setCopy = new int[n];
        for (int i=0; i<n; i++) {
            setCopy[i] = set[i];
        }

        for (int i=0; i<m; i++) {
			// Get random element from range, swap with last element, decrease range.
            int r = (int) (Math.random()*(n-i));
			int temp = setCopy[r];
			setCopy[r] = setCopy[n-i-1];
			setCopy[n-i-1] = temp;
            result[i] = temp;
        }
        return result;
    }

    static int[] subset2(int[] set, int m) {// Repetitions allowed O(m)
        int[] result = new int[m];
        int n = set.length;
        for (int i=0; i<m; i++) {
            int r = (int) (Math.random()*n);
            result[i] = set[r];
        }
        return result;
    }

    static String toString(int[] set) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i=0; i<set.length - 1; i++) {
            sb.append(set[i]);
            sb.append(", ");
        }
        sb.append(set[set.length-1]);
        sb.append("]");
        return sb.toString();
    }

    static void monteCarlo(int iterations, int m, int[] set) {
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int i=0; i<iterations; i++) {
            int[] r = subset(set, m);
            for (int j=0; j<r.length; j++) {
                hash.put(r[j], hash.containsKey(r[j]) ? hash.get(r[j]) + 1 : 1);
            }
        }
        for (HashMap.Entry<Integer, Integer> entry : hash.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + ": " + value);
        }
    }

    public static void main(String[] args) {
        monteCarlo(50000, 5, new int[] {1, 3, 4, 6, 9, 10, 14});
        //System.out.println(toString(r));
    }
}
