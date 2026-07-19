package module.two._2pointers.assignment;

/**
 * Minimize Ai Bj Ck Three Different Sorted Array:
 * <p>
 * Given three sorted arrays A, B, and C of not necessarily same sizes. Calculate the minimum absolute difference between the
 * maximum and minimum number of any triplet A[i], B[j], C[k] such that they belong to arrays A, B and C respectively, i.e.,
 * minimize (max(A[i], B[j], C[k]) – min(A[i], B[j], C[k])).
 * <p>
 * Input : A : [ 1, 4, 5, 8, 10 ]
 * B : [ 6, 9, 15 ]
 * C : [ 2, 3, 6, 6 ]
 * Output : 1
 * Explanation: When we select A[i] = 5 B[j] = 6, C[k] = 6, we get the minimum difference as
 * max(A[i], B[j], C[k]) - min(A[i], B[j], C[k])) = |6-5| = 1
 * <p>
 * Input : A = [ 5, 8, 10, 15 ]
 * B = [ 6, 9, 15, 78, 89 ]
 * C = [ 2, 3, 6, 6, 8, 8, 10 ]
 * Output : 1
 * Explanation: When we select A[i] = 10 b[j] = 9, C[k] = 10.
 * <p>
 * Constraints:
 * 1 <= A.length, B.length, C.length <= 104
 * 1 <= A[i], B[i], C[i] <= 107
 */
public class _5Minimize3Arrays {

    public static void main(String[] args) {
        System.out.println("Minimized absolute difference is " + minimizeArrays(new int[]{1, 4, 5, 8, 10}, new int[]{6, 9, 15},
                new int[]{2, 3, 6, 6}));
        System.out.println("Minimized absolute difference is " + minimizeArrays(new int[]{5, 8, 10, 15}, new int[]{6, 9, 15, 78, 89},
                new int[]{2, 3, 6, 6, 8, 8, 10}));
    }

    /**
     * Approach:
     * - The approach is simple, we already know the array is sorted.
     * - Just traverse from the end of all the arrays and take max and min of all 3.
     * - Now take max and min difference and compare it with a minDiff or min variable value.
     * - Take the min of both and update currMax value index by decrementing it by 1.
     * - Repeat the same process until all indices are greater than or equal to 0.
     * - If any of them goes less than 0, then break the loop and return the minimum difference.
     * - Time complexity: O(min(M,N,O)) as we are iterating over the array and breaking loop if short one is traversed.
     * - Space complexity: O(1) as we do not require any extra space here.
     */
    private static int minimizeArrays(int[] arr1, int[] arr2, int[] arr3) {
        int i = arr1.length - 1, j = arr2.length - 1, k = arr3.length - 1, min = Integer.MAX_VALUE;
        while (i >= 0 && j >= 0 && k >= 0) {
            int currMax = Math.max(arr1[i], Math.max(arr2[j], arr3[k]));
            int currMin = Math.min(arr1[i], Math.min(arr2[j], arr3[k]));
            min = Math.min(min, currMax - currMin);
            if (currMax == arr1[i]) {
                i--;
            } else if (currMax == arr2[j]) {
                j--;
            } else {
                k--;
            }
        }
        return min;
    }

}