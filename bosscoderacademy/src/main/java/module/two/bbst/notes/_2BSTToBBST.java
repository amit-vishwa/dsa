package module.two.bbst.notes;

import module.two.bst.BinaryTree;
import module.two.bst.Node;

import java.util.ArrayList;

/**
 * Normal BST to Balanced BST:
 * <p>
 * Given a Binary Search Tree, modify the given BST such that it is balanced and has the minimum possible height.
 * <p>
 * Example:
 * Input: root = [1,null,2,null,3,null,4,null,null]
 * Output: [2,1,3,null,null,null,4]
 * Explanation: This is not the only correct answer, [3,1,4,null,2] is also correct.
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [1, 104].
 * 1 <= Node.val <= 10^5
 */
public class _2BSTToBBST {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.right = new Node(2);
        root.right.right = new Node(3);
        root.right.right.right = new Node(4);
        BinaryTree.display(root, 4);
        BinaryTree.display(bbst(root), 4);
    }

    /**
     * Approach:
     * - The idea is to traverse the BST in an in-order fashion and store all encountered nodes in a container (array, list,
     * vector, etc.).
     * - The container will be sorted since in order traversal on a BST always visits the nodes in increasing order of their
     * values.
     * - Then construct a height-balanced BST from the sorted nodes.
     * - The idea is to start from the middle element of the sorted array.
     * - That would be our root node of the BST.
     * - All elements before the middle element should go in the left subtree, and all elements after the middle element should
     * go in the right subtree.
     * - We can easily do this recursively, and we will end up with a height-balanced BST.
     * - Time and space complexity is O(N).
     */
    private static Node bbst(Node root) {
        ArrayList<Integer> nodes = nodeList(root);
        return buildBBST(nodes, 0, nodes.size() - 1);
    }

    private static Node buildBBST(ArrayList<Integer> nodes, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start + 1) / 2;
        Node root = new Node(nodes.get(mid));
        root.left = buildBBST(nodes, start, mid - 1);
        root.right = buildBBST(nodes, mid + 1, end);
        return root;
    }

    private static ArrayList<Integer> nodeList(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list = nodeList(root.left);
        list.add(root.data);
        list.addAll(nodeList(root.right));
        return list;
    }

}
