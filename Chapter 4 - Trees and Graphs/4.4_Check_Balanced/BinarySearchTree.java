import java.util.Queue;
import java.util.LinkedList;

public class BinarySearchTree {
    public class Node {
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    Node root = null;

    void add(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }
        Node trav = root;
        while (true) {
            if (value < trav.value) {
                if (trav.left == null) {
                    trav.left = new Node(value);
                    break;
                } else {
                    trav = trav.left;
                }
            } else if (value >= trav.value) {
                if (trav.right == null) {
                    trav.right = new Node(value);
                    break;
                } else {
                    trav = trav.right;
                }
            }
        }

    }

    boolean find(int value) {
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

    void printBreadthFirst() {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            System.out.print(node.value + " ");
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }

    void printPreOrder(Node node) {
        if (node == null) return;
        System.out.println(node.value);
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    void printInOrder(Node node) {
        if (node == null) return;
        printInOrder(node.left);
        System.out.println(node.value);
        printInOrder(node.right);
    }

    void printPostOrder(Node node) {
        if (node == null) return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.println(node.value);
    }

    void printPreOrder() { printPreOrder(root); }
    void printInOrder() { printInOrder(root); }
    void printPostOrder() { printPostOrder(root); }

    public static void main(String[] args) {
    }
}
