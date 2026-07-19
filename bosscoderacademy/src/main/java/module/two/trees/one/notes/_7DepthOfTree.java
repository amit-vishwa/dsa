package module.two.trees.one.notes;

import module.two.trees.BinaryTree;
import module.two.trees.Node;

/**
 * Maximum Depth of Binary Tree:
 * <p>
 * Given the root of a binary tree, return its maximum depth.
 * Input: root = [3, 9, 20, null, null, 15, 7]
 * Output: 3
 * <p>
 * Approach:
 * So, we know the root & its child will be found by Hypothesis. So we go deep inside to its left, then to its right & from
 * there we will get the deepest root to child value of its left & right. We will compare both of them and that will be our
 * Induction which one has the greatest value will be added to 1, as the root will count as well.
 * Now in this, the smallest valid Input could be if the root is null & that's our Base condition.
 * Time complexity: O(N) as we are checking each node.
 * Space complexity: O(H) due to recursion stack
 */
public class _7DepthOfTree {

    public static void main(String[] args) {
        Node node = BinaryTree.createDummyTree();
        node.left.left.left = new Node(1);
        node.left.left.left.left = new Node(0);
        System.out.println(treeDepth(node));
    }

    private static int treeDepth(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(treeDepth(node.left), treeDepth(node.right));
    }

}
