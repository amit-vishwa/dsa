package module.one.arrays_and_maths.lecture;

// Leetcode 42. Trapping Rain Water
public class RainWaterTrapping {

    public static void main(String[] args) {
        System.out.println(getTrappedWater(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 0, 1})); // 6
        System.out.println(getTrappedWater(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 0, 0})); // 5
        System.out.println(getTrappedWater(new int[]{3, 1, 0, 2, 1, 0, 1, 3, 2, 1, 0, 1})); // 14
        System.out.println(getTrappedWater(new int[]{100, 1, 0, 2, 1, 0, 1, 3, 2, 1, 10, 11})); // 89
    }

    /**
     * Approach 1 - Bruteforce:
     * - A simple bruteforce approach is to find max elements at both left and right side.
     * - Then will take minimum of both and subtract current element from it.
     * - The result will be added in the final cumulative result.
     * - Space complexity - O(1)
     * - Time complexity - O(N^2)
     * O(N * (O(N) + O(N))) = O(N * O(2N)) = O(N * O(N)) = O(N * N) = O(N^2) i.e. quadratic
     */
    private static int getTrappedWater(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int i = 1; i < n - 1; i++) { // O(N)
            int maxLeft = 0, maxRight = 0;
            int j = i;
            // get max left element
            while (j >= 0) { // O(N)
                maxLeft = Math.max(arr[j], maxLeft);
                j--;
            }
            j = i;
            // get max right element
            while (j < n) { // O(N)
                maxRight = Math.max(arr[j], maxRight);
                j++;
            }
            // sum will be sum plus min of both side max minus current element height
            sum += (Math.min(maxLeft, maxRight) - arr[i]);
        }
        return sum;
    }

}
