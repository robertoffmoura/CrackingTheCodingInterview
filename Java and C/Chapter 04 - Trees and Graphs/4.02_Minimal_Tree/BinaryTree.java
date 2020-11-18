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
    }

    public Node createNode(int value) {
        return new Node(value);
    }

    public Node root = null;

    public void add(int value) {
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

    public static void main(String[] args) {
    }
}
