import java.util.Scanner;

/*
Imagine a robot sitting on the upper left corner of grid with r rows and c columns. The robot can only move in tow directions, right and down, but certain cells are "off limits" such that the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to bottom right.
*/

public class RobotGrid {
    static int[][] board;

    static void printMatrix(int[][] matrix, int r, int c) {
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    static boolean findPath(int[][] board, int i, int j, int r, int c) {
        if (i < 0 || i >= r) return false;
        if (j < 0 || j >= c) return false;
        if (board[i][j] == -1) return false;
        board[i][j] = 1;
        if (findPath(board, i, j+1, r, c)) return true;
        if (findPath(board, i+1, j, r, c)) return true;
        return (i == r-1 && j == c-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        board = new int[r][c];
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                board[i][j] = 0;
            }
        }
        int n = sc.nextInt();
        for (int i=0; i<n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            board[x][y] = -1;
        }
        findPath(board, 0, 0, r, c);
        printMatrix(board, r, c);
    }
}
