public class LinkedList {
    public class Node {
        public Node next = null;
        public int value;
        public Node(int value) {
            this.value = value;
        }
    }
    public Node head;

    public void addNode(int value) {
        if (head == null) {
            head = new Node(value);
        } else {
            Node newNode = new Node(value);
            newNode.next = head;
            head = newNode;
        }
    }

    public void removeNode(int value) {
        if (head == null) return;
        if (head.value == value) {
            head = head.next;
            return;
        }
        Node trav = head;
        while (trav.next != null) {
            if (trav.next.value == value) {
                trav.next = trav.next.next;
                return;
            }
            trav = trav.next;
        }
        return;
    }

    public boolean find(int value) {
        Node trav = head;
        while(trav != null) {
            if (trav.value == value) {
                return true;
            }
            trav = trav.next;
        }
        return false;
    }

    public void printList() {
        Node trav = head;
        while (trav != null) {
            System.out.print(trav.value);
            trav = trav.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addNode(5);
        list.addNode(4);
        list.addNode(3);
        list.printList();
        list.removeNode(3);
        list.printList();
        list.addNode(3);
        list.printList();
        list.removeNode(4);
        list.printList();
        list.addNode(4);
        list.printList();
        list.removeNode(5);
        list.printList();
        list.addNode(5);
        list.printList();
        list.removeNode(4);
        list.printList();
        list.removeNode(3);
        list.printList();
        list.removeNode(5);
        list.printList();
        list.removeNode(1);
        list.printList();
        System.out.println(list.find(1) ? "True" : "False");
    }
}
