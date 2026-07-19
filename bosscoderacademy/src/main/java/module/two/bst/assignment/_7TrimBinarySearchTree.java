package module.two.bst.assignment;

import module.two.bst.Node;
import module.two.bst.BinaryTree;

/**
 * Trim a Binary Search Tree:
 * <p>
 * Given the root of a binary search tree and the lowest and highest boundaries as low and high, trim the tree so that all its
 * elements lies in [low, high]. Trimming the tree should not change the relative structure of the elements that will remain in
 * the tree (i.e., any node's descendant should remain a descendant). It can be proven that there is a unique answer.
 * Return the root of the trimmed binary search tree. Note that the root may change depending on the given bounds.
 * <p>
 * Input: root = [1,0,2], low = 1, high = 2
 * Output: [1,null,2]
 * <p>
 * Input: root = [3,0,4,null,2,null,null,1], low = 1, high = 3
 * Output: [3,2,null,1]
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [1, 10^4].
 * 0 <= Node.val <= 10^4
 * The value of each node in the tree is unique.
 * root is guaranteed to be a valid binary search tree.
 * 0 <= low <= high <= 10^4
 */
public class _7TrimBinarySearchTree {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(0);
        root.right = new Node(2);
        BinaryTree.display(trimmedBST(root, 1, 2), 2);

        root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);
        root.left.left = new Node(0);
        root.right.right = new Node(4);
        BinaryTree.display(trimmedBST(root, 1, 3), 2);
    }

    /**
     * Approach:
     * - The approach is simple, just do the initial null check.
     * - Then check if current node lies between given range.
     * - If yes, then populate its left and right nodes.
     * - Else check if node is lower than min, if yes then set its left as null and explore right tree for higher values.
     * - Else set right node as null and explore left side as current node values is greater than high limit.
     * - At last just return the node.
     * - Time complexity: O(N) as we are exploring all nodes here.
     * - Space complexity: O(H) due to recursion stack.
     */
    private static Node trimmedBST(Node root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (low <= root.data && root.data <= high) {
            root.left = trimmedBST(root.left, low, high);
            root.right = trimmedBST(root.right, low, high);
        } else if (root.data < low) {
            root.left = null;
            root = trimmedBST(root.right, low, high);
        } else {
            root.right = null;
            root = trimmedBST(root.left, low, high);
        }
        return root;
    }

}