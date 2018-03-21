/*
Write an algorithm to print all ways of arranging eight queens on an 8x8 chess board so that none of them share the same row, column, or diagonal. In this case, "diagonal" means all diagonals, not just the two that bisect the board.
*/

public class EightQueens {
    static void printMatrix(int[][] matrix) {
        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    static void recurse(int j, int[][] board, int[][] matrix) {
        if (j == 8) {
            printMatrix(matrix);
            System.out.println("");
            return;
        }
        for (int i=0; i<8; i++) {
            if (board[i][j] == 0) {
                fillBoard(board, i, j, 1);
                matrix[i][j] = 1;
                recurse(j+1, board, matrix);
                matrix[i][j] = 0;
                fillBoard(board, i, j, -1);
            }
        }
    }

    static boolean validate(int i, int j) {
        if (i < 0 || 8 <= i) return false;
        if (j < 0 || 8 <= j) return false;
        return true;
    }

    static void fillBoard(int[][] board, int i, int j, int value) {
        int[] deltaI = {0, -1, -1, -1,  0, 1,  1, 1};
        int[] deltaJ = {1,  1,  0, -1, -1, -1, 0, 1};
        for (int k=0; k<8; k++) {
            int x = i + deltaI[k];
            int y = j + deltaJ[k];
            while (validate(x, y)) {
                board[x][y] += value;
                x += deltaI[k];
                y += deltaJ[k];
            }
        }
    }


    public static void main(String[] args) {
        int[][] board = new int[8][8]; //board with available spaces marked as zero;
        int[][] matrix = new int[8][8]; //board with queens marked as 1;
        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                board[i][j] = 0;
                matrix[i][j] = 0;
            }
        }

        recurse(0, board, matrix);
    }
}
