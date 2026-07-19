package module.two.trees.two.lecture;

import module.two.trees.Node;
import module.two.trees.BinaryTree;

import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 * Binary Tree Right Side View:
 * <p>
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can
 * see ordered from top to bottom.
 * <p>
 * Example 1:
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 * <p>
 * Example 2:
 * Input: root = [1,2,3,4,null,null,null,5]
 * Output: [1,3,4,5]
 * <p>
 * Example 3:
 * Input: root = [1,null,3]
 * Output: [1,3]
 * <p>
 * Example 4:
 * Input: root = []
 * Output: []
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */
public class _3RightSideView {

    public static void main(String[] args) {
        Node node = BinaryTree.createDummyTree();
        node.left.left.left = new Node(1);
        printRightSideTreeView(node);

        Node node1 = new Node(1);
        node1.left = new Node(2);
        node1.left.right = new Node(5);
        node1.right = new Node(3);
        node1.right.right = new Node(4);
        printRightSideTreeView(node1);

        Node node2 = new Node(1);
        node2.left = new Node(2);
        node2.right = new Node(3);
        node2.left.left = new Node(4);
        node2.left.left.left = new Node(5);
        printRightSideTreeView(node2);
    }

    /**
     * Approach:
     * - Similar to level order traversal, only when size of queue left is 1 then add data in the list as it is right
     * side view.
     * - Time and space complexity is O(N).
     */
    private static void printRightSideTreeView(Node root) {
        if (root == null) {
            return;
        }
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Node node = queue.poll();
                if (size == 1) {
                    list.add(node.data);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
        }
        System.out.println("Right view: " + list);
    }

}
