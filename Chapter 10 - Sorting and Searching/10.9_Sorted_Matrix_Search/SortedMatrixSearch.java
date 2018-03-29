import java.util.Scanner;

/*
Given an M x N matrix in which each row and each column is sorted in ascending order, write a method to find an element.
*/

public class SortedMatrixSearch {
    public class Point {
        int i;
        int j;
        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
        String stringRepresentation() {
            return "(" + i + ", " + j + ")";
        }
    }


    Point search(int[][] matrix, int n) {
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int i;
        int j;
        //We start doing a binary search on the first row, after that we sweep all elements to the right of the column found (because they're all bigger than n). Then we do a binary search on the column at which we stopped, and sweep all elements above the row found (because the're all smaller than n). After that we end up with a new smaller matrix, now we just repeat the steps.
        while (right >= 0 && up <= matrix[0].length - 1) {
            i = up;
            j = (left + right)/2;
            while (left <= right) {
                j = (left + right)/2;
                if (matrix[i][j] < n) left = j + 1;
                else if (matrix[i][j] > n) right = j - 1;
                else return new Point(i, j);
            }
            while (up <= down) {
                i = (up + down)/2;
                if (matrix[i][j] < n) up = i + 1;
                else if (matrix[i][j] > n) down = i - 1;
                else return new Point(i, j);
            }
            left = 0;
            down = matrix[0].length - 1;
        }
        return new Point(-1, -1);
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SortedMatrixSearch problem = new SortedMatrixSearch();
        int[][] matrix = {{0, 1, 2},
                        {3, 4, 5},
                        {6, 7, 8}};
        int n = scanner.nextInt();
        System.out.println(problem.search(matrix, n).stringRepresentation());
    }
}
