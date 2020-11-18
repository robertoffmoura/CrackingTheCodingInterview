/*
Implement the "paint fill" function that one might see on many image editing programs. That is, given a screen (represented by a two-dimensional array of colors), a point, and a new color, fill in the surrounding area until the color changes from the original color
*/

public class PaintFill {
    static void printImage(int[][] image) {
        for (int i=0; i<image.length; i++) {
            for (int j=0; j<image[0].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println("");
        }
    }

    static void fill(int i, int j, int color, int[][] image) {
        fill(i, j, image[i][j], color, image);
    }

    static boolean validatePoint(int i, int j, int[][] image) {
        if (i < 0 || image.length <= i) return false;
        if (j < 0 || image[0].length <= j) return false;
        return true;
    }

    static void fill(int i, int j, int originalColor, int newColor, int[][] image) {
        if (!validatePoint(i, j, image)) return;
        if (image[i][j] == newColor) return;
        if (image[i][j] != originalColor) return;
        image[i][j] = newColor;
        int[] deltaI = {0, -1,  0, 1};
        int[] deltaJ = {1,  0, -1, 0};
        for (int k=0; k<4; k++) {
            fill(i + deltaI[k], j + deltaJ[k], originalColor, newColor, image);
        }
    }


    public static void main(String[] args) {
        int[][] image = new int[10][20];
        for (int i=0; i<10; i++) {
            for (int j=0; j<20; j++) {
                image[i][j] = 2;
            }
        }
        for (int j=0; j<20; j++) {
            image[3][j] = 4;
        }
        printImage(image);
        fill(6, 1, 3, image);
        System.out.println("");
        printImage(image);
    }
}
