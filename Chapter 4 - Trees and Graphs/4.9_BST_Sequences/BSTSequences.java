import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

/*
A binary search tree was created by traversing through an array from left to right and inserting each element. Given a binary search tree with distinct elements, print all possible arrays that could have led to this tree.
*/

public class BSTSequences {
    public static void printSequences(BinarySearchTree tree) {
        Queue<BinarySearchTree.Node> queue = new LinkedList<BinarySearchTree.Node>();
        ArrayList<BinarySearchTree.Node> array = new ArrayList<BinarySearchTree.Node>();
        printSequences(tree.root, array, queue);
    }

    public static void printSequences(BinarySearchTree.Node node, ArrayList<BinarySearchTree.Node> array, Queue<BinarySearchTree.Node> queue) {
        array.add(node);
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
        for (int i=0; i<queue.size(); i++) {
            BinarySearchTree.Node next = queue.remove();
            Queue<BinarySearchTree.Node> newQueue = new LinkedList<BinarySearchTree.Node>(queue);
            printSequences(next, array, newQueue);
            queue.add(next);
        }
        if (queue.size() == 0) printArray(array);
        array.remove(array.size()-1);
    }

    public static void printArray(ArrayList<BinarySearchTree.Node> array) {
        for (BinarySearchTree.Node item : array) {
            System.out.print(item.value + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(4);
        tree.add(2);
        tree.add(6);
        //tree.add(0);
        //tree.add(3);
        tree.add(8);
        printSequences(tree);
    }
}
