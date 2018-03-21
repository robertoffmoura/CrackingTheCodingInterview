import java.util.Scanner;
import java.util.HashSet;

/*
Write a method to compute all permutations of a string of unique characters.
*/
/*
Write a method to compute all permutations of a string whose characters are not necessarily unique. The list of permutations should not have duplicates.
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        System.out.println("Permutations:");
        printPermutations(string);
        System.out.println("Permutations without duplicates:");
        printPermutationsWithoutDuplicates(string);
    }
}
