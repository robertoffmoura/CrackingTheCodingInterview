import java.util.Stack;

/*
Write a program to sort a stack such that the smallest items are on the top. You can use an additional temporary stack, but you may not copy the elements into any other data structure (such as an array). The stack supports the following operations: push, pop, peek, and isEmpty.
*/

public class SortStack {
    static int getSize(Stack<Integer> stack) {
        Stack<Integer> helperStack = new Stack<Integer>();
        int result = 0;
        while (!stack.isEmpty()) {
            helperStack.push(stack.pop());
            result++;
        }
        while (!helperStack.isEmpty()) {
            stack.push(helperStack.pop());
        }
        return result;
    }

    static void sort(Stack<Integer> stack) {
        Stack<Integer> helperStack = new Stack<Integer>();
        int size = getSize(stack);
        int min;
        while (size > 0) {
            min = stack.pop();
            size--;
            for (int i=0; i<size; i++) {
                int value = stack.pop();
                if (value < min) {
                    helperStack.push(min);
                    min = value;
                } else {
                    helperStack.push(value);
                }
            }
            stack.push(min);
            while (!helperStack.isEmpty()) {
                stack.push(helperStack.pop());
            }
        }
    }

    static void sort2(Stack<Integer> stack) {
        Stack<Integer> helperStack = new Stack<Integer>();
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            while (!helperStack.isEmpty() && helperStack.peek() > temp) {
                stack.push(helperStack.pop());
            }
            helperStack.push(temp);
        }
        while(!helperStack.isEmpty()) {
            stack.push(helperStack.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(2);
        s.push(5);
        s.push(4);
        s.push(6);
        s.push(3);
        s.push(1);
        sort2(s);
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
