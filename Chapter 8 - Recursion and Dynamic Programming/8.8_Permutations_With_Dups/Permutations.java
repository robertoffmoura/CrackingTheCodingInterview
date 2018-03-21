import java.util.Scanner;
import java.util.HashSet;

/*
Write a method to compute all permutations of a string whose characters are not necessarily unique. The list of permutations should not have duplicates.
*/

public class Permutations {
    static void printPermutationsWithoutDuplicates(String string) {
        boolean[] used = new boolean[string.length()];
        for (int i=0; i<string.length(); i++) {
            used[i] = false;
        }
        printPermutationsWithoutDuplicates("", string, used);
    }
    static void printPermutationsWithoutDuplicates(String prefix, String string, boolean[] used) {
        if (prefix.length() == string.length()) {
            System.out.println(prefix);
            return;
        }
        HashSet<Character> usedChars = new HashSet<Character>();
        for (int i=0; i<string.length(); i++) {
            if (usedChars.contains(string.charAt(i))) continue;
            if (used[i]) continue;
            usedChars.add(string.charAt(i));
            used[i] = true;
            printPermutationsWithoutDuplicates(prefix + string.charAt(i), string, used);
            used[i] = false;
        }
    }

    static void printPermutationsWithoutDuplicates2(String string) {
        printPermutationsWithoutDuplicates2("", string);
    }
    static void printPermutationsWithoutDuplicates2(String prefix, String remaining) {
        if (remaining.length() == 0) {
            System.out.println(prefix);
            return;
        }
        HashSet<Character> usedChars = new HashSet<Character>();
        for (int i=0; i<remaining.length(); i++) {
            if (usedChars.contains(remaining.charAt(i))) continue;
            usedChars.add(remaining.charAt(i));
            printPermutationsWithoutDuplicates2(prefix + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i+1));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        System.out.println("Permutations:");
        printPermutationsWithoutDuplicates(string);
        System.out.println("");
        printPermutationsWithoutDuplicates2(string);
    }
}
