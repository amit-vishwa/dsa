package module.two.trees.one.notes;

import module.two.trees.BinaryTree;
import module.two.trees.Node;

/**
 * Inorder Traversal:
 * <p>
 * In inorder traversal, the nodes of the tree are visited in this order:
 * - Traverse the left subtree in inorder.
 * - Visit the root node.
 * - Traverse the right subtree in inorder.
 * <p>
 * Time complexity: O(N) as all nodes are traversed once.
 * Space complexity: O(1) as no extra space is used here.
 */
public class _1InOrderTraversal {

    public static void main(String[] args) {
        printInOrderTraversal(BinaryTree.createDummyTree());
        System.out.println("null");
    }

    private static void printInOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        printInOrderTraversal(root.left);
        System.out.print(root.data + " -> ");
        printInOrderTraversal(root.right);
    }

}
