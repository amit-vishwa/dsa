package module.one.searching.one.lecture;

/**
 * Single Number: [Leetcode 540. Single Element in a Sorted Array]
 * - Given an array of duplicate elements where are numbers are present twice except one, return that number.
 * - This problem is already solve in bit manipulation session, with multiple approaches.
 * - That can be referred to get insights of this problem, here we have solved it with binary search only.
 */
public class SingleNumber {

    public static void main(String[] args) {
        System.out.println(distinctNumber(new int[]{1, 1, 2, 2, 4, 4, 8, 8, 9, 10, 10, 12, 12, 18, 18}));
    }

    /**
     * Approach:
     * - This is the most optimal approach to solve this problem.
     * - Here, we are calculating the mid-index and checking if it is not last index.
     * - Then we are checking mid and mid^1 index elements are same or not.
     * - XORing a number by 1 will have it next odd number if that number is even, else it will give previous even.
     * - So, if numbers are repeated twice then even indexed elements will have first occurrence and odd will have repetition.
     * - When that distinct element is added from there onwards, even will have repetition and will have first occurrence.
     * - So, we are just check if even and odd indexed elements are same then distinct element is not added yet, increment left
     * pointer to search in the right region.
     * - If mid and mid^1 elements are not equal that means distinct is already present, and we are in right region we have to
     * search left, so decrease right pointer.
     * - Repeat the process until left and right are not crosses each other.
     * - If they crossed, the while loop end then return the left pointer as initially we started from left and distinct should
     * also be present at left region because if will be present at even index as it is the first occurrence.
     * - Also, at last check if left is not the last index and array length is not odd, if it is then no distinct element present.
     * - Time complexity: O(log(N)) as it is a simple binary search.
     * - Space complexity: O(1) as we are not using any extra space.
     */
    private static int distinctNumber(int[] arr) {
        int n = arr.length, l = 0, r = n - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (m != n - 1 && arr[m] == arr[m ^ 1]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return (l == n - 1 && (n & 1) == 0) ? -1 : l;
    }

}
