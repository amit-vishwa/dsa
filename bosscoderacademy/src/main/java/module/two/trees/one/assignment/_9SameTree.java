package module.two.trees.one.assignment;

import module.two.trees.Node;

/**
 * Same Tree:
 * <p>
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 * <p>
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 * <p>
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [0, 100].
 * -1000 <= Node.val <= 1000
 */
public class _9SameTree {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.left = new Node(2);
        node1.right = new Node(3);
        Node node2 = new Node(1);
        node2.left = new Node(2);
        node2.right = new Node(3);
        System.out.println("Are both trees same? " + sameTrees(node1, node2));


        Node node3 = new Node(1);
        node3.left = new Node(2);
        Node node4 = new Node(1);
        node4.right = new Node(3);
        System.out.println("Are both trees same? " + sameTrees(node3, node4));
    }

    /**
     * Approach:
     * - Approach is quite simple, just check if both trees are null then return true.
     * - If only anyone of them is null then just return false.
     * - Now check if data of both node is same then proceed and check for left tree and right tree.
     * - Just return the actual answer returned by them.
     * - Time complexity: O(N) as all nodes are visited maximum thrice.
     * - Space complexity: O(H) due to recursion stack.
     */
    private static boolean sameTrees(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if ((node1 != null && node2 == null) || (node1 == null && node2 != null)) {
            return false;
        }
        return (node1.data == node2.data) && sameTrees(node1.left, node2.left) && sameTrees(node1.right, node2.right);
    }

}