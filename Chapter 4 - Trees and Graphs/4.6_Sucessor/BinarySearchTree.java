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

    public void printBreadthFirst() {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            System.out.print(node.value + " ");
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }

    public void printPreOrder(Node node) {
        if (node == null) return;
        System.out.println(node.value);
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    public void printInOrder(Node node) {
        if (node == null) return;
        printInOrder(node.left);
        System.out.println(node.value);
        printInOrder(node.right);
    }

    public void printPostOrder(Node node) {
        if (node == null) return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.println(node.value);
    }

    public void printPreOrder() { printPreOrder(root); }
    public void printInOrder() { printInOrder(root); }
    public void printPostOrder() { printPostOrder(root); }

    public static void main(String[] args) {
    }
}
