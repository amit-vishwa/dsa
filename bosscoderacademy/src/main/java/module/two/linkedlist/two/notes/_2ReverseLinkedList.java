package module.two.linkedlist.two.notes;

import module.two.linkedlist.ListNode;
import module.two.linkedlist.Node;

/**
 * Reverse Linked List:
 * <p>
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * <p>
 * Example
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 */
public class _2ReverseLinkedList {

    public static void main(String[] args) {
        reverseLinkedList(new ListNode().convertToLL(new int[]{1, 2, 3, 4, 5}));
    }

    private static void reverseLinkedList(Node head) {
//        iterativeApproach(head);
        recursiveApproach(head);
        System.out.println();
    }

    /**
     * Iterative Approach:
     * - We will use three-pointers to traverse through the entire list and interchange links between nodes.
     * - One pointer to keep track of the current node in the list.
     * - The second one is to keep track of the previous node to the current node and change links.
     * - Lastly, a pointer to keep track of nodes in front of current nodes.
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    private static void iterativeApproach(Node head) {
        System.out.println("Iterative approach:");
        Node prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        display(prev);
    }

    /**
     * Recursive Approach:
     * - We traverse to the end of the list recursively.
     * - As we reach the end of the list, we make the end node the head.
     * - Then receive previous nodes and make them connected to the last one.
     * - At last, we link the second node to the head and the first node to NULL.
     * - We return to our new head.
     * - Time and space complexity: O(N) due to recursion stack.
     */
    private static void recursiveApproach(Node head) {
        System.out.println("Recursive approach:");
        head = recursion(head);
        display(head);
    }

    private static Node recursion(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newNode = recursion(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }

    private static void display(Node head) {
        ListNode node = new ListNode();
        node.head = head;
        node.display();
    }

}
