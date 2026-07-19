package module.two.bst.notes;

import module.two.bst.BinarySearchTree;
import module.two.bst.Node;

/**
 * Inorder Successor in BST:
 * <p>
 * Given a BST, and a reference to a Node x in the BST. Find the In order Successor of the given node in the BST.
 * In the Binary Tree, the Inorder successor of a node is the next node in the Inorder traversal of the Binary Tree.
 * Inorder Successor is NULL for the last node in Inorder traversal.
 * <p>
 * Example
 * In the below diagram, inorder successor of 8 is 10, inorder successor of 10 is 12 and inorder successor of 14 is 20.
 */
public class _4InOrderSuccessor {

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        BinarySearchTree.display(root, 1);
        System.out.println("In order successor of 22 is " + inOrderSuccessor(root, 22));
        System.out.println("In order successor of 14 is " + inOrderSuccessor(root, 14));
        System.out.println("In order successor of 4 is " + inOrderSuccessor(root, 4));
    }

    /**
     * Approach:
     * - We follow the idea of normal BST Search. In BST search, we get closer to the key by comparing with the current node.
     * - So the last greater key visited during search is the successor.
     * - The following cases arise during the search.
     * - If we reach null, then the given target does not exist, we return null
     * - If current node matches the target and right child is not empty, then successor is leftmost node in right subtree.
     * - If current node is greater, then it is a potential successor, we mark it as successor and proceed to left
     * - If current node is smaller or equal to the target, we proceed to right.
     * - Time complexity: O(H) similar to binary search
     * - Space complexity: O(1) as no extra or auxiliary space is used here.
     */
    private static int inOrderSuccessor(Node root, int target) {
        if (root == null) {
            return -1;
        }
        if (root.data == target) {
            return leftMost(root.right);
        }
        Node successor = null;
        Node temp = root;
        while (temp != null) {
            if (temp.data > target) {
                successor = temp;
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return successor != null ? successor.data : -1;
    }

    private static int leftMost(Node root) {
        if (root == null) {
            return -1;
        }
        Node temp = root;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp.data;
    }

}
