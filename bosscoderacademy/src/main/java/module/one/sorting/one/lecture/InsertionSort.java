package module.one.sorting.one.lecture;

import java.util.Arrays;

/**
 * Insertion Sort:
 * - The insertion sorting algorithm deals with inserting the element at the correct position.
 * - We are always sorting the left part of the array and whenever any element is added we are checking it from left side.
 * - If current element is greater than left then no swapping else, we have to keep on swap until it is inserted at correct index.
 * - If left portion is already and current element is greater than no swap, hence works best for partially sorted array.
 * - It is an in-place sorting algorithm.
 * - It is also a stable sorting algorithm as both duplicates will remain on its place due to swapping.
 * - Time complexity: Omega(N) for best case, O(N^2) for average or worst case.
 * - Space complexity: O(1) as we are not using any extra space here.
 */
public class InsertionSort {

    public static void main(String[] args) {
        sort(new int[]{2, 4, 5, 6, 7, 8, 8, 10, 8, 7});
        sort(new int[]{2, 4, 5, 6, 7, 8, 10});
    }

    /* Tutor's approach related to playing cards arrangement:
     * - The approach is simple, we have to consider the unsorted index as 1, will iterate from 1 till end of the array.
     * - We are considering a key as array element of unsorted index and declaring the curr variable.
     * - Then we are iterating from usi-1 till 0 only if current element is greater than key.
     * - If it is then we are shifting it to right side and again comparing with current element.
     * - When we get current element as less than or equal to key, then we are breaking the loop.
     * - And since current element would be less than or equal to key, we are placing the key on right side of it.
     * - This is the whole approach, also it give Omega(N) for best case i.e. already sorted array.
     **/
    private static void sort(int[] arr) {
        System.out.println("Array: " + Arrays.toString(arr));
        for (int usi = 1; usi < arr.length; usi++) {
            int key = arr[usi], curr;
            for (curr = usi - 1; curr >= 0 && arr[curr] > key; curr--) {
                arr[curr + 1] = arr[curr];
            }
            arr[curr + 1] = key;
        }
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    /*private static void sort(int[] arr) {
        System.out.println("Array: " + Arrays.toString(arr));
        for (int pass = 0; pass < arr.length - 1; pass++) {
            for (int curr = pass + 1; curr >= 0 && arr[curr] < arr[curr - 1]; curr--) {
                int temp = arr[curr];
                arr[curr] = arr[curr - 1];
                arr[curr - 1] = temp;
            }
        }
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }*/

}
