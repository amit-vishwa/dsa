package module.two.linkedlist.two.assignment;

import module.two.linkedlist.Node;
import module.two.linkedlist.ListNode;

// Refer _2ReverseLinkedList.java from package module.two.linkedlist.two.lecture.
public class _3ReverseLinkedList {

    public static void main(String[] args) {
        printReversedLinkedList(new ListNode().convertToLL(new int[]{1, 2, 3, 4, 5}));
        printReversedLinkedList(new ListNode().convertToLL(new int[]{1, 2}));
    }

    private static void printReversedLinkedList(Node head) {
        Node prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode.display(prev);
        System.out.println();
    }

}