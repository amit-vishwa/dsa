package module.two.trees.one.notes;

import module.two.trees.BinaryTree;
import module.two.trees.Node;

/**
 * Postorder Traversal
 * <p>
 * In postorder traversal, the nodes of the tree are visited in this order:
 * - Traverse the left subtree in postorder.
 * - Traverse the right subtree in postorder.
 * - Visit the root node.
 * <p>
 * Time complexity: O(N) as all nodes are traversed once.
 * Space complexity: O(1) as no extra space is used here.
 */
public class _3PostOrderTraversal {

    public static void main(String[] args) {
        printPostOrderTraversal(BinaryTree.createDummyTree());
        System.out.println("null");
    }

    private static void printPostOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        printPostOrderTraversal(node.left);
        printPostOrderTraversal(node.right);
        System.out.print(node.data + " -> ");
    }

}
