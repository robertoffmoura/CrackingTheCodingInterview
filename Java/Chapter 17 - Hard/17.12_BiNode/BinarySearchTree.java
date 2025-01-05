import java.util.Queue;
import java.util.LinkedList;

public class BinarySearchTree {
    public class BiNode {
        public int value;
        public BiNode node1, node2;
        public BiNode(int value) {
            this.value = value;
            this.node1 = null;
            this.node2 = null;
        }
    }

    public BiNode createNode(int value) {
        return new BiNode(value);
    }

    public BiNode root = null;

    public void add(int value) {
        if (root == null) {
            root = new BiNode(value);
            return;
        }
        BiNode trav = root;
        while (true) {
            if (value < trav.value) {
                if (trav.node1 == null) {
                    trav.node1 = new BiNode(value);
                    break;
                } else {
                    trav = trav.node1;
                }
            } else if (value >= trav.value) {
                if (trav.node2 == null) {
                    trav.node2 = new BiNode(value);
                    break;
                } else {
                    trav = trav.node2;
                }
            }
        }

    }

    public boolean find(int value) {
        if (root == null) {
            return false;
        }
        BiNode trav = root;
        while (true) {
            if (value < trav.value) {
                if (trav.node1 == null) {
                    return false;
                } else {
                    trav = trav.node1;
                }
            } else if (value > trav.value) {
                if (trav.node2 == null) {
                    return false;
                } else {
                    trav = trav.node2;
                }
            } else {
                return true;
            }
        }
    }

    public void printBreadthFirst() {
        Queue<BiNode> queue = new LinkedList<BiNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BiNode node = queue.remove();
            System.out.print(node.value + " ");
            if (node.node1 != null) queue.add(node.node1);
            if (node.node2 != null) queue.add(node.node2);
        }
    }

    public void printPreOrder(BiNode node) {
        if (node == null) return;
        System.out.println(node.value);
        printPreOrder(node.node1);
        printPreOrder(node.node2);
    }

    public void printInOrder(BiNode node) {
        if (node == null) return;
        printInOrder(node.node1);
        System.out.println(node.value);
        printInOrder(node.node2);
    }

    public void printPostOrder(BiNode node) {
        if (node == null) return;
        printPostOrder(node.node1);
        printPostOrder(node.node2);
        System.out.println(node.value);
    }

    public void printPreOrder() { printPreOrder(root); }
    public void printInOrder() { printInOrder(root); }
    public void printPostOrder() { printPostOrder(root); }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(5);
        tree.add(4);
        tree.add(3);
        tree.add(2);
        tree.add(7);
        tree.add(6);
        tree.printPostOrder();
    }
}
