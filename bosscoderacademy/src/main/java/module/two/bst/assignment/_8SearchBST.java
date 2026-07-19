package module.two.bst.assignment;

import module.two.bst.Node;
import module.two.bst.BinaryTree;

/**
 * Search in a Binary Search Tree:
 * <p>
 * You are given the root of a binary search tree (BST) and an integer val.
 * Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does
 * not exist, return null.
 * <p>
 * Input: root = [4,2,7,1,3], val = 2
 * Output: [2,1,3]
 * <p>
 * Input: root = [4,2,7,1,3], val = 5
 * Output: []
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [1, 5000].
 * 1 <= Node.val <= 10^7
 * root is a binary search tree.
 * 1 <= val <= 10^7
 */
public class _8SearchBST {

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(7);
        BinaryTree.display(binarySearchTree(root, 2), 2);
    }

    /**
     * Approach:
     * - The approach is quite simple here.
     * - We are just doing a normal search in BST, it is similar to binary search.
     * - Time complexity: O(H) as we are search from root to leaf.
     * - Space complexity: O(H) due to recursion stack.
     */
    private static Node binarySearchTree(Node root, int val) {
        if (root == null || root.data == val) {
            return root;
        }
        return val < root.data ? binarySearchTree(root.left, val) : binarySearchTree(root.right, val);
    }

}