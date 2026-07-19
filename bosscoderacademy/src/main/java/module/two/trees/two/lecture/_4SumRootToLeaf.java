package module.two.trees.two.lecture;

import module.two.trees.Node;

import java.util.ArrayList;

/**
 * Refer: https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
 */
public class _4SumRootToLeaf {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        printSumRootToLeaf(node);

        node = new Node(4);
        node.left = new Node(9);
        node.left.left = new Node(5);
        node.left.right = new Node(1);
        node.right = new Node(0);
        printSumRootToLeaf(node);
    }

    private static void printSumRootToLeaf(Node root) {
        System.out.println("Sum of root to leaf by approach 1: " + approach1(root));
        System.out.println("Sum of root to leaf by approach 2: " + approach2(root));
        System.out.println();
    }

    /**
     * Approach 1:
     * - The approach is simple, we are just adding the concatenated node data in a list.
     * - Then we are iterating over the list to return the sum.
     * - Time complexity: O(N) as we are traversing all nodes.
     * - Space complexity: O(N) due to arraylist.
     */
    private static int approach1(Node root) {
        return helper1(root, 0).stream().mapToInt(Integer::intValue).sum();
    }

    private static ArrayList<Integer> helper1(Node root, int current) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> sumList = new ArrayList<>();
        current = current * 10 + root.data;
        if (root.left == null && root.right == null) {
            sumList.add(current);
        }
        sumList.addAll(helper1(root.left, current));
        sumList.addAll(helper1(root.right, current));
        return sumList;
    }

    /**
     * Approach 2:
     * - This is more efficient than approach 1.
     * - We are checking if we reached null or visited leaf node, if yes then simply return.
     * - We are also updating concatenated node data in a number.
     * - Then we are checking if current node if leaf or not, if yes then simply add concatenated number in a cumulative sum.
     * - Simply traverse left and right.
     * - Time complexity: O(N) as we are traversing all nodes.
     * - Space complexity: O(H) due to recursive stack.
     */
    private static int approach2(Node root) {
        int[] ans = {0};
        helper2(root, ans, 0);
        return ans[0];
    }

    private static void helper2(Node root, int[] ans, int current) {
        if (root == null) {
            return;
        }
        current = current * 10 + root.data;
        if (root.left == null && root.right == null) {
            ans[0] += current;
            return;
        }
        helper2(root.left, ans, current);
        helper2(root.right, ans, current);
    }

}
