package module.two.heaps.two.lecture;

import java.util.PriorityQueue;

// Refer _3MergeKSortedLists.java from package module.two.heaps.one.assignment.
public class _4MergeKSortedLists {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private static ListNode[] getInput() {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);

        return new ListNode[]{node1, node2, node3};
    }

    private static void display(ListNode root) {
        ListNode temp = root;
        System.out.print("[");
        while (temp != null) {
            System.out.print(temp.val);
            temp = temp.next;
            if (temp != null) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        display(mergedSortedLists(getInput()));
        display(mergedSortedLists(new ListNode[0]));
        display(mergedSortedLists(new ListNode[]{}));
    }

    private static ListNode mergedSortedLists(ListNode[] lists) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        for (ListNode list : lists) {
            while (list != null) {
                minPQ.add(list.val);
                list = list.next;
            }
        }
        ListNode node = new ListNode();
        ListNode dummy = node;
        while (!minPQ.isEmpty()) {
            dummy.next = new ListNode(minPQ.remove());
            dummy = dummy.next;
        }
        return node.next;
    }

}
