import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class BabyNames2 {// Book's solution. Time complexity: O(B + P), where B is the number of names and P is the number of connections
    static HashMap<String, Node> nodes = new HashMap<String, Node>();
    static Scanner sc = new Scanner(System.in);

    static class Node {
        ArrayList<Node> children;
        String name;
        int frequency;
        boolean visited;

        public Node(String name, int frequency) {
            children = new ArrayList<Node>();
            visited = false;
            this.name = name;
            this.frequency = frequency;
            nodes.put(name, this);
        }

        public int countFrequency() {
            if (visited) return 0;
            visited = true;
            int result = frequency;
            for (Node child : children) {
                result += child.countFrequency();
            }
            return result;
        }
    }

    public static void readFrequencies() {
        int n = sc.nextInt();
        for (int i=0; i<n; i++) {
            String name = sc.next();
            int frequency = sc.nextInt();
            Node node = new Node(name, frequency);
        }
    }

    public static void readConnections() {
        int n = sc.nextInt();
        for (int i=0; i<n; i++) {
            String name1 = sc.next();
            String name2 = sc.next();
            Node node1 = nodes.get(name1);
            Node node2 = nodes.get(name2);
            if (node1 == null) node1 = new Node(name1, 0);
            if (node2 == null) node2 = new Node(name2, 0);
            node1.children.add(node2);
            node2.children.add(node1);
        }
    }

    public static HashMap getRealFrequencies() {
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        for (HashMap.Entry<String, Node> entry : nodes.entrySet()) {
            String name = entry.getKey();
            Node node = entry.getValue();
            int frequency = node.countFrequency();
            if (frequency == 0) continue;
            result.put(name, frequency);
        }
        return result;
    }

    public static void main(String[] args) {
        readFrequencies();
        readConnections();
        HashMap<String, Integer> realFrequencies = getRealFrequencies();

        for (HashMap.Entry<String, Integer> entry : realFrequencies.entrySet()) {
            String name = entry.getKey();
            int frequency = entry.getValue();
            System.out.print(name + " (" + frequency + "), ");
        }
        System.out.print("\n");
    }
}
