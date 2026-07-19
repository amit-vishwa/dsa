package module.two.bbst.notes;

import module.two.bst.BinaryTree;
import module.two.bst.Node;

/**
 * Invert Binary Tree:
 * <p>
 * Given the root of a binary tree, invert the tree, and return its root.
 * <p>
 * Example 1:
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 * <p>
 * Example 2:
 * Input: root = [2,1,3]
 * Output: [2,3,1]
 * <p>
 * Example 3:
 * Input: root = []
 * Output: []
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */
public class _4InvertBinaryTree {

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(7);
        root.right.left = new Node(6);
        root.right.right = new Node(9);
        BinaryTree.display(root, 4);
        BinaryTree.display(invertBinaryTree(root), 4);
    }

    /**
     * Approach:
     * - In this question, we have to Invert the binary tree.
     * - So we use Post Order Traversal in which first we go in the Left subtree and then in the Right subtree then we return
     * to the Parent node.
     * - When we come back to the parent node we swap its Left subtree and Right subtree.
     * - Time complexity: O(N)
     * - Space complexity: O(H) due to recursion stack.
     */
    private static Node invertBinaryTree(Node root) {
        if (root == null) {
            return null;
        }
        Node leftSubtree = invertBinaryTree(root.left);
        Node rightSubtree = invertBinaryTree(root.right);
        root.right = leftSubtree;
        root.left = rightSubtree;
        return root;
    }

}
