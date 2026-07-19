package module.two.trees.two.notes;

import module.two.trees.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Top View of Binary Tree:
 * <p>
 * Given below is a binary tree. The task is to print the top view of a binary tree. The top view of a binary tree is the set of
 * nodes visible when the tree is viewed from the top.
 * <p>
 * Examples:
 * <p>
 * Input: root = [1, 2, 3]
 * Output: [2, 1, 3]
 * Explanation: The Green colored nodes represents the top view in the below Binary tree.
 * <p>
 * Input: root = [10, 20, 30, 40, 60, 90, 100]
 * Output: [40, 20, 10, 30, 100]
 * Explanation: The Green colored nodes represents the top view in the below Binary tree.
 * <p>
 * Refer: https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1
 */
public class _2TopViewOfTree {

    private static Node tree1() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        return root;
    }

    private static Node tree2() {
        Node root = new Node(10);
        root.left = new Node(20);
        root.left.left = new Node(40);
        root.left.right = new Node(60);
        root.right = new Node(30);
        root.right.left = new Node(90);
        root.right.right = new Node(100);
        return root;
    }

    public static void main(String[] args) {
        System.out.println("Top view of binary tree: " + topView(tree1()));
        System.out.println("Top view of binary tree: " + topView(tree2()));
    }

    /**
     * Approach:
     * - The approach is quite similar to vertical level order traversal.
     * - Create a treemap that will store level and the first node data that appears from top.
     * - The queue will store the pair of node and vertical level.
     * - Now, do the level order traversal.
     * - During traversal, just poll the first node from queue.
     * - Check if current level exist in treemap, if not then only add level and node data.
     * - Now add left and right nodes in the queue if they exist.
     * - After traversal using queue, just return all the values.
     * - Time and space complexity is O(N).
     */
    private static ArrayList<Integer> topView(Node root) {
        TreeMap<Integer, Integer> levelNodeDataMap = new TreeMap<>();
        Queue<Pair<Node, Integer>> nodeLevelPairQueue = new LinkedList<>();
        nodeLevelPairQueue.offer(new Pair<>(root, 0));
        while (!nodeLevelPairQueue.isEmpty()) {
            Pair<Node, Integer> nodeLevelPair = nodeLevelPairQueue.poll();
            levelNodeDataMap.computeIfAbsent(nodeLevelPair.value, nodeData -> nodeLevelPair.key.data);
            if (nodeLevelPair.key.left != null) {
                nodeLevelPairQueue.offer(new Pair<>(nodeLevelPair.key.left, nodeLevelPair.value - 1));
            }
            if (nodeLevelPair.key.right != null) {
                nodeLevelPairQueue.offer(new Pair<>(nodeLevelPair.key.right, nodeLevelPair.value + 1));
            }
        }
        return new ArrayList<>(levelNodeDataMap.values());
    }

}
