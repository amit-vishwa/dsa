package module.one._1d_and_2d_array.assignment;

import java.util.List;

/**
 * Submatrix Sum:
 * Given a NxN 2-D matrix, the task to find the sum of all the submatrices.
 *
 * Input 1: arr[] = {{1, 1}, {1, 1}};
 * Output 1: 16
 * Explanation 1:
 * Number of sub-matrices with 1 elements = 4
 * Number of sub-matrices with 2 elements = 4
 * Number of sub-matrices with 3 elements = 0
 * Number of sub-matrices with 4 elements = 1
 * Since all the entries are 1, the sum becomes sum = 1 * 4 + 2 * 4 + 3 * 0 + 4 * 1 = 16
 *
 * Input 2: arr[] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}
 * Output 2: 500
 *
 * Constraints:
 * n == nums.length
 * 1 <= n <= 102
 *
 * Approaches: refer AllSubmatricesSum.java file from module.one._1d_and_2d_array.lecture.day3 package.
 * */
public class _6SubmatrixSum {

    public static void main(String[] args) {
        printSubmatrixSum(List.of(List.of(1, 1), List.of(1, 1)));
        printSubmatrixSum(List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9)));
    }

    // Time complexity: O(M*N), Space complexity: O(1)
    private static void printSubmatrixSum(List<List<Integer>> mat) {
        int sum = 0, m = mat.size(), n = mat.get(0).size();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                sum += ((r + 1) * (c + 1)) * ((m - r) * (n - c)) * mat.get(r).get(c);
            }
        }
        System.out.println("Submatrix sum: " + sum);
    }

}