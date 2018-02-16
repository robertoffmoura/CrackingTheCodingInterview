import java.util.Queue;
import java.util.LinkedList;

/*
Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
*/

public class ListOfDepths {
    LinkedList<BinaryTree.Node>[] list = new LinkedList[10];
    BinaryTree.Node root;
    public ListOfDepths(BinaryTree tree) {
        root = tree.root;
    }

    void createListOfDepths() {
        createListOfDepths(root, 0);
    }

    void createListOfDepths(BinaryTree.Node node, int depth) {
        if (node == null) return;
        if (list[depth] == null) list[depth] = new LinkedList<BinaryTree.Node>();
        list[depth].add(node);
        depth++;
        createListOfDepths(node.left, depth);
        createListOfDepths(node.right, depth);
    }

    void createListOfDepths2() {
        int i = 0;
        list[0] = new LinkedList<BinaryTree.Node>();
        list[0].add(root);
        while (list[i].size() > 0) {
            list[i+1] = new LinkedList<BinaryTree.Node>();
            for (BinaryTree.Node node : list[i]) {
                if (node.left != null) list[i+1].add(node.left);
                if (node.right != null) list[i+1].add(node.right);
            }
            i++;
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.add(5);
        tree.add(4);
        tree.add(3);
        tree.add(2);
        tree.add(7);
        tree.add(6);
        tree.printBreadthFirst();
        ListOfDepths problem = new ListOfDepths(tree);
        problem.createListOfDepths2();
        System.out.println("");
        for (int i=0; i<problem.list.length; i++) {
            if (problem.list[i] == null) return;
            for (BinaryTree.Node node : problem.list[i]) {
                if (node == null) continue;
                System.out.println(node.value);
            }
            System.out.println("");
        }
    }
}
