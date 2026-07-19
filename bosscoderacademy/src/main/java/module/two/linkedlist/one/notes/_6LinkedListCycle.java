package module.two.linkedlist.one.notes;

import module.two.linkedlist.Node;
import module.two.linkedlist.ListNode;

import java.util.HashSet;

/**
 * Linked List Cycle:
 * <p>
 * Given head, the head of a linked list, determines if the linked list has a cycle in it.
 * <p>
 * Example
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 */
public class _6LinkedListCycle {

    public static void main(String[] args) {
        printResult(getInput(new ListNode().convertToLL(new int[]{3, 2, 0, -4}), 1));
        printResult(getInput(new ListNode().convertToLL(new int[]{1, 2}), 0));
        printResult(getInput(new ListNode().convertToLL(new int[]{1}), -1));
    }

    private static void printResult(Node head) {
        System.out.println("Is cycle exist by approach 1: " + approach1(head));
        System.out.println("Is cycle exist by approach 2: " + approach2(head));
        System.out.println();
    }

    /**
     * Approach 1 - Using HashSet
     * - Here, just add all nodes in the hashset while iterating the list using a temporary node.
     * - If set already contains the node then the list contains a cycle, return true.
     * - Else at last after traversal, just return false.
     * - Time and space complexity is O(N).
     */
    private static boolean approach1(Node head) {
        HashSet<Node> set = new HashSet<>();
        Node temp = head;
        while (temp != null) {
            if (set.contains(temp)) {
                return true;
            }
            set.add(temp);
            temp = temp.next;
        }
        return false;
    }

    /**
     * Approach 2 - Using Fast and Slow Pointers
     * - This is simple approach using hare and tortoise method.
     * - Here, we have move faster pointer twice of slow pointer.
     * - If cycle is there, then fast pointer will surely meet slow pointer at one time.
     * - When they meet just return true, else after loop end just return false.
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    private static boolean approach2(Node head) {
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
