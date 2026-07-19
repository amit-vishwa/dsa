package module.two.linkedlist.two.lecture;

import module.two.linkedlist.ListNode;
import module.two.linkedlist.Node;

// Refer: https://leetcode.com/problems/palindrome-linked-list/description/
public class _4PalindromeLL {

    public static void main(String[] args) {
        System.out.println(palindromeLinkedList(new ListNode().convertToLL(new int[]{1, 2, 2, 1})) + "\n");
        System.out.println(palindromeLinkedList(new ListNode().convertToLL(new int[]{1, 2})) + "\n");
        System.out.println(palindromeLinkedList(new ListNode().convertToLL(new int[]{1, 2, 5, 2, 1})) + "\n");
        System.out.println(palindromeLinkedList(new ListNode().convertToLL(new int[]{1, 2, 3, 4, 5, 4, 3, 2, 1})) + "\n");
        System.out.println(palindromeLinkedList(new ListNode().convertToLL(new int[]{1, 2, 3, 4, 5, 5, 3, 2, 1})) + "\n");
    }

    /**
     * Approach:
     * - The approach is quite simple.
     * - We have to first find the middle element, then reverse the list from mid-element.
     * - After that just compare using 2 pointers, keep pointer at 1st element and reversed list's first element.
     * - If any element is different then just return false else at last after all comparisons return true.
     * - Time complexity: O(n)
     * - Space complexity: O(1)
     */
    private static boolean palindromeLinkedList(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node rev = reverse(slow);
        while (head != null && rev != null) {
            if (head.data != rev.data) {
                return false;
            }
            head = head.next;
            rev = rev.next;
        }
        return true;
    }

    private static Node reverse(Node curr) {
        Node prev = null, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
