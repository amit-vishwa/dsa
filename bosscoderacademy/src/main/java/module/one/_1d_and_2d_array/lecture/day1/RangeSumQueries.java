package module.one._1d_and_2d_array.lecture.day1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Range sum queries:
 * The problem statement indicates to find the sum of elements from given where start and end indices are provided.
 * Example: arr = [10, 2, 5, 8, 7], start = 1, end = 4, result = 2+5+8+7 = 22
 *
 * There are 2 approaches to solve this problem:
 * 1.Bruteforce approach:
 * - Simply iterate over the array from start to end, to find its sum.
 * - Here, time complexity will be O(N), but we have to do this for Q queries.
 * - So, the final time complexity will become O(N) * O(Q) = O(N*Q).
 * - Since, we are not using any extra or auxiliary space here so space complexity is O(1).
 *
 * 2.Optimal approach:
 * - In this approach, we can use the prefix approach where we can calculate the sum till that index.
 * - So for the given array, we will create a prefix sum array first, this will take O(N) time and space.
 * - Now for given start and end indices we can calculate the sum in O(1) time with below formula:
 * prefixSumArray[end] - prefixSumArray[start] + arr[start]
 * - So final time complexity is O(N) i.e. for creating prefixSumArray + O(Q) for Q queries.
 * - Time complexity: O(N) + O(Q) = O(N + Q)
 * - Space complexity: O(N)
 * */
public class RangeSumQueries {

    public static void main(String[] args) {
        printRangeSum(new int[]{10, 2, 5, 8, 7});
    }

    // Time complexity with queries: O(N) + O(Q) = O(N + Q)
    private static void printRangeSum(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return;
        }
        System.out.println("Array: " + Arrays.toString(arr));
        int[] prefixSumArray = createPrefixSumArray(arr, n);
        System.out.println("Prefix Sum Array: " + Arrays.toString(prefixSumArray));
        System.out.print("Enter query count: ");
        Scanner sc = new Scanner(System.in);
        int queryCount = sc.nextInt();
        while (queryCount > 0) {
            performOperation(sc, arr, prefixSumArray, n);
            queryCount--;
        }
    }

    private static void performOperation(Scanner sc, int[] arr, int[] prefixSumArray, int n) {
        System.out.print("\nEnter start index: ");
        int start = sc.nextInt();
        System.out.print("Enter end index: ");
        int end = sc.nextInt();
        if (start < 0 || end >= n || start > end) {
            System.out.println("Invalid indices provided");
            return;
        }
        int rangeSum = prefixSumArray[end] - prefixSumArray[start] + arr[start];
        System.out.println("Range Sum: " + rangeSum);
    }

    // Time complexity for this method is O(N)
    private static int[] createPrefixSumArray(int[] arr, int n) {
        int[] prefixSumArray = new int[n];
        prefixSumArray[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixSumArray[i] = prefixSumArray[i - 1] + arr[i];
        }
        return prefixSumArray;
    }

}
