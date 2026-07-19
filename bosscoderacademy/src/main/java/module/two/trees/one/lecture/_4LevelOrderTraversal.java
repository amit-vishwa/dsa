package module.two.trees.one.lecture;

import module.two.trees.BinaryTree;
import module.two.trees.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 102. Binary Tree Level Order Traversal:
 * <p>
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 * <p>
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 * <p>
 * Example 2:
 * Input: root = [1]
 * Output: [[1]]
 * <p>
 * Example 3:
 * Input: root = []
 * Output: []
 * <p>
 * Time and space complexity: O(N)
 * <p>
 * Refer: https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 */
public class _4LevelOrderTraversal {

    public static void main(String[] args) {
        Node node = new Node(3);
        node.left = new Node(9);
        node.right = new Node(20);
        node.right.left = new Node(15);
        node.right.right = new Node(7);
        System.out.println(levelOrderTraversal(node));

        System.out.println(levelOrderTraversal(new Node(1)));
        System.out.println(levelOrderTraversal(null));
    }

    private static ArrayList<ArrayList<Integer>> levelOrderTraversal(Node node) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        if (node == null) {
            return resultList;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> result = new ArrayList<>();
            while (size > 0) {
                Node front = queue.remove();
                result.add(front.data);
                if (front.left != null) {
                    queue.add(front.left);
                }
                if (front.right != null) {
                    queue.add(front.right);
                }
                size--;
            }
            resultList.add(result);
        }
        return resultList;
    }

}
