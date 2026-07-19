package module.one.exams.one;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 658. Find K Closest Elements
 * Refer: https://leetcode.com/problems/find-k-closest-elements/description/
 */
public class _1KClosestElements {

    public static void main(String[] args) {
        System.out.println(findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3));
        System.out.println(findClosestElements(new int[]{1, 1, 2, 3, 4, 5}, 4, -1));
    }

    /**
     * Approach:
     * - The approach is simple, just use two pointers to solve the problem.
     * - Take left as first element and right as last element.
     * - Now here total result list size would be difference of right and left + 1, as left and right have indices.
     * - Until the list size > k, perform checks from if condition which is already given in description.
     * - If left difference is greater than right difference, increment left else increment right pointer.
     * - At last, just add the elements from arr from index left till K size.
     * - Time complexity: O(N-K) as we are iterating over the array till N-K size.
     * - Space complexity: O(1) as no extra space is used, but result list size is O(K).
     */
    private static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> closestElements = new ArrayList<>();
        int left = 0, right = arr.length - 1;
        while (right - left + 1 > k) {
            if (Math.abs(arr[right] - x) < Math.abs(x - arr[left])) {
                left++;
            } else {
                right--;
            }
        }
        for (int i = 0; i < k; i++) {
            closestElements.add(arr[left + i]);
        }
        return closestElements;
    }

}
