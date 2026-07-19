package module.one._1d_and_2d_array.lecture.day3;

/**
 * Sum of all sub matrices:
 * Given a matrix, find the sum of all sub-matrices.
 * Example: mat = [[1,1], [1,1]], sum = 16 i.e. 4 matrices of 1 element, 4 matrices of 2 elements and 1 matrix of 4 elements.
 * <p>
 * Approaches:
 * 1. Bruteforce - find all the sub-matrices, then calculate the cumulative sum for all.
 * 2. Optimal - derive a formula to find the sum in O(M*N) time complexity.
 */
public class AllSubmatricesSum {

    public static void main(String[] args) {
        printSubMatricesSum(new int[][]{
                {1, 1}, {1, 1}
        });
        printSubMatricesSum(new int[][]{
                {1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}
        });
    }

    private static void printSubMatricesSum(int[][] mat) {
        System.out.println("Sum by approach1: " + approach1(mat));
        System.out.println("Sum by approach2: " + approach2(mat));
    }

    /**
     * Approach 1: Bruteforce approach
     * - Here we are starting from first cell and ending at last cell of matrix.
     * - We are creating all the possible sub-matrices and then calculating sum of them.
     * - Storing the matrices sum in a sum variable.
     * - This is giving the worst time complexity.
     * - Time complexity:
     * O(M*N) for r1c1 * O(M*N) for r2c2 * O(M*N) for sum = O(M*N * M*N * M*N) = O(M^3 * N^3) = O(N^6) if M==N
     * - Space complexity: O(1)
     */
    private static int approach1(int[][] mat) {
        int sum = 0, m = mat.length, n = mat[0].length;
        for (int r1 = 0; r1 < m; r1++) {
            for (int c1 = 0; c1 < n; c1++) {
                for (int r2 = r1; r2 < m; r2++) {
                    for (int c2 = c1; c2 < n; c2++) {
                        for (int r = r1; r <= r2; r++) {
                            for (int c = c1; c <= c2; c++) {
                                sum += mat[r][c];
                            }
                        }
                    }
                }
            }
        }
        return sum;
    }

    /**
     * Approach 2: Optimal approach
     * - This is the most optimal approach as we are solving the problem in O(M*N) time with O(1) space.
     * - Here, we have derived a formula to find sum of sub-matrices which gives results in O(1) complexity.
     * - So we are just traversing the matrix in O(M*N) time complexity and calculating the cumulative sum.
     * - Time complexity: O(M*N)
     * - Space complexity: O(1)
     */
    private static int approach2(int[][] mat) {
        int sum = 0, m = mat.length, n = mat[0].length;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int topLefts = (r + 1) * (c + 1);
                int bottomRights = (m - r) * (n - c);
                sum += topLefts * bottomRights * mat[r][c];
            }
        }
        return sum;
    }

}
