package module.one.recursion.two.notes;

/**
 * Number of ways to reach from source to destination with obstacles:
 *
 * Given a maze with obstacles, count the number of paths to reach the rightmost-bottommost cell from the topmost-leftmost
 * cell. A cell in the given maze has a value of -1 if it is a blockage or dead-end, else 0.
 *
 * From a given cell, we are allowed to move to cells (i+1, j) and (i, j+1) only.
 *
 * Examples
 * Input: maze[R][C] =  {{0,  0, 0, 0}, {0, -1, 0, 0}, {-1, 0, 0, 0}, {0,  0, 0, 0}};
 * Output: 4
 */
public class _4DestinationWays {

    // using MOD for large numbers
    static int MOD = 1000000007;

    public static void main(String[] args) {
        System.out.println(maze(new int[][]{
                {0, 0, 0, 0},
                {0, -1, 0, 0},
                {-1, 0, 0, 0},
                {0, 0, 0, 0}
        }, 3, 3));
    }

    /**
     * Approach:
     * - The approach is simple, we just have to check if row or col is 0 that is we have reached from end to start.
     * - We are increasing the count by 1 if we have reached from end to start.
     * - If we encounter any obstacles i.e. cell value is -1, or we have reached a dead-end i.e. row or col < 0,
     * then we are simply returning with 0.
     * - We are performing this for row and col both simultaneously and calculating the sum.
     * - At last we will be left with the final number of ways in which we can reach from end to start.
     * - Time complexity: O(Row) iterating over row + O(Col) iterating over col = O(R+C)
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int maze(int[][] mat, int row, int col) {
        if (row < 0 || col < 0 || mat[row][col] == -1) {
            return 0;
        }
        if (row == 0 && col == 0) {
            return 1;
        }
        return (maze(mat, row - 1, col) % MOD + maze(mat, row, col - 1) % MOD) % MOD;
    }

}