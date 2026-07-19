package module.two.bbst.assignment;

import java.util.Stack;

/**
 * Minimum Cost Tree From Leaf Values:
 * <p>
 * Given an array arr of positive integers, consider all binary trees such that:
 * <p>
 * Each node has either 0 or 2 children;
 * The values of arr correspond to the values of each leaf in an in-order traversal of the tree.
 * The value of each non-leaf node is equal to the product of the largest leaf value in its left and right subtree, respectively.
 * <p>
 * Among all possible binary trees considered, return the smallest possible sum of the values of each non-leaf node.
 * It is guaranteed this sum fits into a 32-bit integer.
 * <p>
 * A node is a leaf if and only if it has zero children.
 * <p>
 * Input: arr = [6,2,4]
 * Output: 32
 * <p>
 * Input: arr = [4,11]
 * Output: 44
 * <p>
 * Constraints:
 * 2 <= arr.length <= 40
 * 1 <= arr[i] <= 15
 */
public class _6MinCostTree {

    public static void main(String[] args) {
        System.out.println("Smallest possible sum of values of each non-leaf node: " + minCostTree(new int[]{6, 2, 4}));
        System.out.println("Smallest possible sum of values of each non-leaf node: " + minCostTree(new int[]{4, 11}));
    }

    /**
     * Approach
     * - Initialize a stack with a sentinel value INT_MAX to avoid empty checks.
     * - Iterate over each value in arr:
     * - While the top of the stack is less than or equal to the current value:
     * - Pop it and add to result: mid * min(st.top(), current value).
     * - Push the current value.
     * - After processing the array, merge remaining stack elements until only the sentinel is left.
     * - The result is the minimal total sum of non-leaf node values.
     * <p>
     * Complexity
     * - Time complexity: O(n) (each element is pushed and popped at most once).
     * - Space complexity: O(n) for the stack.
     */
    private static int minCostTree(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        int result = 0;
        for (int num : arr) {
            while (stack.peek() <= num) {
                int mid = stack.pop();
                result += mid * Math.min(num, stack.peek());
            }
            stack.push(num);
        }
        while (stack.size() > 2) {
            int mid = stack.pop();
            result += mid * stack.peek();
        }
        return result;
    }

}