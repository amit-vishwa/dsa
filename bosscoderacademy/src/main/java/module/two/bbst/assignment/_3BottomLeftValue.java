package module.two.bbst.assignment;

import module.two.bst.Node;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Find Bottom Left Tree Value:
 * <p>
 * Given the root of a binary tree, return the leftmost value in the last row of the tree.
 * <p>
 * Input: root = [2,1,3]
 * Output: 1
 * <p>
 * Input: root = [1,2,3,4,null,5,6,null,null,7]
 * Output: 7
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [0, 10000].
 * -10000 <= Node.val <= 10000
 */
public class _3BottomLeftValue {

    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);
        System.out.println("Bottom left most value: " + bottomLeftValue(root));

        root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.right = new Node(3);
        root.right.left = new Node(5);
        root.right.left.left = new Node(7);
        root.right.right = new Node(6);
        System.out.println("Bottom left most value: " + bottomLeftValue(root));
    }

    /**
     * Approach:
     * - The approach is quite simple, just do the level order traversal and consider first in queue as left most.
     * - Time complexity: O(N) as we are traversing the nodes.
     * - Space complexity: O(Max(Level,Depth)) due to queue.
     */
    private static int bottomLeftValue(Node root) {
        if (root == null) {
            return -1;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int leftmostValue = root.data;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i == 0) {
                    leftmostValue = node.data;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return leftmostValue;
    }

}
