import java.util.Scanner;
import java.util.HashMap;

/*
Given an array filled with letters and numbers, find the longest subarray with an equal number of letters and numbers.
*/

public class LettersAndNumbers {
    static class Pair {
        int start;
        int end;
        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
        public String toString() {
            return "[" + start + ", " + end + "[";
        }
    }

    static boolean numerical(char c) {
        return ('0' <= c && c <= '9');
    }

    static Pair longestSubarray(String string) {
        int[] intsMinusChars = new int[string.length()+1];
        int count = 0;
        intsMinusChars[0] = 0;
        for (int i=0; i<string.length(); i++) {
            count += numerical(string.charAt(i)) ? 1 : -1;
            intsMinusChars[i+1] = count;
        }
        HashMap<Integer, Integer> lastIndexOfInt = new HashMap<Integer, Integer>();
        for (int i=0; i<string.length()+1; i++) {
            lastIndexOfInt.put(intsMinusChars[i], i);
        }
        int max = 0;
        Pair maxPair = new Pair(0,0);
        for (int i=0; i<string.length(); i++) {
            int distance = lastIndexOfInt.get(intsMinusChars[i]) - i;
            if (distance > max) {
                max = distance;
                maxPair = new Pair(i, lastIndexOfInt.get(intsMinusChars[i]));
            }
        }
        return maxPair;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        System.out.println(longestSubarray(string));
    }
}
