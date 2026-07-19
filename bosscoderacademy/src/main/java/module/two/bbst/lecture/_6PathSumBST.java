package module.two.bbst.lecture;

import module.two.bst.Node;

// Refer https://leetcode.com/problems/path-sum/description/
public class _6PathSumBST {

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(2);
        root.left.right = new Node(3);
        root.left.left = new Node(-2);
        root.left.left.right = new Node(1);
        root.left.left.left = new Node(-2);
        root.right = new Node(10);
        root.right.right = new Node(11);
        System.out.println(isPathSumExist(root, 4));
        System.out.println(isPathSumExist(root, 3));
    }

    private static boolean isPathSumExist(Node root, int targetSum) {
        if (root == null) {
            return targetSum == 0;
        }
        return targetSum < root.data ? isPathSumExist(root.left, targetSum - root.data)
                : isPathSumExist(root.right, targetSum - root.data);
    }

}
