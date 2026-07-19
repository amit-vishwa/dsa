package module.two.stacks.notes;

import java.util.Stack;

/**
 * Largest Rectangle in Histogram:
 * <p>
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the
 * area of the largest rectangle in the histogram.
 * <p>
 * Example
 * Input: heights = [2,1,5,6,2,3]
 * Output: 10
 */
public class _5LargestRectangleInHistogram {

    public static void main(String[] args) {
        printLargestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
    }

    private static void printLargestRectangleArea(int[] heights) {
        System.out.println("Largest area of rectangle in histogram by approach 1: " + approach1(heights));
        System.out.println("Largest area of rectangle in histogram by approach 2: " + approach2(heights));
        System.out.println("Largest area of rectangle in histogram by approach 3: " + approach3(heights));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce
     * - This is the simple and bruteforce approach.
     * - Here, we are taking 2 elements and calculating area and updating max area value.
     * - Time complexity: O(N^2) due to nested loops.
     * - Space complexity: O(1) as no extra space dependent on input is used here.
     */
    private static int approach1(int[] heights) {
        int maxArea = Integer.MIN_VALUE, n = heights.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int height = Math.min(heights[i], heights[j]);
                int width = j - i;
                maxArea = Math.max(maxArea, height * width);
            }
        }
        return maxArea;
    }

    /**
     * Approach 2 - Optimized
     * - This is more optimized approach than the bruteforce one.
     * - Here, we are creating left smaller and right smaller elements of particular index using stack.
     * - Then, we are iterating the array and calculating the area.
     * - After that just update the max area and return it.
     * - Time complexity: O(N) for left smaller element array + O(N) for right + O(N) for max area = O(3N) = O(N).
     * - Space complexity: O(N) for left array + O(N) for right + O(N) for stack = O(3N) = O(N)
     */
    /*private static int approach2(int[] heights) {
        int maxArea = Integer.MIN_VALUE, n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int[] leftSmallerElementArray = new int[n];
        int[] rightSmallerElementArray = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() >= heights[i]) {
                stack.pop();
            }
            leftSmallerElementArray[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(heights[i]);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= heights[i]) {
                stack.pop();
            }
            rightSmallerElementArray[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(heights[i]);
        }
        for (int i = 0; i < n; i++) {
            int height = heights[i];
            int width = rightSmallerElementArray[i] - leftSmallerElementArray[i] + 1;
            int area = height * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }*/
    // Time complexity: O(N), Space complexity: O(N)
    private static int approach2(int[] heights) {
        int maxArea = Integer.MIN_VALUE, n = heights.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= n; i++) {
            int h = i == n ? 0 : heights[i];
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }

    /**
     * Approach 3 - Optimal
     * - This is an optimal version using 2 pointers.
     * - Here, we are not taking any extra space and within one iteration we are getting the result.
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    private static int approach3(int[] heights) {
        int maxArea = Integer.MIN_VALUE, l = 0, r = heights.length - 1;
        while (l < r) {
            int h = Math.min(heights[l], heights[r]);
            int w = r - l;
            maxArea = Math.max(maxArea, w * h);
            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }

}
