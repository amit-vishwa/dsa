package module.one.searching.one.assignment;

/**
 * Total Hamming Distance: [Leetcode 477. Total Hamming Distance]
 * <p>
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given an integer array nums, return the sum of Hamming distances between all the pairs of the integers in nums.
 * <p>
 * Input: nums = [4,14,2]
 * Output: 6
 * Explanation:
 * In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just showing the four bits relevant in this case).
 * The answer will be:
 * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 * <p>
 * Input: nums = [4,14,4]
 * Output: 4
 * <p>
 * Constraints:
 * 1 <= nums.length <= 109
 * 0 <= nums[i] <= 109
 */
public class _8TotalHammingDistance {

    public static void main(String[] args) {
        printTotalHammingDistance(new int[]{4, 14, 2});
        printTotalHammingDistance(new int[]{4, 14, 4});
    }

    private static void printTotalHammingDistance(int[] nums) {
        System.out.println("Total hamming distance by approach 1: " + approach1(nums));
        System.out.println("Total hamming distance by approach 2: " + approach2(nums));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce approach
     * - The approach is simple here, we are checking for each pair and also checking its bits.
     * - If bits are different then we are increasing the count of total hamming distance.
     * - Time complexity: O(N^2) for nest loops for each pair * O(32) to check bits = O(N^2)
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int approach1(int[] nums) {
        int totalHammingDistance = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int bits = 0;
                while (bits < 32 && ((nums[i] >> bits) > 0) && ((nums[j] >> bits) > 0)) {
                    if (((nums[i] >> bits) & 1) != ((nums[j] >> bits) & 1)) {
                        totalHammingDistance++;
                    }
                    bits++;
                }
                while (bits < 32 && (nums[i] >> bits) > 0) {
                    totalHammingDistance += ((nums[i] >> bits) & 1);
                    bits++;
                }
                while (bits < 32 && (nums[j] >> bits) > 0) {
                    totalHammingDistance += ((nums[j] >> bits) & 1);
                    bits++;
                }
            }
        }
        return totalHammingDistance;
    }

    /**
     * Approach 2 - Optimal approach
     * - This is an optimal approach.
     * - Here, we are checking each bit of all the elements and calculating ones and zeroes at that bit position.
     * - If count of ones or zeroes is equal to array length then we are skipping adding them in total hamming distance.
     * - Else we are adding product of zeroes and ones as they can have pairs, to total hamming distance.
     * - And at last, we are returning the total hamming distance.
     * - Time complexity: O(32) for bits * O(N) to iterate array elements = O(32 * N) = O(N) as 32 is constant so can be ignored.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int approach2(int[] nums) {
        int totalHammingDistance = 0, n = nums.length;
        for (int bits = 0; bits < 32; bits++) {
            int ones = 0;
            for (int num : nums) {
                if (((num >> bits) & 1) == 1) {
                    ones++;
                }
            }
            totalHammingDistance += ones * (n - ones);
        }
        return totalHammingDistance;
    }

}