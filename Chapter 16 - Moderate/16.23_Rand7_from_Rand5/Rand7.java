/*
Implement a method rand7() given rand5(). That is, given a method that generates a random number between 0 and 4 (inclusive), write a method that generates a random number 0 and 6 (inclusive).
*/

public class Rand7 {
    static int random5() {
        return (int) (5*Math.random());
    }
    static int random7() {
        int n1 = random5();
        int n2 = random5();
        int n = 5*n1 + n2;
        if (n < 21) return n%7;
        return random7();
    }
    public static void main(String[] args) {
        int sum = 0;
        int times = 100000000;
        for (int i=0; i<times; i++) {
            sum += random7();
        }
        System.out.println(sum/(double)times);
    }
}
