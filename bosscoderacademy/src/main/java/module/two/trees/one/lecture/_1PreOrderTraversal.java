package module.two.trees.one.lecture;

import module.two.trees.BinaryTree;
import module.two.trees.Node;

// Refer _2PreOrderTraversal.java from package module.two.trees.notes.
public class _1PreOrderTraversal {

    public static void main(String[] args) {
        printPreOrderTraversal(BinaryTree.createDummyTree());
        System.out.print("null");
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
