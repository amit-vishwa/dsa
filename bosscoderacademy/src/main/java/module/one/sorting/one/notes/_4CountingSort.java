package module.one.sorting.one.notes;

import java.util.Arrays;

/**
 * Counting Sort Algorithm:
 * <p>
 * Counting Sort is an integer sorting algorithm that sorts the elements of an array by counting the number of occurrences of
 * each unique element. The count is stored in an auxiliary array, which is then used to place the elements in their correct
 * position in the output array. This algorithm is particularly efficient for sorting integers when the range of the numbers
 * (k) is not significantly greater than the number of elements (n).
 * <p>
 * Steps of the Counting Sort Algorithm:
 * 1. Find the Range:
 * --> Determine the maximum and minimum values in the array to understand the range of the elements.
 * 2. Initialize Count Array:
 * --> Create a count array with a size equal to the range of the elements. Initialize all elements of this array to zero.
 * 3. Count Occurrences:
 * --> Traverse the input array and for each element, increment its corresponding value in the count array.
 * 4. Accumulate Counts:
 * --> Modify the count array such that each element at each index stores the sum of the previous counts. This step helps to determine the position of each element in the output array.
 * 5. Build Output Array:
 * --> Traverse the input array from right to left, and for each element, place it in its correct position in the output array by using the count array. After placing each element, decrement its count in the count array.
 * 6. Copy to Original Array:
 * --> Copy the sorted elements from the output array back to the original array.
 * <p>
 * - Time complexity: O(N) for input array + O(K) for count array = O(N+K)
 * - Space complexity: O(N + K) extra space taken by result or output array and count array.
 * - It is a non-comparison based stable algorithm.
 * - However, since it requires extra space it is not in place sorting algorithm.
 */
public class _4CountingSort {

    public static void main(String[] args) {
        sort(new int[]{12, 4, 5, 6, 7, 8, 10, 8, 7});
        sort(new int[]{2, 4, 5, 6, 7, 8, 10});
        sort(new int[]{-3, -1, 2, 4, -2, -2, 5, 6});
    }

    private static void sort(int[] arr) {
        System.out.println("Array: " + Arrays.toString(arr));
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : arr) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int[] count = new int[max - min + 1];
        for (int num : arr) {
            count[num - min]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        int[] sorted = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            sorted[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }
        System.out.println("Sorted Array: " + Arrays.toString(sorted));
        System.out.println();
    }

}
