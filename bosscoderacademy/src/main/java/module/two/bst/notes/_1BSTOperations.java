package module.two.bst.notes;

import module.two.bst.BinarySearchTree;
import module.two.bst.Node;

/**
 * Binary Search Tree:
 *
 * A Binary Search Tree (BST) is a binary tree that maintains a specific order property, making it efficient for searching,
 * insertion, and deletion operations.
 *
 * Here are the basics of a BST:
 * Definition
 * A Binary Search Tree is a binary tree where each node has the following properties:
 * - Node Structure: Each node contains a key (or value), a reference to the left child, and a reference to the right child.
 * - Ordering Property: For each node:
 * --> All keys in the left subtree are less than the node's key.
 * --> All keys in the right subtree are greater than the node's key.
 * - No Duplicate Nodes: Typically, BSTs do not allow duplicate values. Each key must be unique.
 *
 * Insertion in BST
 * To insert any element in BST.
 * - Start from the root.
 * - Compare the inserting element with the root, if it is less than the root, then recursively call the left subtree, else
 * recursively call the right subtree.
 * - After reaching the end, just insert that node at left(if less than current) or right.
 * - Time Complexity: O(n)
 * - Space Complexity: O(h)
 *
 * Deletion in BST
 * To delete an element from BST. Three case arises
 * - The node to be deleted is the leaf: Simply remove it from the tree.
 * - The node to be deleted has only one child: Copy the child to the node and delete the child
 * - The node to be deleted has two children: Find in order successor of the node. Copy contents of the in-order successor to
 * the node and delete the in-order successor.
 * - Time Complexity: O(n)
 * - Space Complexity: O(h)
 * */
public class _1BSTOperations {

    public static void main(String[] args) {
        printBstOperations();
    }

    private static void printBstOperations() {
        Node tree = getTree();
        BinarySearchTree.display(tree, 1);
        System.out.print("Adding 10 in BST: ");
        new BinarySearchTree().insert(tree, 10);
        BinarySearchTree.display(tree, 1);

        System.out.print("Deleting 8 from BST: ");
        tree = new BinarySearchTree().delete(tree, 8);
        BinarySearchTree.display(tree, 1);

        System.out.print("Deleting 15 from BST: ");
        tree = new BinarySearchTree().delete(tree, 15);
        BinarySearchTree.display(tree, 1);

        System.out.print("Deleting 20 from BST: ");
        tree = new BinarySearchTree().delete(tree, 20);
        BinarySearchTree.display(tree, 1);

        System.out.print("Deleting 5 from BST: ");
        tree = new BinarySearchTree().delete(tree, 5);
        BinarySearchTree.display(tree, 1);

        System.out.print("Deleting 54 from BST: ");
        tree = new BinarySearchTree().delete(tree, 54);
        BinarySearchTree.display(tree, 1);

        System.out.print("Deleting 54 from BST: ");
        tree = new BinarySearchTree().delete(tree, 54);
        BinarySearchTree.display(tree, 1);
    }

    private static Node getTree() {
        Node root = new Node(15);
        root.left = new Node(12);
        root.right = new Node(54);
        root.left.left = new Node(8);
        root.left.right = new Node(13);
        root.left.left.left = new Node(5);
        root.right.left = new Node(20);
        return root;
    }

}
