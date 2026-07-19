package module.two.linkedlist.two.assignment;

import module.two.linkedlist.Node;
import module.two.linkedlist.ListNode;

/**
 * Binary To Integer Linked List:
 * <p>
 * Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1.
 * The linked list holds the binary representation of a number.
 * Return the decimal value of the number in the linked list.
 * The most significant bit is at the head of the linked list.
 * <p>
 * Input: head = [1,0,1]
 * Output: 5
 * Explanation: (101) in base 2 = (5) in base 10
 * <p>
 * Input: head = [0]
 * Output: 0
 * <p>
 * Constraints:
 * The Linked List is not empty.
 * Number of nodes will not exceed 30.
 * Each node's value is either 0 or 1.
 * <p>
 * Approach:
 * - The approach is simple, just reverse the linked list first.
 * - Then iterate over it and start converting binary to integer value.
 * - At last just return the answer.
 * - Time complexity: O(N) for iterating over list * O(log(N)) for calculating power = O(N*log(N))
 * - Space complexity: O(N) due to recursion stack while reversing the list.
 */
public class _6BinaryToIntegerLL {

    public static void main(String[] args) {
        System.out.println("Integer value: " + binaryToInteger(new ListNode().convertToLL(new int[]{1, 0, 1})) + "\n");
        System.out.println("Integer value: " + binaryToInteger(new ListNode().convertToLL(new int[]{0})) + "\n");
        System.out.println("Integer value: " + binaryToInteger(new ListNode().convertToLL(new int[]{1, 1, 0, 1})) + "\n");
        System.out.println("Integer value: " + binaryToInteger(new ListNode().convertToLL(new int[]{0, 1})) + "\n");
    }

    private static int binaryToInteger(Node head) {
        int integerValue = 0, power = 0;
        Node temp = reverse(head);
        while (temp != null) {
            integerValue += temp.data * (int) Math.pow(2, power);
            power++;
            temp = temp.next;
        }
        return integerValue;
    }

    private static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newNode = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }

}