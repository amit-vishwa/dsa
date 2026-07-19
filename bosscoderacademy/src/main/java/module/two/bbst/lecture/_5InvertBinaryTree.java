package module.two.bbst.lecture;

import module.two.bst.BinaryTree;
import module.two.bst.Node;

// Refer _11InvertBinaryTree.java from package module.two.trees.one.assignment.
public class _5InvertBinaryTree {

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(7);
        root.right.left = new Node(6);
        root.right.right = new Node(9);
        BinaryTree.display(root, 4);
        invertTree(root);
        BinaryTree.display(root, 4);
    }

    private static void invertTree(Node root) {
        if (root == null) {
            return;
        }
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
    }

}
