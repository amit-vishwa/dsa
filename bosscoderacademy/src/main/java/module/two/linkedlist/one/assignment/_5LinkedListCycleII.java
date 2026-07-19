package module.two.linkedlist.one.assignment;

import module.two.linkedlist.ListNode;
import module.two.linkedlist.Node;

// Refer _1LinkedListCycleII.java from package module.two.linkedlist.two.lecture.
public class _5LinkedListCycleII {

    public static void main(String[] args) {
        System.out.println("Cycle start index: " + cycleStartIndex(getInput(new ListNode().convertToLL(new int[]{3, 2, 0, -4}), 1)) + "\n");
        System.out.println("Cycle start index: " + cycleStartIndex(getInput(new ListNode().convertToLL(new int[]{1, 2}), 0)) + "\n");
        System.out.println("Cycle start index: " + cycleStartIndex(getInput(new ListNode().convertToLL(new int[]{1}), -1)) + "\n");
    }

    private static int cycleStartIndex(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                Node start = head;
                int index = 0;
                while (start != slow) {
                    start = start.next;
                    slow = slow.next;
                    index++;
                }
                return index;
            }
        }
        return -1;
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