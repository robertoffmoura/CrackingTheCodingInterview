import java.util.Scanner;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

/*
You are given a list of projects and a list of dependencies (which is a list of pairs of projects, where the second project is dependent on the first project). All of a project's dependencies must be built before the project is. Find a build order that will allow the projects to be built. If there is no valid build order, return an error.
EXAMPLE
Input:
projects: a, b, c, d, e, f
dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
Output: f, e, a, b, d, c
*/

public class BuildOrder {
    public static ArrayList<Graph.Node> order = new ArrayList<Graph.Node>();

    public static void removeRoots(Graph graph) {
        HashSet<Graph.Node> roots = new HashSet<Graph.Node>();
        for (Graph.Node node : graph.nodes) {
            roots.add(node);
        }
        for (Graph.Node node : graph.nodes) {
            Queue<Graph.Node> queue = new LinkedList<Graph.Node>();
            queue.add(node);
            while (!queue.isEmpty()) {
                Graph.Node n = queue.remove();
                if (n != node) roots.remove(n);
                for (Graph.Node child : n.children) {
                    if (child != null) queue.add(child);
                }
            }
        }
        for (Graph.Node node : roots) {
            order.add(node);
            graph.removeNode(node);
        }
    }

    public static Graph scanGraph() {
        Graph graph = new Graph();
        Scanner scanner = new Scanner(System.in);
        int n;
        n = scanner.nextInt();
        for (int i=0; i <n; i++) {
            graph.addNode(scanner.nextInt());
        }
        n = scanner.nextInt();
        for (int i=0; i<n; i++) {
            Graph.Node a = graph.find(scanner.nextInt());
            Graph.Node b = graph.find(scanner.nextInt());
            a.addChild(b);
        }
        return graph;
    }

    public static void main(String[] args) {
        Graph graph = scanGraph();

        while (graph.nodes.size() > 0) {
            int n = graph.nodes.size();
            removeRoots(graph);
            if (n == graph.nodes.size()) {
                System.out.println("error");
                return;
            }
        }

        for (Graph.Node node : order) {
            System.out.print(node.value + " ");
        }
        System.out.println("");

    }
}
