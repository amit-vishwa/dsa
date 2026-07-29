package module.one.searching.one.notes;

/**
 * Find pivot element in a rotated sorted array: [Leetcode 153. Find Minimum in Rotated Sorted Array]
 * <p>
 * Pivot element is nothing but the minimum element in the array.
 * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 * <p>
 * Example
 * <p>
 * Input: n = 6, arr[] = {4,5,6,1,2,3}
 * Output:1
 */
public class _2PivotElement {

    public static void main(String[] args) {
        printPivotElement(new int[]{4, 5, 6, 1, 2, 3});
        printPivotElement(new int[]{4, 6, 8});
        printPivotElement(new int[]{9, 8, 7, 5});
        printPivotElement(new int[]{6, 7, 8, 0, 2, 3, 4, 5});
    }

    private static void printPivotElement(int[] arr) {
        System.out.println("Pivot element by approach 1: " + approach1(arr));
        System.out.println("Pivot element by approach 2: " + approach2(arr));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce approach
     * - A simple bruteforce approach is to simply iterate over the array and find min element.
     * - This will result in getting the pivot.
     * - Another bruteforce is to simply sort the array first and get the first element, but complexity will increase here.
     * - Time complexity: O(N), it is O(N) + O(NlogN) for sorting approach
     * - Space complexity: O(1) as not extra space is used here.
     */
    private static int approach1(int[] arr) {
        int pivot = Integer.MAX_VALUE;
        for (int num : arr) {
            pivot = Math.min(pivot, num);
        }
        return pivot;
    }

    /**
     * Approach 2 - Optimal approach
     * - This is an optimal approach where we are using the Binary Search algorithm.
     * - The approach is simple, we just have to take left and right pointers.
     * - Then calculate mid and check mid-element with right index element.
     * - If mid is smaller or equal to right element then we are in correct region.
     * - Just update the right pointer by moving it to mid, else update left pointer to mid+1.
     * - Repeat the process until left and right are equal.
     * - When both becomes equal, we got our pivot, just return any index.
     * - Time complexity: O(logN) as simple binary search.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int approach2(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] <= arr[r]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return arr[r]; // l and r both will have the answer at end.
    }

}
