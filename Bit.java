public class Bit {
    public static void printByte(int b) {
        int mask = (1 << Integer.SIZE - 1);
        for (int i=0; i<Integer.SIZE; i++) {
            System.out.print((b & (mask)) != 0 ? 1 : 0);
            mask >>>= 1;
        }
        System.out.println("");
        //System.out.println(Integer.toBinaryString(b));
    }

    public static boolean getBit(int b, int i) {
        return (b & (1 << i)) != 0;
    }

    public static int setBit(int b, int i) {
        return (b | (1 << i));
    }

    public static int clearBit(int b, int i) {
        return (b & ~(1 << i));
    }

    public static int updateBit(int b, int i, boolean value) {
        return value ? setBit(b, i) : clearBit(b, i);
    }

    public static int updateBit2(int b, int i, boolean value) {
        int v = value ? 1 : 0;
        return (b & ~(1 << i)) | (v << i);
    }

    public static int switchBit(int b, int i) {
        return updateBit(b, i, !getBit(b, i));
    }

    public static int switchBit2(int b, int i) {
        return (b ^ (1 << i));
    }

    public static void main(String[] args) {
        int a = 0;
        int b = 12;
        printByte(b);
        printByte(setBit(b, 4));
        printByte(setBit(b, 3));
        printByte(clearBit(b, 4));
        printByte(clearBit(b, 3));
        printByte(updateBit2(b, 4, true));
        printByte(updateBit2(b, 4, false));
        printByte(updateBit2(b, 3, true));
        printByte(updateBit2(b, 3, false));
        printByte(switchBit(b, 4));
        printByte(switchBit(b, 3));
        printByte(switchBit2(b, 4));
        printByte(switchBit2(b, 3));
    }
}
