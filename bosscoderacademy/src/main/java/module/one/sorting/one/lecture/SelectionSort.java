package module.one.sorting.one.lecture;

import java.util.Arrays;

/**
 * Selection Sort:
 * - The algorithm is quite simple and least efficient and hence not used much.
 * - It involves of select an element and considering it as min element and storing its index in a variable.
 * - Then iterate over the array to find the least element, if found then just update the index value.
 * - After a pass, just swap the min index with current index and from next perform the same from second element.
 * - This is an in-place sorting algorithm.
 * - Also, it is not a stable sorting algorithm due to the swapping of elements.
 * - Time complexity: O(N^2), for all cases.
 * - Space complexity: O(1) as no extra space is used for sorting.
 */
public class SelectionSort {

    public static void main(String[] args) {
        sort(new int[]{2, 4, 5, 6, 7, 8, 10, 8, 7});
        sort(new int[]{2, 4, 5, 6, 7, 8, 10});
    }

    private static void sort(int[] arr) {
        System.out.println("Array: " + Arrays.toString(arr));
        for (int usi = 0; usi < arr.length - 1; usi++) {
            int minIdx = usi; // un sorted index
            for (int idx = usi + 1; idx < arr.length; idx++) {
                if (arr[minIdx] > arr[idx]) {
                    minIdx = idx;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[usi];
            arr[usi] = temp;
        }
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

}
