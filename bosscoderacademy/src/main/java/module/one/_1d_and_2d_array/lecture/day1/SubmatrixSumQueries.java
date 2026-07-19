package module.one._1d_and_2d_array.lecture.day1;

import java.util.Scanner;

/**
 * Sub-matrix sum queries:
 * Given a matrix find the sum of sub-matrix when start and end co-ordinates are provided.
 * <p>
 * Similar to range sum queries, this problem can be solved by 2 approaches.
 * 1.Bruteforce approach:
 * - Traverse the matrix from starting co-ordinates to ending co-ordinates and calculate sum.
 * - This will take O(N*M) time.
 * - But we have to do this for Q queries, so total complexity will be O(M*N*Q).
 * - If M = N = Q, then this complexity will become O(N^3) which is very bad.
 * - However, space complexity is O(1) only as we are not taking any extra space.
 * <p>
 * 2.Optimal approach:
 * - Again we can solve this problem using prefix sum approach.
 * - We can create a matrix with prefix sum of sub-matrices stored in it.
 * - The creation of this matrix will take O(M*N) time and space.
 * - However, the result finding process will take only O(1) time for Q queries.
 * - So, time complexity will become O(M*N) + O(Q) * O(1) = O(M*N + Q), which is much better than bruteforce.
 * - Space complexity: O(M*N) because of prefixSum matrix.
 */
public class SubmatrixSumQueries {

    public static void main(String[] args) {
        printSubmatrixSum(new int[][]{
                {5, 2, 4, 7, 6},
                {7, 3, 2, 1, 8},
                {1, 3, 8, 9, 10},
                {9, 6, 10, 5, 4}
        });
    }

    /**
     * Total time complexity is O(M*N) for prefixSumMatrix and O(Q) for queries * O(1) for getting result
     * Time complexity: O(M*N) + O(Q) * O(1) = O(M*N) + O(Q*1) = O(M*N) + O(Q) = O(M*N + Q)
     * Space complexity: O(M*N) for create prefix sum matrix.
     */
    private static void printSubmatrixSum(int[][] mat) {
        int m = mat.length;
        if (m == 0) {
            return;
        }
        int n = mat[0].length;
        if (n == 0) {
            return;
        }
        System.out.println("Matrix:");
        display(mat);
        int[][] prefixSumMatrix = createPrefixSumMatrix(mat, m, n);
        System.out.println("Prefix Sum Matrix:");
        display(prefixSumMatrix);
        System.out.print("Enter query count: ");
        Scanner sc = new Scanner(System.in);
        int queryCount = sc.nextInt();
        // Time complexity for Q queries is O(Q)
        while (queryCount > 0) {
            performOperation(prefixSumMatrix, sc);
            queryCount--;
        }
    }

    // Time complexity for finding the result is O(1)
    private static void performOperation(int[][] prefixSumMatrix, Scanner sc) {
        System.out.print("\nEnter starting co-ordinates: ");
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        System.out.print("Enter ending co-ordinates: ");
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();
        if (r1 < 0 || c1 < 0 || r2 >= prefixSumMatrix.length || c2 >= prefixSumMatrix[0].length
                || r1 > r2 || c1 > c2) {
            System.out.println("Invalid co-ordinates provided");
            return;
        }
        int lastCell = prefixSumMatrix[r2][c2];
        int topCell = r1 == 0 ? 0 : prefixSumMatrix[r1 - 1][c2];
        int leftCell = c1 == 0 ? 0 : prefixSumMatrix[r2][c1 - 1];
        int topLeftCell = r1 == 0 || c1 == 0 ? 0 : prefixSumMatrix[r1 - 1][c1 - 1];
        int submatrixSum = lastCell - topCell - leftCell
                + topLeftCell;
        System.out.println("Submatrix sum: " + submatrixSum);
    }

    // Time complexity for create prefix matrix is O(N*M)
    private static int[][] createPrefixSumMatrix(int[][] mat, int m, int n) {
        int[][] prefixSumMatrix = new int[m][n];
        prefixSumMatrix[0][0] = mat[0][0];
        // populate first column
        for (int i = 1; i < m; i++) {
            prefixSumMatrix[i][0] = prefixSumMatrix[i - 1][0] + mat[i][0];
        }
        // populate first row
        for (int i = 1; i < n; i++) {
            prefixSumMatrix[0][i] = prefixSumMatrix[0][i - 1] + mat[0][i];
        }
        // populate rest cells
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                prefixSumMatrix[i][j] = prefixSumMatrix[i - 1][j] + prefixSumMatrix[i][j - 1]
                        - prefixSumMatrix[i - 1][j - 1] + mat[i][j];
            }
        }
        return prefixSumMatrix;
    }

    private static void display(int[][] mat) {
        for (int[] row : mat) {
            for (int i = 0; i < row.length; i++) {
                System.out.print(row[i]);
                if (i < row.length - 1) {
                    System.out.print(", ");
                } else {
                    System.out.println();
                }
            }
        }
        System.out.println();
    }

}
