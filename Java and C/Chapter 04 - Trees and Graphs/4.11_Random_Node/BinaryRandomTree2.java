import java.util.Random;

/*
You are implementing a binary tree class from scratch which, in addition to insert, find, and delete, has a method getRandomNode() which returns a random node from the tree. All nodes should be equally likely to be chosen. Design and implement an algorithm for getRandomNode, and explain how you would implement the rest of the methods.
*/

public class BinaryRandomTree2 {
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
    }

    Node root = null;

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }
        insert(value, root);
    }

    public void insert(int value, Node node) {
        node.numChildren++;
        if (node.value <= value) {
            if (node.left == null) {
                node.left = new Node(value);
            } else {
                insert(value, node.left);
            }
        }
        else if (node.value > value) {
            if (node.right == null) {
                node.right = new Node(value);
            } else {
                insert(value, node.right);
            }
        }
    }

    public Node find(int value) {
        return find(value, root);
    }

    public Node find(int value, Node node) {
        if (node.value == value) return node;
        else if (node.value < value) {
            return node.left == null ? null : find(value, node.left);
        }
        else if (node.value > value) {
            return node.right == null ? null : find(value, node.right);
        }
        return null;
    }

    public Node getRandomNode() {
        return getRandomNode(root);
    }

    public Node getRandomNode(Node node) {
        int l = node.left == null ? 0 : node.left.numChildren;
        int n = node.numChildren;
        Random rand = new Random();
        int r = rand.nextInt(n) ; // r in [0,n-1]
        if (r < l) {
            return getRandomNode(node.left);
        } else if (r == l) {
            return node;
        } else {
            return getRandomNode(node.right);
        }
    }

    public Node getRandomNode2() {
        Random rand = new Random();
        int r = rand.nextInt(root.numChildren) ; // r in [0,n-1]
        return getRandomNode2(r, root);
    }

    public Node getRandomNode2(int r, Node node) {
        int l = node.left == null ? 0 : node.left.numChildren;
        if (r < l) {
            return getRandomNode2(r, node.left);
        } else if (r == l) {
            return node;
        } else {
            return getRandomNode2(r - (l+1), node.right);
        }
    }

    public static void main(String[] args) {
        BinaryRandomTree2 tree = new BinaryRandomTree2();
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
