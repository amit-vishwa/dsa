package module.one.exams.two;

/**
 * LeetCode 81. Search in Rotated Sorted Array II
 * Refer: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
 */
public class _4DuplicateRotatedArray {

    public static void main(String[] args) {
        System.out.println(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
        System.out.println(search(new int[]{2, 5, 6, 0, 0, 1, 1}, 2));
        System.out.println(search(new int[]{2, 5, 6, 0, 0, 1, 1}, 1));
        System.out.println(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
    }

    private static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            }
            if (nums[l] == nums[m]) {
                l++;
                continue;
            }
            if (nums[l] <= nums[m]) {
                if (nums[l] <= target && target <= nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (nums[m] <= target && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }

}
