import java.util.Random;

/*
You are implementing a binary tree class from scratch which, in addition to insert, find, and delete, has a method getRandomNode() which returns a random node from the tree. All nodes should be equally likely to be chosen. Design and implement an algorithm for getRandomNode, and explain how you would implement the rest of the methods.
*/

public class BinaryRandomTree3 {
    public class Node {
        int value;
        Node left;
        Node right;
        int numChildren;
        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
            this.numChildren = 1;
        }
        public void insert(int value) {
            this.numChildren++;
            if (this.value <= value) {
                if (this.left == null) {
                    this.left = new Node(value);
                } else {
                    this.left.insert(value);
                }
            }
            else if (this.value > value) {
                if (this.right == null) {
                    this.right = new Node(value);
                } else {
                    this.right.insert(value);
                }
            }
        }
        public Node find(int value) {
            if (this.value == value) return this;
            else if (this.value < value) {
                return this.left == null ? null : this.left.find(value);
            }
            else if (this.value > value) {
                return this.right == null ? null : this.find(value);
            }
            return null;
        }
        public Node getRandomNode() {
            int l = this.left == null ? 0 : this.left.numChildren;
            int n = this.numChildren;
            Random rand = new Random();
            int r = rand.nextInt(n) ; // r in [0,n-1]
            if (r < l) {
                return this.left.getRandomNode();
            } else if (r == l) {
                return this;
            } else {
                return this.right.getRandomNode();
            }
        }
        public Node getRandomNode2(int r) {
            int l = this.left == null ? 0 : this.left.numChildren;
            if (r < l) {
                return this.left.getRandomNode2(r);
            } else if (r == l) {
                return this;
            } else {
                return this.right.getRandomNode2(r - (l+1));
            }
        }
    }

    Node root = null;

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }
        root.insert(value);
    }

    public Node find(int value) {
        return root.find(value);
    }

    public Node getRandomNode() {
        return root.getRandomNode();
    }

    public Node getRandomNode2() {
        Random rand = new Random();
        int r = rand.nextInt(root.numChildren) ; // r in [0,n-1]
        return root.getRandomNode2(r);
    }


    public static void main(String[] args) {
        BinaryRandomTree3 tree = new BinaryRandomTree3();
        tree.insert(5);
        tree.insert(4);
        tree.insert(3);
        tree.insert(2);
        tree.insert(7);
        tree.insert(6);
        int count[] = new int[10];
        for (int i=0; i<10; i++) {
            count[i] = 0;
        }
        for (int i=0; i<100000; i++) {
            int n = tree.getRandomNode2().value;
            count[n]++;
        }
        for (int i=0; i<10; i++) {
            System.out.println("count[" + i + "]: " + count[i]);
        }
    }
}
