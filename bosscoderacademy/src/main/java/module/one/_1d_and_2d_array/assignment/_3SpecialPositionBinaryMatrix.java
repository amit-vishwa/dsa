package module.one._1d_and_2d_array.assignment;

import java.util.List;

/**
 * Special Position Binary Matrix:
 * Given an m x n binary matrix mat, return the number of special positions in mat.
 * A position (i, j) is called special if mat[i][j] == 1 and all other elements in row i and column j are 0
 * (rows and columns are 0-indexed).
 * <p>
 * Input 1: mat = [[1,0,0],[0,0,1],[1,0,0]]
 * Output 1: 1
 * Explanation 1: (1, 2) is a special position because mat[1][2] == 1 and all other elements in row 1 and
 * column 2 are 0.
 * <p>
 * Input 2: mat = [[1,0,0],[0,1,0],[0,0,1]]
 * Output 2: 3
 * <p>
 * Constraints:
 * 1 <= mat.length, mat[i].length <= 102
 * mat[i][j] is either 0 or 1.
 */
public class _3SpecialPositionBinaryMatrix {

    public static void main(String[] args) {
        printSpecialPositionCount(List.of(List.of(1, 0, 0), List.of(0, 0, 1), List.of(1, 0, 0)));
        printSpecialPositionCount(List.of(List.of(1, 0, 0), List.of(0, 1, 0), List.of(0, 0, 1)));
    }

    private static void printSpecialPositionCount(List<List<Integer>> input) {
        System.out.println("Special position count by approach1: " + approach1(input));
        System.out.println("Special position count by approach2: " + approach2(input));
        System.out.println();
    }

    /**
     * Approach 1: Bruteforce approach
     * - Here, we are traversing the matrix and for each cell where value is 1, we are traversing in
     * top, left, right and bottom directions to check for ones.
     * - If not found, then that cell position is good, we are incrementing our counter.
     * - Else we are skipping the incrementation process.
     * - Time complexity:
     * O(M*N) for traversing matrix * O(Max(M-1, N-1)) as we are searching for 1s in row & col
     * = O(M*N * Max(M-1,N-1))
     * - Space complexity: O(1) as we are not taking any extra space.
     */
    private static int approach1(List<List<Integer>> mat) {
        int goodPos = 0, m = mat.size(), n = mat.get(0).size();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (mat.get(r).get(c) == 1) {
                    int i = r - 1, count = 0;
                    while (i >= 0) {
                        if (mat.get(i--).get(c) == 1) {
                            count++;
                        }
                    }
                    i = r + 1;
                    while (i < m) {
                        if (mat.get(i++).get(c) == 1) {
                            count++;
                        }
                    }
                    i = c - 1;
                    while (i >= 0) {
                        if (mat.get(r).get(i--) == 1) {
                            count++;
                        }
                    }
                    i = c + 1;
                    while (i < n) {
                        if (mat.get(r).get(i++) == 1) {
                            count++;
                        }
                    }
                    if (count == 0) {
                        goodPos++;
                    }
                }
            }
        }
        return goodPos;
    }

    /**
     * Approach 2: Optimal approach
     * - Here we are creating arrays to store ones counter in rows and cols.
     * - Then while traversing the matrix, when we get 1, we are checking ones count in row and col array.
     * - If all are one then position is good, increment the counter else skip.
     * - Time complexity: O(M*N) for storing 1s count in row and col array + O(M * N) for final traversal
     * = O(M*N) + O(M*N) = O(2 (M*N)) = O(M*N) as constants and small values are ignored
     * - Space complexity: O(Max(M,N)) as we are creating arrays for row and col.
     */
    private static int approach2(List<List<Integer>> mat) {
        int m = mat.size(), n = mat.get(0).size(), goodPos = 0;
        int[] rowOnes = new int[m];
        int[] colOnes = new int[n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (mat.get(r).get(c) == 1) {
                    rowOnes[r]++;
                    colOnes[c]++;
                }
            }
        }
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (mat.get(r).get(c) == 1 && rowOnes[r] == 1 && colOnes[c] == 1) {
                    goodPos++;
                }
            }
        }
        return goodPos;
    }

}