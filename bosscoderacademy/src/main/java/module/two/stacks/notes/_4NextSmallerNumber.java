package module.two.stacks.notes;

import java.util.Arrays;
import java.util.Stack;

/**
 * Next Smaller Element:
 * <p>
 * Given an array, print the Next Smaller Element (NSE) for every element. The NSE for an element x is the first smaller
 * element on the right side of x in the array. Elements for which no smaller element exist (on the right side), consider
 * NSE as -1.
 * <p>
 * Example
 * Input: n=5, arr[]={4,8,5,2,25}
 * Output:{2,5,2,-1,-1}
 */
public class _4NextSmallerNumber {

    public static void main(String[] args) {
        printNextGreaterElement(new int[]{4, 8, 5, 2, 25});
        printNextGreaterElement(new int[]{3, 4, 2, 1, 11, 9, 77});
        printNextGreaterElement(new int[]{3, 4, 2, 77, 11, 9, 19});
    }

    private static void printNextGreaterElement(int[] arr) {
        System.out.println("Next greater element by approach 1: " + Arrays.toString(approach1(arr)));
        System.out.println("Next greater element by approach 2: " + Arrays.toString(approach2(arr)));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce
     * - This is simple bruteforce approach.
     * - For last element at rightmost side, just store -1 as result, as we cannot have more element at right.
     * - Now, for each element search in right side and store the first smaller element found, at that index.
     * - Once, smaller number found just break and stop searching for other numbers.
     * - Time complexity: O(N^2) due to nested loops.
     * - Space complexity: O(1) as no extra space is used here, result array is just to return the result.
     */
    private static int[] approach1(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (arr[i] > arr[j]) {
                    res[i] = arr[j];
                    break;
                }
                // no smaller element found for current element
                if (j == n - 1) { // true for last element or smallest in mid
                    res[i] = -1;
                }
            }
        }
        return res;
    }

    /**
     * Approach 2 - Optimal
     * - This is an optimal approach using stack.
     * - Here, we are iterating over the array in reverse order.
     * - Then, checking inside while for top stack element, if it is greater than current element just pop it.
     * - After while loop, check if stack is empty, if yes then store -1 in that index in result array else store top stack one.
     * - Now, push current element in the stack.
     * - At last just return the result array.
     * - Time complexity: O(N) as we are just iterating once the array
     * - Space complexity: O(N) due to stack.
     */
    private static int[] approach2(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > arr[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return res;
    }

}
