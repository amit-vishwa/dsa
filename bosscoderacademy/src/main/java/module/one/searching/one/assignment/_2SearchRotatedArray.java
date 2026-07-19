package module.one.searching.one.assignment;

/**
 * Search Rotated Sorted Array:
 * <p>
 * There is an integer array nums sorted in ascending order (with distinct values).
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such
 * that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example,
 * [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1
 * if it is not in nums.
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Input 1:
 * nums = [4,5,6,7,0,1,2], target = 0
 * Output 1:
 * 4
 * Explanation 1:
 * 0 is present at 4th index.
 * <p>
 * Input 2:
 * nums = [4,5,6,7,0,1,2], target = 3
 * Output 2:
 * -1
 * <p>
 * Constraints:
 * n == nums.length
 * 1 <= n <= 5000
 * All values of nums are unique.
 * -10^4 <= nums[i] <= 10^4
 * -10^4 <= target <= 10^4
 * <p>
 * Approaches:
 * 1. Bruteforce approach - search using linear search algorithm in O(N) time complexity which is not expected here.
 * 2. Optimal approach - search using binary search algorithm in O(logN) time complexity as expected.
 */
public class _2SearchRotatedArray {

    public static void main(String[] args) {
        System.out.println(searchRotatedArray(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(searchRotatedArray(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }

    private static int searchRotatedArray(int[] nums, int target) {
        int pivot = getPivot(nums);
        if (pivot == -1 || nums[pivot] == target) {
            return pivot;
        }
        return target >= nums[0] && pivot > 0 ? binarySearch(nums, target, 0, pivot - 1) : binarySearch(nums, target, pivot, nums.length - 1);
    }

    private static int getPivot(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] > arr[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return r;
    }

    private static int binarySearch(int[] arr, int target, int l, int r) {
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == target) {
                return m;
            }
            if (arr[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

}