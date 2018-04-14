import java.util.Scanner;
import java.util.HashMap;

/*
Given a two-dimensional graph with points on it, find a line which passes the most number of points
*/

public class BestLine {
    static double epsilon = 0.001;

    public static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public String toString() {
            return "(" + x + ", " + y +")";
        }
    }

    public static class Line {
        Point start;
        Point end;
        public Line(Point start, Point end) {
            this.start = start;
            this.end = end;
        }
        public double getSlope() {
            return round((start.y - end.y) / (double)(start.x - end.x), epsilon);
        }
        public String toString() {
            return start + " -> " + end;
        }
    }

    static double round(double x, double epsilon) {
        return ((int) (x/epsilon)) * epsilon;
    }

    static Line getBestLine(Point[] graph) {
        Line result = new Line(new Point(0,0), new Point(1,0));
        int max = 0;
        for (int i=0; i<graph.length; i++) {
            HashMap<Double, Integer> slopeFrequency = new HashMap<Double, Integer>();
            for (int j=i+1; j<graph.length; j++) {
                Line line = new Line(graph[i], graph[j]);
                double slope = line.getSlope();
                System.out.println(line + ": " + slope);
                if (slopeFrequency.containsKey(slope)) {
                    int frequency = slopeFrequency.get(slope);
                    slopeFrequency.replace(slope, ++frequency);
                    if (frequency > max) {
                        max = frequency;
                        result = line;
                    }
                } else {
                    slopeFrequency.put(slope, 1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Point[] graph = new Point[n];
        for (int i=0; i<n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[i] = new Point(x, y);
        }
        Line line = getBestLine(graph);
        System.out.println(line);
    }
}
