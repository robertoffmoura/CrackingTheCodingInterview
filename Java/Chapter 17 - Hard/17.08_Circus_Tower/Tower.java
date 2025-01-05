import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

/*
A circus is designing a tower routine consisting of people standing atop one another's shoulders. For practical and aesthetic reasons, each person must be both shorter and lighter than the person below him or her. Given the heights and weights of each person in the circus, write a method to compute the largest possible number of people in such a tower.
EXAMPLE
Input (ht, wt): (65, 100) (70, 170) (56, 90) (75, 190) (60, 95) (68, 110)
Output: The longest tower is length 6 and includes from top to bottom:
(56, 90) (60, 95) (65, 100) (68, 110) (70, 150) (75, 190)
*/

public class Tower {
    public static class Pair {
        int ht;
        int wt;
        public Pair(int ht, int wt) {
            this.ht = ht;
            this.wt = wt;
        }
        public String toString() {
            return "(" + ht + ", " + wt + ")";
        }
    }
    static ArrayList<Pair> highestTower(ArrayList<Pair> array) {
        boolean[] used = new boolean[array.size()];
        HashMap<Pair, ArrayList<Pair>> memory = new HashMap<Pair, ArrayList<Pair>>();
        return highestTower(0, array, new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE), used, memory);
    }

    static ArrayList<Pair> highestTower(int stack, ArrayList<Pair> array, Pair bottom, boolean[] used, HashMap<Pair, ArrayList<Pair>> memory) {
        //for (int i=0; i<stack; i++) System.out.print("   ");
        //System.out.println(bottom);
        ArrayList<Pair> bestResult = new ArrayList<Pair>();
        int maxSize = 0;
        for (int i=0; i<array.size(); i++) {
            if (used[i]) continue;
            if (!valid(bottom, array.get(i))) continue;
            used[i] = true;
            int size = 1;
            ArrayList<Pair> result = new ArrayList<Pair>();
            if (memory.containsKey(array.get(i))) {
                result = memory.get(array.get(i));
            } else {
                result = highestTower(stack + 1, array, array.get(i), used, memory);
                memory.put(array.get(i), result);
            }
            size += result.size();
            if (size > maxSize) {
                bestResult = result;
                maxSize = size;
            }
            used[i] = false;
        }
        if (stack == 0) return bestResult;
        bestResult.add(bottom);
        return bestResult;
    }

    static boolean valid(Pair bottom, Pair pair) {
        return (bottom.wt > pair.wt && bottom.ht > pair.ht);
    }

    static void printArrayList(ArrayList<Pair> array) {
        for (int i=0; i<array.size(); i++) {
            System.out.print(array.get(i) + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Pair> array = new ArrayList<Pair>();
        for (int i=0; i<n; i++) {
             array.add(new Pair(sc.nextInt(), sc.nextInt()));
        }
        printArrayList(highestTower(array));
    }
}
