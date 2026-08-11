package module.one.backtracking.implementationLab;

/**
 * Sudoku solver: [Leetcode 37. Sudoku Solver]
 * <p>
 * Given a Sudoku, write a program to solve it.
 * <p>
 * Approach:
 * - The approach is simple, just pass the 2D array along with starting row and col values.
 * - Start with checking current cell, if it is '.' then proceed with placing numbers 1-9 and explore solutions.
 * - If a number can be placed then place that number on the cell and explore solution for the next cell.
 * - If we got true as answer then true that Sudoku is solved, else backtrack by resetting the cell value.
 * - If we came out of the loop and no number can be placed from 1 and 9 in a cell then return false that Sudoku cannot be solved.
 * - Also, if current cell is not '.' then proceed with checking the next cell by incrementing the column value.
 * - When col becomes 9, just reset it to 0 and increment row, when row becomes 9 then we got sudoku solved and return true.
 * - Time complexity: O(9 to place 9 numbers on each cell ^ (M for row * N for col)) = O(9^(M*N))
 * = O(9^(N^2)) when M and N are same = O(9^(9*9)) when N is 9 = O(9^81) which is quite more, but it will be fixed.
 * - Space complexity: O(1) as no extra space is used here that will be dependent on input.
 */
public class _2SudokuSolver {

    public static void main(String[] args) {
        solve(new char[][]{
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

    private static void solve(char[][] board) {
        if (sudokuSolved(board, 0, 0)) {
            printBoard(board);
        }
    }

    private static boolean sudokuSolved(char[][] board, int row, int col) {
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
                    if (sudokuSolved(board, row, col + 1)) {
                        return true;
                    }
                    board[row][col] = '.';
                }
            }
            return false;
        } else {
            return sudokuSolved(board, row, col + 1);
        }
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
        int r = row / 3 * 3;
        int c = col / 3 * 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
                if (j < board[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println(" ]");
        }
        System.out.println();
    }

}
