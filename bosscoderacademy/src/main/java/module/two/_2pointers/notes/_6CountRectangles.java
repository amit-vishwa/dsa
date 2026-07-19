package module.two._2pointers.notes;

/**
 * Count of rectangles with an area less than the given number:
 * <p>
 * Given an array find rectangles from the array such that area is less than k.
 * Example
 * Input: n = 5, arr = [1,2,3,4,5], k = 20
 * Output: 8 - this is incorrect, correct ans is 13, we have total 13 pairs
 */
public class _6CountRectangles {

    public static void main(String[] args) {
        printRectanglesCount(new int[]{1, 2, 3, 4, 5}, 20);
    }

    private static void printRectanglesCount(int[] arr, int k) {
        System.out.println("Rectangles less than K by approach 1: " + approach1(arr, k));
        System.out.println("Rectangles less than K by approach 2: " + approach2(arr, k));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce
     * - The approach is simple, just iterate over the array.
     * - If product is less than K, then count it.
     * - Time complexity: O(N^2) due to nested loops.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int approach1(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] * arr[j] < k) {
                    count++; // to count pairs
//                    count = i == j ? count + 1 : count + 2; // to count elements
                }
            }
        }
        return count;
    }

    /**
     * Approach 2 - Optimal
     * - The approach is more optimal than above one.
     * - Here, take pointers at left and right and proceed with checking product.
     * - If product is less than K, then increase left pointer and update count which is window size.
     * - Else decrease right pointer, repeat the process until left become greater than right.
     * - Time complexity: O(N) as we are iterating only once.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int approach2(int[] arr, int k) {
        int l = 0, r = arr.length - 1, count = 0;
        while (l <= r) {
            if (arr[l] * arr[r] < k) {
                count += (r - l + 1); // to count pairs;
//                count += (2 * (r - l) + 1); // to count elements
                l++;
            } else {
                r--;
            }
        }
        return count;
    }
}
