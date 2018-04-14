/*
Given two (singly) linked lists, determine if the two lists intersect. Return the inter­secting node. Note that the intersection is defined based on reference, not value. That is, if the kth node of the first linked list is the exact same node (by reference) as the jth node of the second linked list, then they are intersecting.
*/

public class A {
    public static LinkedList.Node intersection(LinkedList list1, LinkedList list2) {
        int len1 = getLength(list1);
        int len2 = getLength(list2);
        LinkedList.Node smallNode = (len1 < len2 ? list1.head : list2.head);
        LinkedList.Node largeNode = (len1 < len2 ? list2.head : list1.head);
        for (int i=0; i<abs(len1-len2); i++) {
            largeNode = largeNode.next;
        }
        while (largeNode != null) {
            if (largeNode == smallNode) {
                return largeNode;
            }
            largeNode = largeNode.next;
            smallNode = smallNode.next;
        }
        return null;
    }

    public static int abs(int x) {
        return x > 0 ? x : -x;
    }

    public static int getLength(LinkedList list) {
        LinkedList.Node node = list.head;
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.addNode(1);
        list1.addNode(2);
        list1.addNode(4);
        list1.addNode(5);
        LinkedList list2 = new LinkedList();
        list2.addNode(3);
        list2.head.next = list1.head.next.next;
        list1.printList();
        list2.printList();
        System.out.println(intersection(list1, list2).value);
    }
}
