package module.two.bst.assignment;

import module.two.bst.Node;
import module.two.bst.BinaryTree;

import java.util.ArrayList;

/**
 * Merge Two BSTs:
 * <p>
 * Given two BSTs, return elements of both BSTs in sorted form.
 * <p>
 * Input:
 * root1 = 5 3 6 2 4
 * root2 = 2 1 3 N N N 7 6
 * Output: 1 2 2 3 3 4 5 6 6 7
 * <p>
 * Constraints:
 * 1 ≤ Number of Nodes ≤ 10^5
 */
public class _3MergeTwoBSTs {

    public static void main(String[] args) {
        Node node1 = new Node(4);
        node1.left = new Node(3);
        node1.left.left = new Node(2);
        node1.right = new Node(5);
        node1.right.right = new Node(6);

        Node node2 = new Node(3);
        node2.left = new Node(2);
        node2.left.left = new Node(1);
        node2.right = new Node(6);
        node2.right.right = new Node(7);
        printMergedTree(node1, node2);
    }

    private static void printMergedTree(Node root1, Node root2) {
        BinaryTree.display(root1, 2);
        BinaryTree.display(root2, 2);
        System.out.println("Merged tree by approach 1: " + approach1(root1, root2));
        System.out.println("Merged tree by approach 2: " + approach2(root1, root2));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce
     * - A simple bruteforce is to inorder traverse tree1 and tree2 and add them in the list.
     * - Now just sort the list and return it.
     * - Time complexity: O(N) for tree1 + O(M) for tree2 + O((N+M)*log(N+M))= O((N+M)*log(N+M))
     * - Space complexity: O(N+M) due to array list.
     */
    private static ArrayList<Integer> approach1(Node root1, Node root2) {
        ArrayList<Integer> list = inorderTraversal(root1);
        list.addAll(inorderTraversal(root2));
        list.sort(null);
        return list;
    }

    /**
     * Approach 2 - Better
     * - This is similar to approach 1, only don't use in-built sort method.
     * - Just merge the already sorted list in a new list.
     * - Time complexity: O(N) for tree1 + O(M) for tree2 = O(N+M)
     * - Space complexity: O(N+M) due to array list.
     */
    private static ArrayList<Integer> approach2(Node root1, Node root2) {
        ArrayList<Integer> list1 = inorderTraversal(root1);
        ArrayList<Integer> list2 = inorderTraversal(root2);
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            list.add(list1.get(i) <= list2.get(j) ? list1.get(i++) : list2.get(j++));
        }
        while (i < list1.size()) {
            list.add(list1.get(i++));
        }
        while (j < list2.size()) {
            list.add(list2.get(j++));
        }
        return list;
    }

    private static ArrayList<Integer> inorderTraversal(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list = inorderTraversal(root.left);
        list.add(root.data);
        list.addAll(inorderTraversal(root.right));
        return list;
    }

}