package module.one.backtracking.notes;

import java.util.ArrayList;
import java.util.List;

/**
 * N-Queens: [Leetcode 51. N-Queens]
 *
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
 * Each solution contains a distinct board configuration of the queens' placement, where 'Q' and '.' both indicate a queen
 * and an empty space, respectively.
 *
 * Input: n = 4
 * Output: [[".Q..","...Q", "Q...","..Q."],["..Q.", "Q...","...Q",".Q.."]]
 */
public class _1NQueens {

    public static void main(String[] args) {
        printNQueens(4);
    }

    private static void printNQueens(int n) {
        List<List<String>> boardList;
        System.out.println("N Queens by approach 1:");
        boardList = approach1(n);
        for (List<String> board : boardList) {
            for (String row : board) {
                System.out.println("[ " + row + " ]");
            }
            System.out.println();
        }
        System.out.println("N Queens by approach 2:");
        boardList = approach2(n);
        for (List<String> board : boardList) {
            for (String row : board) {
                System.out.println("[ " + row + " ]");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Approach 1:
     * - Here, we are using recursion and backtracking to place N Queens on the board.
     * - We are initializing the board with '.' and row with 0, and a list of string.
     * - For each cell we are first checking if placing Queen on that cell is safe or not.
     * - For checking safe we are checking if any Queen is present in same column in previous row and both previous diagonals.
     * - If we are good to place queen, we are placing the queen by updating cell value to 'Q' and add string to list.
     * - Then we are exploring for next row as in a row a single Queen can be placed, then after call is returned we are backtracking
     * by update the cell value back to '.'.
     * - When row is equal to N then we have traversed the board and placed all N Queens.
     * - We got our answer, we are storing it inside the nested list of string.
     * - Time complexity: O(N!) for placing queens as a queen is place n-1 choices will be left which keeps on repeating * O(N) for
     * checking the safety while placing the queen = O(N*N!)
     * - Space complexity: O(N) for recursion
     */
    private static List<List<String>> approach1(int n) {
        char[][] board = new char[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                board[row][col] = '.';
            }
        }
        return helper1(board, 0, new ArrayList<String>());
    }

    private static List<List<String>> helper1(char[][] board, int row, List<String> ans) {
        if (row == board.length) {
            return new ArrayList<>(List.of(new ArrayList<>(ans)));
        }
        List<List<String>> ansList = new ArrayList<>();
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                ans.add(String.valueOf(board[row]));
                ansList.addAll(helper1(board, row + 1, ans));
                ans.removeLast();
                board[row][col] = '.';
            }
        }
        return ansList;
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
        for (int r = row, c = col; r >= 0 && c < board.length; r--, c++) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }
        return true;
    }

    /**
     * Approach 2:
     * - The approach is similar to approach 1.
     * - Here, we have just optimized the isSafe function so that time complexity of O(N) can be reduced to O(1).
     * - However, we have space complexity added to O(N) for hash array.
     * - We will create 4 boolean array to mark row, col, positive and negative diagonals as visited.
     * - The marking row and col as visited is simple just update row and col valued index to true.
     * - The size of row and col hash array would be similar to row and col size only, however the size of diagonal array is 2*N-1.
     * - Now for positive diagonal visit we have to mark index which is sum of row and col as true when row col is visited.
     * - For negative diagonal we will mark index which is sum of N-1 and col-row i.e. (N-1)+(Col-Row) as visited.
     * - Rest of the steps would be same, however while backtracking we have to revert hash array values to mark them as not visited.
     * - Time complexity: O(N!) as we have optimized isSafe function and using hash array to mark visits.
     * - Space complexity: O(N) for recursion stack + O(N) for hash array = O(N)
     */
    private static List<List<String>> approach2(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board) {
            for (int col = 0; col < n; col++) {
                row[col] = '.';
            }
        }
        return helper2(board, n, 0, new ArrayList<String>(), new boolean[n], new boolean[n], new boolean[2 * n - 1],
                new boolean[2 * n - 1]);
    }

    private static List<List<String>> helper2(char[][] board, int n, int row, List<String> ans, boolean[] rowVisited,
                                              boolean[] colVisited, boolean[] diagonal1Visited, boolean[] diagonal2Visited) {
        if (row == n) {
            return new ArrayList<>(List.of(new ArrayList<>(ans)));
        }
        List<List<String>> ansList = new ArrayList<>();
        for (int col = 0; col < n; col++) {
            if (!rowVisited[row] && !colVisited[col] && !diagonal1Visited[row + col] && !diagonal2Visited[n - 1 + col - row]) {
                rowVisited[row] = true;
                colVisited[col] = true;
                diagonal1Visited[row + col] = true;
                diagonal2Visited[n - 1 + col - row] = true;
                board[row][col] = 'Q';
                ans.add(String.valueOf(board[row]));
                ansList.addAll(helper2(board, n, row + 1, ans, rowVisited, colVisited, diagonal1Visited, diagonal2Visited));
                ans.removeLast();
                board[row][col] = '.';
                rowVisited[row] = false;
                colVisited[col] = false;
                diagonal1Visited[row + col] = false;
                diagonal2Visited[n - 1 + col - row] = false;
            }
        }
        return ansList;
    }
}
