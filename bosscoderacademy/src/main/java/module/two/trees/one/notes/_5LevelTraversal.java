package module.two.trees.one.notes;

import module.two.trees.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Print level order traversal line by line:
 * <p>
 * Given the root of a binary tree, The task is to print level order traversal so that nodes of all levels are printed in
 * separate lines.
 * <p>
 * Approach:
 * The idea is to keep a queue that stores nodes of the current level. Starting from the root, calculate the size of the queue
 * size and for each one of the size nodes enqueues its children to queue and print the node. After printing the size nodes of
 * every iteration print a line break.
 * Follow the below steps to Implement the idea: Initialise a queue q. Push root in q while q is not empty. Create a variable
 * nodeCount = q.size(). while (nodeCount > 0). Create temporary node node *node = q.front() and print node->data. Pop a front
 * element from q if node->left != NULL push node->left in q. If node->right != NULL push node->right in q.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class _5LevelTraversal {

    public static void main(String[] args) {
        printLevelTraversalLineByLine(createInput());
    }

    private static void printLevelTraversalLineByLine(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Node temp = queue.poll();
                System.out.print(temp.data + " -> ");
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
                size--;
            }
            System.out.println("null");
        }
    }

    private static Node createInput() {
        Node node = new Node(20);

        node.left = new Node(8);
        node.left.left = new Node(4);
        node.left.left.left = new Node(10);

        node.right = new Node(22);
        node.right.right = new Node(12);
        node.right.right.right = new Node(14);

        return node;
    }

}
