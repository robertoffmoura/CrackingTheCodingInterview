import java.util.Queue;
import java.util.LinkedList;

public class BinarySearchTree {
    public class Node {
        int value;
        Node left;
        Node right;
        Node parent;
        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
            this.parent = null;
        }
        public Node getLeft() {
            if (this.left == null) return this.parent;
            Node trav = this.left;
            while (trav.right != null) trav = trav.right;
            return trav;
        }
        public Node getRight() {
            if (this.right == null) return this.parent;
            Node trav = this.left;
            while (trav.right != null) trav = trav.right;
            return trav;
        }
    }

    public Node createNode(int value) {
        return new Node(value);
    }

    public Node root = null;

    public Node add(int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        Node trav = root;
        while (true) {
            if (value < trav.value) {
                if (trav.left == null) {
                    trav.left = new Node(value);
                    trav.left.parent = trav;
                    return trav.left;
                } else {
                    trav = trav.left;
                }
            } else if (value >= trav.value) {
                if (trav.right == null) {
                    trav.right = new Node(value);
                    trav.right.parent = trav;
                    return trav.right;
                } else {
                    trav = trav.right;
                }
            }
        }

    }

    public boolean find(int value) {
        if (root == null) {
            return false;
        }
        Node trav = root;
        while (true) {
            if (value < trav.value) {
                if (trav.left == null) {
                    return false;
                } else {
                    trav = trav.left;
                }
            } else if (value > trav.value) {
                if (trav.right == null) {
                    return false;
                } else {
                    trav = trav.right;
                }
            } else {
                return true;
            }
        }
    }


    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(5);
        tree.add(4);
        tree.add(3);
        tree.add(2);
        tree.add(7);
        tree.add(6);
    }
}
