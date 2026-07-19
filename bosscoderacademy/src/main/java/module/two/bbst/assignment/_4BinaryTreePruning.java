package module.two.bbst.assignment;

import module.two.bst.Node;
import module.two.bst.BinaryTree;

/**
 * Binary Tree Pruning:
 * <p>
 * Given the root of a binary tree, return the same tree where every subtree (of the given tree) not containing a 1 has been
 * removed.
 * A subtree of a node is node plus every node that is a descendant of node.
 * <p>
 * Input: root = [1,null,0,0,1]
 * Output: [1,null,0,null,1]
 * <p>
 * Input: root = [1,0,1,0,0,0,1]
 * Output: [1,null,1,null,1]
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [1, 200].
 * Node.val is either 0 or 1.
 */
public class _4BinaryTreePruning {

    public static void main(String[] args) {
        BinaryTree.display(binaryTreePruning(tree1()), 4);
        BinaryTree.display(binaryTreePruning(tree2()), 4);
        BinaryTree.display(binaryTreePruning(tree3()), 4);
    }

    private static Node tree1() {
        Node root = new Node(1);
        root.right = new Node(0);
        root.right.left = new Node(0);
        root.right.right = new Node(1);
        return root;
    }

    private static Node tree2() {
        Node root = new Node(1);
        root.left = new Node(0);
        root.left.left = new Node(0);
        root.left.right = new Node(0);
        root.right = new Node(1);
        root.right.left = new Node(0);
        root.right.right = new Node(1);
        return root;
    }

    private static Node tree3() {
        Node root = new Node(1);
        root.left = new Node(1);
        root.left.left = new Node(1);
        root.left.right = new Node(1);
        root.left.left.left = new Node(0);
        root.right = new Node(0);
        root.right.left = new Node(0);
        root.right.right = new Node(1);
        return root;
    }

    /**
     * Approach:
     * - The approach is quite simple here.
     * - Just do the post order traversal and when a leaf node is found having data as 0, just return null else return node.
     * - Time complexity: O(N) as we are traversing all nodes.
     * - Space complexity: O(H) due to recursive stack.
     */
    private static Node binaryTreePruning(Node root) {
        if (root == null) {
            return null;
        }
        root.left = binaryTreePruning(root.left);
        root.right = binaryTreePruning(root.right);
        return (root.left == null && root.right == null && root.data == 0) ? null : root;
    }

}