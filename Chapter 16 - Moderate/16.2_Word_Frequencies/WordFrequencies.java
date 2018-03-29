import java.util.HashMap;
import java.util.Scanner;

/*
Design a method to find the frequency of occurrences of any given word in a book. What if we were running this algorithm multiple times?
*/

public class WordFrequencies {
    static HashMap<String, Integer> hash = new HashMap<String, Integer>();

    static void count(String[] book) {
        for (int i=0; i<book.length; i++) {
            String word = book[i].toLowerCase();
            if (hash.containsKey(word)) hash.replace(word, hash.get(word) + 1);
            else hash.put(word, 1);
        }
    }

    static int getCount(String string) {
        return hash.containsKey(string.toLowerCase()) ? hash.get(string.toLowerCase()) : 0;
    }

    public static void main(String[] args) {
        String[] book = {"once", "upon", "a", "time", "a"};
        count(book);
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        System.out.println(getCount(string));
    }
}
