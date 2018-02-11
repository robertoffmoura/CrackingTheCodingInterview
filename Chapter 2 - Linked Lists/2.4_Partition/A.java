/*
Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x. If x is contained within the list, the values of x only need to be after the elements less than x (see below). The partition element x can appear anywhere in the "right partition"; it does not need to appear between the left and right partitions.
EXAMPLE
Input:  3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition=5]
Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
*/

public class A {
    public static void partition(LinkedList list, int x) {
        LinkedList.Node trav = list.head;
        LinkedList.Node head = trav;
        LinkedList.Node tail = trav;
        LinkedList.Node next;

        while (trav != null) {
            next = trav.next;
            if (trav.value < x) {
                trav.next = head;
                head = trav;
            } else {
                tail.next = trav;
                tail = trav;
            }
            trav = next;
        }
        tail.next = null;
        list.head = head;
        return;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addNode(1);
        list.addNode(0);
        list.addNode(9);
        list.addNode(8);
        list.addNode(1);
        list.addNode(7);
        list.addNode(6);
        list.addNode(5);
        list.addNode(3);
        list.printList();
        partition(list,7);
        list.printList();
    }
}
