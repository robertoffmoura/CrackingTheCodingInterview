import java.util.EmptyStackException;

public class Stack {
    public class Node {
        public Node next = null;
        public int value;
        public Node(int value) {
            this.value = value;
        }
    }
    public Node head;

    public void push(int value) {
        if (head == null) {
            head = new Node(value);
        } else {
            Node newNode = new Node(value);
            newNode.next = head;
            head = newNode;
        }
    }

    public int pop() {
        if (head == null) {
            throw new EmptyStackException();
        }
        Node oldNode = head;
        head = head.next;
        return oldNode.value;
    }

    public int peek() {
        if (head == null) {
            throw new EmptyStackException();
        }
        return head.value;
    }

    public static void main(String[] args) {
        Stack list = new Stack();
        list.push(5);
        list.push(4);
        list.push(3);
        for (int i=0; i<3; i++) {
            System.out.println(list.pop());
        }
    }
}
