package module.two.trees.one.notes;

import module.two.trees.BinaryTree;
import module.two.trees.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Level Order Traversal
 * <p>
 * In level order traversal, the nodes of the tree are visited level by level from left to right:
 * - Visit all the nodes at the current level before moving to the next level.
 * - Typically implemented using a queue to keep track of nodes at the current level.
 * <p>
 * Time complexity: O(N) as all nodes are traversed once.
 * Space complexity: O(N) due to queue, we require it to store child nodes of a node.
 */
public class _4LevelOrderTraversal {

    public static void main(String[] args) {
        printLevelOrderTraversal(BinaryTree.createDummyTree());
    }

    private static void printLevelOrderTraversal(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.data + " -> ");
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
        System.out.println("null");
    }

}
