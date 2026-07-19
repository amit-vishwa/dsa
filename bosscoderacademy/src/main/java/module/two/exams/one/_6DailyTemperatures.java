package module.two.exams.one;

import java.util.Arrays;
import java.util.Stack;

/**
 * Daily Temperatures:
 * <p>
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the
 * number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is
 * possible, keep answer[i] == 0 instead.
 * <p>
 * Example 1:
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * <p>
 * Example 2:
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 * <p>
 * Example 3:
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 * <p>
 * Constraints:
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
 * <p>
 * Refer: https://leetcode.com/problems/daily-temperatures/description/
 */
public class _6DailyTemperatures {

    public static void main(String[] args) {
        System.out.println("Days to wait for a warmer day: " + Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println("Days to wait for a warmer day: " + Arrays.toString(dailyTemperatures(new int[]{30, 40, 50, 60})));
        System.out.println("Days to wait for a warmer day: " + Arrays.toString(dailyTemperatures(new int[]{30, 60, 90})));
    }

    /**
     * Approach:
     * - This is an optimized approach using monotonic stack.
     * - We are adding the indices in stack.
     * - We are checking if stack is not empty and top index element is less than or equal to current element.
     * - If yes then just keep on removing top element from stack.
     * - Now, while adding the answer, check if stack is empty.
     * - If yes, then just store 0 as answer, else store difference of stack's peek element and current index.
     * - After that, just add the index in the stack.
     * - At last, just return the answer array.
     * - Time complexity: O(N) as we are iterating over the array once.
     * - Space complexity: O(N) due to stack.
     */
    private static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            answer[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return answer;
    }

}
