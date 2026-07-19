package module.one.backtracking.assignment;

/**
 * LeetCode 37. Sudoku Solver
 * Refer: https://leetcode.com/problems/sudoku-solver/description/
 */
public class _6SudokuSolver {

    public static void main(String[] args) {
        solveSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        });
    }

    /**
     * Approach:
     * - The approach is simple, we have to set initial row and col values as 0.
     * - Check if col is exhausted, then reset it and increment row.
     * - Now check if row is exhausted that means sudoku board is visited and solved, return true.
     * - Now, first check if current cell is empty then proceed with placing numbers from 1 to 9.
     * - Else, increase col value and check for next cell.
     * - Now while placing numbers check if that can be placed, iterate row-wise, col-wise and grid-wise.
     * - For grid we have formula of row/3 * 3 for row and col/3*3 for col, to get starting indices.
     * - If number already exists then cannot be placed, check for next number.
     * - Time complexity: O(9^(M*N)) where 9 is numbers that can be chosen, M is row and N is col = O(9^(N^2)) i.e. M==N
     * - Space complexity: O(M*N) due to recursion stack = O(N^2) as both are equal here.
     */
    private static void solveSudoku(char[][] board) {
        if (solve(board, 0, 0)) {
            printBoard(board);
        }
    }

    private static boolean solve(char[][] board, int row, int col) {
        if (col == 9) {
            col = 0;
            row++;
        }
        if (row == 9) {
            return true;
        }
        if (board[row][col] == '.') {
            for (char num = '1'; num <= '9'; num++) {
                if (isPossible(board, row, col, num)) {
                    board[row][col] = num;
                    if (solve(board, row, col + 1)) {
                        return true;
                    }
                    board[row][col] = '.';
                }
            }
            return false;
        }
        return solve(board, row, col + 1);
    }

    private static boolean isPossible(char[][] board, int row, int col, char num) {
        for (int r = 0; r < 9; r++) {
            if (board[r][col] == num) {
                return false;
            }
        }
        for (int c = 0; c < 9; c++) {
            if (board[row][c] == num) {
                return false;
            }
        }
        int rS = row / 3 * 3, cS = col / 3 * 3;
        for (int r = rS; r < rS + 3; r++) {
            for (int c = cS; c < cS + 3; c++) {
                if (board[r][c] == num) {
                    return false;
                }
            }
        }
        return true;
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

}