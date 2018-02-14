import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.EmptyStackException;

/*
Imagine a (literal) stack of plates. If the stack gets too high, it might topple. Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold. Implement a data structure SetOfStacks that mimics this. SetOfStacks should be composed of several stacks and should create a new stack once the previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack (that is, pop() should return the same values as it would if there were just a single stack).
FOLLOW UP
Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
*/

public class StackOfPlates {
    List<Stack<Integer>> listOfStacks = new ArrayList<Stack<Integer>>();
    int listIndex = 0;
    int maxListSize;
    int stackSize[];
    int maxStackSize;
    public StackOfPlates(int maxListSize, int maxStackSize) {
        this.maxStackSize = maxStackSize;
        this.maxListSize = maxListSize;
        stackSize = new int[maxListSize];
        for (int i=0; i<maxStackSize; i++) {
            stackSize[i] = 0;
        }
        listOfStacks.add(new Stack<Integer>());
    }

    void push(int value) {
        if (stackSize[listIndex] == maxStackSize) {
            if (listIndex == maxListSize - 1) {
                //System.out.println("Error: List of Stacks is full");
                return;
            }
            listIndex++;
            //System.out.println("Creating new Stack");
            listOfStacks.add(new Stack<Integer>());
        }
        //System.out.println("Adding " + value + " to list of stacks");
        listOfStacks.get(listIndex).push(value);
        stackSize[listIndex]++;
    }

    int pop() {
        if (stackSize[listIndex] == 0) {
            if (listIndex == 0) {
                throw new EmptyStackException();
            }
            //System.out.println("Deleting Stack");
            listOfStacks.remove(listIndex);
            listIndex--;
        }
        stackSize[listIndex]--;
        //System.out.println("removing " + listOfStacks.get(listIndex).peek() + " from list of stacks");
        return listOfStacks.get(listIndex).pop();
    }

    public static void main(String[] args) {
        StackOfPlates s = new StackOfPlates(3, 3);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(7);
        s.push(8);
        s.push(9);
        s.push(10);
        s.push(11);
        s.push(12);
        s.pop();
        s.pop();
        s.pop();
        s.pop();
        s.pop();
        s.pop();
        s.pop();
        s.pop();
        s.pop();

    }
}
