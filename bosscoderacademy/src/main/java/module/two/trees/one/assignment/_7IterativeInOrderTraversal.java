package module.two.trees.one.assignment;

import java.util.Stack;
import java.util.ArrayList;

import module.two.trees.Node;
import module.two.trees.BinaryTree;

/**
 * Inorder Traversal Without Recursion:
 * <p>
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 * <p>
 * Input: root = [1]
 * Output: [1]
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */
public class _7IterativeInOrderTraversal {

    public static void main(String[] args) {
        System.out.println("Iterative inorder traversal: " + iterativeTraversal(BinaryTree.createDummyTree()));
    }

    /**
     * Approach:
     * - The is quite similar approach as we have for level order traversal, here we are using Stack.
     * - For in order, we are first traversing all left nodes and pushing them in Stack.
     * - After that, we are popping and visiting top most node from stack and proceeding with right node, if any.
     * - We are repeating this process and adding all node data in the list.
     * - Time complexity: O(N) as all nodes can be visited max thrice.
     * - Space complexity: O(H) as we are storing max height in Stack.
     */
    private static ArrayList<Integer> iterativeTraversal(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<Node> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.data);
            root = root.right;
        }
        return list;
    }

}