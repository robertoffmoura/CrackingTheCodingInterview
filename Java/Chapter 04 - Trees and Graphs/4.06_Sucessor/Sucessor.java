/*
Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a binary search tree. You may assume that each node has a link to its parent.
*/

public class Sucessor {
    static BinarySearchTree.Node next(BinarySearchTree.Node node) {
        if (node.right == null) {
            BinarySearchTree.Node trav = node.parent;
            while (trav != null && trav.value < node.value) {
                trav = trav.parent;
            }
            return trav;
        }
        node = node.right;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        BinarySearchTree.Node node = tree.add(5);
        tree.add(2);
        tree.add(0);
        tree.add(-2);
        tree.add(7);
        tree.add(6);
        tree.add(1);
        tree.printBreadthFirst();
        System.out.println(next(node).value);
    }
}
