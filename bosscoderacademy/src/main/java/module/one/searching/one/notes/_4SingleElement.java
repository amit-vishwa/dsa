package module.one.searching.one.notes;

/**
 * Single Element in a Sorted Array:
 * <p>
 * You are given a sorted array consisting of only integers where every element appears exactly twice,
 * except for one element which appears exactly once. Return the single element that appears only once.
 * <p>
 * Example :
 * <p>
 * Input:  nums = [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * <p>
 * Approaches:
 * - The problem can be solved using multiple approaches, they are as follows:
 * 1. Bruteforce - Iterate over array and re-iterate array for each element to check its count, if found one then return answer.
 * 2. Hashing - Use hash array to maintain count, then iterate over hash array if count is one then found the answer.
 * 3. HashMap - Works similar to hashing, but can be used in case of negative numbers or large max values.
 * 5. Iterate array - Iterate over array check with its right element if not same then found answer.
 * 4. XOR - We can simply perform XOR on all elements of the array, duplicates will get cancelled out and distinct element
 * will be left at last.
 * <p>
 * - All above approaches can work for sorted and unsorted arrays.
 * - But when array is already sorted then the best approach is binary search which we are using here.
 */
public class _4SingleElement {

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        System.out.println(binarySearch(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 8}));
        System.out.println(binarySearch(new int[]{1, 2, 2, 3, 3, 4, 4, 8, 8}));
        System.out.println(binarySearch(new int[]{1, 1, 2, 2, 4, 4, 8, 8, 9, 10, 10, 12, 12, 18, 18}));
    }

    /**
     * Approach:
     * - This is the most optimal approach for sorted array.
     * - Here we are just checking the neighbours, if they are same then we are update left to mid + 1.
     * - Else we are updating right to mid - 1, also when mid is at last index then also we are updating right only.
     * - When left and crosses each other, left will have the answer i.e. the index for the distinct element.
     * - Time complexity: O(logN) as it is a simple binary search.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int binarySearch(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (m < arr.length - 1 && arr[m] == arr[m ^ 1]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return arr[l];
    }

}
