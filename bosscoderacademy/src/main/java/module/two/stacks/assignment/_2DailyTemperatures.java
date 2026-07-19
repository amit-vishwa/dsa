package module.two.stacks.assignment;

import java.util.List;
import java.util.Stack;
import java.util.Arrays;

public class _2DailyTemperatures {

    public static void main(String[] args) {
        System.out.println("Waiting days: " + Arrays.toString(waitingDays(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println("Waiting days: " + Arrays.toString(waitingDays(new int[]{30, 40, 50, 60})));
    }

    private static int[] waitingDays(int[] temperatures) {
        int n = temperatures.length;
        int[] days = new int[n];
        Stack<List<Integer>> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek().get(0) <= temperatures[i]) {
                stack.pop();
            }
            days[i] = stack.empty() ? 0 : stack.peek().get(1) - i;
            stack.push(List.of(temperatures[i], i));
        }
        return days;
    }

}