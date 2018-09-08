/*
Same problem, but this time implement a method rand5() given rand7(). That is, given a method that generates a random number between 0 and 6 (inclusive), write a method that generates a random number 0 and 4 (inclusive).
*/

public class Rand5 {
    static int random7() {
        return (int) (7*Math.random());
    }
    static int random5() {
        int n = random7();
        if (n < 5) return n;
        return random5();
    }
    public static void main(String[] args) {
        int sum = 0;
        int times = 100000000;
        for (int i=0; i<times; i++) {
            sum += random5();
        }
        System.out.println(sum/(double)times);
    }
}
