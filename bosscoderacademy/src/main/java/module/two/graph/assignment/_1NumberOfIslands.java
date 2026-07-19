package module.two.graph.assignment;

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Number Of Islands:
 * <p>
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all
 * four edges of the grid are all surrounded by water.
 * <p>
 * Input: grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * Output: 1
 * <p>
 * Input: grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * Output: 3
 * <p>
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 */
public class _1NumberOfIslands {

    private static List<List<Integer>> getInput1() {
        ArrayList<Integer> list1 = new ArrayList<>(List.of(1, 1, 1, 1, 0));
        ArrayList<Integer> list2 = new ArrayList<>(List.of(1, 1, 0, 1, 0));
        ArrayList<Integer> list3 = new ArrayList<>(List.of(1, 1, 0, 0, 0));
        ArrayList<Integer> list4 = new ArrayList<>(List.of(0, 0, 0, 0, 0));
        return new ArrayList<>(List.of(list1, list2, list3, list4));
    }

    private static List<List<Integer>> getInput2() {
        ArrayList<Integer> list1 = new ArrayList<>(List.of(1, 1, 0, 0, 0));
        ArrayList<Integer> list2 = new ArrayList<>(List.of(1, 1, 0, 0, 0));
        ArrayList<Integer> list3 = new ArrayList<>(List.of(0, 0, 1, 0, 0));
        ArrayList<Integer> list4 = new ArrayList<>(List.of(0, 0, 0, 1, 1));
        return new ArrayList<>(List.of(list1, list2, list3, list4));
    }

    public static void main(String[] args) {
        printNumberOfIslands(getInput1());
        printNumberOfIslands(getInput2());
    }

    private static void printNumberOfIslands(List<List<Integer>> grid) {
        System.out.println("Number of islands using depth first traversal: " + approach1(grid));
        System.out.println("Number of islands using breadth first traversal: " + approach2(grid));
        System.out.println();
    }

    /**
     * Approach 1 - Depth First Search
     * - The approach is quite simple, we just have to iterate over the grid or graph.
     * - If current cell is 1, then increase the island count.
     * - Now, traverse using DFS and make cell as 0 if it is 1, else skip.
     * - Time complexityL: O(M*N) as we are traversing each cell.
     * - Space complexity: O(M*N) due to recursion stack in worst case.
     */
    private static int approach1(List<List<Integer>> grid) {
        int m = grid.size(), n = grid.get(0).size();
        int islands = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid.get(r).get(c) == 1) {
                    islands++;
                    dfs(grid, r, c, m, n);
                }
            }
        }
        return islands;
    }

    private static void dfs(List<List<Integer>> grid, int r, int c, int m, int n) {
        if (r < 0 || c < 0 || r >= m || c >= n || grid.get(r).get(c) == 0) {
            return;
        }
        grid.get(r).set(c, 0);
        dfs(grid, r - 1, c, m, n); // up
        dfs(grid, r + 1, c, m, n); // down
        dfs(grid, r, c - 1, m, n); // left
        dfs(grid, r, c + 1, m, n); // right
    }

    /**
     * Approach 2 - Breadth First Search
     * - This is little complex to code than the simple DFS approach.
     * - Here, will count for cell with value as 1, then do the BFS traversal.
     * - Will store current row and col in queue and mark that cell as 0.
     * - Then will create directions 2D array.
     * - Now, will iterate over queue till it becomes empty.
     * - Will get row and col indices, iterate over directions array to calculate new indices.
     * - If indices are valid and the cell value is 1, then update it to 0 and store those indices in the queue.
     * - Time complexity: O(M*N) as we are traversing all cells.
     * - Space complexity: O(M*N) due to queue.
     */
    private static int approach2(List<List<Integer>> grid) {
        int m = grid.size(), n = grid.get(0).size();
        int islands = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid.get(r).get(c) == 1) {
                    islands++;
                    bfs(grid, r, c, m, n);
                }
            }
        }
        return islands;
    }

    private static void bfs(List<List<Integer>> grid, int r, int c, int m, int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        grid.get(r).set(c, 0);
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] dir = queue.poll();
            int row = dir[0], col = dir[1];
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if (newRow >= 0 && newCol >= 0 && newRow < m && newCol < n && grid.get(newRow).get(newCol) == 1) {
                    queue.offer(new int[]{newRow, newCol});
                    grid.get(newRow).set(newCol, 0);
                }
            }
        }
    }

}