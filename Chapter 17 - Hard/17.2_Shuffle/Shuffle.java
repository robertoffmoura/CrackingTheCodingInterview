/*
Write a method to shuffle a deck of cards. It must be a perfect shuffle - in other words, each of the 52! permutations of the deck has to be equally likely. Assume that you are given a random number generator which is perfect.
*/

public class Shuffle {
    static int[] shuffle(int[] array) {
        int[] result = new int[52];
        boolean[] used = new boolean[52];
        for (int n=0; n<52; n++) {
            int rand = (int) (Math.random()*(52-n));
            int i = 0;
            for (int j=0; j<rand;) {
                while (used[i]) i++;
                i++;
                j++;
            }
            while (used[i]) i++;
            result[n] = array[i];
            used[i] = true;
        }
        return result;
    }

    static void shift(int start, int end, int[] array) {
        int temp = array[start];
        for (int i=start; i<end; i++) {
            array[i] = array[i+1];
        }
        array[end] = temp;
    }

    static int[] shuffle2(int[] array) {
        for (int n=0; n<52; n++) {
            int rand = (int) (Math.random()*(52-n));
            shift(rand, 52-n-1, array);
        }
        return array;
    }

    static void printArray(int[] array) {
        for (int i=0; i<array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }


    public static void main(String[] args) {
        int[] array = new int[52];
        for (int i=0; i<52; i++) {
            array[i] = i;
        }
        printArray(shuffle2(array));
    }
}
