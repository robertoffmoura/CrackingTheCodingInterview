import java.util.HashSet;

/*
Given a circular linked list, implement an algorithm that returns the node at the
beginning of the loop.
DEFINITION
Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so as to make a loop in the linked list.
EXAMPLE
Input: A -> B -> C -> D -> E -> C [the same C as earlier]
Output: C
*/

public class A {
    public static LinkedList.Node intersection(LinkedList list) {
        //O(n^2) time, O(1) space
        LinkedList.Node current = list.head.next;
        LinkedList.Node node;
        int i = 0;
        while (current != null) {
            node = list.head;
            for (int j=0; j<i; j++) {
                if (node == current) {
                    return node;
                }
                node = node.next;
            }
            i++;
            current = current.next;
        }
        return null;
    }

    public static LinkedList.Node intersection2(LinkedList list) {
        //O(n) time, O(n) space
        HashSet<LinkedList.Node> set = new HashSet<LinkedList.Node>();
        LinkedList.Node trav = list.head;
        while (trav != null) {
            if (set.contains(trav)) {
                return trav;
            } else {
                set.add(trav);
            }
            trav = trav.next;
        }
        return null;
    }

    public static LinkedList.Node intersection3(LinkedList list) {
        //O(n) time, O(1) space
        LinkedList.Node fast = list.head;
        LinkedList.Node slow = fast;
        slow = slow.next;
        fast = fast.next.next;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = list.head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);
        list.head.next.next.next.next.next = list.head.next.next;
        System.out.println(intersection3(list).value);
    }
}
