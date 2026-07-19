package module.two.linkedlist.two.assignment;

import module.two.linkedlist.Node;
import module.two.linkedlist.ListNode;

/**
 * Reverse Linked List II:
 * <p>
 * Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list
 * from position left to position right, and return the reversed list.
 * <p>
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 * <p>
 * Input: head = [5], left = 1, right = 1
 * Output: [5]
 * <p>
 * Constraints:
 * The number of nodes in the list is n.
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 */
public class _7ReverseLinkedListII {

    public static void main(String[] args) {
        printReversedLinkedList(new ListNode().convertToLL(new int[]{1, 2, 3, 4, 5}), 2, 4);
        printReversedLinkedList(new ListNode().convertToLL(new int[]{5}), 1, 1);
    }

    /**
     * Approach:
     * - The approach is little tricky here.
     * - Create a dummy node and point it to head.
     * - Now, create a previous node and iterate it left previous of left index.
     * - After that create a current node and point it to next of previous.
     * - Start a loop from 0 till diff of right and left.
     * - Store the head of sublist i.e. next of previous in a temp variable.
     * - Point next of previous to current's next and the point current's next to its next.
     * - Also, now point previous next's next to temp.
     * - After completing the loop we will be having the reversed sublist.
     * - Time complexity: O(N) as we are iterating over once.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static void printReversedLinkedList(Node head, int left, int right) {
        Node node = new Node();
        node.next = head;
        Node prev = node;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        Node curr = prev.next;
        for (int i = 0; i < right - left; i++) {
            Node temp = prev.next;
            prev.next = curr.next;
            curr.next = curr.next.next;
            prev.next.next = temp;
        }
        ListNode.display(node.next);
        System.out.println();
    }

}