package module.one._1d_and_2d_array.assignment;

import java.util.List;

/**
 * Matrix Diagonal Sum: [Leetcode 1572. Matrix Diagonal Sum]
 *
 * Given a square matrix mat, return the sum of the matrix diagonals. Only include the sum of all the elements on
 * the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.
 *
 * Input 1: mat = [[1,2,3], [4,5,6], [7,8,9]]
 * Output 1: 25
 * Explanation 1: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25. Notice that element mat[1][1] = 5 is counted only once.
 *
 * Input 2: mat = [[1,1,1,1], [1,1,1,1], [1,1,1,1], [1,1,1,1]]
 * Output 2: 8
 *
 * Constraints:
 * n == mat.length, mat[i].length
 * 1 <= n <= 100
 * 1 <= mat[i][j] <= 100
 *
 * Approach:
 * - Simply iterate through the matrix and check if it is a diagonal cell.
 * - Add the value to a cumulative sum variable for diagonal cells only.
 * - Also, do not re-add diagonal value if it's already added.
 * */
public class _10MatrixDiagonalSum {

    public static void main(String[] args) {
        System.out.println("Matrix diagonal sum: " + solve(List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9))));
        System.out.println("Matrix diagonal sum: " + solve(List.of(List.of(1, 1, 1, 1), List.of(1, 1, 1, 1),
                List.of(1, 1, 1, 1), List.of(1, 1, 1, 1))));
    }

    // Time complexity: O(M*N), Space complexity: O(1)
    private static int solve(List<List<Integer>> input) {
        int sum = 0;
        int m = input.size(), n = input.get(0).size();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (r == c || r + c == n - 1) {
                    sum += input.get(r).get(c);
                }
            }
        }
        return sum;
    }

}