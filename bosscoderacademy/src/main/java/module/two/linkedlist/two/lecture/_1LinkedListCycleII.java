package module.two.linkedlist.two.lecture;

import module.two.linkedlist.Node;
import module.two.linkedlist.ListNode;

public class _1LinkedListCycleII {

    public static void main(String[] args) {
        System.out.println("Is cycle exist: " + cyclePosition(getInput(new ListNode().convertToLL(new int[]{3, 2, 0, -4}), 1)) + "\n");
        System.out.println("Is cycle exist: " + cyclePosition(getInput(new ListNode().convertToLL(new int[]{1, 2}), 0)) + "\n");
        System.out.println("Is cycle exist: " + cyclePosition(getInput(new ListNode().convertToLL(new int[]{1}), -1)) + "\n");
    }

    /**
     * Approach:
     * - We are using the slow and fast pointer approach here.
     * - The logic is simple, just check if cycle exist.
     * - If not exist i.e. fast pointer reaches at last node or exits the list then return -1 as position.
     * - Else, when cycle found, just start slow pointer from that position and keep a new pointer at start and move it like slow.
     * - Now, also keep a counter to count their indexes.
     * - When they meet return the index counter and that will be the start of the cycle.
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    private static int cyclePosition(Node head) {
        Node fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return -1;
        }
        Node start = head;
        int pos = 0;
        while (start != slow) {
            start = start.next;
            slow = slow.next;
            pos++;
        }
        return pos;
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
