import java.util.Scanner;

/*
Design an algorithm to figure out if someone has won a game of tic-tac-toe.
*/

public class TicTacWin {
    static boolean equals(int a, int b, int c) {
        return (a == b && b == c);
    }
    static boolean win(int[][] board) {
        if (board[1][1] != 0) {
            int[] J = {1, 1, 0, -1};
            int[] I = {0, -1, -1, -1};
            for (int k=0; k<4; k++) {
                if (equals(board[1][1], board[1+I[k]][1+J[k]], board[1-I[k]][1-J[k]])) return true;
            }
        }
        if (board[2][0] != 0) {
            if (equals(board[2][0], board[2][1], board[2][2])) return true;
            if (equals(board[2][0], board[1][0], board[0][0])) return true;
        }
        if (board[0][2] != 0) {
            if (equals(board[0][2], board[1][2], board[2][2])) return true;
            if (equals(board[0][2], board[0][1], board[0][0])) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] board = new int[3][3];
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                board[i][j] = scanner.nextInt();
            }
        }
        System.out.println(win(board));
    }
}
