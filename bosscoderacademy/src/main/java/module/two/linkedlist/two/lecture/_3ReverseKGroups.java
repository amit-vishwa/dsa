package module.two.linkedlist.two.lecture;

import module.two.linkedlist.ListNode;
import module.two.linkedlist.Node;

// Refer: https://leetcode.com/problems/reverse-nodes-in-k-group/description/
public class _3ReverseKGroups {

    public static void main(String[] args) {
        printReversedLinkedListInKGroups(new ListNode().convertToLL(new int[]{1, 2, 3, 4, 5}), 2);
        printReversedLinkedListInKGroups(new ListNode().convertToLL(new int[]{1, 2, 3, 4, 5}), 3);
    }

    private static void printReversedLinkedListInKGroups(Node head, int k) {
        head = recursion(head, k);
        ListNode node = new ListNode();
        node.head = head;
        node.display();
        System.out.println();
    }

    /**
     * Approach:
     * - The approach is little complex here.
     * - We are making recursive calls to reverse the list in K groups.
     * - We are creating a tail pointer and moving it K times.
     * - Then reversing the K elements using iteration and storing its head in a new variable node.
     * - Now for current head's next we are making another recursive call for next K elements.
     * - This time pass tail in parameter.
     * - At last just return the new node that will have the actual answer.
     * - Time and space complexity is O(N).
     */
    private static Node recursion(Node head, int k) {
        if (head == null) {
            return null;
        }
        Node tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }
        Node newNode = reverse(head, tail);
        head.next = recursion(tail, k);
        return newNode;
    }

    private static Node reverse(Node curr, Node end) {
        Node prev = null, next;
        while (curr != end) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
