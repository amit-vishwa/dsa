package module.two.linkedlist.one.lecture;

import module.two.linkedlist.Node;
import module.two.linkedlist.ListNode;

// Refer: https://leetcode.com/problems/linked-list-cycle/description/
public class _3LinkedListCycle {

    public static void main(String[] args) {
        System.out.println("Is cycle exist: " + isCycleExist(getInput(new ListNode().convertToLL(new int[]{3, 2, 0, -4}), 1)) + "\n");
        System.out.println("Is cycle exist: " + isCycleExist(getInput(new ListNode().convertToLL(new int[]{1, 2}), 0)) + "\n");
        System.out.println("Is cycle exist: " + isCycleExist(getInput(new ListNode().convertToLL(new int[]{1}), -1)) + "\n");
    }

    /**
     * Approach:
     * - This is a simple approach with fast and slow pointer method.
     * - Just increase the fast pointer by 2 and slow by 1.
     * - Then check if both pointers meet at point and fast and its next is not becoming null at any point.
     * - If yes, then we got a cycle else no cycle exist here.
     * - Time complexity: O(N) as we are iterating the list multiple times.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static boolean isCycleExist(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    // helper method to create a cycle in linked list
    private static Node getInput(Node head, int pos) {
        if (pos == -1) {
            return head;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node temp2 = head;
        for (int i = 0; i < pos; i++) {
            temp2 = temp2.next;
        }
        temp.next = temp2;
        return head;
    }

}
