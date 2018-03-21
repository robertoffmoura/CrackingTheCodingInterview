import java.util.Scanner;

public class StackOfBoxes {
    static int tallestStackHeight(int[] w, int[] h, int[] d) {
        boolean[] used = new boolean[h.length];
        return tallestStackHeight(0, 0, w, h, d, used);
    }
    static int tallestStackHeight(int count, int last, int[] w, int[] h, int[] d, boolean[] used) {
        int max = 0;
        for (int i=0; i <h.length; i++) {
            if (used[i]) continue;
            if (count > 0) {
                if (w[i] <= w[last]) continue;
                if (h[i] <= h[last]) continue;
                if (d[i] <= d[last]) continue;
            }
            used[i] = true;
            int height = h[i] + tallestStackHeight(count + 1, i, w, h, d, used);
            used[i] = false;
            if (height > max) max = height;
        }
        return max;
    }

    static int tallestStackHeight2(int[] w, int[] h, int[] d) {
        boolean[] used = new boolean[h.length];
        int[] memory = new int[h.length];
        return tallestStackHeight2(0, 0, w, h, d, used, memory);
    }
    static int tallestStackHeight2(int count, int last, int[] w, int[] h, int[] d, boolean[] used, int[] memory) {
        if (memory[last] != 0) return memory[last];
        int max = 0;
        for (int i=0; i <h.length; i++) {
            if (used[i]) continue;
            if (count > 0) {
                if (w[i] <= w[last]) continue;
                if (h[i] <= h[last]) continue;
                if (d[i] <= d[last]) continue;
            }
            used[i] = true;
            int height = h[i] + tallestStackHeight2(count + 1, i, w, h, d, used, memory);
            used[i] = false;
            if (height > max) max = height;
        }
        memory[last] = max;
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] w = new int[n];
        for (int i=0; i<n; i++) w[i] = scanner.nextInt();
        int[] h = new int[n];
        for (int i=0; i<n; i++) h[i] = scanner.nextInt();
        int[] d = new int[n];
        for (int i=0; i<n; i++) d[i] = scanner.nextInt();
        System.out.println(tallestStackHeight2(w, h, d));
    }
}
