package module.two.bbst.notes;

import module.two.bst.BinaryTree;
import module.two.bst.Node;

/**
 * Array to BST:
 * <p>
 * Given a sorted array. Convert it into a Height Balanced Binary Search Tree (BST). Find the preorder traversal of
 * height-balanced BST. If there exist many such balanced BST consider the tree whose preorder is lexicographically smallest.
 * <p>
 * Example
 * Input: array = {1, 2, 3, 4}
 * Output: {2, 1, 3, 4}
 */
public class _1SortedArrayToBST {

    public static void main(String[] args) {
        BinaryTree.display(binarySearchTree(new int[]{1, 2, 3, 4}), 4);
    }

    /**
     * Approach:
     * - Set The middle element of the array as root.
     * - Recursively do the same for the left half and right half.
     * - Get the middle of the left half and make it the left child of the root created in step 1.
     * - Get the middle of the right half and make it the right child of the root created in step 1.
     * - Print the preorder of the tree.
     * - Time complexity: O(N) are we are traversing whole array
     * - Space complexity: O(H) due to recursion stack
     */
    private static Node binarySearchTree(int[] arr) {
        return buildTree(arr, 0, arr.length - 1);
    }

    private static Node buildTree(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start + 1) / 2;
        Node root = new Node(arr[mid]);
        root.left = buildTree(arr, start, mid - 1);
        root.right = buildTree(arr, mid + 1, end);
        return root;
    }

}
