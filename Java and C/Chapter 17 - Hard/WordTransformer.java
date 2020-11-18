import java.util.Scanner;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Queue;

public class WordTransformer {
    static HashSet<String> dictionary = new HashSet<String>();

    static charArrayToString(char[] s) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length; i++) sb.append(s[i]);
        return sb.toString();
    }

    static String path(String start, String end) {
        static HashMap<String, boolean> seen = new HashMap<String, boolean>();
        static Queue<char[]> queue = new Queue<char[]>();
        char[] startArray = new char[start.size()];
        char[] endArray = new char[end.size()];
        for (int i=0; i<start.size(); i++) startArray[i] = start.charAt(i);
        for (int i=0; i<end.size(); i++) endArray[i] = end.charAt(i);
        return path(startArray, endArray, seen, queue);
    }

    static String path(char[] start, char[] end, HashMap<String, boolean> seen, Queue queue) {
        queue.add(start);

        while (queue.size() > 0) {
            char[] current = queue.poll();
            if (current == end) return 
            String currentString = charArrayToString(current);
            seen.put(currentString, true);
            char[] guess = new char[current.length];
            for (int i=0; i<guess.length; i++) guess[i] = current[i];
            for (int i=0; i<guess.length; i++) {
                for (int j=0; j<26; j++) {
                    guess[i] = (char) ((start[i] + j - 'a')%26 + 'a';
                    guessString = charArrayToString(guess);
                    if (dictionary.contains(guessString) && !seen.get(guessString)) queue.add(guess);
                }
            }
        }
        return "not found";

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String start = sc.next();
        String end = sc.next();
        System.out.println(path(start, end));
    }
}
