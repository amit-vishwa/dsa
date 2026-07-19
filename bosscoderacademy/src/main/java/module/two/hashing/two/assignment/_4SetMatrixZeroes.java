package module.two.hashing.two.assignment;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * Set Matrix Zeroes:
 * <p>
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 * You must do it in place.
 * <p>
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 * <p>
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * <p>
 * Constraints:
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 */
public class _4SetMatrixZeroes {

    public static void main(String[] args) {
        // List.of() is immutable so used Arrays.asList() to update elements, however array size cannot be changed
        System.out.println("Result matrix: " + zeroMatrix(new ArrayList<>(List.of(Arrays.asList(1, 1, 1), Arrays.asList(1, 0, 1), Arrays.asList(1, 1, 1)))));
        System.out.println("Result matrix: " + zeroMatrix(new ArrayList<>(List.of(Arrays.asList(0, 1, 2, 0), Arrays.asList(3, 4, 5, 2), Arrays.asList(1, 3, 1, 5)))));
    }

    /**
     * Approach:
     * - The approach is simple, we have just created hash arrays for rows and cols.
     * - Then traversing over the matrix to find the 0 elements, then updated rows and cols for the same by incrementing.
     * - After that just iterate over the row array first and if value is not 0, then just make whole row as 0.
     * - Similarly, iterate over the col array and if value is not 0, then make whole col as 0.
     * - Time complexity: O(N*M) for setting rows & cols array + O(N^2) for setting rows as 0 + O(M^2) for setting cols as 0 = O(N^2)
     * - Space complexity: O(N) for hash row + O(M) for hash col = O(N+M)
     */
    private static List<List<Integer>> zeroMatrix(List<List<Integer>> matrix) {
        int n = matrix.size(), m = matrix.getFirst().size();
        int[] rows = new int[n];
        int[] cols = new int[m];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (matrix.get(r).get(c) == 0) {
                    rows[r]++;
                    cols[c]++;
                }
            }
        }
        for (int r = 0; r < n; r++) {
            if (rows[r] > 0) {
                for (int c = 0; c < m; c++) {
                    matrix.get(r).set(c, 0);
                }
            }
        }
        for (int c = 0; c < m; c++) {
            if (cols[c] > 0) {
                for (int r = 0; r < n; r++) {
                    matrix.get(r).set(c, 0);
                }
            }
        }
        return matrix;
    }

}