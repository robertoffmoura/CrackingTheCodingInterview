import java.util.HashSet;

/*
Write code to remove duplicates from an unsorted linked list.
FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?
*/

public class A {
    public static void deleteDups(LinkedList list) {
        //O(n) time, O(n) space
        HashSet<Integer> set = new HashSet<Integer>();
        LinkedList.Node trav = list.head;
        if (trav == null) return;
        set.add(trav.value);
        while (trav.next != null) {
            if (set.contains(trav.next.value)) {
                trav.next = trav.next.next;
            } else {
                set.add(trav.next.value);
                trav = trav.next;
            }
        }
    }

    public static void deleteDups2(LinkedList list) {
        //O(n^2) time, O(1) space
        LinkedList.Node current = list.head;
        LinkedList.Node runner;
        while (current != null) {
            runner = current;
            while (runner.next != null) {
                if (runner.next.value == current.value) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(4);
        list.addNode(3);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);
        list.printList();
        //Remove "static" from deleteDups declaration and you have to do the following:
        //A a = new A();
        //a.deleteDups(list);
        deleteDups2(list);
        list.printList();
    }
}
