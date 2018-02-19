import java.util.Queue;
import java.util.LinkedList;

public class BinaryTree {
    public class Node {
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
        Node addLeft(int value) {
            Node left = new Node(value);
            this.left = left;
            return left;
        }
        Node addRight(int value) {
            Node right = new Node(value);
            this.right = right;
            return right;
        }
    }

    public Node createNode(int value) {
        return new Node(value);
    }

    public Node root = null;

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = tree.createNode(5);
        tree.root.addLeft(4);
        tree.root.addRight(6);
    }
}
