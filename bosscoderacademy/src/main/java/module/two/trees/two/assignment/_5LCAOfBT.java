package module.two.trees.two.assignment;

import module.two.trees.Node;

/**
 * Lowest Common Ancestor Of A Binary Tree:
 * <p>
 * Given a Binary Tree with all unique values and two nodes value, n1 and n2. The task is to find the lowest common ancestor
 * of the given two nodes. We may assume that either both n1 and n2 are present in the tree or none of them are present.
 * <p>
 * LCA: It is the first common ancestor of both the nodes n1 and n2 from bottom of tree.
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], n1 = 5, n2 = 1
 * Output: 3
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], n1 = 5, n2 = 4
 * Output: 5
 * <p>
 * Constraints:
 * 1 ≤ Number of nodes ≤ 10^5
 * 1 ≤ Data of a node ≤ 10^5
 * <p>
 * Refer _5LCAOfBST.java from package module.two.bst.assignment.
 */
public class _5LCAOfBT {

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(5);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);
        root.right = new Node(1);
        root.right.left = new Node(0);
        root.right.right = new Node(8);
        System.out.println("Lowest Common Ancestor of Binary Tree: " + binaryTreeLCA(root, 5, 1));
        System.out.println("Lowest Common Ancestor of Binary Tree: " + binaryTreeLCA(root, 5, 4));
    }

    private static int binaryTreeLCA(Node root, int n1, int n2) {
        if (root == null) {
            return -1;
        }
        if (root.data == n1 || root.data == n2) {
            return root.data;
        }
        int left = binaryTreeLCA(root.left, n1, n2);
        int right = binaryTreeLCA(root.right, n1, n2);
        if (left != -1 && right != -1) {
            return root.data;
        }
        return left != -1 ? left : right;
    }

}