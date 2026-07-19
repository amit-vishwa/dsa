package module.two.linkedlist.two.notes;

import module.two.linkedlist.ListNode;
import module.two.linkedlist.Node;

/**
 * Sort a linked list:
 * <p>
 * Given the head of a linked list, return the list after sorting it in ascending order.
 * <p>
 * Example:
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 */
public class _3SortLinkedList {

    public static void main(String[] args) {
        printSortedList(new ListNode().convertToLL(new int[]{5, 2, 1, 4, 3}));
        printSortedList(new ListNode().convertToLL(new int[]{5, 2, 1, 4, 6, 3}));
    }

    /**
     * Approach:
     * - The problem is to sort the linked list.
     * - If we look at various sorting algorithms, Merge Sort is one of the efficient sorting algorithms that is popularly used
     * for sorting the linked list.
     * - The merge sort algorithm runs in O(nlogn) time in all the cases.
     * - Let's discuss approaches to sorting linked lists using merge sort.
     * - Merge sort is a popularly known algorithm that follows the Divide and conquer strategy.
     * - The divide and conquer strategy can be split into 2 phases:
     * Divide phase: Divide the problem into subproblems.
     * Conquer phase: Repeatedly solve each subproblem independently and combine the result to form the original problem.
     * - The top-down approach for merge sort recursively splits the original list into sublists of equal sizes, sorts each
     * sublist independently, and eventually merges the sorted lists.
     * - Time complexity: O(N*log(N))
     * - Space complexity: O(log(N))
     */
    private static void printSortedList(Node head) {
        head = sort(head);
        ListNode node = new ListNode();
        node.head = head;
        node.display();
        System.out.println();
    }

    private static Node sort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node mid = middle(head);
        Node left = sort(head);
        Node right = sort(mid);
        return merge(left, right);
    }

    // fetch start from previous of mid, then return mid
    private static Node middle(Node head) {
        Node midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        Node mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

    // merge nodes by creating a dummy variable and iterating over it
    private static Node merge(Node left, Node right) {
        Node merged = new Node();
        Node temp = merged;
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
        temp.next = (left != null) ? left : right;
        return merged.next;
    }

}
