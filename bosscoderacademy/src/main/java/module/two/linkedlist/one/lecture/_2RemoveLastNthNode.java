package module.two.linkedlist.one.lecture;

import module.two.linkedlist.Node;
import module.two.linkedlist.ListNode;

// Refer: https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
public class _2RemoveLastNthNode {

    public static void main(String[] args) {
        printUpdatedList(new ListNode().convertToLL(new int[]{1, 2, 3, 4, 5}), 2);
        printUpdatedList(new ListNode().convertToLL(new int[]{1}), 1);
        printUpdatedList(new ListNode().convertToLL(new int[]{1, 2}), 1);


        print(new ListNode().convertToLL(new int[]{1, 2, 3, 4, 5}), 2);
        print(new ListNode().convertToLL(new int[]{1}), 1);
        print(new ListNode().convertToLL(new int[]{1, 2}), 1);
    }

    /**
     * Approach:
     * - The approach is simple.
     * - We are using fast and slow pointer here.
     * - Increase the fast pointer K times, then check if it is null that traversed whole list then remove head.
     * - Else, keep on increasing the fast pointer and slow pointer until fast pointer reaches at last node.
     * - Now, just update slow pointer's next, point it towards next of next.
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    private static void printUpdatedList(Node head, int k) {
        if (head.next != null) {
            Node fast = head, slow = head;
            for (int i = 0; i < k && fast != null; i++) {
                fast = fast.next;
            }
            if (fast == null) {
                head = head.next;
            }
            while (fast != null && fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            if (slow.next != null) {
                slow.next = slow.next.next;
            } else {
                slow = null;
            }
        }
        ListNode node = new ListNode();
        node.head = head;
        node.display();
        System.out.println();
    }

    // Correct code to remove Nth node from last.
    private static void print(Node head, int n) {
        Node start = new Node();
        start.next = head;
        Node fast = start, slow = start;

        // Move fast pointer n steps ahead
        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Skip the nth node
        slow.next = slow.next.next;

//            return start.next;
        ListNode node = new ListNode();
        node.head = start.next;
        node.display();
        System.out.println();
    }

}
