package module.two._2pointers.notes;

import java.util.Arrays;

// Refer _1TwoSumSorted.java file from package module.two._2pointers.lecture;
public class _1TwoSum {

    public static void main(String[] args) {
        printIndices(new int[]{2, 7, 11, 15}, 9);
        printIndices(new int[]{2, 3, 4}, 6);
        printIndices(new int[]{-1}, -1);
    }

    private static void printIndices(int[] nums, int target) {
        System.out.println("Indices of elements whose sum is target by approach 1 : " + Arrays.toString(approach1(nums, target)));
        System.out.println("Indices of elements whose sum is target by approach 2 : " + Arrays.toString(approach2(nums, target)));
        System.out.println();
    }

    private static int[] approach1(int[] nums, int target) {
        int[] indices = {-1, -1};
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    indices[0] = i;
                    indices[1] = j;
                    return indices;
                }
            }
        }
        return indices;
    }

    private static int[] approach2(int[] nums, int target) {
        int[] indices = {-1, -1};
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                indices[0] = i;
                indices[1] = j;
                return indices;
            }
            if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return indices;
    }

}
