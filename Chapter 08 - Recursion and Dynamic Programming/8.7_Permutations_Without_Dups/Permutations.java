import java.util.Scanner;
import java.util.ArrayList;

/*
Write a method to compute all permutations of a string of unique characters.
*/

public class Permutations {
    static void printPermutations(String string) {
        boolean[] used = new boolean[string.length()];
        for (int i=0; i<string.length(); i++) {
            used[i] = false;
        }
        printPermutations("", string, used);
    }
    static void printPermutations(String prefix, String string, boolean[] used) {
        if (prefix.length() == string.length()) {
            System.out.println(prefix);
            return;
        }
        for (int i=0; i<string.length(); i++) {
            if (used[i]) continue;
            used[i] = true;
            printPermutations(prefix + string.charAt(i), string, used);
            used[i] = false;
        }
    }

    static void printPermutations2(String string) {
        printPermutations2("", string);
    }
    static void printPermutations2(String prefix, String remaining) {
        if (remaining.length() == 0) {
            System.out.println(prefix);
            return;
        }
        for (int i=0; i<remaining.length(); i++) {
            printPermutations2(prefix + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i+1));
        }
    }

    static ArrayList<String> permutations(String string) {
        ArrayList<String> list = new ArrayList<String>();
        permutate("", string, list);
        return list;
    }
    static void permutate(String prefix, String remaining, ArrayList<String> list) {
        if (remaining.length() == 0) {
            list.add(prefix);
            return;
        }
        for (int i=0; i<remaining.length(); i++) {
            permutate(prefix + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i+1), list);
        }
    }

    static void printList(ArrayList<String> list) {
        for (int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        System.out.println("Permutations:");
        printPermutations(string);
        System.out.println("");
        printPermutations2(string);
        System.out.println("");
        printList(permutations(string));
    }
}
