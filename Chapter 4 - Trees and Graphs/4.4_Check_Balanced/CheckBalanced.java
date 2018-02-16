import java.util.Queue;
import java.util.LinkedList;

/*
Implement a function to check if a binary tree is balanced. For the purposes of this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any node never differ by more than one.
*/

public class CheckBalanced {
    static public class Result {
        boolean value;
        int subTreeHeight;
        public Result(boolean value, int subTreeHeight) {
            this.value = value;
            this.subTreeHeight = subTreeHeight;
        }
    }

    static int abs(int x) {
        return x > 0 ? x : -x;
    }

    static boolean check(BinarySearchTree tree) {
        return check(tree.root, 0).value;
    }

    static Result check(BinarySearchTree.Node node, int height) {
        if (node == null) return new Result(true, height);
        Result leftResult = check(node.left, height + 1);
        if (leftResult.value == false) return leftResult;
        Result rightResult = check(node.right, height + 1);
        if (rightResult.value == false) return rightResult;
        if (abs(leftResult.subTreeHeight - rightResult.subTreeHeight) > 1) {
            return new Result(false, -1);
        }
        return leftResult.subTreeHeight > rightResult.subTreeHeight ? leftResult : rightResult;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(5);
        tree.add(4);
        tree.add(3);
        tree.add(2);
        tree.add(7);
        tree.add(6);
        tree.printPostOrder();
        System.out.println(check(tree));
        BinarySearchTree t = new BinarySearchTree();
        t.add(4);
        t.add(2);
        t.add(6);
        t.add(1);
        t.add(3);
        System.out.println(check(t));
    }
}
