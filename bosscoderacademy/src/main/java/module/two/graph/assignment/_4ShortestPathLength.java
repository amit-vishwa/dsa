package module.two.graph.assignment;

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Shortest Path In Binary Matrix:
 * <p>
 * Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path,
 * return -1.
 * A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e.,
 * (n - 1, n - 1)) such that:
 * - All the visited cells of the path are 0.
 * - All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a
 * corner).
 * The length of a clear path is the number of visited cells of this path.
 * <p>
 * Input: grid = [[0,1],[1,0]]
 * Output: 2
 * <p>
 * Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
 * Output: 4
 * <p>
 * Constraints:
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 100
 * grid[i][j] is 0 or 1
 */
public class _4ShortestPathLength {

    private static List<List<Integer>> getInput1() {
        List<Integer> row1 = new ArrayList<>(List.of(0, 1));
        List<Integer> row2 = new ArrayList<>(List.of(1, 0));
        return new ArrayList<>(List.of(row1, row2));
    }

    private static List<List<Integer>> getInput2() {
        List<Integer> row1 = new ArrayList<>(List.of(0, 0, 0));
        List<Integer> row2 = new ArrayList<>(List.of(1, 1, 0));
        List<Integer> row3 = new ArrayList<>(List.of(1, 1, 0));
        return new ArrayList<>(List.of(row1, row2, row3));
    }

    public static void main(String[] args) {
        System.out.println("Length of shortest clear path is " + shortestClearPathLength(getInput1()));
        System.out.println("Length of shortest clear path is " + shortestClearPathLength(getInput2()));
    }

    /**
     * Approach:
     * - The approach is quite simple using BFS.
     * - We are checking the important edge case first, i.e. if first or last cell is blocked then return -1.
     * - Now we are adding the first cell in the queue and marked it as visited, path length is 1.
     * - Then iterating over queue and fetching the indices and checking if it is last cell then return path length.
     * - Else iterate over 8 directions array and get new indices and check for validity.
     * - If the cell is not visited, then visit and mark it as visited and add new indices in queue to explore further.
     * - After each level iteration, increment the path length.
     * - At last, after queue traversal, just return -1 as path cannot be explored.
     * - Time complexity: O(M*N) due to 2D grid.
     * - Space complexity: O(M*N) due to queue.
     */
    private static int shortestClearPathLength(List<List<Integer>> grid) {
        int n = grid.size();
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) {
            return -1;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        grid.get(0).set(0, 1);
        int pathLength = 1;
        int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] dir = queue.poll();
                int r = dir[0], c = dir[1];
                if (r == n - 1 && c == n - 1) {
                    return pathLength;
                }
                for (int[] direction : directions) {
                    int nr = r + direction[0];
                    int nc = c + direction[1];
                    if (nr >= 0 && nc >= 0 && nr < n && nc < n && grid.get(nr).get(nc) == 0) {
                        grid.get(nr).set(nc, 1);
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
            pathLength++;
        }
        return -1;
    }

}