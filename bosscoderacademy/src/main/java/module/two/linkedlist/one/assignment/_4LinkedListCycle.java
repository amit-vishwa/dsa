package module.two.linkedlist.one.assignment;

import module.two.linkedlist.Node;
import module.two.linkedlist.ListNode;

// Refer _3LinkedListCycle.java from package module.two.linkedlist.one.lecture.
public class _4LinkedListCycle {

    public static void main(String[] args) {
        System.out.println("Is cycle exist? " + cycleCheck(getInput(new ListNode().convertToLL(new int[]{3, 2, 0, -4}), 1)) + "\n");
        System.out.println("Is cycle exist? " + cycleCheck(getInput(new ListNode().convertToLL(new int[]{1, 2}), 0)) + "\n");
        System.out.println("Is cycle exist? " + cycleCheck(getInput(new ListNode().convertToLL(new int[]{1}), -1)) + "\n");
    }

    private static boolean cycleCheck(Node head) {
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