/*
Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node, not necessarily the exact middle) of a singly linked list, given only access to that node.
EXAMPLE
lnput: the node c from the linked list a->b->c->d->e->f
Result: nothing is returned, but the new linked list looks like a->b->d->e->f
*/

public class A {
    public static void deleteCurrentNode(LinkedList.Node node) {
        if (node == null || node.next == null) return;
        LinkedList.Node next = node.next;
        node.value = next.value;
        node.next = next.next;
        return;
    }
    public static void main(String[] args) {

    }
}
