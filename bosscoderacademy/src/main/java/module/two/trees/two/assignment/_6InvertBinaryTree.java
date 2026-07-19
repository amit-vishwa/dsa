package module.two.trees.two.assignment;

import module.two.trees.Node;
import module.two.trees.BinaryTree;

// Refer _11InvertBinaryTree.java from package module.two.trees.one.assignment.
public class _6InvertBinaryTree {

    private static Node tree1() {
        Node root = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(7);
        root.right.left = new Node(6);
        root.right.right = new Node(9);
        return root;
    }

    private static Node tree2() {
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);
        return root;
    }

    public static void main(String[] args) {
        Node root = tree1();
        BinaryTree.display(root, 4);
        invertBinaryTree(root);
        BinaryTree.display(root, 4);

        root = tree2();
        BinaryTree.display(root, 4);
        invertBinaryTree(root);
        BinaryTree.display(root, 4);
    }

    private static void invertBinaryTree(Node root) {
        if (root == null) {
            return;
        }
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
    }

}