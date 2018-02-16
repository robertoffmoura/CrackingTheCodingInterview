import java.util.Queue;
import java.util.LinkedList;

/*
Implement a function to check if a binary tree is a binary search tree.
*/

public class ValidateBST {
    boolean wrongValidate(BinarySearchTree tree) {
        return wrongValidate(tree.root);
    }

    boolean wrongValidate(BinarySearchTree.Node node) {
        if (node.left != null) {
            if (node.left.value > node.value) return false;
            boolean leftResult = wrongValidate(node.left);
            if (leftResult == false) return false;
        }
        if (node.right != null) {
            if (node.value >= node.right.value) return false;
            boolean rightResult = wrongValidate(node.right);
            if (rightResult == false) return false;
        }
        return true;
    }

    public class Result {
        boolean value;
        int min;
        int max;
        public Result(boolean value, int min, int max) {
            this.value = value;
            this.min = min;
            this.max = max;
        }
    }

    boolean validate(BinarySearchTree tree) {
        return validate(tree.root).value;
    }

    Result validate(BinarySearchTree.Node node) {
        if (node == null) {
            return new Result(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Result leftResult = validate(node.left);
        if (leftResult.value == false) return leftResult;
        if (leftResult.max > node.value) {
            leftResult.value = false;
            return leftResult;
        }
        Result rightResult = validate(node.right);
        if (rightResult.value == false) return rightResult;
        if (node.value >= rightResult.min) {
            rightResult.value = false;
            return rightResult;
        }
        return new Result(true, min(leftResult.min, node.value, rightResult.min), max(leftResult.max, node.value, rightResult.max));
    }

    int max(int a, int b, int c) { return max(max(a,b),c); }
    int min(int a, int b, int c) { return min(min(a,b),c); }
    int max(int a, int b) { return a > b ? a : b; }
    int min(int a, int b) { return a < b ? a : b; }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(5);
        tree.add(4);
        tree.add(3);
        tree.add(2);
        tree.add(7);
        tree.add(6);
        tree.printPostOrder();
        ValidateBST v = new ValidateBST();
        System.out.println(v.validate(tree));
        BinarySearchTree tree2 = new BinarySearchTree();
        tree2.root = tree2.createNode(4);
        tree2.root.left = tree2.createNode(2);
        tree2.root.left.right = tree2.createNode(3);
        tree2.root.right = tree2.createNode(5);
        tree2.root.right.left = tree2.createNode(5);
        System.out.println(v.validate(tree2));

    }
}
