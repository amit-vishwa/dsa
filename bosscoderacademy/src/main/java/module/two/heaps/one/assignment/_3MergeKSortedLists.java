package module.two.heaps.one.assignment;

import java.util.PriorityQueue;

/**
 * Merge K Sorted Lists:
 * <p>
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 * <p>
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * <p>
 * Input: lists = [[]]
 * Output: []
 * <p>
 * Constraints:
 * k == lists.length
 * 0 <= k <= 104
 * 0 <= lists[i].length <= 500
 * -104 <= lists[i][j] <= 104
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length will not exceed 104.
 */
public class _3MergeKSortedLists {

    static class ListNode {
        int data;
        ListNode next;

        ListNode() {
            data = 0;
            next = null;
        }

        ListNode(int val) {
            data = val;
            next = null;
        }
    }

    private static ListNode[] getInput1() {
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

    private static void display(ListNode node) {
        ListNode temp = node;
        System.out.print("[");
        while (temp != null) {
            System.out.print(temp.data);
            temp = temp.next;
            if (temp != null) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        display(mergedSortedList(getInput1()));
        display(mergedSortedList(new ListNode[0]));
    }

    /**
     * Approach:
     * - The approach is quite straightforward.
     * - We are iterating over the list node array.
     * - Then we are also iterating over each node to store all the values in min-heap based priority queue.
     * - We are doing this for all values.
     * - After that we are creating the result node and a dummy node for traversal.
     * - We are traversing over the priority queue and removing and storing all queue values in node.
     * - At last, we are returning the next of result node as we started filling the values from the next node.
     * - Time complexity: O(M) for array length * O(N) for each node length * log(K) for queue insertion = O(M*N*log(K))
     * - Space complexity: O(M*N) as we are storing all the values in priority queue.
     */
    private static ListNode mergedSortedList(ListNode[] lists) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        for (ListNode list : lists) {
            while (list != null) {
                minPQ.add(list.data);
                list = list.next;
            }
        }
        ListNode sortedListNode = new ListNode();
        ListNode temp = sortedListNode;
        while (!minPQ.isEmpty()) {
            temp.next = new ListNode(minPQ.remove());
            temp = temp.next;
        }
        return sortedListNode.next;
    }

}