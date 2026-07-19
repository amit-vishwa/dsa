package module.two._2pointers.notes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

// Refer _4KDiffPairs.java file from package module.two._2pointers.lecture.
public class _3KDiffPairs {

    public static void main(String[] args) {
        printCount(new int[]{3, 1, 4, 1, 5}, 2);
        printCount(new int[]{1, 1, 3, 4, 5}, 2);
        printCount(new int[]{1, 2, 3, 4, 5}, 1);
        printCount(new int[]{1, 3, 1, 5, 4}, 0);
    }

    private static void printCount(int[] nums, int k) {
        System.out.println("Unique k-diff pairs count by approach 1: " + approach1(nums, k));
        System.out.println("Unique k-diff pairs count by approach 2: " + approach2(nums, k));
        System.out.println();
    }

    private static int approach1(int[] nums, int k) {
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    set.add(new ArrayList<>(List.of(nums[i], nums[j])));
                }
            }
        }
        return set.size();
    }

    private static int approach2(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0, i = 0, j = 1;
        while (j < nums.length) {
            if (i == j) {
                j++;
                continue;
            }
            int diff = nums[j] - nums[i];
            if (diff == k) {
                count++;
                i++;
                j++;
            } else if (diff < k) {
                j++;
            } else {
                i++;
            }
        }
        return count;
    }

}
