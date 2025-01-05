import java.util.Stack;

/*
Implement a MyQueue class which implements a queue using two stacks.
*/

public class MyQueue {
    Stack<Integer> mainStack = new Stack<Integer>();
    Stack<Integer> secondaryStack = new Stack<Integer>();

    void push(int value) {
        mainStack.push(value);
    }

    int pop() {
        while (!mainStack.isEmpty()) {
            secondaryStack.push(mainStack.pop());
        }
        int value = secondaryStack.pop();
        while (!secondaryStack.isEmpty()) {
            mainStack.push(secondaryStack.pop());
        }
        return value;
    }

    int pop2() {
        if (secondaryStack.isEmpty()) {
            while (!mainStack.isEmpty()) {
                secondaryStack.push(mainStack.pop());
            }
        }
        return secondaryStack.pop();
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        q.push(3);
        for (int i=0; i<3; i++) {
            System.out.println(q.pop2());
        }
    }
}
