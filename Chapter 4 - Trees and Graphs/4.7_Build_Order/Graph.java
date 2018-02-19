import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class Graph {
    public class Node {
        int value;
        ArrayList<Node> children;
        public Node(int value) {
            this.value = value;
            children = new ArrayList<Node>();
        }
        public void addChild(Node node) {
            children.add(node);
        }
    }

    ArrayList<Node> nodes = new ArrayList<Node>();

    Node addNode(int value) {
        Node node = new Node(value);
        nodes.add(node);
        return node;
    }

    void removeNode(Node node) {
        nodes.remove(node);
    }

    Node find(int value) {
        for (Node node : nodes) {
            if (node.value == value) {
                return node;
            }
        }
        return null;
    }

    HashSet<Node> visitedNodes = new HashSet<Node>();

    void depthFirstSearch() {
        depthFirstSearch(nodes.get(5));
    }

    void depthFirstSearch(Node node) {
        if (node == null) return;
        if (visitedNodes.contains(node)) return;
        visitedNodes.add(node);
        System.out.println(node.value);
        for (Node child : node.children) {
            depthFirstSearch(child);
        }
        //System.out.println(node.value);
    }

    void breadthFirstSearch() {
        breadthFirstSearch(nodes.get(5));
    }

    void breadthFirstSearch(Node node) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node r = queue.remove();
            if (visitedNodes.contains(r)) continue;
            visitedNodes.add(r);
            for (Node child : r.children) {
                if (child != null) {
                    queue.add(child);
                }
            }
            System.out.println(r.value);
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        Node node1 = g.addNode(1);
        Node node2 = g.addNode(2);
        Node node3 = g.addNode(3);
        Node node4 = g.addNode(4);
        Node node5 = g.addNode(5);
        Node node0 = g.addNode(0);
        node0.addChild(node1);
        node0.addChild(node4);
        //node0.addChild(node5);
        node1.addChild(node3);
        node1.addChild(node4);
        node2.addChild(node1);
        node3.addChild(node2);
        node3.addChild(node4);
        //g.depthFirstSearch();
    }
}
