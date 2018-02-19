import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Iterator;

public class BSTSequences {
    public static void printSequences(BinarySearchTree tree) {
        Queue<BinarySearchTree.Node> queue = new LinkedList<BinarySearchTree.Node>();
        ArrayList<Integer> array = new ArrayList<Integer>();
        queue.add(tree.root);
        printSequences(tree.root, array, queue);
    }

    public static void printSequences(BinarySearchTree.Node node, ArrayList<Integer> array, Queue<BinarySearchTree.Node> queue) {
        int n = queue.size();
        for (int i=0; i<n; i++) {
            BinarySearchTree.Node next = queue.remove();
            array.add(next.value);
            if (next.left != null) queue.add(next.left);
            if (next.right != null) queue.add(next.right);
            printSequences(next, array, queue);
            array.remove(array.size()-1);
            queue.add(next);
        }

        if (queue.size() == 0) {
            for (Integer i : array) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }
    /*
    ArrayList<ArrayList<BinarySearchTree.Node>> sequences(BinarySearchTree.Node node) {
        if (node == null) return new ArrayList<ArrayList<BinarySearchTree.Node>>();
        ArrayList<ArrayList<BinarySearchTree.Node>> leftList = squences(node.left);
        ArrayList<ArrayList<BinarySearchTree.Node>> rightList = sequences(node.right);
        ArrayList<ArrayList<BinarySearchTree.Node>> list = new <ArrayList<ArrayList<BinarySearchTree.Node>>();
        return list;
    }
    */

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(4);
        tree.add(2);
        tree.add(6);
        //tree.add(8);
        //tree.add(5);
        printSequences(tree);
    }
}
