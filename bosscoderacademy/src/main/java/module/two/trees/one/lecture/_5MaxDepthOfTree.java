package module.two.trees.one.lecture;

import module.two.trees.Node;

// Refer _7DepthOfTree.java from package module.two.trees.notes.
public class _5MaxDepthOfTree {

    public static void main(String[] args) {
        Node node1 = new Node(3);
        node1.left = new Node(9);
        node1.right = new Node(20);
        node1.right.left = new Node(15);
        node1.right.right = new Node(7);
        System.out.println(maxDepthOfTree(node1));

        Node node2 = new Node(1);
        node2.right = new Node(2);
        System.out.println(maxDepthOfTree(node2));
    }

    private static int maxDepthOfTree(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(maxDepthOfTree(node.left), maxDepthOfTree(node.right));
    }

}
