package module.two.trees.one.assignment;

import module.two.trees.Node;
import module.two.trees.BinaryTree;

// Refer _7DepthOfTree.java from package module.two.trees.notes.
public class _3MaxDepthOfTree {

    public static void main(String[] args) {
        Node node = BinaryTree.createDummyTree();
        node.left.left.left = new Node(1);
        System.out.println("Maximum depth of tree is " + maxDepth(node));
    }

    private static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}