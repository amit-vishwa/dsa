package module.two.trees.two.notes;

import module.two.trees.Node;

/**
 * Path Sum from root to any node:
 * <p>
 * Check if path sum exist from root to leaf nodes, return true if yes else return false.
 * <p>
 * Example:
 * Input: root = [5,4,8,11, null,13,4,7,2, null, null,5,1], targetSum = 22
 * Output: true
 * <p>
 * Example:
 * Input: root = [5,4,8,11, null,13,4,7,2, null, null,5,1], targetSum = 5
 * Output: false
 * <p>
 * Time Complexity: O(N)
 * Space Complexity: O(H)
 * <p>
 * Refer: https://leetcode.com/problems/path-sum/description/
 */
public class _5PathSumII {

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(4);
        root.left.left = new Node(11);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(2);
        root.right = new Node(8);
        root.right.left = new Node(13);
        root.right.right = new Node(4);
        root.right.right.left = new Node(5);
        root.right.right.right = new Node(1);
        System.out.println("Has path sum? " + hasPathSum(root, 22));
        System.out.println("Has path sum? " + hasPathSum(root, 5));
    }

    private static boolean hasPathSum(Node root, int target) {
        if (root == null) {
            return target == 0;
        }
        return hasPathSum(root.left, target - root.data) || hasPathSum(root.right, target - root.data);
    }

}
