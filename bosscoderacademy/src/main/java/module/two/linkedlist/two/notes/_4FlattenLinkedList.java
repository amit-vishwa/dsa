package module.two.linkedlist.two.notes;

/**
 * Flattening a Linked List:
 * <p>
 * Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:
 * <p>
 * (i) a next pointer to the next node,
 * <p>
 * (ii) a bottom pointer to a linked list where this node is headed.
 * <p>
 * Each of the sub-linked-list is in sorted order.
 * <p>
 * Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order.
 * <p>
 * Example
 * Input: Number of head nodes = 4
 * Array holding length of each list with head and bottom = [4,2,3,4]
 * Elements of entire linked list = [5,7,8,30,10,20,19,22,50,28,35,40,45]
 * Output: [5,7,8,10,19,20,22,28,30,35,40,45,50]
 * <p>
 * Refer: https://www.geeksforgeeks.org/problems/flattening-a-linked-list/1
 */
public class _4FlattenLinkedList {

    static class NewNode {
        int data;
        NewNode next;
        NewNode bottom;

        public NewNode(int data) {
            this.data = data;
            this.next = null;
            this.bottom = null;
        }
    }

    private static void display(NewNode head) {
        NewNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.bottom;
        }
        System.out.println("null");
    }

    private static NewNode createInput() {
        NewNode head = new NewNode(5);
        head.bottom = new NewNode(7);
        head.bottom.bottom = new NewNode(8);
        head.bottom.bottom.bottom = new NewNode(30);

        head.next = new NewNode(10);
        head.next.bottom = new NewNode(20);

        head.next.next = new NewNode(19);
        head.next.next.bottom = new NewNode(22);
        head.next.next.bottom.bottom = new NewNode(50);

        head.next.next.next = new NewNode(28);
        head.next.next.next.bottom = new NewNode(35);
        head.next.next.next.bottom.bottom = new NewNode(40);
        head.next.next.next.bottom.bottom.bottom = new NewNode(45);

        return head;
    }

    public static void main(String[] args) {
        display(flattenLinkedList(createInput()));
    }

    /**
     * Approach:
     * - Each list, followed by the bottom pointer, is in sorted order.
     * - Our main aim is to make a single list in the sorted order of all nodes.
     * - So, we can think of a merge algorithm of merge sort.
     * - The process to flatten the given linked list is as follows will recurse until the head pointer moves null.
     * - The main motive is to merge each list from the last.
     * - Merge each list chosen using the merge algorithm.
     * - The steps are to Create a dummy node.
     * - Point two pointers, i.e, temp and res on dummy node. res is to keep track of the dummy node and the temp pointer is
     * to move ahead as we build the flattened list.
     * - We iterate through the two chosen. Move head from any of the chosen lists ahead whose current pointed node is smaller.
     * - Return the new flattened list found.
     * - Time Complexity: O(N)
     * - Space Complexity: O(1)
     */
    private static NewNode flattenLinkedList(NewNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = flattenLinkedList(head.next); // traverse till last bucket
        head = mergeList(head, head.next); // take 2 buckets
        return head;
    }

    private static NewNode mergeList(NewNode left, NewNode right) {
        NewNode merged = new NewNode(0);
        NewNode temp = merged;
        while (left != null && right != null) {
            if (left.data <= right.data) {
                temp.bottom = left; // store data at bottom
                left = left.bottom; // traverse at bottom
            } else {
                temp.bottom = right;
                right = right.bottom;
            }
            temp = temp.bottom; // proceed with storing data at bottom
        }
        temp.bottom = (left != null) ? left : right;
        return merged.bottom;
    }

}