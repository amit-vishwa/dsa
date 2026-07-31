package module.one.backtracking.lecture;

/**
 * Place N Queens: [Leetcode 51. N-Queens]
 * <p>
 * Given N Queens, place them on the N*N board and print the board.
 * <p>
 * Approach:
 * - The approach is quite simple, we just have to iterate over the columns of a row.
 * - Then check for each column if Q can be placed by calling isSafe boolean method.
 * - The method will check for Q in same column with previous row i.e. vertically and positive and negative diagonally.
 * - We just have to check the half part of the board.
 * - As we have not explored the next columns or rows we do not have to check for them.
 * - If Q can be placed then update that cell value to Q and explore for next row as we do no require to check for same row.
 * - After exploring, when we are returning back we can replace cell value with old value.
 * - When all rows are visited then we can print the board as we have place the N Queens on the board.
 * - Time complexity: O(N) for boolean function * O(N!) for recursion calls = O(N*N!)
 * - Space complexity: O(N+1) for recursion stack i.e. row goes from 0 to board length i.e. N+1 = O(N)
 */
public class _1NQueens {

    public static void main(String[] args) {
        placeNQueens(4);
        placeNQueens(5);
    }

    private static void placeNQueens(int queens) {
        char[][] board = new char[queens][queens];
        for (char[] row : board) {
            for (int col = 0; col < row.length; col++) {
                row[col] = 'X';
            }
        }
        placeQueens(board, 0);
    }

    private static void placeQueens(char[][] board, int row) {
        if (row == board.length) {
            printBoard(board);
            return;
        }
        for (int col = 0; col < board[row].length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                placeQueens(board, row + 1);
                board[row][col] = 'X';
            }
        }
    }

    private static void printBoard(char[][] board) {
        for (char[] row : board) {
            System.out.print("[ ");
            for (int col = 0; col < row.length; col++) {
                System.out.print(row[col]);
                if (col < row.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println(" ]");
        }
        System.out.println();
    }

    private static boolean isSafe(char[][] board, int row, int col) {
        for (int r = row; r >= 0; r--) {
            if (board[r][col] == 'Q') {
                return false;
            }
        }
        for (int r = row, c = col; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }
        for (int r = row, c = col; r >= 0 && c < board[r].length; r--, c++) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }
        return true;
    }

}
