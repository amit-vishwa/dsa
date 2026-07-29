package module.one.searching.one.lecture;

/**
 * Linear search: [Leetcode 704. Binary Search]
 * - This search algorithm is simple.
 * - It's just a simple traversal over the array.
 * - It checks each element, it found target then returns index, else keep on searching till the end of the array.
 * - When target does not exist in the array, return -1.
 * - Time complexity: O(N) as it traverse the whole array.
 * - Space complexity: O(1) as no extra space is used.
 */
public class LinearSearch {

    public static void main(String[] args) {
        System.out.println("Found at index: " + searchTarget(new int[]{2, 4, 5, 9, 12, 18, 24, 31, 44, 52, 58, 60, 72}, 3));
        System.out.println("Found at index: " + searchTarget(new int[]{2, 4, 5, 9, 12, 18, 24, 31, 44, 52, 58, 60, 72}, 31));
        System.out.println("Found at index: " + searchTarget(new int[]{2, 4, 5, 9, 12, 18, 24, 31, 44, 52, 58, 60, 72}, 72));
        System.out.println("Found at index: " + searchTarget(new int[]{2, 4, 5, 9, 12, 18, 24, 31, 44, 52, 58, 60, 72}, 2));
        System.out.println("Found at index: " + searchTarget(new int[]{2, 4, 5, 9, 12, 18, 24, 31, 44, 52, 58, 60, 72}, 1));
        System.out.println("Found at index: " + searchTarget(new int[]{2, 4, 5, 9, 12, 18, 24, 31, 44, 52, 58, 60, 72}, 75));
    }

    private static int searchTarget(int[] arr, int t) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == t) {
                return i;
            }
        }
        return -1;
    }

}
