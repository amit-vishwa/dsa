package module.two.trees.two.notes;

import module.two.trees.Node;

import java.util.ArrayList;

/**
 * Path Sum from root to leaf:
 * <p>
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in
 * the path equals targetSum. Each path should be returned as a list of the node values, not node references.A root-to-leaf
 * path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
 * <p>
 * Example
 * Input: root = [5,4,8,11, null,13,4,7,2, null, null,5,1], targetSum = 22
 * Output: [[5,4,11,2],[5,8,4,5]]
 * <p>
 * Refer: https://leetcode.com/problems/path-sum-ii/description/
 */
public class _4PathSumI {

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(4);
        root.left.left = new Node(11);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(2);
        root.right = new Node(8);
        root.right.left = new Node(13);
        root.right.right = new Node(4);
        root.right.right.left = new Node(5);
        root.right.right.right = new Node(1);
        System.out.println("Root to leaf path whose sum is target: " + targetSumPathList(root, 22));
    }

    private static ArrayList<ArrayList<Integer>> targetSumPathList(Node root, int target) {
        return helper(root, target, new ArrayList<>());
    }

    /**
     * Approach:
     * - The approach is not so much straightforward.
     * - We are using a helper method here with root node, target value and a list to track path.
     * - Now if root is null, just return the empty list.
     * - For current node, check if left and right both are null, if yes then proceed with path logic.
     * - Add current node data in path, reduce if from target, check if target is 0, if yes then consider that path and
     * after doing backtrack just return the path list.
     * - For all nodes, just add node data to path and explore left and right paths with updated target sum.
     * - After that just do backtrack by removing the node data from path.
     * - At last, just return the path list.
     * - Time complexity: O(N) as we are traversing all nodes.
     * - Space complexity: O(H) due to recursion stack.
     */
    private static ArrayList<ArrayList<Integer>> helper(Node root, int target, ArrayList<Integer> path) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> pathList = new ArrayList<>();
        if (root.left == null && root.right == null) {
            path.add(root.data);
            target -= root.data;
            if (target == 0) {
                pathList.add(new ArrayList<>(path));
            }
            path.removeLast();
            return pathList;
        }
        path.add(root.data);
        pathList.addAll(helper(root.left, target - root.data, path));
        pathList.addAll(helper(root.right, target - root.data, path));
        path.removeLast();
        return pathList;
    }

}
