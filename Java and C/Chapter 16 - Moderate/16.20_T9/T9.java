import java.util.Scanner;
import java.util.ArrayList;

/*
On old cell phones, users typed on a numeric keypad and the phone would provide a list of words that matched these numbers. Each digit mapped to a set of 0 - 4 letters. Implement an algorithm to return a list of matching words, given a sequence of digits. You are provided a list of valid words (provided in whatever data structure you'd like). The mapping is shown in the diagram beliow:
<diagram>
EXAMPLE
Input:  8733
Output: tree, used
*/

public class T9 {
    public static class Node {
        Node[] children = new Node[26];
        boolean endOfWord;
    }

    static Node root;

    public static void addWord(String word) {
        if (root == null) root = new Node();
        Node node = root;
        for (int i=0; i<word.length(); i++) {
            char character = word.charAt(i);
            if (node.children[character - 'a'] == null) node.children[character - 'a'] = new Node();
            node = node.children[character - 'a'];
        }
        node.endOfWord = true;
    }

    public static boolean searchWord(String word) {
        Node node = root;
        for (int i=0; i<word.length(); i++) {
            char character = word.charAt(i);
            if (node.children[character - 'a'] == null) return false;
            node = node.children[character - 'a'];
        }
        return node.endOfWord;
    }

    static void findWord(String input, char[][] keyboard) {
        findWord(input, 0, root, "", keyboard);
    }

    static void findWord(String input, int i, Node node, String word, char[][] keyboard) {
        if (node == null) return;
        if (i == input.length()) {
            if (node.endOfWord == true) System.out.println(word);
            return;
        }
        char[] key = keyboard[input.charAt(i)-'0'];
        for (int j=0; j<key.length; j++) {
            char character = key[j];
            findWord(input, i+1, node.children[character - 'a'], word + character, keyboard);
        }
    }


    public static void main(String[] args) {
        char[][] keyboard = { {}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

        addWord("tree");
        addWord("used");

        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        findWord(input, keyboard);
    }
}
