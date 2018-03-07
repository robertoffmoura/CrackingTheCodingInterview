/*
T1 and T2 are two very large binary trees, with T1 much bigger than T2. Create an algorithm to determine if T2 is a subtree of T1.
A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to T2. That is, if you cut off the tree at node n, the two trees would be identical.
*/

public class CheckSubTree {
    static boolean checkTreeEquality(BinaryTree.Node node1, BinaryTree.Node node2) {
        if ((node1 == null) != (node2 == null)) return false;
        if (node1 == null) return true;
        return node1.value == node2.value && checkTreeEquality(node1.left, node2.left) && checkTreeEquality(node1.right, node2.right);
    }

    static boolean checkIfSubTree(BinaryTree t1, BinaryTree t2) {
        return checkIfSubTree(t1.root, t2.root);
    }

    static boolean checkIfSubTree(BinaryTree.Node node1, BinaryTree.Node node2) {
        if (node1 == null || node2 == null) return false;
        return checkTreeEquality(node1, node2) || checkIfSubTree(node1.left, node2) || checkIfSubTree(node1.right, node2);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = tree.createNode(5);
        tree.root.addLeft(4);
        tree.root.addRight(3);
        tree.root.right.addLeft(1);
        tree.root.left.addLeft(3);
        BinaryTree tree2 = new BinaryTree();
        tree2.root = tree2.createNode(2);
        tree2.root.addLeft(5);
        tree2.root.left.addLeft(4);
        tree2.root.left.addRight(3);
        tree2.root.left.right.addLeft(1);
        tree2.root.left.left.addLeft(3);
        System.out.println(checkIfSubTree(tree2, tree));
    }
}
