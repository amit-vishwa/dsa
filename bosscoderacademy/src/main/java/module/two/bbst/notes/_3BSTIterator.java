package module.two.bbst.notes;

import module.two.bst.Node;

import java.util.Stack;

/**
 * Binary Search Tree Iterator:
 * <p>
 * Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):
 * BSTIterator(TreeNode root) Initialises an object of the BSTIterator class. The root of the BST is given as part of the
 * constructor. The pointer should be initialised to a non-existent number smaller than any element in the BST.
 * <p>
 * boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns
 * false.
 * <p>
 * int next() Moves the pointer to the right, then returns the number at the pointer.
 * <p>
 * Example
 * Input: ["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
 * [[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
 * <p>
 * Output: [null, 3, 7, true, 9, true, 15, true, 20, false]
 */
public class _3BSTIterator {

    static class BSTIterator1 {
        Stack<Node> stack;

        public BSTIterator1(Node root) {
            this.stack = new Stack<>();
            this.pushAllLeft(root);
        }

        private void pushAllLeft(Node root) {
            while (root != null) {
                this.stack.push(root);
                root = root.left;
            }
        }

        public int next() {
            if (!hasNext()) {
                return -1;
            }
            Node top = this.stack.pop();
            int val = top.data;
            if (top.right != null) {
                this.pushAllLeft(top.right);
            }
            return val;
        }

        public boolean hasNext() {
            return !this.stack.isEmpty();
        }
    }

    static class BSTIterator2 {
        Stack<Node> stack;

        public BSTIterator2(Node root) {
            this.stack = new Stack<>();
            this.pushAllLeft(root);
        }

        private void pushAllLeft(Node root) {
            if (root == null) {
                return;
            }
            this.stack.push(root);
            pushAllLeft(root.left);
        }

        public int next() {
            if (!hasNext()) {
                return -1;
            }
            Node top = this.stack.pop();
            int val = top.data;
            if (top.right != null) {
                this.pushAllLeft(top.right);
            }
            return val;
        }

        public boolean hasNext() {
            return !this.stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        iterativeApproach();
        recursiveApproach();
    }

    /**
     * Approach 1:
     * - We can solve this problem using the stack data structure.
     * - We will make use of the stack and instead of in-order traversal, we will use partial in-order traversal so that at
     * any instant of time the stack contains elements equal to the height of the tree.
     * - Time complexity: O(N) as we are adding all nodes in stack
     * - Space complexity: O(N) due to stack.
     */
    private static void iterativeApproach() {
        System.out.println("Iterative approach:");
        Node root = new Node(7);
        root.left = new Node(3);
        root.right = new Node(15);
        root.right.left = new Node(9);
        root.right.right = new Node(20);
        BSTIterator1 bstIterator1 = new BSTIterator1(root);
        System.out.println(bstIterator1.next());  // Output: 3
        System.out.println(bstIterator1.next());  // Output: 7
        System.out.println(bstIterator1.hasNext());  // Output: true
        System.out.println(bstIterator1.next());  // Output: 9
        System.out.println(bstIterator1.hasNext());  // Output: true
        System.out.println(bstIterator1.next());  // Output: 15
        System.out.println(bstIterator1.hasNext());  // Output: true
        System.out.println(bstIterator1.next());  // Output: 20
        System.out.println(bstIterator1.hasNext());  // Output: false
        System.out.println();
    }

    /**
     * Approach 2:
     * - We can solve this problem using the stack data structure.
     * - For pushing all nodes at left we are using recursion here.
     * - Time complexity: O(N) as we are adding all nodes in stack
     * - Space complexity: O(N) due to stack.
     */
    private static void recursiveApproach() {
        System.out.println("Recursive approach:");
        Node root = new Node(7);
        root.left = new Node(3);
        root.right = new Node(15);
        root.right.left = new Node(9);
        root.right.right = new Node(20);
        BSTIterator2 bstIterator2 = new BSTIterator2(root);
        System.out.println(bstIterator2.next());  // Output: 3
        System.out.println(bstIterator2.next());  // Output: 7
        System.out.println(bstIterator2.hasNext());  // Output: true
        System.out.println(bstIterator2.next());  // Output: 9
        System.out.println(bstIterator2.hasNext());  // Output: true
        System.out.println(bstIterator2.next());  // Output: 15
        System.out.println(bstIterator2.hasNext());  // Output: true
        System.out.println(bstIterator2.next());  // Output: 20
        System.out.println(bstIterator2.hasNext());  // Output: false
        System.out.println();
    }

}
