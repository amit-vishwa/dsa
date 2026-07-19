package module.one._1d_and_2d_array.notes;

import java.util.Scanner;
import java.util.Arrays;

public class _2RangeSumQueries1DArray {

    public static void main(String[] args) {
        printRangeSum();
    }

    private static void printRangeSum() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array length: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Array: " + Arrays.toString(arr));
        approach1(arr, sc);
        System.out.println();
        approach2(arr, sc);
    }

    /**
     * Approach 1 - Brutefoce approach:
     * - Here, we are simply iterating over the array from start index to end index.
     * - And then we are calculating the sum.
     * - Iteration takes O(N) time and querying takes O(Q) time.
     * - So, total time complexity becomes O(N) * O(Q) = O(N*Q), which is not good.
     * - Space complexity is O(1), as we are not taking any extra space dependent on input.
     */
    private static void approach1(int[] arr, Scanner sc) {
        System.out.print("Enter query count for approach 1: ");
        int q = sc.nextInt();
        while (q > 0) { // Time complexity: O(Q)
            System.out.print("\nEnter start index: ");
            int s = sc.nextInt();
            System.out.print("Enter end index: ");
            int e = sc.nextInt();
            performApproach1Operation(arr, s, e);
            q -= 1;
        }
    }

    // Time complexity: O(N), Space complexity: O(1)
    private static void performApproach1Operation(int[] arr, int s, int e) {
        if (s < 0 || e >= arr.length || s > e) {
            System.out.println("Invalid indices provided!");
            return;
        }
        int sum = 0;
        for (int i = s; i <= e; i++) {
            sum += arr[i];
        }
        System.out.println("Range sum from index " + s + " to index " + e + ": " + sum);
    }

    /**
     * Approach 2 - Optimal approach:
     * - Here, we are creating the prefix sum array by calculating prefix of all elements.
     * - After that we are simply fetching the ending index element from prefix sum array and
     * reducing the start index element from that.
     * - And then we are adding the start index element from original array to the sum which
     * we have.
     * - So the answer here will be:
     * ans = endPrefixIndexElement - startPrefixIndexElement + startIndexElement
     * - The time and space complexity of creating prefixSumArray is O(N).
     * - Then querying the results takes O(Q) with actual answer obtaining is O(1).
     * - So, total time complexity is O(N) + [ O(Q) * O(1) ] = O(N) + O(Q) = O(N + Q)
     * - And space complexity is O(N) for creating the prefix sum array.
     */
    private static void approach2(int[] arr, Scanner sc) {
        int[] prefixSumArray = getPrefixSumArray(arr, arr.length);
        System.out.print("Enter query count for approach 2: ");
        int q = sc.nextInt();
        while (q > 0) { // Time complexity: O(Q)
            System.out.print("\nEnter start index: ");
            int s = sc.nextInt();
            System.out.print("Enter end index: ");
            int e = sc.nextInt();
            performApproach2Operation(prefixSumArray, arr, s, e);
            q -= 1;
        }
    }

    // Time and space complexity is O(N).
    private static int[] getPrefixSumArray(int[] arr, int n) {
        int[] prefixSumArray = new int[n];
        prefixSumArray[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixSumArray[i] = prefixSumArray[i - 1] + arr[i];
        }
        System.out.println("Prefix sum array: " + Arrays.toString(prefixSumArray));
        return prefixSumArray;
    }

    // Time and space complexity is O(1).
    private static void performApproach2Operation(int[] prefixSumArray, int[] arr, int s, int e) {
        if (s < 0 || e >= arr.length || s > e) {
            System.out.println("Invalid indices provided!");
            return;
        }
        int sum = prefixSumArray[e] - prefixSumArray[s] + arr[s];
        System.out.println("Range sum from index " + s + " to index " + e + ": " + sum);
    }

}
