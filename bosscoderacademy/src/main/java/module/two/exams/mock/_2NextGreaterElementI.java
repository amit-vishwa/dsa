package module.two.exams.mock;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

// Refer https://leetcode.com/problems/next-greater-element-i/
public class _2NextGreaterElementI {

    public static void main(String[] args) {
        System.out.println("Next greater element array: " + Arrays.toString(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
        System.out.println("Next greater element array: " + Arrays.toString(nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4})));
    }

    private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n1; i++) {
            map.put(nums1[i], i);
        }
        int[] ngeArr = new int[n2];
        Stack<Integer> stack = new Stack<>();
        for (int i = n2 - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }
            ngeArr[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums2[i]);
        }
        int[] res = new int[n1];
        for (int i = 0; i < n2; i++) {
            if (map.containsKey(nums2[i])) {
                int index = map.get(nums2[i]);
                res[index] = ngeArr[i];
            }
        }
        return res;
    }
}
