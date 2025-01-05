/*
Consider a simple data structure called BiNode, which has pointers to two other nodes.
public class Binode {
    public BiNode node1, node2;
    public int data;
}
The data structure BiNode could be used to represent both a binary tree (where node1 is the left node and node2 is the right node) or a doubly linked list (where node1 is the previous node and node2 is the next node). Implement a method to convert a binary search tree (implemented with BiNode) into a doubly linked list. The values should be kept in order and the operation should be performed in place (that is, on the original data structure).
*/

public class Converter {
    static class Result {
        BinarySearchTree.BiNode start, end;
        public Result(BinarySearchTree.BiNode start, BinarySearchTree.BiNode end) {
            this.start = start;
            this.end = end;
        }
    }

    static Result convert(BinarySearchTree.BiNode root) {
        if (root == null) return new Result(null, null);

        Result left = convert(root.node1);
        BinarySearchTree.BiNode leftEnd = left.end;
        if (leftEnd != null) {
            leftEnd.node2 = root;
            root.node1 = leftEnd;
        }

        Result right = convert(root.node2);
        BinarySearchTree.BiNode rightStart = right.start;
        if (rightStart != null) {
            rightStart.node1 = root;
            root.node2 = rightStart;
        }

        return new Result(left.start != null ? left.start : root,
                            right.end != null ? right.end : root);
    }


    static void printList(BinarySearchTree.BiNode start) {
        System.out.print(start.value);
        if (start.node2 != null) {
            System.out.print(" <-> ");
            printList(start.node2);
        } else {
            System.out.print("\n");
        }
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
        BinarySearchTree.BiNode start = convert(tree.root).start;
        printList(start);
    }
}
