package module.two.bbst.lecture;

import module.two.bst.Node;

// Refer https://leetcode.com/problems/path-sum/description/
public class _4PathSum {

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(4);
        root.left.left = new Node(11);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(2);
        root.right = new Node(8);
        root.right.left = new Node(13);
        root.right.right = new Node(4);
        root.right.right.right = new Node(1);
        System.out.println(isPathSumExist(root, 22));
    }

    private static boolean isPathSumExist(Node root, int targetSum) {
        if (root == null) {
            return targetSum == 0;
        }
        targetSum -= root.data;
        return isPathSumExist(root.left, targetSum) || isPathSumExist(root.right, targetSum);
    }

}
