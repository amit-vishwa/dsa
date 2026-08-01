package module.one.backtracking.notes;

/**
 * Rat in a Maze: [Equivalent Leetcode 980. Unique Paths III]
 * <p>
 * Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N - 1, N - 1). Find all
 * possible paths that the rat can take to reach from source to destination. The directions in which the rat can move are 'U'(up),
 * 'D'(down), 'L' (left), and 'R' (right). Value 0 at a cell in the matrix represents that it is blocked and the rat cannot move to
 * it while value 1 at a cell in the matrix represents that the rat can travel through it.
 * <p>
 * Example
 * Input: N = 4 m[][] = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}}
 * Output: DDRDRR DRDDRR
 * <p>
 * Approach:
 * - The approach is quite simple for this problem.
 * - We just have to visit only the cell which are in maze and marked as can be visited i.e. 1 here.
 * - When row and col is last index then we have reached to end that means we got our answer just print the ways.
 * - If current cell is not 1 that means we cannot visit it we have to return from there.
 * - Then we mark current cell as visited if it is 1, then explore in all 4 ways and adding the directions in path string.
 * - After exploring all the ways we are backtracking by resetting the cell value.
 * - Time complexity: O(4^(M*N)) 4 is for 4 possible ways and M*N is 2D maze, when N==M then O(4^(N^2))
 * - Space complexity: O(M*N) for recursion stack = O(N^2) when M==N.
 * - We also have one more approach where we are using extra 2D array to mark cell as visited however the time complexity will
 * remain same but extra space will be added for hash array, so this approach is more optimal.
 */
public class _2RatInAMaze {

    public static void main(String[] args) {
        maze(new int[][]{
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        }, 4, 0, 0, "");
    }

    private static void maze(int[][] board, int n, int row, int col, String path) {
        if (row == n - 1 && col == n - 1) {
            System.out.println(path);
            return;
        }
        if (board[row][col] != 1) {
            return;
        }
        board[row][col] = 0;
        if (row < n - 1) {
            maze(board, n, row + 1, col, path + 'D');
        }
        if (col < n - 1) {
            maze(board, n, row, col + 1, path + 'R');
        }
        if (row > 0) {
            maze(board, n, row - 1, col, path + 'U');
        }
        if (col > 0) {
            maze(board, n, row, col - 1, path + 'L');
        }
        board[row][col] = 1;
    }

}
