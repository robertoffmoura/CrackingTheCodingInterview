public class Paths {
    static int numberOfPathsWithSum(int sum, BinaryTree tree) {
        return numberOfPathsWithSum(sum, 0, tree.root);
    }

    static int numberOfPathsWithSum(int sum, int count, BinaryTree.Node node) {
        if (node == null) return 0;
        count += node.value;
        int result = count == sum ? 1 : 0;
        result += numberOfPathsWithSum(sum, count, node.left);
        result += numberOfPathsWithSum(sum, count, node.right);
        return result;
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = tree.createNode(5);
        tree.root.addLeft(4);
        tree.root.addRight(3);
        tree.root.right.addLeft(1);
        tree.root.left.addLeft(3);
        System.out.println(numberOfPathsWithSum(9, tree));
    }
}
