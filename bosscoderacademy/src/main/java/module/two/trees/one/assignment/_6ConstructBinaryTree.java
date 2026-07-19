package module.two.trees.one.assignment;

import java.util.HashMap;

import module.two.trees.Node;
import module.two.trees.BinaryTree;

/**
 * Construct Binary Tree From Inorder And Postorder Traversal:
 * <p>
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the
 * postorder traversal of the same tree, construct and return the binary tree.
 * <p>
 * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * Output: [3,9,20,null,null,15,7]
 * <p>
 * Input: inorder = [-1], postorder = [-1]
 * Output: [-1]
 * <p>
 * Constraints:
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder and postorder consist of unique values.
 * Each value of postorder also appears in inorder.
 * inorder is guaranteed to be the inorder traversal of the tree.
 * postorder is guaranteed to be the postorder traversal of the tree.
 */
public class _6ConstructBinaryTree {

    public static void main(String[] args) {
        BinaryTree.display(binaryTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3}), 1);
    }

    /**
     * Approach:
     * - The approach is simple and quite efficient.
     * - We are storing inorder array values and index in HashMap, along with last index of postorder in array.
     * - Then we are proceeding with building the tree.
     * - First checking if start index exceeds end index, then return null.
     * - Now fetch right most val from postorder array and create a node of it.
     * - Now update postorder index and get middle index using HashMap.
     * - After that just populate right node first with range from mid + 1 till end indices.
     * - Then populate left node first with range from start till mid - 1 indices.
     * - At last just return root.
     * - Time complexity: O(N) as we are traversing the inorder array once then creating the tree.
     * - Space complexity: O(N) due to HashMap.
     */
    private static Node binaryTree(int[] inorder, int[] postorder) {
        int iLen = inorder.length;
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < iLen; i++) {
            inorderMap.put(inorder[i], i);
        }
        int[] pIndex = {iLen - 1};
        return buildTree(postorder, inorderMap, 0, pIndex[0], pIndex);
    }

    private static Node buildTree(int[] postorder, HashMap<Integer, Integer> inorderMap, int start, int end, int[] pIndex) {
        if (start > end) {
            return null;
        }
        int val = postorder[pIndex[0]];
        Node root = new Node(val);
        pIndex[0]--;
        int mid = inorderMap.get(val);
        root.right = buildTree(postorder, inorderMap, mid + 1, end, pIndex);
        root.left = buildTree(postorder, inorderMap, start, mid - 1, pIndex);
        return root;
    }

}