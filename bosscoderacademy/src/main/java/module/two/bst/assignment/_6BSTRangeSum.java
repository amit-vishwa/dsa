package module.two.bst.assignment;

import module.two.bst.Node;

/**
 * Range Sum Of BST:
 * <p>
 * Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a
 * value in the inclusive range [low, high].
 * <p>
 * Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
 * Output: 32
 * Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.
 * <p>
 * Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * Output: 23
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [1, 2 * 10^4].
 * 1 <= Node.val <= 10^5
 * 1 <= low <= high <= 10^5
 * All Node.val are unique.
 */
public class _6BSTRangeSum {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right = new Node(15);
        root.right.right = new Node(18);
        printRangeSum(root, 7, 15);
        printRangeSum(root, 7, 18);
    }

    private static void printRangeSum(Node root, int low, int high) {
        System.out.println(rangeSum(root, low, high));
    }

    /**
     * Approach:
     * - The approach is quite simple, just go to the left most part of the tree i.e. minimum element.
     * - Now check if current node data falls under low and high ranges, add them if yes.
     * - At last, just return the cumulative sum.
     * - Time complexity: O(N) as we are exploring all the nodes.
     * - Space complexity: O(H) due to recursion stack.
     */
    private static int rangeSum(Node root, int low, int high) {
        int[] ans = {0};
        helper(root, low, high, ans);
        return ans[0];
    }

    private static void helper(Node root, int low, int high, int[] ans) {
        if (root == null) {
            return;
        }
        helper(root.left, low, high, ans);
        if (low <= root.data && root.data <= high) {
            ans[0] += root.data;
        }
        helper(root.right, low, high, ans);
    }

}