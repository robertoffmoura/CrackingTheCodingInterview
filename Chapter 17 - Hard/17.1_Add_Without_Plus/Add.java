import java.util.Scanner;

/*
Write a function that adds two numbers. You should not use + or any arithmetic operators.
*/

public class Add {
    static int sum(int a, int b) {
        int c = 1;
        int result = 0;
        int carry = 0;
        int value;
        while (c != 0) {
            if (carry == 0) {
                value = ((a&c)^(b&c));
                carry = (((a&c)&(b&c)) != 0) ? 1 : 0;
            } else {
                value = (a&c)&(b&c);
                if ((a&c) == 0 && (b&c) == 0) value = c;
                carry = (((a&c)|(b&c)) != 0) ? 1 : 0;
            }
            result |= value;
            c <<= 1;
        }
        return result;
    }

    static int sum2(int a, int b) {//Book's solution
        if (b == 0) return a;
        int sum = a^b; //add without carrying
        int carry = (a&b) << 1; //carry without adding
        return sum2(sum, carry);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(sum2(a,b));
    }
}
