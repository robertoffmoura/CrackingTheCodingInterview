import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

public class Graph {
    public class Node {
        int value;
        Node[] children;
        int index;
        public Node(int value) {
            this.value = value;
            children = new Node[16];
            index = 0;
        }
    }

    Node[] nodes = new Node[16];
    int index = 0;
    HashSet<Node> visitedNodes = new HashSet<Node>();

    void addNode(int value) {
        nodes[index] = new Node(value);
        index++;
    }

    void depthFirstSearch() {
        depthFirstSearch(nodes[5]);
    }

    void depthFirstSearch(Node node) {
        if (node == null) return;
        if (visitedNodes.contains(node)) return;
        visitedNodes.add(node);
        System.out.println(node.value);
        for (int i=0; i<node.children.length; i++) {
            depthFirstSearch(node.children[i]);
        }
        //System.out.println(node.value);
    }

    void breadthFirstSearch() {
        breadthFirstSearch(nodes[5]);
    }

    void breadthFirstSearch(Node node) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node r = queue.remove();
            if (visitedNodes.contains(r)) continue;
            visitedNodes.add(r);
            for (int i=0; i<r.children.length; i++) {
                if (r.children[i] != null) {
                    queue.add(r.children[i]);
                }
            }
            System.out.println(r.value);
        }
    }

    boolean aFindsB(Node a, Node b) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(a);
        while (!queue.isEmpty()) {
            Node r = queue.remove();
            if (visitedNodes.contains(r)) continue;
            visitedNodes.add(r);
            for (int i=0; i<r.children.length; i++) {
                if (r.children[i] != null) {
                    queue.add(r.children[i]);
                }
            }
            if (r == b) return true;
        }
        return false;
    }

    boolean areConnected(Node a, Node b) {
        return aFindsB(a, b) || aFindsB(b, a);
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addNode(1);
        g.addNode(2);
        g.addNode(3);
        g.addNode(4);
        g.addNode(5);
        g.addNode(0);
        g.nodes[5].children[0] = g.nodes[0];
        g.nodes[5].children[1] = g.nodes[3];
        //g.nodes[5].children[2] = g.nodes[4];
        g.nodes[0].children[0] = g.nodes[2];
        g.nodes[0].children[1] = g.nodes[3];
        g.nodes[1].children[0] = g.nodes[0];
        g.nodes[2].children[0] = g.nodes[1];
        g.nodes[2].children[1] = g.nodes[3];
        //g.depthFirstSearch();
        System.out.println(g.aFindsB(g.nodes[5], g.nodes[4]));
    }
}
