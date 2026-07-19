package module.two.trees.one.lecture;

import module.two.trees.BinaryTree;
import module.two.trees.Node;

// Refer _1InOrderTraversal.java from module.two.trees.notes.
public class _2InOrderTraversal {

    public static void main(String[] args) {
        printPreOrderTraversal(BinaryTree.createDummyTree());
        System.out.print("null");
    }

    private static void printPreOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        printPreOrderTraversal(node.left);
        System.out.print(node.data + " -> ");
        printPreOrderTraversal(node.right);
    }

}
