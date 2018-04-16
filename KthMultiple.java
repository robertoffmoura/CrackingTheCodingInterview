import java.util.Scanner;

public class KthMultiple {
    static boolean valid(int n) {
        while (n%7 == 0) n /= 7;
        while (n%5 == 0) n /= 5;
        while (n%3 == 0) n /= 3;
        return (n == 1);
    }

    static String decompose(int n) {
        int count7 = 0;
        int count5 = 0;
        int count3 = 0;
        while (n%7 == 0) {
            n /= 7;
            count7++;
        }
        while (n%5 == 0) {
            n /= 5;
            count5++;
        }
        while (n%3 == 0) {
            n /= 3;
            count3++;
        }
        return count7 + " " + count5 + " " + count3;
    }

    static int multiple(int k) {
        int n = 1;
        for (int i=0; i<k; ) {
            n++;
            if (valid(n)) i++;
        }
        return n;
    }

    static void printList(int k) {
        int n = 1;
        for (int i=0; i<k; ) {
            n++;
            if (valid(n)) {
                i++;
                System.out.println(i + "\t" + n + "\t" + decompose(n));
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        System.out.println(multiple(k));
    }
}
