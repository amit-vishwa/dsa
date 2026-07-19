package module.two.bst.lecture;

import module.two.bst.Node;

/**
 * Maximum Depth or Height of a Binary Tree:
 * <p>
 * Given the root of a binary tree, find the maximum depth of the tree.
 * The maximum depth or height of the tree is the number of edges in the tree from the root to the deepest node.
 */
public class _1HeightOfTree {

    public static void main(String[] args) {
        Node node1 = new Node(12);
        node1.right = new Node(18);
        node1.left = new Node(8);
        node1.left.left = new Node(5);
        node1.left.right = new Node(11);
        System.out.println("Tree height: " + (treeHeight(node1) - 1));
    }

    private static int treeHeight(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(treeHeight(root.left), treeHeight(root.right));
    }

}
