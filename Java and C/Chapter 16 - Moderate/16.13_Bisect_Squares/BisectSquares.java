/*
Given two squares on a two-dimensional plane, find a line that would cut these two squares in half. Assume that the op and the bottom sides of the square run parallel to the x-axis.
*/

public class BisectSquares {
    public static class Point {
        double x;
        double y;
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

    }
    public static class Line {
        Point start;
        Point end;
        public Line(Point start, Point end) {
            this.start = start;
            this.end = end;
        }
    }
    public static class Square {
        Point lowerLeft;
        Point upperRight;
        public Square(Point lowerLeft, Point, upperRight) {
            this.lowerLeft = lowerLeft;
            this.upperRight = upperRight;
        }
    }

    static Point middle(Point a, Point b) {
        return new Point((a.x + b.x)/2, (a.y + b.y)/2;
    }

    Line lineThatBisectsTwoSquares(Square a, Square b) {
        Point start = middle(a.lowerLeft, a.upperRight);
        Point end = middle(b.lowerLeft, b.upperRight);
        return new Line(start, end);
    }

    public static void int(String[] args) {

    }
}
