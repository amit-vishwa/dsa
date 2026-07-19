package module.two.stacks.notes;

import java.util.Arrays;
import java.util.Stack;

/**
 * Find the nearest smaller numbers on left side in an array:
 * <p>
 * Given an array of integers, find the nearest smaller number for every element such that the smaller element is on
 * the left side.
 * <p>
 * Example
 * Input:  arr[] = {1, 6, 4, 10, 2, 5}
 * Output: {_, 1, 1,  4, 1, 2}
 * <p>
 * Refer _3NextGreaterNumber.java from package module.two.stacks.lecture, only minor changes are done here.
 */
public class _3NearestSmallerNumber {

    public static void main(String[] args) {
        printSmallerNumbers(new int[]{1, 6, 4, 10, 2, 5});
    }

    private static void printSmallerNumbers(int[] arr) {
        System.out.println("Smaller numbers on left side by approach 1: " + Arrays.toString(approach1(arr)));
        System.out.println("Smaller numbers on left side by approach 2: " + Arrays.toString(approach2(arr)));
        System.out.println();
    }

    private static int[] approach1(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    res[i] = arr[j];
                    break;
                }
                if (j == 0) {
                    res[i] = -1;
                }
            }
        }
        return res;
    }

    private static int[] approach2(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() > arr[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return res;
    }

}
