import java.util.Stack;

/*
In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of different sizes which can slide onto any tower. The puzzle starts with disks sorted in ascending order of size from top to bottom (i.e., each disk sits on top of an even larger one). You have the following constraints:
(1) Only one disk can be moved at a time.
(2) A disk is slid off the top of one tower onto another tower.
(3) A disk cannot be placed on top of a smaller disk.
Write a program to move the disks from the first tower to the last using stacks.
*/

public class TowersOfHanoi {
    Stack<Integer> stack = new Stack<Integer>();
    static Stack<Integer>[] tower = new Stack[3];

    static void moveDisks(int source, int destination, int size) {
        if (size == 1) {
            tower[destination].push(tower[source].pop());
            return;
        }
        int freeSpace = 0;
        while (freeSpace == source || freeSpace == destination) freeSpace++;
        moveDisks(source, freeSpace, size-1);
        tower[destination].push(tower[source].pop());
        moveDisks(freeSpace, destination, size-1);
        return;
    }

    static void printStack(Stack<Integer> stack) {
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String[] args) {
        int n = 5;
        for (int i=0; i<3; i++) {
            tower[i] = new Stack<Integer>();
        }
        for (int i=0; i<n; i++) {
            tower[0].push(n-i);
        }
        moveDisks(0, 2, n);
        for (int i=0; i<3; i++) {
            System.out.print("Tower " + (i + 1) + ") ");
            printStack(tower[i]);
            System.out.println("");
        }
    }
}
