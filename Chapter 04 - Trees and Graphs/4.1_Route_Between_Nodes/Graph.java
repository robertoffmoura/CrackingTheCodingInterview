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

    public Node[] nodes = new Node[16];
    public int index = 0;

    public void addNode(int value) {
        nodes[index] = new Node(value);
        index++;
    }

    public static void main(String[] args) {
    }
}
