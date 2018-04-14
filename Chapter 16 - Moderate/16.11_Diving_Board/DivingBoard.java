import java.util.ArrayList;

/*
You are building a diving board by placing a bunch of planks of wood end-to-end. There are two types of planks, one of length shorter and one of length longer. You must use exactly k planks of wood. Write a method to generate all possible lengths for the diving board.
*/

public class DivingBoard {
    static ArrayList<Integer> boardLengths(int shorter, int longer, int k) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        for (int i=0; i<=k; i++) {
            array.add(shorter*i + longer*(k-i));
        }
        return array;
    }
    public static void main(String[] args) {
        ArrayList<Integer> a = boardLengths(2, 1, 3);
        for (Integer i : a) {
            System.out.println(i);
        }
    }
}
