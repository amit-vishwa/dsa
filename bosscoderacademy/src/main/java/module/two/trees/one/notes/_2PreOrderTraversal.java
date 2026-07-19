package module.two.trees.one.notes;

import module.two.trees.BinaryTree;
import module.two.trees.Node;

/**
 * PreOrder Traversal
 * <p>
 * In preorder traversal, the nodes of the tree are visited in this order:
 * - Visit the root node.
 * - Traverse the left subtree in preorder.
 * - Traverse the right subtree in preorder.
 * <p>
 * Time complexity: O(N) as all node are traversed only once.
 * Space complexity: O(1) as no extra space is used here.
 */
public class _2PreOrderTraversal {

    public static void main(String[] args) {
        printPreOrderTraversal(BinaryTree.createDummyTree());
        System.out.println("null");
    }

    private static void printPreOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " -> ");
        printPreOrderTraversal(node.left);
        printPreOrderTraversal(node.right);
    }

}
