package module.two.linkedlist.two.assignment;

import module.two.linkedlist.Node;
import module.two.linkedlist.ListNode;

/**
 * Sort Linked List:
 * <p>
 * Given the head of a linked list, return the list after sorting it in ascending order.
 * <p>
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 * <p>
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 * <p>
 * Constraints:
 * The number of nodes in the list is in the range [0, 5 * 104].
 * -105 <= Node.val <= 105
 */
public class _8SortLinkedList {

    public static void main(String[] args) {
        printSortedList(new ListNode().convertToLL(new int[]{4, 2, 1, 3}));
        printSortedList(new ListNode().convertToLL(new int[]{-1, 5, 3, 4, 0}));
    }

    private static void printSortedList(Node head) {
        head = sort(head);
        ListNode.display(head);
        System.out.println();
    }

    /**
     * Approach:
     * - The approach is similar to merge sort only.
     * - However, here when we are calculating the mid, we are start fast with second node.
     * - Also, after getting mid-node, the right part is taken as next of middle node and next of mid is set as null.
     * - The while merging, do the similar process as of merge sort using a dummy node.
     * - Time complexity: O(N*log(N)) similar to merge sort.
     * - Space complexity: O(N) similar to merge sort.
     */
    private static Node sort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node midNode = getMid(head);
        Node right = midNode.next;
        midNode.next = null;
        Node leftSorted = sort(head);
        Node rightSorted = sort(right);
        return merge(leftSorted, rightSorted);
    }

    private static Node getMid(Node head) {
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private static Node merge(Node left, Node right) {
        Node sorted = new Node();
        Node temp = sorted;
        while (left != null && right != null) {
            if (left.data <= right.data) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }
        while (left != null) {
            temp.next = left;
            left = left.next;
            temp = temp.next;
        }
        while (right != null) {
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }
        return sorted.next;
    }

}