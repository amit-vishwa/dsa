package module.one.searching.one.assignment;

/**
 * Find Peak Element: [Leetcode 162. Find Peak Element]
 * <p>
 * A peak element is an element that is strictly greater than its neighbors.
 * Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks,
 * return the index to any of the peaks.
 * You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than
 * a neighbor that is outside the array.
 * You must write an algorithm that runs in O(log n) time.
 * <p>
 * Input 1:
 * nums = [1,2,3,1]
 * Output 1:
 * 2
 * Explanation 1:
 * 3 is a peak element and your function should return the index number 2.
 * <p>
 * Input 2:
 * nums = [1,2,1,3,5,6,4]
 * Output 2:
 * 5
 * <p>
 * Constraints:
 * 1 <= nums.length <= 10^3
 * -2^31-1 <= arr[i] <= 2^31-1
 * <p>
 * Approaches:
 * 1. Bruteforce - search using linear search in O(N) time which is not expected here.
 * 2. Optimal - search using binary search in O(logN) time as expected.
 */
public class _3FindPeakElement {

    public static void main(String[] args) {
        System.out.println(findPeakIndex(new int[]{1, 2, 3, 1}));
        System.out.println(findPeakIndex(new int[]{1, 2, 1, 3, 5, 6, 4}));
    }

    private static int findPeakIndex(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[m + 1]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return r;
    }

}