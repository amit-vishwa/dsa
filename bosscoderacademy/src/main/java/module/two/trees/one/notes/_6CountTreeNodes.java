package module.two.trees.one.notes;

import module.two.trees.BinaryTree;
import module.two.trees.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Count Complete Tree Nodes:
 * <p>
 * Given the root of a complete binary tree, return the number of the nodes in the tree.
 * <p>
 * Input: root = [1,2,3,4,5,6]
 * Output: 6
 */
public class _6CountTreeNodes {

    public static void main(String[] args) {
        Node head = BinaryTree.createDummyTree();
        head.left.left.left = new Node(1);
        printNodeCount(head);
    }

    private static void printNodeCount(Node node) {
        System.out.println("Node count by approach 1: " + approach1(node));
        System.out.println("Node count by approach 2: " + approach2(node));
        System.out.println("Node count by approach 3: " + approach3(node));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce (BFS)
     * - This is a simple bruteforce approach using breadth first search approach.
     * - Here, we are doing the level order traversal using a queue.
     * - Time complexity: O(N) as we are counting the nodes only once.
     * - Space complexity: O(N) due to queue.
     */
    private static int approach1(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        int nodeCount = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            nodeCount += size;
            while (size > 0) {
                Node temp = queue.poll();
                if (temp != null) {
                    if (temp.left != null) {
                        queue.offer(temp.left);
                    }
                    if (temp.right != null) {
                        queue.offer(temp.right);
                    }
                    size--;
                }
            }
        }
        return nodeCount;
    }

    /**
     * Approach 2 - Bruteforce (DFS)
     * - This is a simple bruteforce approach using depth first search approach.
     * - Here, we are doing the pre-order traversal here.
     * - Time complexity: O(N) as we are counting the nodes only once.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int approach2(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + approach2(node.left) + approach2(node.right);
    }

    /**
     * Approach 3 - Optimal (Tree height)
     * - We know that a binary can have max of 2^(H) - 1 nodes i.e. 2 raised to tree height - 1 for a full tree.
     * - Here, we are calculating the height of left subtree and right subtree.
     * - If both are equal then just return the formula to calculate nodes.
     * - Else, do the recursive call and proceed with the calculation for left subtree and right subtree.
     * - Time complexity: O(log(N)) for calculating nodes * O(log(N)) for height calculation = O((log(N))^2).
     * - Space complexity: O(log(N)) due to recursion stack.
     */
    private static int approach3(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = treeHeight(node, true);
        int rightHeight = treeHeight(node, false);
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        }
        return 1 + approach3(node.left) + approach3(node.right);
    }

    private static int treeHeight(Node node, boolean left) {
        int height = 0;
        while (node != null) {
            height++;
            node = left ? node.left : node.right;
        }
        return height;
    }
}
