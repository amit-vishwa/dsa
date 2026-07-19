package module.two.bst.notes;

import module.two.bst.Node;

import java.util.ArrayList;

/**
 * Validate Binary Search Tree:
 *
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Example
 * Input: root = [2,1,3]
 * Output: true
 * */
public class _3ValidateBST {

    public static void main(String[] args) {
        Node node = new Node(2);
        node.left = new Node(1);
        node.right = new Node(3);
        System.out.println("Is Binary Search Tree? " + isBST(node));
        node.right = new Node(0);
        System.out.println("Is Binary Search Tree? " + isBST(node));
    }

    /**
     * Approach:
     * - The idea is to use Inorder traversal of a binary search tree generates output, sorted in ascending order.
     * - So generate in order traversal of the  given binary tree and check if the values are sorted or not.
     * - Time Complexity: O(n)
     * - Space Complexity: O(h)
     * */
    private static boolean isBST(Node root) {
        ArrayList<Integer> list = getList(root);
        System.out.println(list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private static ArrayList<Integer> getList(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list = getList(root.left);
        list.add(root.data);
        list.addAll(getList(root.right));
        return list;
    }

}
