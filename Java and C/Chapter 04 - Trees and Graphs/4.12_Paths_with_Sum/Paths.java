import java.util.HashMap;

/*
You are given a binary tree in which each node contains an integer value (which might be positive or negative). Design an algorithm to count the number of paths that sum to a given value. The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
*/

public class Paths {
    static int numberOfPathsWithSum(int sum, BinaryTree tree) {
        return numberOfPathsWithSumFromNode(sum, 0, tree.root);
    }

    static int numberOfPathsWithSumFromNode(int sum, int count, BinaryTree.Node node) {
        if (node == null) return 0;
        count += node.value;
        int result = count == sum ? 1 : 0;
        result += numberOfPathsWithSumFromNode(sum, count, node.left);
        result += numberOfPathsWithSumFromNode(sum, count, node.right);
        return result;
    }

    static int numberOfPathsWithSum2(int sum, BinaryTree tree) {
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        return numberOfPathsWithSum2(sum, 0, tree.root, hash);
    }

    static int numberOfPathsWithSum2(int sum, int count, BinaryTree.Node node, HashMap<Integer, Integer> hash) {
        if (node == null) return 0;

        int result = 0;
        count += node.value;
        if (hash.get(count) == null) {
            hash.put(count, 0);
        }
        hash.replace(count, hash.get(count) + 1);

        if (sum == count) result++;

        int searchedSum = count - sum;
        if (hash.containsKey(searchedSum)) result += hash.get(searchedSum);

        result += numberOfPathsWithSum2(sum, count, node.left, hash);
        result += numberOfPathsWithSum2(sum, count, node.right, hash);

        if (hash.get(count) == 0) hash.remove(count);
        else hash.replace(count, hash.get(count) - 1);

        return result;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = tree.createNode(5);
        tree.root.addLeft(4);
        tree.root.addRight(3);
        tree.root.right.addLeft(1);
        tree.root.left.addLeft(3);
        System.out.println(numberOfPathsWithSum2(9, tree));
    }
}
