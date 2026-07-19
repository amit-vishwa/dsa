package module.two.linkedlist.two.assignment;

import module.two.linkedlist.Node;
import module.two.linkedlist.ListNode;

/**
 * Remove Linked List Elements:
 * <p>
 * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and
 * return the new head.
 * <p>
 * Input: head = [1,2,6,3,4,5,6], val = 6
 * Output: [1,2,3,4,5]
 * <p>
 * Input: head = [7,7,7,7], val = 7
 * Output: []
 */
public class _5RemoveLLElements {

    public static void main(String[] args) {
        printUpdatedList(new ListNode().convertToLL(new int[]{1, 2, 6, 3, 4, 5, 6}), 6);
        printUpdatedList(new ListNode().convertToLL(new int[]{7, 7, 7, 7}), 7);
    }

    /**
     * Approach:
     * - The approach is quite simple.
     * - We are using 2 temp nodes here.
     * - Pointer the first node to previous of head and 2nd to first node.
     * - Now iterating over the list and removing the nodes if data is same as provided data.
     * - At last we will be having the correct updated list in the next of first node.
     * - Time complexity: O(N) as we are traversing the whole list.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static void printUpdatedList(Node head, int data) {
        Node node = new Node();
        node.next = head;
        Node temp = node;
        while (temp.next != null) {
            if (temp.next.data == data) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        ListNode.display(node.next);
        System.out.println();
    }

}