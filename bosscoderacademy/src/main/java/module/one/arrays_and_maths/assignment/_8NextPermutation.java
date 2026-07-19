package module.one.arrays_and_maths.assignment;

import java.util.Arrays;

// Leetcode 31. Next Permutation
public class _8NextPermutation {

    public static void main(String[] args) {
        printNextPermutation(new int[]{1, 2, 3});
        printNextPermutation(new int[]{3, 2, 1});
        printNextPermutation(new int[]{3, 2, 1, 5});
        printNextPermutation(new int[]{1, 2, 7, 4, 3, 1});
    }

    /**
     * Optimal approach:
     * - This problem also consist of bruteforce approach where all permutations are calculated.
     * - Then the next permutation is found, it has time complexity of O(N!) with space as O(N).
     * - This solution is quite optimal as it consist of O(N) time complexity and O(1) space complexity.
     * - Here, we are finding the pivot index first.
     * - Pivot element is nothing but element greater than or equal to it next element.
     * - If pivot index found (i.e. l >= 0), then we are finding the successor that is next element greater than pivot.
     * - When we get the index of successor, we are swapping pivot element and successor.
     * - At last, we are reversing the elements from next of pivot to keep it sorted.
     */
    private static void printNextPermutation(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return;
        }
        System.out.println("Permutation: " + Arrays.toString(arr));
        int l = n - 2;
        while (l >= 0 && arr[l] >= arr[l + 1]) {
            l--;
        }
        if (l >= 0) {
            int r = n - 1;
            while (arr[r] <= arr[l]) {
                r--;
            }
            swap(arr, l, r);
        }
        reverse(arr, l + 1, n - 1);
        System.out.println("Next Permutation: " + Arrays.toString(arr));
    }

    private static void reverse(int[] arr, int s, int e) {
        while (s <= e) {
            swap(arr, s++, e--);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}