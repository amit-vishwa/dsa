package module.two.graph.assignment;

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Surrounded Regions:
 * <p>
 * Given an m x n matrix board containing '1' and '0', capture all regions that are 4-directionally surrounded by '1'.
 * A region is captured by flipping all '0's into '1's in that surrounded region.
 * <p>
 * Input: board = [["1","1","1","1"],["1","0","0","1"],["1","1","0","1"],["1","0","1","1"]]
 * Output: [["1","1","1","1"],["1","1","1","1"],["1","1","1","1"],["1","0","1","1"]]
 * <p>
 * Input: board = [["1"]]
 * Output: [["1"]]
 * <p>
 * Constraints:
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] is '1' or '0'.
 */
public class _5SurroundedRegions {

    private static List<List<Integer>> getInput1() {
        List<Integer> row1 = new ArrayList<>(List.of(1, 1, 1, 1));
        List<Integer> row2 = new ArrayList<>(List.of(1, 0, 0, 1));
        List<Integer> row3 = new ArrayList<>(List.of(1, 1, 0, 1));
        List<Integer> row4 = new ArrayList<>(List.of(1, 0, 1, 1));
        return new ArrayList<>(List.of(row1, row2, row3, row4));
    }

    private static List<List<Integer>> getInput2() {
        return new ArrayList<>(List.of(new ArrayList<>(List.of(1))));
    }

    public static void main(String[] args) {
        printSurroundedRegions(getInput1());
        printSurroundedRegions(getInput2());
    }

    private static void printSurroundedRegions(List<List<Integer>> board) {
        System.out.println("Surrounded regions using DFS: " + approach1(board));
        System.out.println("Surrounded regions using BFS: " + approach2(board));
        System.out.println();
    }

    /**
     * Approach 1 - DFS
     * - This is a simple recursive approach using Depth First Search traversal.
     * - We are marking the cells as safe by updating the value to 2 if it is 0.
     * - We are doing this for boundary regions, first col and row and last col and row.
     * - We are traversing in 4 directions to update the board.
     * - Then at last we are checking if cell is marked as safe, then we are reverting it.
     * - Else if it is marked as 0, then we are updating it to 1.
     * - Time complexity: O(M*N) due to 2D board traversal using DFS.
     * - Space complexity: O(M*N) due to recursion stack.
     * *
     */
    private static List<List<Integer>> approach1(List<List<Integer>> board) {
        int m = board.size(), n = board.get(0).size();
        for (int r = 0; r < m; r++) {
            dfs(board, r, 0, m, n);
            dfs(board, r, n - 1, m, n);
        }
        for (int c = 0; c < n; c++) {
            dfs(board, 0, c, m, n);
            dfs(board, m - 1, c, m, n);
        }
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board.get(r).get(c) == 0) {
                    board.get(r).set(c, 1);
                } else if (board.get(r).get(c) == 2) {
                    board.get(r).set(c, 0);
                }
            }
        }
        return board;
    }

    private static void dfs(List<List<Integer>> board, int r, int c, int m, int n) {
        if (r < 0 || c < 0 || r >= m || c >= n || board.get(r).get(c) != 0) {
            return;
        }
        board.get(r).set(c, 2);
        dfs(board, r + 1, c, m, n);
        dfs(board, r - 1, c, m, n);
        dfs(board, r, c + 1, m, n);
        dfs(board, r, c - 1, m, n);
    }

    /**
     * Approach 2 - BFS
     * - This is better than approach 1, we are using the Breadth First Search traversal here using queue.
     * - Here, we won't be getting the stack overflow error as recursion is not used here.
     * - The logic is almost similar to approach 1 only.
     * - Time complexity: O(M*N)
     * - Space complexity: O(M*N) due to Queue.
     */
    private static List<List<Integer>> approach2(List<List<Integer>> board) {
        int m = board.size(), n = board.get(0).size();
        bfs(board, m, n);
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board.get(r).get(c) == 0) {
                    board.get(r).set(c, 1);
                } else if (board.get(r).get(c) == 2) {
                    board.get(r).set(c, 0);
                }
            }
        }
        return board;
    }

    private static void bfs(List<List<Integer>> board, int m, int n) {
        Queue<int[]> queue = new LinkedList<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if ((r == 0 || c == 0 || r == m - 1 || c == n - 1) && board.get(r).get(c) == 0) {
                    queue.offer(new int[]{r, c});
                    board.get(r).set(c, 2);
                }
            }
        }
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] dir = queue.poll();
            for (int[] direction : directions) {
                int r = dir[0] + direction[0];
                int c = dir[1] + direction[1];
                if (r >= 0 && c >= 0 && r < m && c < n && board.get(r).get(c) == 0) {
                    board.get(r).set(c, 2);
                    queue.offer(new int[]{r, c});
                }
            }
        }
    }

}