package module.one._1d_and_2d_array.assignment;

import java.util.List;
import java.util.ArrayList;

/**
 * Reshape The Matrix: [Leetcode 566. Reshape the Matrix]
 *
 * In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a
 * different size r x c keeping its original data.
 * You are given an m x n matrix mat and two integers r and c representing the number of rows and the number of
 * columns of the wanted reshaped matrix.
 * The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing
 * order as they were.
 * If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise,
 * output the original matrix.
 *
 * Input: mat = [[1,2],[3,4]], r = 1, c = 4
 * Output: [[1,2,3,4]]
 *
 * Input: mat = [[1,2],[3,4]], r = 2, c = 4
 * Output: [[1,2],[3,4]]
 *
 * Constraints:
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 100
 * -1000 <= mat[i][j] <= 1000
 * 1 <= r, c <= 300
 *
 * Approach:
 * - Here, we have created a new matrix of given row and col size.
 * - Then initialized the row for that matrix.
 * - Now, we have a counter from 0 to m * n - 1, based on this counter we are populating cells of new matrix.
 * - Time and space complexities are O(M*N).
 * */
public class _9ReshapeMatrix {

    public static void main(String[] args) {
        System.out.println("Matrix: " + reshapeMatrix(List.of(List.of(1, 2), List.of(3, 4)), 1, 4));
        System.out.println("Matrix: " + reshapeMatrix(List.of(List.of(1, 2), List.of(3, 4)), 2, 4));
    }

    // Time and space complexity: O(M*N)
    private static List<List<Integer>> reshapeMatrix(List<List<Integer>> input, int r, int c) {
        int m = input.size(), n = input.get(0).size();
        if (m * n != r * c) {
            return input;
        }
        List<List<Integer>> output = new ArrayList<>();
        for (int row = 0; row < r; row++) {
            output.add(new ArrayList<>());
        }
        for (int cell = 0; cell < m * n; cell++) {
            output.get(cell / c).add(input.get(cell / n).get(cell % n));
        }
        return output;
    }

}