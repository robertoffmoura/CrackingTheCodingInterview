import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

/*
Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
*/

public class RouteBetweenNodes {
    HashSet<Graph.Node> visitedNodes = new HashSet<Graph.Node>();

    boolean aFindsB(Graph.Node a, Graph.Node b) {
        //Breadth First Search
        Queue<Graph.Node> queue = new LinkedList<Graph.Node>();
        queue.add(a);
        while (!queue.isEmpty()) {
            Graph.Node r = queue.remove();
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

    boolean areConnected(Graph.Node a, Graph.Node b) {
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
        RouteBetweenNodes r = new RouteBetweenNodes();
        System.out.println(r.aFindsB(g.nodes[5], g.nodes[4]));
    }
}
