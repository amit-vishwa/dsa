package module.two.bbst.assignment;

import module.two.bst.Node;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Maximum Level Sum of a Binary Tree:
 * <p>
 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
 * Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
 * <p>
 * Input: root = [1,7,0,7,-8,null,null]
 * Output: 2
 * <p>
 * Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
 * Output: 2
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [1, 10^4].
 * -10^5 <= Node.val <= 10^5
 */
public class _5MaxLevelSum {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(7);
        root.left.left = new Node(7);
        root.left.right = new Node(-8);
        root.right = new Node(0);
        System.out.println("Level with max sum of nodes: " + maxLevelSum(root));

        root = new Node(989);
        root.right = new Node(10250);
        root.right.left = new Node(98693);
        root.right.right = new Node(-9388);
        root.right.right.right = new Node(-32127);
        System.out.println("Level with max sum of nodes: " + maxLevelSum(root));
    }

    /**
     * Approach:
     * - The approach is simple, just use level order traversal.
     * - Calculate sum of all nodes at same level and check if it is max, if yes just update the max level.
     * - At last, just return the level with max sum.
     * - Time and space complexity is similar to level order traversal.
     */
    private static int maxLevelSum(Node root) {
        if (root == null) {
            return 0;
        }
        int level = 0, maxLevel = 0, maxSum = Integer.MIN_VALUE;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size(), sum = 0;
            level++;
            while (size > 0) {
                Node node = queue.poll();
                sum += node.data;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            if (sum > maxSum) {
                maxSum = sum;
                maxLevel = level;
            }
        }
        return maxLevel;
    }

}