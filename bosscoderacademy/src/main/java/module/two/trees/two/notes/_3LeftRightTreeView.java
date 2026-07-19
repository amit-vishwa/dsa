package module.two.trees.two.notes;

import module.two.trees.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Left And Right View:
 * <p>
 * Given a binary tree find its left and right view.
 * <p>
 * Input:
 * 1
 * /        \
 * 2          3
 * /  \       /  \
 * 4   5      7   8
 * <p>
 * Output:
 * Left View: 1 2 4
 * Right View: 1 3 8
 * Explanation:
 * When the tree is viewed from the left side, then the nodes which are visible is 1 2 4.
 * When the tree is viewed from the right side, then the nodes which are visible is 1 3 8.
 * <p>
 * Input:
 * 1
 * /         \
 * 2            3
 * \         /   \
 * 4      5      6
 * \
 * 7
 * Output:
 * Left View: 1 2 4 7
 * Right View: 1 3 6 7
 * <p>
 * Refer: https://www.geeksforgeeks.org/dsa/left-and-right-view-of-a-generic-tree/
 */
public class _3LeftRightTreeView {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(7);
        root.right.right = new Node(8);
        printLeftRightView(root);

        root = new Node(1);
        root.left = new Node(2);
        root.left.right = new Node(4);
        root.left.right.right = new Node(7);
        root.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        printLeftRightView(root);
    }

    /**
     * Approach:
     * - The approach is quite simple, just do the level order traversal.
     * - Store left most in left view list and right most in right view list.
     * - At last, just return the answer.
     * - Time complexity: O(N) are we are traversing all nodes.
     * - Space complexity: O(Max(level)) due to queue.
     */
    private static void printLeftRightView(Node root) {
        ArrayList<Integer> leftView = new ArrayList<>();
        ArrayList<Integer> rightView = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 1; i <= size; i++) {
                Node node = queue.poll();
                if (i == 1) {
                    leftView.add(node.data);
                }
                if (i == size) {
                    rightView.add(node.data);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        System.out.println("Left view: " + leftView);
        System.out.println("Right view: " + rightView);
        System.out.println();
    }

}
