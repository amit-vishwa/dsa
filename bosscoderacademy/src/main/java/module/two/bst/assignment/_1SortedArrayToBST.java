package module.two.bst.assignment;

import module.two.bst.Node;
import module.two.bst.BinaryTree;

/**
 * Convert Sorted Array To Binary Search Tree:
 * <p>
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 * <p>
 * Input: nums = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * <p>
 * Input: nums = [1,3]
 * Output: [3,1]
 * <p>
 * Constraints:
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums is sorted in a strictly increasing order.
 */
public class _1SortedArrayToBST {

    public static void main(String[] args) {
        printBinarySearchTree(new int[]{-10, -3, 0, 5, 9});
        printBinarySearchTree(new int[]{1, 3});
    }

    /**
     * Approach:
     * - The approach is quite simple.
     * - Since, we already have a sorted array we have to find the mid and make it as root.
     * - Then populate the left node by traversing left side of the array.
     * - And populate right node by traversing right side of the array.
     * - At last just return the root node.
     * - Time complexity: O(N) as we are iterating over all array elements to construct BST.
     * - Space complexity: O(1) as we do not require any extra space here.
     */
    private static void printBinarySearchTree(int[] arr) {
        Node root = buildTree(arr, 0, arr.length - 1);
        BinaryTree.display(root, 2);
    }

    private static Node buildTree(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start + 1) / 2; // to handle edge cases
        Node root = new Node(arr[mid]);
        root.left = buildTree(arr, start, mid - 1);
        root.right = buildTree(arr, mid + 1, end);
        return root;
    }

}