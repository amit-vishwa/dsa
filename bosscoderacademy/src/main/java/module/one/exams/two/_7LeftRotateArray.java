package module.one.exams.two;

import java.util.Arrays;

/**
 * Rotate an Array by d - Counterclockwise or Left
 * Refer: https://www.geeksforgeeks.org/dsa/array-rotation/
 */
public class _7LeftRotateArray {

    public static void main(String[] args) {
        printLeftRotatedArray(new int[]{1, 2, 3, 4, 5, 6}, 2);
        printLeftRotatedArray(new int[]{1, 2, 3}, 4);
    }

    private static void printLeftRotatedArray(int[] arr, int d) {
        System.out.println("Left rotated array by approach 1: " + Arrays.toString(approach1(arr, d)));
        System.out.println("Left rotated array by approach 2: " + Arrays.toString(approach2(arr, d)));
        System.out.println("Left rotated array by approach 3: " + Arrays.toString(approach3(arr, d)));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce approach
     * - This is a simple bruteforce approach where we are rotating the array left side by d times.
     * - Time complexity: O(d) for d times rotation * O(n) for shifting array elements = O(d*n)
     * - Space complexity: O(1) as no extra space is used here for this logic.
     */
    private static int[] approach1(int[] arr, int d) {
        int n = arr.length;
        int[] res = Arrays.copyOf(arr, n);
        for (int i = 0; i < d; i++) {
            int first = res[0];
            for (int index = 0; index < n - 1; index++) {
                res[index] = res[index + 1];
            }
            res[n - 1] = first;
        }
        return res;
    }

    /**
     * Approach 2 - Better approach
     * - The approach is better than the bruteforce approach.
     * - We are using an extra array to directly store the elements at correct position.
     * - Only we have to calculate the correct indexes here, also take care of the case where d >= n;
     * - Time complexity: O(N) as we are iterating over the array to store elements in new array at correct position.
     * - Space complexity: O(N) as we are using new array to store elements at correct position.
     */
    private static int[] approach2(int[] arr, int d) {
        int n = arr.length;
        int[] res = new int[n];
        d %= n;
        for (int i = 0; i < n - d; i++) {
            res[i] = arr[d + i];
        }
        for (int i = n - d, j = 0; i < n; i++) {
            res[i] = arr[j++];
        }
        return res;
    }

    /**
     * Approach 3 - Optimal approach
     * - The approach is most optimal one.
     * - We are reversing the elements from 0 to d-1.
     * - Then reversing the elements from d to n-1, and then reversing whole array.
     * - Finally we will be left with the result.
     * - Time complexity: O(N) as reversing array takes linear time.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int[] approach3(int[] arr, int d) {
        int n = arr.length;
        d %= n;
        int[] res = Arrays.copyOf(arr, n);
        reverse(res, 0, d - 1);
        reverse(res, d, n - 1);
        reverse(res, 0, n - 1);
        return res;
    }

    private static void reverse(int[] res, int s, int e) {
        while (s < e) {
            int temp = res[s];
            res[s] = res[e];
            res[e] = temp;
            s++;
            e--;
        }
    }
}
