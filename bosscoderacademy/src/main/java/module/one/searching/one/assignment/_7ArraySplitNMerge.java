package module.one.searching.one.assignment;

/**
 * Array Zero Split And Merge:
 * <p>
 * Given an array arr[] with N elements, the task is to find whether all the elements of the given array can be made 0 by
 * given operations. Only 2 types of operations can be performed on this array:
 * Split an element B into 2 elements C and D such that B = C + D.
 * Merge 2 elements P and Q as one element R such that R = P^Q i.e. (XOR of P and Q).
 * You have to determine whether it is possible to convert array A to size 1, containing a single element equal to 0 after
 * several splits and/or merges?
 * <p>
 * Input: arr = [9, 17]
 * Output: Yes
 * Explanation: Following is one possible sequence of operations –
 * 1) Merge i.e 9 XOR 17 = 24
 * 2) Split 24 into two parts each of size 12
 * 3) Merge i.e 12 XOR 12 = 0
 * As there is only 1 element i.e 0. So it is possible.
 * <p>
 * Input: arr = [1]
 * Output: No
 * <p>
 * Constraints:
 * 1 ≤ N ≤ 105
 * 1 ≤ A[i] < 231
 */
public class _7ArraySplitNMerge {

    public static void main(String[] args) {
        printIfZero(new int[]{9, 17});
        printIfZero(new int[]{1});
    }

    private static void printIfZero(int[] arr) {
        System.out.println("Can be zero by approach 1: " + approach1(arr));
        System.out.println("Can be zero by approach 2: " + approach2(arr));
        System.out.println();
    }

    /**
     * Approach 1:
     * - The approach is simple, just XOR all the elements, if we are left with even number then zero can be obtained.
     * - Else we cannot get zero from the given array.
     * - Time complexity: O(N) as we are iterating over the array.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static boolean approach1(int[] arr) {
        int xor = 0;
        for (int num : arr) {
            xor ^= num;
        }
        return (xor & 1) == 0;
    }

    /**
     * Approach 2:
     * - The approach is similar to approach 1 only the change here is we have to count odd numbers from array.
     * - If the odd count is even the 0 can be obtained, else it cannot be obtained.
     * - Time complexity: O(N) as we are iterating over the array elements.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static boolean approach2(int[] arr) {
        int oddCount = 0;
        for (int num : arr) {
            if ((num & 1) == 1) {
                oddCount++;
            }
        }
        return (oddCount & 1) == 0;
    }

}