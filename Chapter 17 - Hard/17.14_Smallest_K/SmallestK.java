import java.util.ArrayList;
import java.util.Scanner;

/*
Design an algorithm to find the smallest K numbers in an array.
*/

public class SmallestK {
    static ArrayList<Integer> append(ArrayList<Integer> main, ArrayList<Integer> appendix) {
        for (int item : appendix) {
            main.add(item);
        }
        return main;
    }

    static ArrayList<Integer> smallestK(ArrayList<Integer> array, int k) {
        int i = (int) (Math.random() * array.size());
        int element = array.get(i);
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();

        for (int item : array) {
            if (item < element) {
                left.add(item);
            } else {
                right.add(item);
            }
        }

        if (left.size() == k) return left;
        else if (left.size() > k) return smallestK(left, k);
        else return append(left, smallestK(right, k - left.size()));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        ArrayList<Integer> array = new ArrayList<Integer>();
        while (sc.hasNext()) {
            array.add(sc.nextInt());
        }
        System.out.println(array);
        System.out.println(smallestK(array, k));
    }
}
