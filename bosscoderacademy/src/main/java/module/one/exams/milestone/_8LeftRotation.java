package module.one.exams.milestone;

import java.util.Arrays;

/**
 * Refer _7LeftRotateArray.java file from package module.one.exams.two.
 */
public class _8LeftRotation {

    public static void main(String[] args) {
        rotateLeft(new int[]{1, 2, 3, 4, 5, 6}, 2);
        rotateLeft(new int[]{1, 2, 3}, 4);
    }

    private static void rotateLeft(int[] arr, int d) {
        System.out.println("Array: " + Arrays.toString(arr));
        int s = 0, e = arr.length - 1;
        int r = d % (e + 1);
        reverse(arr, s, r - 1);
        reverse(arr, r, e);
        reverse(arr, s, e);
        System.out.println(d + " times left rotated array: " + Arrays.toString(arr));
        System.out.println();
    }

    private static void reverse(int[] arr, int s, int e) {
        while (s <= e) {
            swap(arr, s++, e--);
        }
    }

    private static void swap(int[] arr, int s, int e) {
        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;
    }

}
