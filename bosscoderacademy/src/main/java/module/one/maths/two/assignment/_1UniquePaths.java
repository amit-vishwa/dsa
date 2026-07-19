package module.one.maths.two.assignment;

/**
 * Unique Paths:
 * <p>
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or
 * right at any point in time.
 * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the
 * bottom-right corner.
 * <p>
 * Input 1:
 * m = 3, n = 2
 * Output 1:
 * 3
 * Explanation 1:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * Right -> Down -> Down
 * Down -> Down -> Right
 * Down -> Right -> Down
 * <p>
 * Input 2:
 * m = 3, n = 7
 * Output 2:
 * 28
 * <p>
 * Constraints:
 * 1 <= m, n <= 102
 */
public class _1UniquePaths {

    public static void main(String[] args) {
        printPathCount(3, 2);
        System.out.println();
        printPathCount(3, 7);
    }

    private static void printPathCount(int m, int n) {
        System.out.println("Unique paths by approach 1: " + approach1(m, n));
        System.out.println("Unique paths by approach 2: " + approach2(m, n));
        System.out.println();
    }

    /**
     * Approach 1 - Math
     * - This is an optimal solution.
     * - Here, we are iterating through the row and calculating the answer by taking the (column + index) / index
     * - At last, just return the answer.
     * - Time complexity: O(M) i.e. row size.
     * - Space complexity: O(1)
     */
    private static int approach1(int m, int n) {
        int ans = 1;
        for (int i = 1; i < m; i++) {
            ans = ans * (n - 1 + i) / i;
        }
        return ans;
    }

    /**
     * Approach 2 - DP:
     * - This is a non-optimal solution.
     * - There are multiple approaches to solve this problem, however I am only aware of dynamic programming approach now.
     * - The logic is simple, as robot can move in right and down directions, mark first row and col as 1 as it will take 1 step.
     * - Now, to reach diagonal the number of steps would be sum of steps from prev row and prev col.
     * - Repeat the same process until the matrix is traversed completely.
     * - At last, just return the unique path value i.e. the last cell value.
     * - Time complexity: O(M*N) as we are traversing the whole matrix.
     * - Space complexity: O(M*N) as we require to create matrix and traverse on it to calculate unique paths.
     */
    private static int approach2(int m, int n) {
        if (m == 0 && n == 0) {
            return 0;
        }
        int[][] mat = new int[m][n];
        System.out.println("Matrix: ");
        display(mat);
        mat[0][0] = 1;
        // populate first col
        for (int row = 1; row < m; row++) {
            mat[row][0] = 1;
        }
        // populate first row
        for (int col = 1; col < n; col++) {
            mat[0][col] = 1;
        }
        // populate rest cell
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                mat[r][c] = mat[r - 1][c] + mat[r][c - 1];
            }
        }
        System.out.println("Updated matrix: ");
        display(mat);
        return mat[m - 1][n - 1]; // unique path to reach last cell
    }

    private static void display(int[][] mat) {
        for (int[] row : mat) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}