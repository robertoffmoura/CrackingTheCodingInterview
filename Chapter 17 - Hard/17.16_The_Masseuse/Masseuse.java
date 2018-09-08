import java.util.Scanner;

/*
A popular masseuse receives a sequence of back-to-back appointment requests and is debating which ones to accept. She needs a 15-minute break between appointments and therefore she cannot accept any adjacent requests. Given a sequence of back-to-back appointment requests (all multiples of 15 minutes, none overlap, and none can be moved), find the optimal (highest total booked minutes) set the masseuse can honor. Return the number of minutes.
EXAMPLE
Input: {30, 15, 60, 75, 45, 15, 15, 45}
Outuput: 180 minutes ({30, 60, 45, 45}).
*/

public class Masseuse {
    static int bestSum(int[] array) {
        int[] memory = new int[array.length];
        for (int i=0; i<array.length; i++) memory[i] = -1;
        return bestSum(array, 0, memory);
    }

    static int bestSum(int[] array, int i, int[] memory) {
        if (i >= array.length) return 0;
        if (memory[i] != -1) return memory[i];
        int r1 = bestSum(array, i+1, memory);
        int r2 = array[i] + bestSum(array, i+2, memory);
        memory[i] = r1 > r2 ? r1 : r2;
        return memory[i];
    }

    static int bestSum2(int[] array) {// Book's solution
        int oneAway = 0;
        int twoAway = 0;
        for (int i=array.length-1; i>=0; i--) {
            int with = array[i] + twoAway;
            int without = oneAway;
            int current = with > without ? with : without;
            twoAway = oneAway;
            oneAway = current;
        }
        return oneAway;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i=0; i<n; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println(bestSum(array));
    }
}
