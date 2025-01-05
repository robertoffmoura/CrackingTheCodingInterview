/*
Implement a function to check if a linked list is a palindrome.
*/

public class A {
    public static boolean isPalindrome(LinkedList list) {
        Stack stack = new Stack();
        LinkedList.Node fastPointer = list.head;
        LinkedList.Node slowPointer = list.head;
        while (fastPointer != null && fastPointer.next != null) {
            stack.push(slowPointer.value);
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        if (fastPointer != null) {//odd size
            slowPointer = slowPointer.next;
        }
        while (slowPointer != null) {
            if (stack.pop() != slowPointer.value) {
                return false;
            }
            slowPointer = slowPointer.next;
        }
        return true;
    }

    public static class Result {
        LinkedList.Node node;
        boolean value;
        public Result(LinkedList.Node node, boolean value) {
            this.node = node;
            this.value = value;
        }
    }

    public static Result search(LinkedList.Node node, int length) {
        if (length == 1) {
            return new Result(node.next, true);
        }
        if (length == 0) {
            return new Result(node, true);
        }

        Result res = search(node.next, length-2);
        if (res.value == false || res.node == null) {
            return res;
        }

        res.value = (res.node.value == node.value);
        res.node = res.node.next;
        return res;
    }

    public static int getSize(LinkedList list) {
        LinkedList.Node node = list.head;
        int size = 0;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }

    public static boolean isPalindrome2(LinkedList list) {
        int length = getSize(list);
        Result res = search(list.head, length);
        return res.value;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addNode(2);
        list.addNode(3);
        list.addNode(1);
        list.addNode(3);
        list.addNode(2);
        System.out.println(isPalindrome2(list) ? "Yes" : "No");
    }
}
