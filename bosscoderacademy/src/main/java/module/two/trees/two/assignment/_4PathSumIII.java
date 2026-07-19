package module.two.trees.two.assignment;

import module.two.trees.Node;

// Refer _6PathSumIII.java from package module.two.trees.two.notes.
public class _4PathSumIII {

    private static Node tree1() {
        Node root = new Node(10);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(2);
        root.left.right.right = new Node(1);
        root.left.left.left = new Node(3);
        root.left.left.right = new Node(-2);
        root.right = new Node(-3);
        root.right.right = new Node(11);
        return root;
    }

    private static Node tree2() {
        Node root = new Node(5);
        root.left = new Node(4);
        root.left.left = new Node(11);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(2);
        root.right = new Node(8);
        root.right.left = new Node(13);
        root.right.right = new Node(4);
        root.right.right.left = new Node(5);
        root.right.right.right = new Node(1);
        return root;
    }

    public static void main(String[] args) {
        System.out.println("Path count: " + pathCount(tree1(), 8));
        System.out.println("Path count: " + pathCount(tree1(), 11));
        System.out.println("Path count: " + pathCount(tree2(), 22));
    }

    private static int pathCount(Node root, int targetSum) {
        return helper(root, targetSum, new int[]{0});
    }

    private static int helper(Node root, int targetSum, int[] pathCount) {
        if (root == null) {
            return 0;
        }
        updatePathCount(root, targetSum, pathCount);
        helper(root.left, targetSum, pathCount);
        helper(root.right, targetSum, pathCount);
        return pathCount[0];
    }

    private static void updatePathCount(Node root, int targetSum, int[] pathCount) {
        if (root == null) {
            return;
        }
        if (root.data == targetSum) {
            pathCount[0]++;
        }
        updatePathCount(root.left, targetSum - root.data, pathCount);
        updatePathCount(root.right, targetSum - root.data, pathCount);
    }

}