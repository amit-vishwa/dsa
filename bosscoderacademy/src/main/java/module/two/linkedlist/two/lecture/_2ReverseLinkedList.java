package module.two.linkedlist.two.lecture;

import module.two.linkedlist.ListNode;
import module.two.linkedlist.Node;

// Refer: https://leetcode.com/problems/reverse-linked-list/description/
public class _2ReverseLinkedList {

    public static void main(String[] args) {
        printReversedLinkedList(new ListNode().convertToLL(new int[]{1, 2, 3, 4, 5}));
        printReversedLinkedList(new ListNode().convertToLL(new int[]{1, 2}));
        printReversedLinkedList(new ListNode().convertToLL(new int[]{}));
    }

    private static void printReversedLinkedList(Node head) {
        iterativeApproach(head);
        recursiveApproach(head);
        System.out.println();
    }

    /**
     * Approach 1 - Iteration
     * - The approach uses 3 extra variables to reverse a linked list.
     * - We have prev, curr and next variable.
     * - The prev will point to null and curr will point to head.
     * - Now loop until curr becomes null.
     * - First update next to curr's next, then update curr's next to point to prev.
     * - After that move prev to curr, and then curr to next.
     * - At last when the loop ends, just return the prev or move head to prev as it is the answer.
     * - Time complexity: O(N) we are reversing in a single iteration.
     * - Space complexity: O(1) as no extra space that is dependent on input is used here.
     */
    private static void iterativeApproach(Node head) {
        System.out.println("Reversed linked using iteration:");
        Node prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode node = new ListNode();
        node.head = prev;
        node.display();
    }

    /**
     * Approach 2 - Recursion
     * - This is another approach to reverse a linked list.
     * - We are doing the recursive call and reaching till last node.
     * - Now, if node is null or node's next is null just return the node and store it in new node.
     * - After recursion call, it while coming back just store the node in a new variable.
     * - Now, for curr node, just update it's next of next and point it to curr.
     * - And curr's next should point to null.
     * - At last just return the new node as it is a new head of the reversed list.
     * - Time and space complexity is O(N).
     */
    private static void recursiveApproach(Node head) {
        System.out.println("Reversed linked using recursion:");
        head = recursion(head); // helper function
        ListNode node = new ListNode();
        node.head = head;
        node.display();
    }

    private static Node recursion(Node head) {
        if (head == null || head.next == null) {
            return head; // base case when we reach at last node
        }
        Node newHead = recursion(head.next); // will have last node
        head.next.next = head; // last's next point to second last
        head.next = null; // curr's next point to null
        return newHead;
    }

}
