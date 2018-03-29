/*
Write a method to sort an array of strings so that all the anagrams are next to each other
*/

public class GroupAnagrams {
    static int[] memory = new int[26];
    static int prime(int n) {
        if (memory[n] != 0) return memory[n];
        memory[0] = 2;
        int p = 3;
        for (int i=1; i<26; p++) {
            boolean prime = true;
            for (int d = 2; d*d <= p; d++) {
                if (p%d == 0) prime = false;
            }
            if (prime) {
                memory[i++] = p;
            }
        }
        return memory[n];
    }

    static int value(String str) {
        int result = 1;
        for (int i=0; i<str.length(); i++) {
            result *= prime(str.charAt(i) - 'a');
        }
        return result;
    }


    public static void main(String[] args) {
        for (int i=0; i<26; i++) {
            System.out.print(prime(i) + " ");
        }
        String a = "abc";
        System.out.println("");
        System.out.println(value(a));
    }
}
