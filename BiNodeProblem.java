public class BiNodeProblem {
    public static class BiNode {
        public BiNode b1, b2;
        public int data;
        public BiNode(int data) {
            this.data = data;
        }
    }

    static void inOrderPrint(BiNode node) {
        if (node == null) return;
        inOrderPrint(node.b1);
        System.out.println(node.data);
        inOrderPrint(node.b2);
    }

    static void convert(BiNode node) {
        
    }

    public static void main(String[] args) {
        BiNode binode1 = new BiNode(6);
        binode1.b1 = new BiNode(3);
        binode1.b2 = new BiNode(9);
        binode1.b1.b1 = new Binode(1);
        binode1.b1.b2 = new Binode(5);
        binode1.b2.b2 = new Binode(14);
        binode1.b2.b2.b1 = new Binode(12);
        binode1.b2.b2.b1.b1 = new Binode(10);
        binode1.b2.b2.b1.b2 = new Binode(13);
    }
}
