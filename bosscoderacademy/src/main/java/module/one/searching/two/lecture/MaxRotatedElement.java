package module.one.searching.two.lecture;

/**
 * Max element in rotated array:
 * Given a rotated array, we have to return the max element from that array.
 * <p>
 * Approaches:
 * 1. Linear search - a bruteforce approach where max element is found and its index is returned at the end.
 * 2. Binary search - an optimal approach where we are comparing mid with right element and returning max element.
 * - This program consist of optimal solution only.
 */
public class MaxRotatedElement {

    public static void main(String[] args) {
        System.out.println(maxElement(new int[]{30, 40, 50, 10, 20}));
        System.out.println(maxElement(new int[]{10, 20, 30, 40, 60}));
        System.out.println(maxElement(new int[]{20, 30, 10}));
    }

    /**
     * Approach:
     * - The optimal approach is simple here.
     * - Just find the pivot element and return its previous element as it will be the max element.
     * - If pivot found at index 0, then return last element.
     * - Time complexity: O(logN) as this is a simple binary search.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int maxElement(int[] arr) {
        int n = arr.length, l = 0, r = n - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] > arr[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return arr[r - 1 < 0 ? n - 1 : r - 1];
    }

}
