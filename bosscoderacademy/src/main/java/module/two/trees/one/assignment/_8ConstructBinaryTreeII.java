package module.two.trees.one.assignment;

import java.util.HashMap;

import module.two.trees.Node;
import module.two.trees.BinaryTree;

/**
 * Construct Binary Tree From Preorder And Inorder Traversal:
 * <p>
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the
 * inorder traversal of the same tree, construct and return the binary tree.
 * <p>
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * <p>
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 * <p>
 * Constraints:
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder and inorder consist of unique values.
 * Each value of inorder also appears in preorder.
 * preorder is guaranteed to be the preorder traversal of the tree.
 * inorder is guaranteed to be the inorder traversal of the tree.
 * <p>
 * Approach: It is quite similar to _6ConstructBinaryTree.java
 */
public class _8ConstructBinaryTreeII {

    public static void main(String[] args) {
        BinaryTree.display(binaryTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}), 3);
    }

    private static Node binaryTree(int[] preorder, int[] inorder) {
        int iLen = inorder.length;
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < iLen; i++) {
            inorderMap.put(inorder[i], i);
        }
        int[] pIndex = {0};
        return buildTree(preorder, inorderMap, 0, iLen - 1, pIndex);
    }

    private static Node buildTree(int[] preorder, HashMap<Integer, Integer> inorderMap, int start, int end, int[] pIndex) {
        if (start > end) {
            return null;
        }
        int val = preorder[pIndex[0]];
        Node root = new Node(val);
        pIndex[0]++;
        int mid = inorderMap.get(val);
        root.left = buildTree(preorder, inorderMap, start, mid - 1, pIndex);
        root.right = buildTree(preorder, inorderMap, mid + 1, end, pIndex);
        return root;
    }

}