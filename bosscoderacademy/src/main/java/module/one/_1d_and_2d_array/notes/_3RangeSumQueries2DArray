package module.one._1d_and_2d_array.notes;

import java.util.Scanner;
import java.util.Arrays;

public class _3RangeSumQueries2DArray {

    public static void main(String[] args) {
        printRangeSum();
    }

    private static void printRangeSum() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter row length: ");
        int m = sc.nextInt();
        System.out.print("Enter col length: ");
        int n = sc.nextInt();
        int[][] mat = new int[m][n];
        System.out.print("Enter matrix elements: ");
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                mat[r][c] = sc.nextInt();
            }
        }
        System.out.println("Matrix: ");
        System.out.println(Arrays.deepToString(mat));
        approach1(mat, sc);
        System.out.println();
        approach2(mat, sc);
    }

    /**
     * Approach 1 - Brutefoce approach:
     * - Here, we are simply iterating over the matrix from start cell to end cell.
     * - And then we are calculating the sum.
     * - Iteration takes O(M*N) time and querying takes O(Q) time.
     * - So, total time complexity becomes O(M*N) * O(Q) = O(M*N*Q), which is not good.
     * - Space complexity is O(1), as we are not taking any extra space dependent on input.
     */
    private static void approach1(int[][] mat, Scanner sc) {
        System.out.print("Enter query count for approach 1: ");
        int q = sc.nextInt();
        while (q > 0) { // Time complexity: O(Q)
            System.out.print("\nEnter starting co-ordinates: ");
            int r1 = sc.nextInt();
            int c1 = sc.nextInt();
            System.out.print("Enter ending co-ordinates: ");
            int r2 = sc.nextInt();
            int c2 = sc.nextInt();
            performApproach1Operation(mat, r1, c1, r2, c2);
            q -= 1;
        }
    }

    // Time complexity: O(M*N), Space complexity: O(1)
    private static void performApproach1Operation(int[][] mat, int r1, int c1, int r2, int c2) {
        if (r1 < 0 || c1 < 0 || r2 >= mat.length || c2 >= mat[0].length || r1 > r2 || c1 > c2) {
            System.out.println("Invalid co-ordinates provided!");
            return;
        }
        int sum = 0;
        for (int r = r1; r <= r2; r++) {
            for (int c = c1; c <= c2; c++) {
                sum += mat[r][c];
            }
        }
        System.out.println("Range sum from cell [" + r1 + ", " + c1 + "] to cell [" + r2 + ", " + c2 + "]: " + sum);
    }

    /**
     * Approach 2 - Optimal approach:
     * - Here, we are creating the prefix sum matrix by calculating prefix of all matrices.
     * - After that we are simply fetching the ending cell element from prefix sum matrix and
     * reducing the top right cell and bottom left cell from above start cell and bottom left cell
     * respectively, also adding the top diagonal cell value as it is reduced twice.
     * - So the answer here will be:
     * ans = endPrefixMatrixCell - aboveTopRowBottomCol - leftTopColBottomRow +
     * aboveTopRowLeftTopCol (i.e. prev diagonal cell)
     * - The time and space complexity of creating prefixSumArray is O(M*N).
     * - We can create prefixSumMatrix by creating the prefixSumArray of first row and first
     * col and then for rest cells we can add top and left cells minus prev diagonal cell for
     * current cell.
     * The formula will be: currentPrefixMatrixCell = topPrefixMatrixCell + leftPrefixMatrixCell
     * - prevDiagonalPrefixMatrixCell (as it is already computed in top and left cells) +
     * actualCurrentCellValue
     * - Then querying the results takes O(Q) with actual answer obtaining is O(1).
     * - So, total time complexity is O(M*N) + [ O(Q) * O(1) ] = O(M*N) + O(Q) = O(M*N + Q)
     * - And space complexity is O(M*N) for creating the prefix sum array.
     */
    private static void approach2(int[][] mat, Scanner sc) {
        int[][] prefixSumMatrix = getPrefixSumMatrix(mat, mat.length, mat[0].length);
        System.out.print("Enter query count for approach 2: ");
        int q = sc.nextInt();
        while (q > 0) { // Time complexity: O(Q)
            System.out.print("\nEnter starting co-ordinates: ");
            int r1 = sc.nextInt();
            int c1 = sc.nextInt();
            System.out.print("Enter ending co-ordinates: ");
            int r2 = sc.nextInt();
            int c2 = sc.nextInt();
            performApproach2Operation(prefixSumMatrix, mat, r1, c1, r2, c2);
            q -= 1;
        }
    }

    // Time and space complexity is O(M*N).
    private static int[][] getPrefixSumMatrix(int[][] mat, int m, int n) {
        int[][] prefixSumMatrix = new int[m][n];
        prefixSumMatrix[0][0] = mat[0][0];
        // populating first row
        for (int c = 1; c < n; c++) {
            prefixSumMatrix[0][c] = prefixSumMatrix[0][c - 1] + mat[0][c];
        }
        // populating first col
        for (int r = 1; r < m; r++) {
            prefixSumMatrix[r][0] = prefixSumMatrix[r - 1][0] + mat[r][0];
        }
        // populating rest cells
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                prefixSumMatrix[r][c] = prefixSumMatrix[r - 1][c] + prefixSumMatrix[r][c - 1]
                        - prefixSumMatrix[r - 1][c - 1] + mat[r][c];
            }
        }
        System.out.println("Prefix sum matrix: " + Arrays.deepToString(prefixSumMatrix));
        return prefixSumMatrix;
    }

    // Time and space complexity is O(1).
    private static void performApproach2Operation(int[][] prefixSumMatrix, int[][] mat, int r1, int c1, int r2, int c2) {
        if (r1 < 0 || c1 < 0 || r2 >= mat.length || c2 >= mat[0].length || r1 > r2 || c1 > c2) {
            System.out.println("Invalid co-ordinates provided!");
            return;
        }
        int topRow = r1 > 0 ? prefixSumMatrix[r1 - 1][c2] : 0;
        int leftCol = c1 > 0 ? prefixSumMatrix[r2][c1 - 1] : 0;
        int prevDiagonal = r1 > 0 && c1 > 0 ? prefixSumMatrix[r1 - 1][c1 - 1] : 0;
        int sum = prefixSumMatrix[r2][c2] - topRow - leftCol + prevDiagonal;
        System.out.println("Range sum from cell [" + r1 + ", " + c1 + "] to cell [" + r2 + ", " + c2 + "]: " + sum);
    }

}
