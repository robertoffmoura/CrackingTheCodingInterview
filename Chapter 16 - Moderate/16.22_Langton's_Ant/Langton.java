import java.util.Scanner;
import java.util.HashSet;

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
