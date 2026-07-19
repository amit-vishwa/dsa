package module.two.linkedlist.one.notes;

import module.two.linkedlist.Node;
import module.two.linkedlist.ListNode;

/**
 * Find the n/k -th node in a linked list:
 * <p>
 * Given a singly linked list and a number k. Write a function to find the (N/k)th element, where N is the number of elements
 * in the list. We need to consider ceil value in the case of decimals.
 * <p>
 * Example
 * <p>
 * Input:
 * 6
 * 1 2 3 4 5 6
 * 2
 * Output:
 * 3
 * <p>
 * Approach
 * Take two pointers temp and fractionalNode and initialise them with null and head respectively. For every k jump of the temp
 * pointer, make one jump of the fractionalNode pointer.
 * <p>
 * Time complexity: O(N)
 * Space complexity: O(1)
 */
public class _5NByKNode {

    public static void main(String[] args) {
        printNByKthNode(new ListNode().convertToLL(new int[]{1, 2, 3, 4, 5, 6}), 2);
        printNByKthNode(new ListNode().convertToLL(new int[]{1, 2, 3, 4, 5, 6}), 12);
        printNByKthNode(new ListNode().convertToLL(new int[]{1, 2, 3, 4, 5, 6}), 1);
    }

    private static void printNByKthNode(Node head, int k) {
        int len = 0;
        Node temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        for (int i = 1; i < len / k; i++) {
            head = head.next;
        }
        System.out.println(head.data + "\n");
    }

}
