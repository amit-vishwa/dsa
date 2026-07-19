package module.two.linkedlist.two.lecture;

import module.two.linkedlist.ListNode;
import module.two.linkedlist.Node;

// Refer: https://leetcode.com/problems/delete-node-in-a-linked-list/description/
public class _5DeleteNode {

    public static void main(String[] args) {
        printLinkedList(new ListNode().convertToLL(new int[]{4, 5, 1, 9}), new Node(5, null));
        printLinkedList(new ListNode().convertToLL(new int[]{4, 5, 1, 9}), new Node(1, null));
        printLinkedList(new ListNode().convertToLL(new int[]{4, 5, 1, 9}), new Node(10, null));
        printLinkedList(new ListNode().convertToLL(new int[]{}), new Node(1, null));
        printLinkedList(new ListNode().convertToLL(new int[]{4, 5, 1, 9}), null);
        printLinkedList(new ListNode().convertToLL(new int[]{}), null);
    }

    /**
     * Approach:
     * - Iterate till the specified node first using a temp node variable.
     * - Then replace current node with next node if next exist, else make node as null.
     * - Then just display the list.
     * - Time complexity: O(N).
     * - Space complexity: O(1).
     */
    private static void printLinkedList(Node head, Node node) {
        Node temp = head;
        while (temp != null) {
            if (node != null && temp.data == node.data) {
                if (temp.next != null) {
                    temp.data = temp.next.data;
                    temp.next = temp.next.next;
                } else {
                    temp = null;
                }
            }
            temp = temp.next;
        }
        ListNode listNode = new ListNode();
        listNode.head = head;
        listNode.display();
        System.out.println();
    }

}
