package module.one.arrays_and_maths.assignment;

import java.util.*;

/**
 * 4. Maximum Gap: [Leetcode 164. Maximum Gap]
 * Given an integer array nums, return the maximum difference between two successive elements in its sorted form.
 * If the array contains less than two elements, return 0.
 * You must write an algorithm that runs in linear time and uses linear extra space.
 */
public class _4MaximumGap {

    public static void main(String[] args) {
        printMaximumGap(new int[]{3, 6, 9, 1});
        printMaximumGap(new int[]{10});
    }

    private static void printMaximumGap(int[] arr) {
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Approach 1: Maximum Gap => " + approach1(arr));
        System.out.println("Approach 2: Maximum Gap => " + approach2(arr));
        System.out.println("Approach 3: Maximum Gap => " + approach3(arr));
        System.out.println("Approach BCA: Maximum Gap => " + solve(arr) + "\n");
    }

    /**
     * 1. Approach 1 - Bruteforce solution:
     * - A simple bruteforce solution that uses a sorted array to find maximum difference.
     * - It is not a proper solution as it takes O(N*logN) time.
     * - Space complexity - O(N), for merge sort.
     * - Time complexity - O(N*logN) due to merge sort.
     */
    private static int approach1(int[] arr) {
        int n = arr.length;
        if (n < 2) {
            return 0;
        }
        arr = sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        int maxDiff = 0;
        for (int i = 1; i < n; i++) {
            maxDiff = Math.max(maxDiff, arr[i] - arr[i - 1]);
        }
        return maxDiff;
    }

    private static int[] sort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int s = 0;
        int e = arr.length;
        int m = s + (e - s) / 2;
        int[] left = sort(Arrays.copyOfRange(arr, s, m));
        int[] right = sort(Arrays.copyOfRange(arr, m, e));
        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int lSize = left.length;
        int rSize = right.length;
        int[] res = new int[lSize + rSize];
        int l = 0, r = 0, k = 0;
        while (l < lSize && r < rSize) {
            if (left[l] < right[r]) {
                res[k++] = left[l++];
            } else {
                res[k++] = right[r++];
            }
        }
        while (l < lSize) {
            res[k++] = left[l++];
        }
        while (r < rSize) {
            res[k++] = right[r++];
        }
        return res;
    }

    /**
     * Approach 2 - Better solution:
     * - A better solution than previous bruteforce one.
     * - It is a proper solution as it take O(MAX+1) space and time complexities.
     * - We have used a temporary array to store the elements in sorted format.
     * - It passed 3/5 testcases in the BCA assignment.
     * - Memory limit exceeded error on LeetCode.
     * - Space complexity - O(MAX+1), for stored sorted array
     * - Time complexity - O(MAX), to simply iterate multiple times.
     */
    private static int approach2(int[] arr) {
        int n = arr.length;
        if (n < 2) {
            return 0;
        }
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, arr[i]);
        }
        boolean[] sortedArray = new boolean[max + 1];
        for (int num : arr) {
            sortedArray[num] = true;
        }
        int count = 0, maxDiff = 0;
        boolean isFirstTrue = false;
        for (int i = 0; i < sortedArray.length; i++) {
            if (sortedArray[i] && !isFirstTrue) {
                isFirstTrue = true;
                count++;
            } else if (sortedArray[i]) {
                maxDiff = Math.max(maxDiff, count);
                count = 0;
            } else {
                count++;
            }
        }
        return maxDiff;
    }

    /**
     * Approach 3 - Better solution:
     * - A better solution than previous approach two.
     * - It is a proper solution as it take O(N) space and O(MAX) time complexities.
     * - We have used a set to store the elements and also calculating the min and max values.
     * - It passed 4/5 testcases in the BCA assignment.
     * - TLE error on LeetCode.
     * - Space complexity - O(N), for storing all elements in a set.
     * - Time complexity - O(MAX), to simply iterate through set till max element.
     */
    private static int approach3(int[] arr) {
        if (arr.length < 2) {
            return 0;
        }
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int maxGap = 0, prev = min;
        for (int num = min + 1; num <= max; num++) {
            if (set.contains(num)) {
                maxGap = Math.max(maxGap, num - prev);
                prev = num;
            }
        }
        return maxGap;
    }

    /**
     * Approach expected in BCA assignment.
     * The solution is provided by them.
     */
    private static int solve(int[] nums) {
        if (nums.length < 2) return 0;
        int hi = 0, lo = Integer.MAX_VALUE, ans = 0;
        for (int n : nums) {
            hi = Math.max(hi, n);
            lo = Math.min(lo, n);
        }
        int bsize = Math.max((hi - lo) / (nums.length - 1), 1);
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < (hi - lo) / bsize + 1; i++) {
            buckets.add(new ArrayList<>());
        }
        for (int n : nums) {
            buckets.get((n - lo) / bsize).add(n);
        }
        int currhi = 0;
        for (List<Integer> b : buckets) {
            if (b.isEmpty()) continue;
            int prevhi = currhi != 0 ? currhi : b.get(0);
            int currlo = b.get(0);
            for (int n : b) {
                currhi = Math.max(currhi, n);
                currlo = Math.min(currlo, n);
            }
            ans = Math.max(ans, currlo - prevhi);
        }
        return ans;
    }

}