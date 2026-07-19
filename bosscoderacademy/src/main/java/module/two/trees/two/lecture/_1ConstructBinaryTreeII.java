package module.two.trees.two.lecture;

import module.two.trees.BinaryTree;
import module.two.trees.Node;

import java.util.HashMap;

// Refer _8ConstructBinaryTreeII.java from package module.two.trees.one.assignment.
public class _1ConstructBinaryTreeII {

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
        return constructTree(inorderMap, preorder, 0, iLen - 1, pIndex);
    }

    private static Node constructTree(HashMap<Integer, Integer> inorderMap, int[] preorder, int start, int end, int[] pIndex) {
        if (start > end) {
            return null;
        }
        int val = preorder[pIndex[0]];
        Node root = new Node(val);
        int mid = inorderMap.get(val);
        pIndex[0]++;
        root.left = constructTree(inorderMap, preorder, start, mid - 1, pIndex);
        root.right = constructTree(inorderMap, preorder, mid + 1, end, pIndex);
        return root;
    }

}
