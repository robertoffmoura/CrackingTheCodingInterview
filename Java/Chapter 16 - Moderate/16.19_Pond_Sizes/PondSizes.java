import java.util.ArrayList;
import java.util.Scanner;

/*
You have an integer matrix representing a plot of land, where the value at that location represents the height above sea level. A value of zero indicates water. A pond is a region of water connected vertically, horizontally, or diagonally. The size of the pond is the total number of connected water cells. Write a method to compute the sizes of all ponds in the matrix.
EXAMPLE
Input:
    0 2 1 0
    0 1 0 1
    1 1 0 1
    0 1 0 1
Output: 2, 4, 1 (in any order)
*/

public class PondSizes {
    static boolean valid(int[][] pond, int i, int j) {
        if (i < 0 || i >= pond.length) return false;
        if (j < 0 || j >= pond[0].length) return false;
        return (pond[i][j] == 0);
    }

    static int count(int[][] pond, int i, int j) {
        if (!valid(pond, i, j)) return 0;
        pond[i][j] = -1;
        int result = 1;
        int[] deltaI = {0, -1, -1, -1,  0,  1, 1, 1};
        int[] deltaJ = {1,  1,  0, -1, -1, -1, 0, 1};
        for (int k=0; k<8; k++) {
            result += count(pond, i + deltaI[k], j + deltaJ[k]);
        }
        /*
        for (int di = -1; di <= 1; di ++) {
            for (int dj = -1; dj <= 1; dj ++) {
                result += count(pond, i + di, i + dj);
            }
        }
        */
        return result;
    }

    static ArrayList<Integer> sizes(int[][] pond) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        for (int i=0; i<pond.length; i++) {
            for (int j=0; j<pond[0].length; j++) {
                int size = count(pond, i, j);
                if (size > 0) {
                    results.add(size);
                }
            }
        }
        return results;
    }

    static void printArrayList(ArrayList<Integer> arrayList) {
        if (arrayList.size() == 0) return;
        for (int i=0; i<arrayList.size()-1; i++) {
            System.out.print(arrayList.get(i) + ", ");
        }
        System.out.println(arrayList.get(arrayList.size()-1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] pond = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                pond[i][j] = sc.nextInt();
            }
        }
        printArrayList(sizes(pond));
    }
}
