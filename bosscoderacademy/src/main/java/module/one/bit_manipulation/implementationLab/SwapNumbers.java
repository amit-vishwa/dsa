package module.one.bit_manipulation.implementationLab;

import java.util.Arrays;

/**
 * Swap two numbers without using any extra space:
 * <p>
 * - Here, we do not have to use any extra space or variable like we used to use temp variable.
 * - So this can be solved with 2 approaches - Arithmetic and Bitwise approach.
 */
public class SwapNumbers {

    public static void main(String[] args) {
        printUpdatedArray(new int[]{1, 2, 3, 4, 5, 6});
    }

    private static void printUpdatedArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
        approach1(arr, 1, 4);
        System.out.println(Arrays.toString(arr));
        approach2(arr, 2, 3);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Approach 1 - Arithmetic swap
     * - Here we are using arithmetic operation like add or subtract to swap the numbers.
     * - Constant space and time complexity.
     */
    private static void approach1(int[] arr, int i, int j) {
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }

    /**
     * Approach 2 - Bitwise swap
     * - Here we are using bitwise xor operation like to swap the numbers.
     * - The properties of XOR plays a vital role here to swap the numbers and it highly efficient.
     * - Constant space and time complexity.
     */
    private static void approach2(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

}
