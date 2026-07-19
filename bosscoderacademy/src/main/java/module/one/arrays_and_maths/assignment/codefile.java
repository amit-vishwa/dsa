package module.one.arrays_and_maths.assignment;

import java.util.Arrays;

public class codefile {

    public static void main(String[] args) {
        solve(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
        solve(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}});
    }

    public static void solve(int[][] matrix) {
        System.out.println("Matrix: " + Arrays.deepToString(matrix));
        int m = matrix.length, n = matrix[0].length;
        int cells = m + n;
        // top, left
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }
                int top = cells, left = cells;
                if (i > 0) {
                    top = matrix[i - 1][j];
                }
                if (j > 0) {
                    left = matrix[i][j - 1];
                }
                matrix[i][j] = Math.min(top, left) + 1;
            }
        }
        // bottom, right
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == 0) {
                    continue;
                }
                int bottom = cells, right = cells;
                if (i + 1 < m) {
                    bottom = matrix[i + 1][j];
                }
                if (j + 1 < n) {
                    right = matrix[i][j + 1];
                }
                matrix[i][j] = Math.min(matrix[i][j], Math.min(bottom, right) + 1);
            }
        }
        System.out.println("Result: " + Arrays.deepToString(matrix));
    }
}