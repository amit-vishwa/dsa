package module.two.bst.assignment;

import module.two.bst.Node;
import module.two.bst.BinaryTree;

import java.util.ArrayList;

/**
 * Kth Smallest Element In BST:
 * <p>
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the
 * nodes in the tree.
 * <p>
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 * <p>
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 * <p>
 * Constraints:
 * The number of nodes in the tree is n.
 * 1 <= k <= n <= 10^4
 * 0 <= Node.val <= 10^4
 */
public class _2KthSmallestBSTNode {

    public static void main(String[] args) {
        printKthSmallestNode(BinaryTree.createDummyTree(), 4);
    }

    private static void printKthSmallestNode(Node root, int k) {
        System.out.println(k + "th smallest by approach 1: " + approach1(root, k));
        System.out.println(k + "th smallest by approach 2: " + approach2(root, k));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce
     * - This is a simple bruteforce approach.
     * - We are doing the simple inorder traversal first.
     * - Adding all the node values in a list.
     * - Then just returning the K-1 index from the list.
     * - Time complexity: O(N) as we are traversing over the whole tree.
     * - Space complexity: O(N) due to array list.
     */
    private static int approach1(Node root, int k) {
        ArrayList<Integer> nodeDataList = getNodeDataList(root);
        return nodeDataList.isEmpty() || k > nodeDataList.size() ? -1 : nodeDataList.get(k - 1);
    }

    private static ArrayList<Integer> getNodeDataList(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> nodeDataList = getNodeDataList(root.left);
        nodeDataList.add(root.data);
        nodeDataList.addAll(getNodeDataList(root.right));
        return nodeDataList;
    }

    /**
     * Approach 2 - Optimal
     * - This is a simple optimal solution.
     * - Just pass K as array value and a variable as answer array.
     * - Do the inorder traversal, and while visiting the node, just reduce K array value.
     * - If it reached to 0, then just return the node data.
     * - Time complexity: O(H) as we are traversing the left tree first.
     * - Space complexity: O(H) due to recursion stack.
     */
    private static int approach2(Node root, int k) {
        int[] ans = {-1};
        helper(root, new int[]{k}, ans);
        return ans[0];
    }

    private static void helper(Node root, int[] k, int[] ans) {
        if (root == null) {
            return;
        }
        helper(root.left, k, ans);
        k[0]--;
        if (k[0] == 0) {
            ans[0] = root.data;
            return;
        }
        helper(root.right, k, ans);
    }

}