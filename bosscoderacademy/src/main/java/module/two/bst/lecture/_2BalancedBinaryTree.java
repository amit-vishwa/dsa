package module.two.bst.lecture;

import module.two.bst.Node;

/**
 * Refer: https://leetcode.com/problems/balanced-binary-tree/description/
 * */
public class _2BalancedBinaryTree {

    public static void main(String[] args) {
        Node node1 = new Node(3);
        node1.left = new Node(9);
        node1.right = new Node(20);
        node1.right.left = new Node(15);
        node1.right.right = new Node(7);
        System.out.println("Is binary tree balanced? " + balancedBinaryTree(node1));

        Node node2 = new Node(1);
        node2.left = new Node(2);
        node2.right = new Node(2);
        node2.left.left = new Node(3);
        node2.left.right = new Node(3);
        node2.left.left.left = new Node(4);
        node2.left.left.right = new Node(4);
        System.out.println("Is binary tree balanced? " + balancedBinaryTree(node2));

        System.out.println("Is binary tree balanced? " + balancedBinaryTree(null));
    }

    private static boolean balancedBinaryTree(Node root) {
        return height(root) != -1;
    }

    private static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        if (left == -1) {
            return -1;
        }
        int right = height(root.right);
        if (right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return 1 + Math.max(left, right);
    }

}
