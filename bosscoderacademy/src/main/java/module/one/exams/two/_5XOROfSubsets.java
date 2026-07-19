package module.one.exams.two;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 1863. Sum of All Subset XOR Totals
 * Refer: https://www.youtube.com/watch?v=_YdRjA5EvK4
 */
public class _5XOROfSubsets {

    public static void main(String[] args) {
        printSubsetXorSum(new int[]{1, 3});
        printSubsetXorSum(new int[]{5, 1, 6});
        printSubsetXorSum(new int[]{3, 4, 5, 6, 7, 8});
    }

    private static void printSubsetXorSum(int[] nums) {
        System.out.println("All subsets XOR sum by approach 1: " + approach1(nums));
        System.out.println("All subsets XOR sum by approach 2: " + approach2(nums));
        System.out.println("All subsets XOR sum by approach 3: " + approach3(nums));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce approach
     * - This is simple bruteforce approach where we are calculating all the subsets first.
     * - Then storing them in the list.
     * - After iteration over the list of subset and then finding the XOR of all subset elements.
     * - Finally returning the cumulative sum of all XORs of subsets.
     * - Time complexity: O(N) for iterating over array * O(2^N) for subsets = O(N*2^N)
     * - Space complexity: O(N) for recursion stack and O(N*2^N) for storing the subsets.
     */
    private static int approach1(int[] nums) {
        int sum = 0;
        List<List<Integer>> subsets = getSubsets(nums);
        for (List<Integer> subset : subsets) {
            int xor = 0;
            for (int num : subset) {
                xor ^= num;
            }
            sum += xor;
        }
        return sum;
    }

    private static List<List<Integer>> getSubsets(int[] nums) {
        List<List<Integer>> outerList = new ArrayList<>();
        outerList.add(new ArrayList<>());
        for (int num : nums) {
            int size = outerList.size();
            for (int i = 0; i < size; i++) {
                List<Integer> innerList = new ArrayList<>(outerList.get(i));
                innerList.add(num);
                outerList.add(innerList);
            }
        }
        return outerList;
    }

    /**
     * Approach 2 - Better approach
     * - The approach is better than the bruteforce approach.
     * - Here we are calculating the subsets via iteration and calculating XORs if bit is set at mask.
     * - Then adding XOR total to the cumulative sum which is then returned as an answer.
     * - Time complexity: O(2^N) for outer loop of calculating subsets * O(N) for inner loop of finding subset elements
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int approach2(int[] nums) {
        int sum = 0, n = nums.length;
        for (int mask = 0; mask < (1 << n); mask++) {
            int xor = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) > 0) {
                    xor ^= nums[i];
                }
            }
            sum += xor;
        }
        return sum;
    }

    /**
     * Approach 3 - Optimal approach
     * - The approach is the most optimal one here.
     * - We are just performing the OR operations on all the elements.
     * - Then multiplying the result with 2^(N-1) for all elements contributions.
     * - Time complexity: O(N) as we are iterating over the array once.
     * - Space complexity: O(1) as not extra space is used here.
     */
    private static int approach3(int[] nums) {
        int or = 0;
        for (int num : nums) {
            or |= num;
        }
        return or * (1 << nums.length - 1);
    }


}
