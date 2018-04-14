import java.util.Scanner;

/*
The Game of Master Mind is played as follows:
The computer has four slots, and each slot will contain a ball that is red (R), yellow (Y), green (G) or blue (B). For example, the computer might have RGGB (Slot #1 is red, Slots #2 and #3 are green, Slot #4 is blue).
You, the user, are trying to guess the solution. You might, for example, guess YRGB.
When you guess the correct color for the correct slot, you get a "hit". If you guess a color that exists but is in the wrong slot, you get a "pseudo-hit". Note that a slot that is a hit can never count as a pseudo-hit.
For example, if the actual solution is RGBY and you guess GGRR, you have one hit and one pseudo-hit. Write a method that, given a guess and a soluton, returns the number of hits and pseudo-hits.
*/

public class MasterMind {
    static int colorCode(char c) {
        switch (c) {
            case 'R': return 0;
            case 'G': return 1;
            case 'B': return 2;
            case 'Y': return 3;
        }
        return -1;
    }

    static void printResult(char[] guess, char[] solution) {
        int hits = 0;
        int pseudoHits = 0;
        boolean[] used = new boolean[4];
        int[] colorCount = new int[4];
        for (int i=0; i<4; i++) {
            colorCount[colorCode(solution[i])]++;
        }
        for (int i=0; i<4; i++) {
            if (guess[i] == solution[i]) {
                hits++;
                colorCount[colorCode(solution[i])]--;
                used[i] = true;
            }
        }
        for (int i=0; i<4; i++) {
            if (used[i]) continue;
            if (colorCount[colorCode(guess[i])] > 0) {
                pseudoHits++;
                colorCount[colorCode(guess[i])]--;
            }
        }
        System.out.println("hits: " + hits + ", pseudoHits: " + pseudoHits);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] guess = new char[4];
        char[] solution = new char[4];
        String string = sc.next();
        for (int i=0; i<4; i++) {
            guess[i] = string.charAt(i);
        }
        string = sc.next();
        for (int i=0; i<4; i++) {
            solution[i] = string.charAt(i);
        }
        printResult(guess, solution);
    }
}
