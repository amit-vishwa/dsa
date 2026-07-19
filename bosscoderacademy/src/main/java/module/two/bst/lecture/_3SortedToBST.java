package module.two.bst.lecture;

import module.two.bst.BinaryTree;
import module.two.bst.Node;

/**
 * Refer: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 */
public class _3SortedToBST {

    public static void main(String[] args) {
        BinaryTree.display(createBst(new int[]{-10, -3, 0, 5, 9}), 4);
    }

    private static Node createBst(int[] arr) {
        return binarySearchTree(arr, 0, arr.length - 1);
    }

    /**
     * Approach:
     * - The approach is quite simple, here we are calculating the middle index.
     * - Then storing the value as root data.
     * - After that we are calculating the left node and right node by passing the indices to calculate mid-index.
     * - Time complexity: O(N) as we are traversing the whole array.
     * - Space complexity: O(H) due to recursion stack.
     */
    private static Node binarySearchTree(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        Node root = new Node(arr[mid]);
        root.left = binarySearchTree(arr, start, mid - 1);
        root.right = binarySearchTree(arr, mid + 1, end);
        return root;
    }

}
