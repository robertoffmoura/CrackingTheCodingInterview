/*
A monochrome screen is stored as a single array of bytes, allowing eight consecutive pixels to be stored in one byte. The screen has width w, where w is divisible by 8 (that is, no byte will be split across rows). The height of the screen, of course, can be derived from the length of the array and the width. Implement a function that draws a horizontal line from (x1, y) to (x2, y).
The method should look something like:
drawLine(byte[] screen, int width, int x1, int x2, int y)
*/

public class DrawLine {
    static void drawLine(byte[] screen, int width, int x1, int x2, int y) { //Assuming x2 > x1
        int height = screen.length/width;
        int i1 = x1%8
        int i2 = x2%8;
        int index1 = (height - 1 - y)*width + x1/8;
        int index2 = (height - 1 - y)*width + x2/8;
        if (index1 == index2) {
            screen[index1] |= (((1 << (i2-i1+1)) - 1) << 8-1-i2);
            return;
        }
        screen[index1] |= ((1 << (8-1-i1+1)) - 1);
        for (int i=index1+1; i<index2; i++) screen[i] |= ~0;
        screen[index2] |= (((1 << i2+1) - 1) << 8-1-i2);
        return;
    }

    static void printByte(byte b) {
        int mask = (1 << 8 - 1);
        for (int i=0; i<8; i++) {
            System.out.print((b & (mask)) != 0 ? 1 : 0);
            mask >>>= 1;
        }
    }

    static void showScreen(byte[] screen, int width) {
        for (int i=0; i<screen.length; i++) {
            printByte(screen[i]);
            System.out.print(" ");
            if (i%width == width - 1) System.out.println("");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        byte[] screen = new byte[9];
        showScreen(screen, 3);
        drawLine(screen, 3, 3, 18, 1);
        showScreen(screen, 3);
    }
}
