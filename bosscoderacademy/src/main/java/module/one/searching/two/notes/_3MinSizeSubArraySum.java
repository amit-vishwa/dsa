package module.one.searching.two.notes;

/**
 * Minimum Size Subarray Sum: [Leetcode 209. Minimum Size Subarray Sum]
 * <p>
 * Given an array of positive integers nums and a positive integer, the target returns the minimal length of a subarray whose
 * sum is greater than or equal to the target. If there is no such subarray, return 0 instead.
 * <p>
 * Example
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * <p>
 * Explanation: The subarray [4,3] has a minimal length under the problem constraint.
 */
public class _3MinSizeSubArraySum {

    public static void main(String[] args) {
        printMinSize(new int[]{2, 3, 1, 2, 4, 3}, 7);
        printMinSize(new int[]{2, 3, 1, 2, 4, 3}, 9);
        printMinSize(new int[]{2, 3, 1, 2, 4, 3}, 11);
        printMinSize(new int[]{2, 3, 1, 2, 4, 3}, 90);
        printMinSize(new int[]{1, 4, 4}, 4);
        printMinSize(new int[]{1, 1, 1, 1, 1, 1, 1, 1}, 11);
    }

    private static void printMinSize(int[] arr, int t) {
        System.out.println("Minimum size sub-array sum by approach1: " + approach1(arr, t));
        System.out.println("Minimum size sub-array sum by approach2: " + approach2(arr, t));
        System.out.println();
    }

    /**
     * Approach 1 - Optimal approach
     * - The approach is simple, here we are using Sliding Window approach to solve the problem.
     * - Here, we are starting with low and high pointers at 0.
     * - We are simply increasing the right pointer and checking if sum till now if greater than or equal to target.
     * - If yes, then count window size, update size till now and reduce left element from sum.
     * - At last return the size if it is updated else return 0.
     * - Time complexity: O(N) as all elements are being visited.
     * - Space complexity: O(1) no extra space is used here.
     */
    private static int approach1(int[] arr, int t) {
        int l = 0, size = Integer.MAX_VALUE, sum = 0;
        for (int h = 0; h < arr.length; h++) {
            sum += arr[h];
            while (sum >= t) {
                int window = h - l + 1;
                size = Math.min(size, window);
                sum -= arr[l++];
            }
        }
        return size == Integer.MAX_VALUE ? 0 : size;
    }

    /**
     * Approach 2 - Bruteforce approach
     * - This approach is bruteforce because it if unnecessary using the binary search with sliding window technique.
     * - The sliding window was sufficient to find the answer, but we can use binary search along with it to solve it.
     * - The binary search is only used for calculating the array length efficiently.
     * - Rest we have to check if mid is possible answer or not, if it is then we can reduce size by updating r.
     * - Else update l to mid - 1.
     * - Also, the function to check possible answer uses sliding window technique there with O(N) complexity.
     * - And this binary search uses O(logN) complexity.
     * - Time complexity: O(logN) * O(N) = O(N*logN)
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int approach2(int[] arr, int t) {
        int l = 1, r = arr.length, res = 0;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (isPossible(arr, t, m)) {
                res = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res;
    }

    private static boolean isPossible(int[] arr, int target, int mid) {
        int sum = 0;
        for (int i = 0; i < mid; i++) {
            sum += arr[i];
        }
        int l = 0, r = mid, max = sum;
        while (r < arr.length) {
            sum += arr[r++];
            sum -= arr[l++];
            max = Math.max(max, sum);
        }
        return max >= target;
    }

}
