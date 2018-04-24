import java.util.Scanner;

/*
Given any integer, print an English phrase that describes the integers (e.g., "One thousand, Two Hundred Thirty Four").
*/

public class EnglishInt {
    static int digits(int n) {
        int result = 0;
        while (n > 0) {
            n /= 10;
            result++;
        }
        return result;
    }

    static int firstDigits(int n, int d) {
        return n/(int)Math.pow(10, digits(n)-d);
    }

    static String english(int n) {
        int digits = digits(n);
        if (digits == 0) return "zero";
        int firstDigit = firstDigits(n, 1);
        int remaining = n - firstDigit*(int)Math.pow(10, digits-1);
        if (digits == 1) {
            switch(firstDigit) {
                case 1: return "one";
                case 2: return "two";
                case 3: return "three";
                case 4: return "four";
                case 5: return "five";
                case 6: return "six";
                case 7: return "seven";
                case 8: return "eight";
                case 9: return "nine";
                default: return "";
            }
        }
        if (digits == 2) {
            switch(firstDigit) {
                case 0: return english(remaining);
                case 1:
                    switch (remaining) {
                        case 0: return "ten";
                        case 1: return "eleven";
                        case 2: return "twelve";
                        case 3: return "thirteen";
                        case 5: return "fifteen";
                        case 8: return "eighteen";
                        default: return english(remaining) + "teen";
                    }
                case 2: return "twenty " + english(remaining);
                case 3: return "thirty " + english(remaining);
                case 4: return "forty " + english(remaining);
                case 5: return "fifty " + english(remaining);
                case 6: return "sixty " + english(remaining);
                case 7: return "seventy " + english(remaining);
                case 8: return "eighty " + english(remaining);
                case 9: return "ninety " + english(remaining);
                default: return "";
            }
        }
        if (digits == 3) return english(firstDigit) + " hundred " + english(remaining);
        /*
        String string;
        if (3 < digits && digits <= 6) string = " thousand ";
        else if (6 < digits && digits <= 9) string = " million ";
        else if (9 < digits && digits <= 12) string = " billion ";
        int k = (digits-1)%3 + 1
        int firstKDigits = firstDigits(n, k);
        remaining = n - firstKDigits*(int)Math.pow(10, digits-k);
        return english(firstKDigits) + string + english(remaining);
        */
        if (3 < digits && digits <= 6) {
            int k = digits-3;
            int firstKDigits = firstDigits(n, k);
            remaining = n - firstKDigits*(int)Math.pow(10, 3);
            return english(firstKDigits) + " thousand " + english(remaining);
        }
        if (6 < digits && digits <= 9) {
            int k = digits-6;
            int firstKDigits = firstDigits(n, k);
            remaining = n - firstKDigits*(int)Math.pow(10, 6);
            return english(firstKDigits) + " million " + english(remaining);
        }
        if (9 < digits && digits <= 12) {
            int k = digits-9;
            int firstKDigits = firstDigits(n, k);
            remaining = n - firstKDigits*(int)Math.pow(10, 9);
            return english(firstKDigits) + " billion " + english(remaining);
        }
        if (12 < digits) {
            int k = digits-12;
            int firstKDigits = firstDigits(n, k);
            remaining = n - firstKDigits*(int)Math.pow(10, 12);
            return english(firstKDigits) + " trillion " + english(remaining);
        }
        return "yo";
    }

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(english(n));

    }
}
