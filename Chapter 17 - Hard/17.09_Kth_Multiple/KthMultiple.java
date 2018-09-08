import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

/*
Design an algorithm to find the kth number such that the only prime factors are 3, 5, and 7. Note that 3, 5, and 7 do not have to be the factors, but it should not have any other prime factors. For example, the first several multiples would be (in order) 1, 3, 5, 7, 9, 15, 21.
*/

public class KthMultiple {//Book's Solution
    static int min(int a, int b) {
        return a < b ? a : b;
    }

    static int min(int a, int b, int c) {
        return min(a, min(b, c));
    }

    static int kthMultiple(int k) {
        Queue<Integer> queue3 = new LinkedList<Integer>();
        Queue<Integer> queue5 = new LinkedList<Integer>();
        Queue<Integer> queue7 = new LinkedList<Integer>();

        queue3.add(3);
        queue5.add(5);
        queue7.add(7);

        int count = 1;
        int last = 1;
        int minimum = 1;
        while (count < k) {
            int a = queue3.peek();
            int b = queue5.peek();
            int c = queue7.peek();

            minimum = min(a, b, c);

            if (minimum == a) queue3.poll();
            else if (minimum == b) queue5.poll();
            else queue7.poll();

            if (minimum == last) continue;

            queue3.add(minimum*3);
            queue5.add(minimum*5);
            queue7.add(minimum*7);
            last = minimum;
            count++;
        }
        return minimum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        System.out.println(kthMultiple(k));
    }
}
