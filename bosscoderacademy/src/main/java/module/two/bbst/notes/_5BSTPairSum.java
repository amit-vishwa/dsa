package module.two.bbst.notes;

import module.two.bst.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Find a pair with the given sum in BST:
 * <p>
 * Given a BST and a sum, find if there is a pair with the given sum.
 * <p>
 * Example
 * <p>
 * Input:  sum = 28, tree = {15, 10, 8, 1220, 16, 25}
 * Output: 16,12
 */
public class _5BSTPairSum {

    public static void main(String[] args) {
        Node node = new Node(15);
        node.left = new Node(10);
        node.left.left = new Node(8);
        node.left.right = new Node(12);
        node.right = new Node(20);
        node.right.left = new Node(16);
        node.right.right = new Node(25);
        printIfPairSumExist(node, 28);
        printIfPairSumExist(node, 38);
        printIfPairSumExist(node, 41);
    }

    private static void printIfPairSumExist(Node root, int target) {
        System.out.println("Pair sum exist by approach 1: " + Arrays.toString(approach1(root, target)));
        System.out.println("Pair sum exist by approach 2: " + Arrays.toString(approach2(root, target)));
        System.out.println();
    }

    /**
     * Approach 1:
     * - This is an approach using 2 pointers.
     * - We are first doing the inorder traversal to create a sorted list.
     * - After that we are using the 2 pointers approach to find the pair sum.
     * - Time complexity: O(N) while creating the arraylist and traversing using 2 pointers.
     * - Space complexity: O(N) due to arraylist.
     */
    private static int[] approach1(Node root, int target) {
        ArrayList<Integer> nodeDataList = inOrderTraversal(root);
        int i = 0, j = nodeDataList.size() - 1;
        while (i < j) {
            int nodeData1 = nodeDataList.get(i), nodeData2 = nodeDataList.get(j);
            int sum = nodeData1 + nodeData2;
            if (sum == target) {
                return new int[]{nodeData1, nodeData2};
            }
            if (target > sum) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * Approach 2:
     * - This is almost similar to approach 1 in terms of complexities.
     * - We are just using hashset and traversing the tree using inorder traversal.
     * - First we are checking if complement exists in set.
     * - If it exists then return complement and current data.
     * - Else just add data in the set and traverse right.
     * - Time and space complexity is similar to approach 1.
     */
    private static int[] approach2(Node root, int target) {
        int[] res = {-1, -1};
        helper(root, target, new HashSet<Integer>(), res);
        return res;
    }

    private static void helper(Node root, int target, HashSet<Integer> set, int[] res) {
        if (root == null) {
            return;
        }
        helper(root.left, target, set, res);
        int complement = target - root.data;
        if (set.contains(complement)) {
            res[0] = complement;
            res[1] = root.data;
            return;
        }
        set.add(root.data);
        helper(root.right, target, set, res);
    }

    private static ArrayList<Integer> inOrderTraversal(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> nodeDataList = inOrderTraversal(root.left);
        nodeDataList.add(root.data);
        nodeDataList.addAll(inOrderTraversal(root.right));
        return nodeDataList;
    }

}
