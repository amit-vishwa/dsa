package module.two.exams.cohort;

import java.util.Arrays;
import java.util.HashSet;

// Refer _2LongestConsecutiveSequence.java from package module.two.hashing.one.assignment.
public class _3LongestConsecutiveSequence {

    public static void main(String[] args) {
        printLongestConsecutiveSequenceLength(new int[]{100, 4, 200, 1, 3, 2});
        printLongestConsecutiveSequenceLength(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1});
    }

    private static void printLongestConsecutiveSequenceLength(int[] nums) {
        System.out.println("Longest consecutive sequence length by approach 1: " + approach1(nums));
        System.out.println("Longest consecutive sequence length by approach 2: " + approach2(nums));
        System.out.println();
    }

    private static int approach1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int length = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int number = num, count = 0;
                while (set.contains(number)) {
                    number++;
                    count++;
                }
                length = Math.max(length, count);
            }
        }
        return length;
    }

    private static int approach2(int[] nums) {
        Arrays.sort(nums);
        int count = 1, length = 1; // initial length should be 1
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue; // skip duplicates
            }
            if (nums[i] == nums[i - 1] + 1) {
                count++;
            } else {
                count = 1;
            }
            length = Math.max(length, count);
        }
        return length;
    }
}
