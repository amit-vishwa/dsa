package module.one.searching.one.assignment;

/**
 * Single Element In Sorted Array:
 * <p>
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one
 * element which appears exactly once.
 * Return the single element that appears only once.
 * Your solution must run in O(log n) time and O(1) space.
 * <p>
 * Input1: nums = [1,1,2,3,3,4,4,8,8]
 * Output1: 2
 * <p>
 * Input2: nums = [3,3,7,7,10,11,11]
 * Output2: 10
 * <p>
 * Constraints:
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 105
 * <p>
 * Refer _4SingleElement from module.one.searching.one.notes; package for more.
 */
public class _4SingleElement {

    public static void main(String[] args) {
        System.out.println(singleElement(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        System.out.println(singleElement(new int[]{3, 3, 7, 7, 10, 11, 11}));
    }

    private static int singleElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (m != nums.length - 1 && nums[m] == nums[m ^ 1]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l < nums.length ? nums[l] : -1;
    }

}