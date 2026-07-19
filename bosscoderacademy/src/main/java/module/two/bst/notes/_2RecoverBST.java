package module.two.bst.notes;

import module.two.bst.BinarySearchTree;
import module.two.bst.Node;

import java.util.ArrayList;

/**
 * Recover Binary Search Tree:
 *
 * You are given the root of a binary search tree (BST), where the values of exactly two tree nodes were swapped by mistake.
 * Recover the tree without changing its structure.
 *
 * Example
 * Input: root = [1,3, null, null,2]
 * Output: [3,1, null, null,2]
 * */
public class _2RecoverBST {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.left.right = new Node(2);
        printBst(root);

        Node root2 = new Node(3);
        root2.left = new Node(1);
        root2.right = new Node(4);
        root2.right.left = new Node(2);
        printBst(root2);
    }

    private static void printBst(Node root) {
//        approach1(root);
        approach2(root);
    }

    /**
     * Approach 1 - Bruteforce
     * - The in-order traversal of a BST produces a sorted array.
     * - So a simple method is to store in-order traversal of the input tree in an auxiliary array.
     * - Sort the auxiliary array.
     * - Finally, insert the auxiliary array elements back into the BST, keeping the structure of the BST same.
     * - Time complexity: O(N) for getting list + O(N*log(N)) for sorting + O(N) for correcting BST = O(N*log(N))
     * - Space complexity: O(N) due to list
     */
    private static void approach1(Node root) {
        System.out.println("Approach 1 solution:");
        BinarySearchTree.display(root, 2);
        ArrayList<Integer> nodeList = getNodeList(root);
        nodeList.sort(null);
        correctBST(root, nodeList, new int[]{0});
        BinarySearchTree.display(root, 2);
        System.out.println();
    }

    private static void correctBST(Node root, ArrayList<Integer> nodeList, int[] index) {
        if (root == null) {
            return;
        }
        correctBST(root.left, nodeList, index);
        root.data = nodeList.get(index[0]++);
        correctBST(root.right, nodeList, index);
    }

    private static ArrayList<Integer> getNodeList(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list = getNodeList(root.left);
        list.add(root.data);
        list.addAll(getNodeList(root.right));
        return list;
    }

    /**
     * Approach 2 - Optimized
     * - Perform an inorder traversal of the tree.
     * - Track:
     * i.prev — the previously visited node.
     * ii.first — the first node where violation occurs (prev.val > curr.val).
     * iii.second — the node being visited at violation.
     * - There can be one or two violations depending on whether the swapped nodes are adjacent or not.
     * - After identifying both nodes, simply swap their values.
     * - Time complexity: O(N) as nodes are visited once.
     * - Space complexity: O(H) due to recursion stack.
     */
    private static void approach2(Node root) {
        System.out.println("Approach 2 solution:");
        BinarySearchTree.display(root, 2);
        Node[] refs = new Node[3]; // prev, first, second
        correctTree(root, refs);
        swapNodes(refs);
        BinarySearchTree.display(root, 2);
        System.out.println();
    }

    private static void correctTree(Node root, Node[] refs) {
        if (root == null) {
            return;
        }
        correctTree(root.left, refs);
        // prev is not null and greater than root
        if (refs[0] != null && refs[0].data > root.data) {
            if (refs[1] == null) { // first is null
                refs[1] = refs[0]; // then store prev in first
            }
            refs[2] = root; // always update second with root
        }
        refs[0] = root; // always update prev with root
        correctTree(root.right, refs);
    }

    private static void swapNodes(Node[] refs) {
        if (refs[1] != null && refs[2] != null) {
            int temp = refs[1].data;
            refs[1].data = refs[2].data;
            refs[2].data = temp;
        }
    }

}
