package module.one.searching.two.lecture;

/**
 * Find pivot in rotated sorted array:
 * Pivot is nothing but the minimum element in the array.
 * We have to return minimum element index, i.e. index of pivot element.
 */
public class PivotElement {

    public static void main(String[] args) {
        printPivotElementIndex(new int[]{30, 40, 50, 10, 20});
    }

    private static void printPivotElementIndex(int[] arr) {
        System.out.println("Pivot element index by approach 1: " + approach1(arr));
        System.out.println("Pivot element index by approach 2: " + approach2(arr));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce approach
     * - This is the simple bruteforce approach where we are iterating over the array using linear search.
     * - And finding the minimum element and storing its index value.
     * - At last we are simply returning that index.
     * - Time complexity: O(N) to iterate the array.
     * - Space complexity: O(1) as no extra space is used.
     */
    private static int approach1(int[] arr) {
        int pivotElement = Integer.MAX_VALUE, pivotIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < pivotElement) {
                pivotElement = arr[i];
                pivotIndex = i;
            }
        }
        return pivotIndex;
    }

    /**
     * Approach 2 - Optimal approach
     * - This is the optimal approach where we are using the Binary Search algorithm.
     * - The logic is simple, just check the mid-element with element at right pointer.
     * - If mid is smaller or equal to right then update right pointer to point to mid.
     * - Else update left pointer to point to next of mid as mid is greater than right which means we are in left side.
     * - And pivot will always lie in right side.
     * - Time complexity: O(logN) as it is a simple binary search.
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
        return r;
    }

}
