import java.util.Scanner;
import java.util.HashSet;

/*
An ant is sitting on an infinite grid of white and black squares. It initially faces right. At each step, it does the following:
(1) At a white square, flip the color of the square, turn 90 degress right (clockwise), and move forward one unit.
(2) At a black square, flip the color of the square, turn 90 degrees left (counter-clockwise), and move forward one unit.
Write a program to simulate the first K moves that the ant makes and print the final board as a grid. Note that you are not provided with the data structure to represent the grid. This is something you must design yourself. The only input to your method is K. You should print the final grid and return nothing. The method signature might be something like void printKMoves(int K).
*/

public class Langton {
    static int n = 20;
    static boolean[][] board = new boolean[n][n];

    public static class Ant {
        Point position;
        public void move(int dx, int dy) {
            this.position.x += dx;
            this.position.y += dy;
        }
        public Ant(int x, int y) {
            this.position = new Point(x, y);
        }
    }

    public static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    static boolean isBlack(Point p) {
        return board[p.x][p.y];
    }

    static void flipColor(Point p) {
        board[p.x][p.y] = !board[p.x][p.y];
    }

    static void printMoves(int k) {
        Ant ant = new Ant(10, 10);
        int[] dx = {0, -1,  0, 1};
        int[] dy = {1,  0, -1, 0};
        int i = 0;
        for (int j=0; j<k; j++) {
            i += isBlack(ant.position) ? 1 : -1;
            if (i == -1) i += 4;
            if (i == 4) i -= 4;
            flipColor(ant.position);
            ant.move(dx[i], dy[i]);
        }
        printBoard();
    }

    static void printBoard() {
        for (int x=0; x<n; x++) {
            for (int y=0; y<n; y++) {
                System.out.print((board[x][y] ? 1 : 0) + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        printMoves(k);
    }
}
