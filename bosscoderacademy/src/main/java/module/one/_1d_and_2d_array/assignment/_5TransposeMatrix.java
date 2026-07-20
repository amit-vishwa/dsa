package module.one._1d_and_2d_array.assignment;

import java.util.List;
import java.util.ArrayList;

/**
 * Transpose Matrix: [Leetcode 867. Transpose Matrix]
 * Given a 2D integer array matrix, return the transpose of matrix.
 * The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column
 * indices.
 * <p>
 * Input 1: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output 1: [[1,4,7],[2,5,8],[3,6,9]]
 * Explanation 1:
 * <p>
 * Input 2: matrix = [[1,2,3],[4,5,6]]
 * Output 2: [[1,4],[2,5],[3,6]]
 * <p>
 * Constraints:
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n,m <= 1000
 * 1 <= n*m <= 1000
 * -109 <= matrix[i][j] <= 109
 * <p>
 * Approach:
 * - Simple approach, just create a list with row size = column size from given matrix.
 * - Then iterate over the given matrix and add row values in the column-wise in transpose matrix.
 * - Time complexity: O(M*N), traversing the whole matrix.
 * - Space complexity: O(M*N), as we are creating a transpose matrix.
 */
public class _5TransposeMatrix {

    public static void main(String[] args) {
        printTransposeMatrix(List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9)));
        printTransposeMatrix(List.of(List.of(1, 2, 3), List.of(4, 5, 6)));
    }

    private static void printTransposeMatrix(List<List<Integer>> matrix) {
        int m = matrix.size(), n = matrix.get(0).size();
        List<List<Integer>> transposeMatrix = new ArrayList<>();
        for (int r = 0; r < n; r++) {
            transposeMatrix.add(new ArrayList<>());
        }
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                transposeMatrix.get(c).add(matrix.get(r).get(c));
            }
        }
        System.out.println("Transpose matrix: " + transposeMatrix);
    }

}