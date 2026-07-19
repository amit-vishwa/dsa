package module.one.exams.two;

/**
 * LeetCode 33. Search in Rotated Sorted Array
 * Refer: https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 */
public class _3RotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(searchRotatedSortedArray(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(searchRotatedSortedArray(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(searchRotatedSortedArray(new int[]{1}, 0));
    }

    private static int searchRotatedSortedArray(int[] nums, int target) {
        int pivot = getPivot(nums);
        if (pivot == -1 || nums[pivot] == target) {
            return pivot;
        }
        if (target >= nums[0] && pivot > 0) {
            return binarySearch(nums, target, 0, pivot - 1);
        }
        return binarySearch(nums, target, pivot, nums.length - 1);
    }

    private static int getPivot(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return r;
    }

    private static int binarySearch(int[] nums, int target, int l, int r) {
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            }
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

}
