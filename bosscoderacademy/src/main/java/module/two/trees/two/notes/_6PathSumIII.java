package module.two.trees.two.notes;

import module.two.trees.Node;

/**
 * Path Sum from any source to any node:
 * <p>
 * Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the
 * path equals targetSum.The path does not need to start or end at the root or a leaf, but it must go downwards (i.e.,
 * traveling only from parent nodes to child nodes).
 * <p>
 * Example
 * Input: root = [10,5,-3,3,2, null,11,3,-2, null,1], targetSum = 8
 * Output: 3
 * <p>
 * Refer: https://leetcode.com/problems/path-sum-iii/description/
 */
public class _6PathSumIII {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(2);
        root.left.right.right = new Node(1);
        root.left.left.left = new Node(3);
        root.left.left.right = new Node(-2);

        root.right = new Node(-3);
        root.right.right = new Node(11);
        System.out.println("Path count: " + pathCount(root, 8));
        System.out.println("Path count: " + pathCount(root, 11));
        System.out.println("Path count: " + pathCount(root, 3));
        System.out.println("Path count: " + pathCount(root, -3));
        System.out.println("Path count: " + pathCount(root, 22));
    }

    /**
     * Approach:
     * - The approach is not much straightforward.
     * - We have to use a helper function to get the path count whose sum is equal to target.
     * - First start from current node, go downwards and update path count if target sum found.
     * - Now do the same for left and right subtree.
     * - At last, we have the path count whose sum is target.
     * - Time complexity: O(N^2) as we are going downwards and all nodes are visited multiple times like nested loops.
     * - Space complexity: O(H) due to recursive stack.
     */
    private static int pathCount(Node root, int target) {
        int[] ans = {0};
        return helper(root, target, new int[]{0});
    }

    private static int helper(Node root, int target, int[] ans) {
        if (root == null) {
            return 0;
        }
        updateCount(root, target, ans);
        helper(root.left, target, ans);
        helper(root.right, target, ans);
        return ans[0];
    }

    private static void updateCount(Node root, int target, int[] ans) {
        if (root == null) {
            return;
        }
        if (root.data == target) {
            ans[0]++;
        }
        updateCount(root.left, target - root.data, ans);
        updateCount(root.right, target - root.data, ans);
    }

}
