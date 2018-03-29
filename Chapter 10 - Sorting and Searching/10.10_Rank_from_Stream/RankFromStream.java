import java.util.Scanner;

/*
Imagine you are reading in a stream of integers. Periodically, you wish to be able to look up the rank of a number x (the number of values less than or equal to x). Implement the data structures and algorithms to support these operations. That is, implement the method track (int x), which is called when each number is generated, and the method getRankOfNumber (int x), which returns the number of values less than or equal to x (not including x itself).
*/

public class RankFromStream {
    public class Node {
        int value;
        Node left;
        Node right;
        int numChildren;
        public Node(int value) {
            this.value = value;
            numChildren = 0;
        }
        public void add(int value) {
            numChildren++;
            if (this.value < value) {
                if (this.right != null) this.right.add(value);
                else this.right = new Node(value);
            } else {
                if (this.left != null) this.left.add(value);
                else this.left = new Node(value);
            }
        }
        public int getRank(int value) {
            return this.getRank(value, false);
        }
        public int getRank(int value, boolean foundX) {
            if (value < this.value) {
                return this.left == null ? 0 : this.left.getRank(value);
            } else if (this.value < value) {
                int result = 1;
                if (this.left != null) result += 1 + this.left.numChildren;
                if (this.right != null) result += this.right.getRank(value);
                return result;
            } else {
                return this.left == null ? 0 : 1 + this.left.numChildren;
            }
        }
    }

    public Node root;

    public void track(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }
        root.add(value);
    }

    public int getRankOfNumber(int value) {
        if (root == null) return 0;
        return root.getRank(value);
    }

    public static void main(String[] args) {
        RankFromStream rank = new RankFromStream();
        Scanner scanner = new Scanner(System.in);
        //while (scanner.hasNextInt()) {
        for (int i=0; i<8; i++) {
            int n = scanner.nextInt();
            rank.track(n);
        }
        for (int i=0; i<8; i++) {
            int n = scanner.nextInt();
            System.out.println(rank.getRankOfNumber(n));
        }

    }
}
