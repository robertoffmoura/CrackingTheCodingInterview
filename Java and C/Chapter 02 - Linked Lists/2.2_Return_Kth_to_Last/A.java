import java.util.Scanner;

/*
Implement an algorithm to find the kth to last element of a singly linked list.
*/

public class A {
    static LinkedList.Node kthNode(LinkedList list, int k) {
        int length = 1;
        LinkedList.Node head = list.head;
        LinkedList.Node trav = head;
        while (trav.next != null) {
            length++;
            trav = trav.next;
        }
        trav = head;
        for (int i=0; i<length-k; i++) {
            trav = trav.next;
        }
        return trav;
    }

    static LinkedList.Node kthNode2(LinkedList list, int k) {
        LinkedList.Node first = list.head;
        LinkedList.Node second = first;
        for (int i=0; i<k; i++) {
            if (first == null) return null;
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }

    public static void main (String[] args) {
        LinkedList list = new LinkedList();
        list.addNode(1);
        list.addNode(3);
        list.addNode(8);
        list.addNode(3);
        list.addNode(7);
        list.addNode(6);
        list.addNode(1);
        list.addNode(7);
        list.addNode(5);
        list.addNode(1);
        list.addNode(3);
        list.printList();
        Scanner reader = new Scanner(System.in);
        int k = reader.nextInt();
        reader.close();
        System.out.println(kthNode2(list, k).value);
    }
}
