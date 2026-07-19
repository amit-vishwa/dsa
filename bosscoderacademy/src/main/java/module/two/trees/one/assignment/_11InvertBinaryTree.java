package module.two.trees.one.assignment;

import module.two.trees.Node;
import module.two.trees.BinaryTree;

/**
 * Invert Binary Tree:
 * <p>
 * Given the root of a binary tree, invert the tree, and return its root.
 * <p>
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 * <p>
 * Input: root = [2,1,3]
 * Output: [2,3,1]
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */
public class _11InvertBinaryTree {

    public static void main(String[] args) {
        BinaryTree.display(BinaryTree.createDummyTree(), 1);
        BinaryTree.display(invertTree(BinaryTree.createDummyTree()), 1);
    }

    /**
     * Approach:
     * - The approach is simple, just return null when root is null.
     * - Now store left and right nodes in temp variables.
     * - After that just update left and right nodes of current node as the desired result.
     * - At last, just return the inverted tree.
     * - Time complexity: O(N) as we are traversing all the nodes.
     * - Space complexity: O(H) due to recursion stack.
     */
    private static Node invertTree(Node root) {
        if (root == null) {
            return root;
        }
        Node left = invertTree(root.left);
        Node right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

}