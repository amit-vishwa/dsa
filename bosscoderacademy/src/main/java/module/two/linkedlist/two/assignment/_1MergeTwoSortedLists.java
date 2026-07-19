package module.two.linkedlist.two.assignment;

import module.two.linkedlist.Node;
import module.two.linkedlist.ListNode;

// Refer _3SortLinkedList.java from package module.two.linkedlist.two.notes.
public class _1MergeTwoSortedLists {

    public static void main(String[] args) {
        printMergedSortedList(new ListNode().convertToLL(new int[]{1, 2, 4}), new ListNode().convertToLL(new int[]{1, 3, 4}));
        printMergedSortedList(new ListNode().convertToLL(new int[]{1}), new ListNode().convertToLL(new int[]{0}));
    }

    private static void printMergedSortedList(Node head1, Node head2) {
        Node node = new Node();
        Node temp = node;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        temp.next = (head1 != null) ? head1 : head2;
        ListNode.display(node.next);
        System.out.println();
    }

}