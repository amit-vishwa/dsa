package module.two.bst.assignment;

import module.two.bst.Node;

/**
 * Lowest Common Ancestor Of A Binary Search Tree:
 * <p>
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
 * <p>
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], n1 = 2, n2 = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * <p>
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], n1 = 2, n2 = 4
 * Output: 2
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [2, 10^5].
 * -10^9 <= Node.val <= 10^9
 * All Node.val are unique.
 * n1 != n2
 * n1 and n2 will exist in the BST.
 */
public class _5LCAOfBST {

    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(2);
        root.left.left = new Node(0);
        root.left.right = new Node(4);
        root.left.right.left = new Node(3);
        root.left.right.right = new Node(5);
        root.right = new Node(8);
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        System.out.println("Lowest Common Ancestor of BST: " + lowestCommonAncestor(root, 2, 8));
        System.out.println("Lowest Common Ancestor of BST: " + lowestCommonAncestor(root, 2, 4));
        System.out.println("Lowest Common Ancestor of BST: " + lowestCommonAncestor(root, 0, 5));
    }

    /**
     * Approach:
     * - The approach is quite similar, we have to return -1 when root is null.
     * - Now if node data is equal to p or q then just return the node data.
     * - Explore left and right subtrees and store them in the variables.
     * - If both are not -1 then just return the node data, it is the LCA.
     * - At last, just return the left if it is not -1 else return right.
     * - Time complexity: O(N) as we may have to explore every node.
     * - Space complexity: O(H) due to recursion stack.
     */
    private static int lowestCommonAncestor(Node root, int p, int q) {
        if (root == null) {
            return -1;
        }
        if (root.data == p || root.data == q) {
            return root.data;
        }
        int left = lowestCommonAncestor(root.left, p, q);
        int right = lowestCommonAncestor(root.right, p, q);
        if (left != -1 && right != -1) {
            return root.data;
        }
        return left != -1 ? left : right;
    }

}