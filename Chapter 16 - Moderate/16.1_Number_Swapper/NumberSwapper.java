import java.util.Scanner;

/*
Write a function to swap a number in place (that is, without temporary variables).
*/

public class NumberSwapper {
    public static class Point {
        int value;
        public Point(int value) {
            this.value = value;
        }
    }
    static void swap(Point a, Point b) {
        int temp = a.value;
        a.value = b.value;
        b.value = temp;
    }
    static void swap2(Point a, Point b) {
        a.value -= b.value;
        b.value += a.value;
        a.value -= b.value;
        a.value *= (-1);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Point a = new Point(scanner.nextInt());
        Point b = new Point(scanner.nextInt());
        swap2(a,b);
        System.out.println(a.value + " " + b.value);
    }
}
