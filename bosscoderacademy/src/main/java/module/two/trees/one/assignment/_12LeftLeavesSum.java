package module.two.trees.one.assignment;

import module.two.trees.Node;
import module.two.trees.BinaryTree;

/**
 * Sum of Left Leaves:
 * <p>
 * Given the root of a binary tree, return the sum of all left leaves.
 * A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.
 * <p>
 * Input: root = [3,9,20,null,null,15,7] Output: 24
 * Input: root = [1] Output: 0
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [1, 1000].
 * -1000 <= Node.val <= 1000
 */
public class _12LeftLeavesSum {

    public static void main(String[] args) {
        System.out.println("Left leaves sum: " + leftLeavesSum(BinaryTree.createDummyTree()));
    }

    /**
     * Approach:
     * - The approach is simple, if root is null, just return 0 as sum.
     * - Now check if left node is there with no child then add its data in sum, else traverse to left and right nodes.
     * - At last, just return the calculated sum.
     * - Time complexity: O(N) as we are traversing the nodes.
     * - Space complexity: O(H) due to recursion stack.
     */
    private static int leftLeavesSum(Node root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.data;
            } else {
                sum += leftLeavesSum(root.left);
            }
        }
        sum += leftLeavesSum(root.right);
        return sum;
    }

}