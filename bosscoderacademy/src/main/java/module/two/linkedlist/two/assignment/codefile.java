package module.two.linkedlist.two.assignment;

import module.two.linkedlist.ListNode;
import module.two.linkedlist.Node;

public class codefile {

    public static void main(String[] args) {
        Node node = new codefile().sortList(new ListNode().convertToLL(new int[]{4, 2, 1, 3}));
        ListNode.display(node);
    }

    Node sortList(Node head) {
        // code here
        if (head == null || head.next == null) {
            return head;
        }
        Node mid = getMid(head);
        Node right = mid.next;
        mid.next = null;
        Node leftSorted = sortList(head);
        Node rightSorted = sortList(right);
        return merge(leftSorted, rightSorted);
    }

    private static Node getMid(Node head) {
//        Node node = new Node();
//        node.next = head;
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
//        slow.next = null;
        return slow;
    }

    private static Node merge(Node left, Node right) {
        Node node = new Node();
        Node temp = node;
        while (left != null && right != null) {
            if (left.data <= right.data) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }
        while (left != null) {
            temp.next = left;
            left = left.next;
            temp = temp.next;
        }
        while (right != null) {
            temp.next = right;
            right = right.next;
            temp = temp.next;

        }
//        temp.next = (left != null) ? left : right;
        return node.next;
    }
}