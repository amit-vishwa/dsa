package module.two.trees.one.assignment;

import module.two.trees.Node;
import module.two.trees.BinaryTree;

/**
 * Path Sum:
 * <p>
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding
 * up all the values along the path equals targetSum.
 * A leaf is a node with no children.
 * <p>
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * Output: true
 * <p>
 * Input: root = [1,2,3], targetSum = 5
 * Output: false
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [0, 5000].
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */
public class _10PathSum {

    public static void main(String[] args) {
        System.out.println("Is path sum exist? " + pathSum(BinaryTree.createDummyTree(), 19));
        System.out.println("Is path sum exist? " + pathSum(BinaryTree.createDummyTree(), 220));
        System.out.println("Is path sum exist? " + pathSum(BinaryTree.createDummyTree(), 10));
        System.out.println("Is path sum exist? " + pathSum(BinaryTree.createDummyTree(), 41));
    }

    /**
     * Approach:
     * - The approach is simple, just keep on reducing the target and when reached a leaf node, just check if target is 0.
     * - Time complexity: O(N) when target achieved after traversing all nodes.
     * - Space complexity: O(H) due to recursion stack.
     */
    private static boolean pathSum(Node root, int target) {
        if (root == null) {
            return target == 0;
        }
        return pathSum(root.left, target - root.data) || pathSum(root.right, target - root.data);
    }

}