import java.util.Queue;
import java.util.LinkedList;

/*
Given a sorted (increasing order) array with unique integer elements, write an algo­rithm to create a binary search tree with minimal height.
*/

public class MinimalTree extends BinaryTree {
    void createMinimalTree2(int[] array) {
        addToTree(array, 0, array.length-1);
    }

    void addToTree(int[] array, int start, int end) {
        //O(n log(n))
        if (start > end) return;
        int mid = (start+end)/2;
        add(array[mid]);
        addToTree(array, start, mid-1);
        addToTree(array, mid+1, end);
    }

    void createMinimalTree(int[] array) {
        root = createMinimalTree(array, 0, array.length - 1);
    }

    Node createMinimalTree(int[] array, int start, int end) {
        //O(n)
        if (start > end) return null;
        int mid = (start+end)/2;
        Node node = createNode(array[mid]);
        node.left = createMinimalTree(array, start, mid - 1);
        node.right = createMinimalTree(array, mid + 1, end);
        return node;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        MinimalTree tree = new MinimalTree();
        tree.createMinimalTree(array);
        //tree.createMinimalTree2(array);
        tree.printBreadthFirst();
    }
}
