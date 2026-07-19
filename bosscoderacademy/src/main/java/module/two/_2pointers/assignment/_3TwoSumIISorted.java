package module.two._2pointers.assignment;

import java.util.Arrays;

/**
 * Two Sum II Sorted:
 * <p>
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they
 * add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2]
 * where 1 <= index1 < index2 <= numbers.length. *
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 * Your solution must use only constant extra space.
 * <p>
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
 * <p>
 * Input: numbers = [2,3,4], target = 6
 * Output: [1,3]
 * Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
 * <p>
 * Constraints:
 * 2 <= numbers.length <= 3 * 104
 * -1000 <= numbers[i] <= 1000
 * Numbers is sorted in non-decreasing order.
 * -1000 <= target <= 1000
 * The tests are generated such that there is exactly one solution.
 * <p>
 * Refer _1TwoSumSorted.java from package module.two._2pointers.lecture
 */
public class _3TwoSumIISorted {

    public static void main(String[] args) {
        System.out.println("Indices of two numbers whose sum is K are " + Arrays.toString(twoSumIndices(new int[]{2, 7, 11, 15}, 9)));
        System.out.println("Indices of two numbers whose sum is K are " + Arrays.toString(twoSumIndices(new int[]{2, 3, 4}, 6)));
    }

    private static int[] twoSumIndices(int[] numbers, int target) {
        int[] indices = {-1, -1};
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                indices[0] = left + 1;
                indices[1] = right + 1;
                return indices;
            }
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return indices;
    }

}