package module.two.trees.two.lecture;

import module.two.trees.BinaryTree;
import module.two.trees.Node;

import java.util.*;

/**
 * Binary Tree Zigzag Level Order Traversal:
 * <p>
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right,
 * then right to left for the next level and alternate between).
 * <p>
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
 * <p>
 * Example 2:
 * Input: root = [1]
 * Output: [[1]]
 * <p>
 * Example 3:
 * Input: root = []
 * Output: []
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [0, 2000].
 * -100 <= Node.val <= 100
 */
public class _2ZigzagLevelOrderTraversal {

    public static void main(String[] args) {
        zigzagTraversal(BinaryTree.createDummyTree());
    }

    /**
     * Approach:
     * - The approach is little tricky here, we have to use ArrayDeque and a boolean flag.
     * - First keep the flag as false and add root node in deque.
     * - Now proceed with normal flow of level order traversal.
     * - But check if flag is true or false.
     * - If it is false, then flow is normal i.e. poll from first and add at last.
     * - Else, add at first and poll from last.
     * - Keep on adding node data in the list and display that at last.
     * - Time complexity: O(N) as we are visiting all nodes.
     * - Space complexity: O(max(level)) as deque will have max level nodes.
     */
    private static void zigzagTraversal(Node root) {
        if (root == null) {
            return;
        }
        ArrayList<ArrayList<Integer>> levels = new ArrayList<>();
        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(root);
        boolean reverse = false;
        while (!deque.isEmpty()) {
            int size = deque.size();
            ArrayList<Integer> level = new ArrayList<>();
            while (size > 0) {
                Node node = reverse ? deque.pollLast() : deque.pollFirst();
                level.add(node.data);
                if (reverse) {
                    if (node.right != null) {
                        deque.offerFirst(node.right);
                    }
                    if (node.left != null) {
                        deque.offerFirst(node.left);
                    }
                } else {
                    if (node.left != null) {
                        deque.offerLast(node.left);
                    }
                    if (node.right != null) {
                        deque.offerLast(node.right);
                    }
                }
                size--;
            }
            levels.add(level);
            reverse = !reverse;
        }
        System.out.println("Zigzag level order traversal: " + levels);
    }

}
