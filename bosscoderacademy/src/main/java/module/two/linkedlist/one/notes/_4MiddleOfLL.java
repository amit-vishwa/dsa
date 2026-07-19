package module.two.linkedlist.one.notes;

import module.two.linkedlist.ListNode;
import module.two.linkedlist.Node;

/**
 * Middle of the Linked List:
 * <p>
 * Given the head of a singly linked list, return the middle node of the linked list.
 * <p>
 * Example
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 */
public class _4MiddleOfLL {

    public static void main(String[] args) {
        printListFromMiddle(new ListNode().convertToLL(new int[]{1, 2, 3, 4, 5}));
        printListFromMiddle(new ListNode().convertToLL(new int[]{1, 2, 3, 4, 5, 6}));
    }

    private static void printListFromMiddle(Node head) {
        printListFromMiddleUsingApproach1(head);
        printListFromMiddleUsingApproach2(head);
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce
     * - This is a simple bruteforce method, where we are calculating the length first.
     * - Then we are calculating the mid and traversing till mid (second mid for even).
     * - After that just displaying the data from there.
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    private static void printListFromMiddleUsingApproach1(Node head) {
        int len = 0;
        Node temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        int mid = len / 2;
        Node midNode = head;
        while (mid > 0) {
            midNode = midNode.next;
            mid--;
        }
        ListNode node = new ListNode();
        node.head = midNode;
        node.display();
    }

    /**
     * Approach 2 - Hare & Tortoise Approach (i.e. Fast & Slow Pointer Approach)
     * - Here, we are using the fast and slow pointer approach.
     * - Increase the fast by 2 steps and slow by 1.
     * - When fast reach at end or exits the list, then slow will be pointing to the middle element.
     * - This is better than above, as it takes only one pass.
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    private static void printListFromMiddleUsingApproach2(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode node = new ListNode();
        node.head = slow;
        node.display();
    }

}
