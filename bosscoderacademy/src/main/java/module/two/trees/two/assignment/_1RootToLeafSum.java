package module.two.trees.two.assignment;

import module.two.trees.Node;

// Refer: _4SumRootToLeaf.java from package module.two.trees.two.lecture.
public class _1RootToLeafSum {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        System.out.println("Root to leaf sum: " + rootToLeafSum(root));

        root = new Node(4);
        root.left = new Node(9);
        root.left.left = new Node(5);
        root.left.right = new Node(1);
        root.right = new Node(0);
        System.out.println("Root to leaf sum: " + rootToLeafSum(root));
    }

    private static int rootToLeafSum(Node root) {
        return helper(root, 0, new int[]{0});
    }

    private static int helper(Node root, int current, int[] sum) {
        if (root == null) {
            return 0;
        }
        current = current * 10 + root.data;
        helper(root.left, current, sum);
        helper(root.right, current, sum);
        if (root.left == null && root.right == null) {
            sum[0] += current;
            return sum[0];
        }
        return sum[0];
    }

}