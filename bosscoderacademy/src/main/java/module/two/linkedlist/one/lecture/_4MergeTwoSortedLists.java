package module.two.linkedlist.one.lecture;

import module.two.linkedlist.Node;
import module.two.linkedlist.ListNode;

// Refer: https://leetcode.com/problems/merge-two-sorted-lists/description/
public class _4MergeTwoSortedLists {

    public static void main(String[] args) {
        printMergedSortedLists(new ListNode().convertToLL(new int[]{1, 2, 4}), new ListNode().convertToLL(new int[]{1, 3, 4}));
        printMergedSortedLists(new ListNode().convertToLL(new int[]{}), new ListNode().convertToLL(new int[]{}));
        printMergedSortedLists(new ListNode().convertToLL(new int[]{}), new ListNode().convertToLL(new int[]{0}));
    }

    /**
     * Approach:
     * - It is a simple approach.
     * - We are creating an object of list node to insert data in it.
     * - We are traversing on both lists and checking if current left node is smaller, then insert left else right.
     * - At last just display the sorted list after insertion in a new merged list.
     * - Time complexity: O(M+N)
     * - Space complexity: O(N) to return the result, else O(1) as no extra space is used.
     */
    private static void printMergedSortedLists(Node head1, Node head2) {
        ListNode head = new ListNode();
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                head.insert(head1.data);
                head1 = head1.next;
            } else {
                head.insert(head2.data);
                head2 = head2.next;
            }
        }
        while (head1 != null) {
            head.insert(head1.data);
            head1 = head1.next;
        }
        while (head2 != null) {
            head.insert(head2.data);
            head2 = head2.next;
        }
        head.display();
        System.out.println();
    }

}
