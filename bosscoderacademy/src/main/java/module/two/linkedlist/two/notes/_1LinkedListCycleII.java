package module.two.linkedlist.two.notes;

import module.two.linkedlist.ListNode;
import module.two.linkedlist.Node;

/**
 * Linked List Cycle II:
 *
 * Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * Example
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1.
 * */
import java.util.HashSet;

public class _1LinkedListCycleII {

    public static void main(String[] args) {
        printCycleStartingNode(getInput(new ListNode().convertToLL(new int[]{3, 2, 0, -4}), 1));
        printCycleStartingNode(getInput(new ListNode().convertToLL(new int[]{1, 2}), 0));
        printCycleStartingNode(getInput(new ListNode().convertToLL(new int[]{1}), -1));
    }

    private static void printCycleStartingNode(Node head) {
        System.out.println("Cycle starting index by approach 1: " + approach1(head));
        System.out.println("Cycle starting index by approach 2: " + approach2(head));
        System.out.println();
    }

    /**
     * Approach 1 - Using Hashing:
     * - We can use the concept of hashing to detect the first node of the loop.
     * - The idea is simple just iterate over the entire linked list and store node addresses in a set one by one, while adding
     * the node address into the set check if it already contains that particular node address if not then add the node address
     * to the set if it is already present in the set then the current node is the first node of the loop.
     * - Time and space complexity is O(N).
     */
    private static int approach1(Node head) {
        HashSet<Node> nodeSet = new HashSet<>();
        Node temp = head;
        while (temp != null) {
            if (nodeSet.contains(temp)) {
                return temp.data;
            }
            nodeSet.add(temp);
            temp = temp.next;
        }
        return -1;
    }

    /**
     * Approach 2 - Optimized Approach:
     * - Initially take two pointers, fast and slow.
     * - The fast pointer takes two steps ahead while the slow pointer will take a single step ahead for each iteration.
     * - We know that if a cycle exists, fast and slow pointers will collide.
     * - If the cycle does not exist, the fast pointer will move to NULL.
     * - Otherwise, when both slow and fast pointer collides, it detects a cycle exists.
     * - Take another pointer, say entry.
     * - Point to the very first of the linked list.
     * - Move the slow and the entry pointer ahead by single steps until they collide.
     * - Once they collide we get the starting node of the linked list.
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    private static int approach2(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return helper(head, slow);
            }
        }
        return -1;
    }

    private static int helper(Node node1, Node node2) {
        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1.data;
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
