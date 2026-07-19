package module.two.linkedlist.one.lecture;

import module.two.linkedlist.Node;
import module.two.linkedlist.ListNode;

// Refer: https://leetcode.com/problems/middle-of-the-linked-list/description/
public class _1MiddleOfLL {

    public static void main(String[] args) {
        printMiddleOfLL(new ListNode().convertToLL(new int[]{1, 2, 3, 4, 5}));
        printMiddleOfLL(new ListNode().convertToLL(new int[]{1, 2, 3, 4, 5, 6}));
    }

    /**
     * Approach:
     * - Here we are using a simple fast and slow pointer approach.
     * - The fast pointer proceeds with two steps and slow pointer proceeds with a single step.
     * - If fast pointer is not null and next of fast pointer is not null then proceed else stop and we got our middle node.
     * - Time complexity: O(N) due to array traversal.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static void printMiddleOfLL(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode node = new ListNode();
        node.head = slow;
        node.display();
        System.out.println();
    }

}
