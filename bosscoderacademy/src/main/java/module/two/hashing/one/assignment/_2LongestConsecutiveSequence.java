package module.two.hashing.one.assignment;

import java.util.Arrays;
import java.util.HashSet;

public class _2LongestConsecutiveSequence {

    public static void main(String[] args) {
        printLargestConsecutiveSequenceCount(new int[]{100, 4, 200, 1, 3, 2});
        printLargestConsecutiveSequenceCount(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1});
    }

    private static void printLargestConsecutiveSequenceCount(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr);
        System.out.println("Largest consecutive sequence count by approach 1: " + approach1(arr));
        System.out.println("Largest consecutive sequence count by approach 2: " + approach2(arr));
        System.out.println("Largest consecutive sequence count by approach 3: " + approach3(nums));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce
     * - This is the bruteforce approach that works on sorted array.
     * - Here, we are first sorting the array and iterating over it to check consecutive numbers.
     * - If consecutive numbers found, then count is increase and maxCount is updated, else count is set to 1.
     * - At last, just return the maxCount.
     * - Time complexity: O(N*logN) due to sorting + O(N^2) due to nested loops = O(N^2)
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int approach1(int[] nums) {
        int maxSequenceCount = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            int sequenceCount = 1;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] == nums[j - 1] + 1) {
                    sequenceCount++;
                    maxSequenceCount = Math.max(maxSequenceCount, sequenceCount);
                } else {
                    sequenceCount = 1;
                }
            }
        }
        return maxSequenceCount;
    }

    /**
     * Approach 2 - Better Bruteforce
     * - This is a better bruteforce approach that works on sorted array.
     * - We are first sorting the array, then using two pointers iterating over it.
     * - If 2 consecutive numbers found then count is increased and maxCount is updated, else count is set to 1.
     * - We are always setting the i pointer to j and then increasing the j pointer.
     * - Time complexity: O(N*logN) due to sorting + O(N) as we are iterating over the array only once = O(N*logN)
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int approach2(int[] nums) {
        int maxSequenceCount = 0, sequenceCount = 1, n = nums.length, i = 0, j = 1;
        while (j < n) { // 1,2,3,4,100,200
            if (nums[j] == nums[i] + 1) {
                sequenceCount++;
                maxSequenceCount = Math.max(maxSequenceCount, sequenceCount);
            } else {
                sequenceCount = 1;
            }
            i = j;
            j++;
        }
        return maxSequenceCount;
    }

    /**
     * Approach 3 - Optimal
     * - This is the most optimal approach.
     * - Here, we are using HashSet and adding all numbers in it.
     * - Then iterating over the set and checking if previous number not exist, then initializing the sequenceCount and
     * storing current number in a new variable.
     * - After that we are checking if number + 1 exist in set, if yes then increment sequenceCount and number and then
     * repeat the process.
     * - After the loop, just update the maxCount.
     * - After iterating over the set, just return the maxCount.
     * - Time complexity: O(N) as we are iterating over the array + O(N) as we are iterating over the set = O(N)
     * - Space complexity: O(N) due to set data structure.
     */
    private static int approach3(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxSequenceCount = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int sequenceCount = 1;
                int number = num;
                while (set.contains(number + 1)) {
                    sequenceCount++;
                    number++;
                }
                maxSequenceCount = Math.max(maxSequenceCount, sequenceCount);
            }
        }
        return maxSequenceCount;
    }

}