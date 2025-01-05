import java.util.Scanner;

/*
Given two straight line segments (represented as a start point and an end point), compute the point of intersection, if any.
*/

public class Intersection {
    static boolean isBetween(double x, int left, int right) {
        if (left <= x && x <= right) return true;
        if (right <= x && x <= left) return true;
        return false;
    }

    static boolean intersects(int x1, int x2, int x3, int x4, int y1, int y2, int y3, int y4) {
        if ((y2-y1)*(x4-x3) - (y4-y3)*(x2-x1) == 0) {//same angular coefficient
            if ((y4-y2)*(x4-x3)*(x2-x1) - x4*(y4-y3)*(x2-x1) + x2*(y2-y1)*(x4-x3) == 0) {//same linear coefficient
                if (isBetween((double)x3, x1, x2)) return true;
            }
            return false;
        }
        double x = ((y4-y2)*(x2-x1)*(x4-x3) + x2*(y2-y1)*(x4-x3) - x3*(y4-y3)*(x2-x1)) / (double) ((y2-y1)*(x4-x3) - (y4-y3)*(x2-x1));
        //x is the intersection of the two lines
        if (isBetween(x, x1, x2)) {
            if (isBetween(x, x3, x4)) return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] x = new int[4];
        int[] y = new int[4];
        for (int i=0; i<4; i++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
        }
        System.out.println(intersects(x[0], x[1], x[2], x[3], y[0], y[1], y[2], y[3]));
    }
}
