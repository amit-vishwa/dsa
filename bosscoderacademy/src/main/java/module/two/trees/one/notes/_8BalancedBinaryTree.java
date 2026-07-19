package module.two.trees.one.notes;

import module.two.trees.BinaryTree;
import module.two.trees.Node;

/**
 * Balanced Binary Tree:
 * <p>
 * Given a binary tree, determine if it is height-balanced.
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more
 * than one.
 * <p>
 * Example
 * Input: root = [3,9,20, null, null,15,7]
 * Output: true
 */
public class _8BalancedBinaryTree {

    public static void main(String[] args) {
        Node node = BinaryTree.createDummyTree();
        printIfTreeIsBalanced(node);
        node.left.left.left = new Node(1);
        printIfTreeIsBalanced(node);
        node.left.left.left.left = new Node(0);
        printIfTreeIsBalanced(node);
    }

    private static void printIfTreeIsBalanced(Node node) {
        System.out.println("Tree is balanced by approach 1: " + approach1(node));
        System.out.println("Tree is balanced by approach 2: " + approach2(node));
        System.out.println();
    }

    /**
     * Brute Force Method:
     * - For a Balanced Binary Tree, check left subtree height and right subtree height for every node present in the tree.
     * - Hence, traverse the tree recursively and calculate the height of the left and right subtree from every node, and
     * whenever the condition of the Balanced tree is violated, simply return false.
     * - Condition for Balanced Binary Tree: For all Nodes = Absolute( Left Subtree Height – Right Subtree Height ) <= 1
     * - Time complexity: O(N^2) as node can be traversed multiple times.
     * - Space complexity: O(H) due to recursion stack.
     */
    private static boolean approach1(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(treeDepth(node.left) - treeDepth(node.right)) <= 1 && approach1(node.left) && approach1(node.right);
    }

    private static int treeDepth(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(treeDepth(node.left), treeDepth(node.right));
    }

    /**
     * Optimized Approach:
     * - Use post-order traversal.
     * - Since, in postorder traversal, we first traverse the left and right subtrees and then visit the parent node, similarly
     * instead of calculating the height of the left subtree and right subtree every time at the root node, use post-order
     * traversal, and keep calculating the heights of the left and right subtrees and perform the validation.
     * - Time complexity: O(N) as nodes are traversed only once.
     * - Space complexity: O(H) due to recursion stack.
     */
    private static boolean approach2(Node node) {
        return height(node) != -1;
    }

    private static int height(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }

}
