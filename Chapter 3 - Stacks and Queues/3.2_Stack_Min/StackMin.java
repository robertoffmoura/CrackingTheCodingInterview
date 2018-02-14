import java.util.EmptyStackException;
import java.util.Stack;

/*
How would you design a stack which, in addition to push and pop, has a function min which returns the minimum element? Push, pop and min should all operate in 0(1) time.
*/

public class StackMin {
    public class Node {
        public Node next = null;
        public int value;
        public Node(int value) {
            this.value = value;
        }
    }
    public Node head;
    public Stack<Integer> minimunStack = new Stack<Integer>();

    public void push(int value) {
        if (head == null) {
            head = new Node(value);
            minimunStack.push(value);
        } else {
            Node newNode = new Node(value);
            newNode.next = head;
            head = newNode;
            if (newNode.value <= getMin()) {
                minimunStack.push(value);
            }
        }
    }

    public int pop() {
        if (head == null) {
            throw new EmptyStackException();
        }
        Node oldNode = head;
        head = head.next;
        if (oldNode.value == getMin()) {
            minimunStack.pop();
        }
        return oldNode.value;
    }

    public int getMin() {
        return minimunStack.peek();
    }

    public int peek() {
        if (head == null) {
            throw new EmptyStackException();
        }
        return head.value;
    }

    public static void main(String[] args) {
        StackMin list = new StackMin();
        list.push(5);
        System.out.println("min = " + list.getMin());
        list.push(4);
        System.out.println("min = " + list.getMin());
        list.push(3);
        System.out.println("min = " + list.getMin());
        list.push(7);
        System.out.println("min = " + list.getMin());
        for (int i=0; i<3; i++) {
            System.out.print("pop = " + list.pop());
            System.out.println(", min = " + list.getMin());
        }
    }
}
