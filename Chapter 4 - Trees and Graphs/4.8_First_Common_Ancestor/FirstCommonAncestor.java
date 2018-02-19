/*
Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not necessarily a binary search tree.
*/

public class FirstCommonAncestor {
    public static class Result {
        BinaryTree.Node node;
        boolean hasA;
        boolean hasB;
        public Result(BinaryTree.Node node, boolean hasA, boolean hasB) {
            this.node = node;
            this.hasA = hasA;
            this.hasB = hasB;
        }
    }

    static BinaryTree.Node fca(BinaryTree tree, BinaryTree.Node a, BinaryTree.Node b) {
        return fca(tree.root, a, b).node;
    }

    static Result fca(BinaryTree.Node node, BinaryTree.Node a, BinaryTree.Node b) {
        if (node == null) return new Result(null, false, false);
        Result l = fca(node.left, a, b);
        Result r = fca(node.right, a, b);
        if (l.node != null) return l;
        if (r.node != null) return r;
        if ((l.hasA && r.hasB) ||
            (l.hasB && r.hasA) ||
            (l.hasA && node == b) ||
            (l.hasB && node == a) ||
            (node == a && r.hasB) ||
            (node == b && r.hasA)) {
            return new Result(node, true, true);
        }
        return new Result(null, (l.hasA || r.hasA || node == a), (l.hasB || r.hasB || node == b));
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        BinaryTree.Node a, b;
        tree.root = tree.createNode(5);
        tree.root.addLeft(4);
        tree.root.addRight(6);
        tree.root.left.addLeft(7);
        a = tree.root.left.addRight(8);
        b = tree.root.left.left.addLeft(9);

        System.out.println("fca: " + fca(tree, a, b).value);
    }
}
