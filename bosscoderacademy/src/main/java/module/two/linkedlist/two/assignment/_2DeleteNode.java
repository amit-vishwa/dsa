package module.two.linkedlist.two.assignment;

import module.two.linkedlist.Node;
import module.two.linkedlist.ListNode;

// Refer _5DeleteNode.java from package module.two.linkedlist.two.lecture.
public class _2DeleteNode {

    public static void main(String[] args) {
        printUpdatedList(new ListNode().convertToLL(new int[]{1, 3, 4}), 3);
        printUpdatedList(new ListNode().convertToLL(new int[]{1, 5, 2, 9}), 2);
    }

    /**
     * Approach:
     * - If index is 1, just return the list from next of head.
     * - Now, simply update the index, reduce 2 from it as 1st case is already considered, and we have to reach prev of node.
     * - Now just iterate and reach till previous node of the node that is getting deleted using temporary node.
     * - After reaching just point the next to next of next.
     * - At last, just return the head as list is already updated now.
     * - Time complexity: O(N) as we are iterating till previous of specified index.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static void printUpdatedList(Node head, int index) {
        if (index == 1) {
            ListNode.display(head.next);
            return;
        }
        index = index - 2;
        Node temp = head;
        while (index > 0) {
            temp = temp.next;
            index--;
        }
        temp.next = temp.next.next;
        ListNode.display(head);
        System.out.println();
    }

}