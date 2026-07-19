package module.two._2pointers.lecture;

import java.util.Arrays;
import java.util.HashMap;

/**
 * LeetCode 167. Two Sum II - Input Array Is Sorted
 * Refer: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 */
public class _1TwoSumSorted {

    public static void main(String[] args) {
        printIndices(new int[]{2, 7, 11, 15}, 9);
        printIndices(new int[]{2, 3, 4}, 6);
        printIndices(new int[]{-1}, -1);
    }

    private static void printIndices(int[] numbers, int target) {
        System.out.println("Two sum indices by approach 1: " + Arrays.toString(approach1(numbers, target)));
        System.out.println("Two sum indices by approach 2: " + Arrays.toString(approach2(numbers, target)));
        System.out.println("Two sum indices by approach 3: " + Arrays.toString(approach3(numbers, target)));
        System.out.println("Two sum indices by approach 4: " + Arrays.toString(approach4(numbers, target)));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce
     * - This is the most bruteforce approach.
     * - Here, we are using the nested loops.
     * - Time complexity: O(N^2)
     * - Space complexity: O(1)
     */
    private static int[] approach1(int[] numbers, int target) {
        int[] indices = {-1, -1};
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    indices[0] = i + 1;
                    indices[1] = j + 1;
                    return indices;
                }
            }
        }
        return indices;
    }

    /**
     * Approach 2 - Better approach
     * - This is better approach than the bruteforce one.
     * - Here, we are using a hashmap that stores the number and the index value of it.
     * - If we already have complement of target in map, then return its index and current element index.
     * - Else simply add the element with its index.
     * - Time complexity: O(N)
     * - Space complexity: O(N)
     */
    private static int[] approach2(int[] numbers, int target) {
        int[] indices = {-1, -1};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                indices[0] = map.get(target - numbers[i]) + 1;
                indices[1] = i + 1;
                return indices;
            }
            map.put(numbers[i], i);
        }
        return indices;
    }

    /**
     * Approach 3 - Better bruteforce
     * - This is slightly better than bruteforce in terms of time complexity and better than above in terms of space.
     * - Here, we are iterating over the array and performing binary search each time.
     * - The left pointer starts from index + 1, then the simple binary search logic is implemented.
     * - We are comparing mid and ith element sum with target, if equal then return i+1 and mid+1 as indices for 1-based indexing.
     * - If the sum is less than target, then increase left pointer else decrease right pointer.
     * - Time complexity: O(N) for outer loop * O(logN) for binary search = O(N*logN)
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int[] approach3(int[] numbers, int target) {
        int[] indices = {-1, -1};
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            int l = i + 1, r = n - 1;
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (numbers[i] + numbers[m] == target) {
                    indices[0] = i + 1;
                    indices[1] = m + 1;
                    return indices;
                }
                if (numbers[i] + numbers[m] < target) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return indices;
    }

    /**
     * Approach 4 - Optimal solution
     * - This is the most optimal and the expected solution for this problem.
     * - Here, we are using the 2 pointers approach.
     * - We are keeping left pointer at 0th index and right pointer at last index.
     * - Then comparing the sum of both index elements with given target, if equal then return the 1-based indices.
     * - If sum is less than target, then increase left pointer by 1, else decrease right pointer by 1.
     * - Time complexity: O(N) as we are traversing the array only once.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int[] approach4(int[] numbers, int target) {
        int[] indices = {-1, -1};
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                indices[0] = i + 1;
                indices[1] = j + 1;
                return indices;
            }
            if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return indices;
    }

}
