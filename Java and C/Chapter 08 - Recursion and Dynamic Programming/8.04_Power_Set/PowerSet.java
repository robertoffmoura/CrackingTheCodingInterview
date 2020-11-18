import java.util.ArrayList;
import java.util.Scanner;

/*
Write a method to return all subsets of a set.
*/

public class PowerSet {
    static ArrayList<ArrayList<Integer>> subSets(ArrayList<Integer> set) {
        return subSets(set, 0);
    }

    static ArrayList<ArrayList<Integer>> subSets(ArrayList<Integer> set, int i) {//Recursive
        if (i == set.size()) {
            ArrayList<ArrayList<Integer>> subSetsSoFar = new ArrayList<ArrayList<Integer>>();
            ArrayList<Integer> firstSubSet = new ArrayList<Integer>();
            subSetsSoFar.add(firstSubSet);
            return subSetsSoFar;
        }
        ArrayList<ArrayList<Integer>> subSetsSoFar = subSets(set, i+1);
        int length = subSetsSoFar.size();
        int element = set.get(i);
        for (int j=0; j<length; j++) {
            ArrayList<Integer> subSet = new ArrayList<Integer>(subSetsSoFar.get(j));
            subSet.add(element);
            subSetsSoFar.add(subSet);
        }
        return subSetsSoFar;
    }

    static ArrayList<ArrayList<Integer>> subSets2(ArrayList<Integer> set) {//Iterative
        ArrayList<ArrayList<Integer>> subSetsSoFar = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> firstSubSet = new ArrayList<Integer>();
        subSetsSoFar.add(firstSubSet);
        for (int i=0; i<set.size(); i++) {
            int length = subSetsSoFar.size();
            int element = set.get(i);
            for (int j=0; j<length; j++) {
                ArrayList<Integer> subSet = new ArrayList<Integer>(subSetsSoFar.get(j));
                subSet.add(element);
                subSetsSoFar.add(subSet);
            }
        }
        return subSetsSoFar;
    }

    static ArrayList<ArrayList<Integer>> subSets3(ArrayList<Integer> set) {//Book's solution
        ArrayList<ArrayList<Integer>> subSetsSoFar = new ArrayList<ArrayList<Integer>>();
        int length = set.size();
        int max = (1 << length);
        for (int i=0; i<max; i++) {
            ArrayList<Integer> subSet = new ArrayList<Integer>();
            int b = 1;
            for (int j=0; j<length; j++) {
                if ((b & i) != 0) subSet.add(set.get(j));
                b <<= 1;
            }
            subSetsSoFar.add(subSet);
        }
        return subSetsSoFar;
    }

    static void printSet(ArrayList<Integer> set) {
        for (int i=0; i<set.size(); i++) {
            System.out.print(set.get(i) + " ");
        }
    }

    static void printSets(ArrayList<ArrayList<Integer>> sets) {
        for (int i=0; i<sets.size(); i++) {
            printSet(sets.get(i));
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> set = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0; i<n; i++) set.add(sc.nextInt());
        printSets(subSets(set));
    }
}
