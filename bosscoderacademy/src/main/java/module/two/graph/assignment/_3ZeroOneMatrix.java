package module.two.graph.assignment;

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Zero One Matrix:
 * <p>
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 * The distance between two adjacent cells is 1.
 * <p>
 * Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: [[0,0,0],[0,1,0],[0,0,0]]
 * <p>
 * Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
 * Output: [[0,0,0],[0,1,0],[1,2,1]]
 * <p>
 * Constraints:
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * mat[i][j] is either 0 or 1.
 * There is at least one 0 in mat.
 */
public class _3ZeroOneMatrix {

    private static List<List<Integer>> getInput1() {
        List<Integer> row1 = new ArrayList<>(List.of(0, 0, 0));
        List<Integer> row2 = new ArrayList<>(List.of(0, 1, 0));
        List<Integer> row3 = new ArrayList<>(List.of(0, 0, 0));
        return new ArrayList<>(List.of(row1, row2, row3));
    }

    private static List<List<Integer>> getInput2() {
        List<Integer> row1 = new ArrayList<>(List.of(0, 0, 0));
        List<Integer> row2 = new ArrayList<>(List.of(0, 1, 0));
        List<Integer> row3 = new ArrayList<>(List.of(1, 1, 1));
        return new ArrayList<>(List.of(row1, row2, row3));
    }

    public static void main(String[] args) {
        System.out.println("The distance of the nearest 0 cell: " + updatedGrid(getInput1()));
        System.out.println("The distance of the nearest 0 cell: " + updatedGrid(getInput2()));
    }

    /**
     * Approach - BFS
     * - The approach is quite simple using BFS.
     * - As shortest distance problems require BFS traversal, so we are using the same here.
     * - First we are adding all the sources in the queue, and destinations as unvisited.
     * - Then we are iterating over the queue and calculating the new row and col.
     * - After that we are checking for valid indices and checking if cell is visited or not.
     * - Then we are updating the value for that cell and adding the new indices in the queue.
     * - Time complexity: O(M*N) as we are visiting all the cells of the matrix.
     * - Space complexity: O(M*N) due to queue.
     */
    private static List<List<Integer>> updatedGrid(List<List<Integer>> mat) {
        int rows = mat.size(), cols = mat.get(0).size();
        Queue<int[]> queue = new LinkedList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (mat.get(r).get(c) == 0) {
                    queue.offer(new int[]{r, c}); // add sources in queue
                } else {
                    mat.get(r).set(c, -1); // mark destination as unvisited
                }
            }
        }
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] dir = queue.poll();
                int row = dir[0], col = dir[1];
                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];
                    if (newRow >= 0 && newCol >= 0 && newRow < rows && newCol < cols && mat.get(newRow).get(newCol) == -1) {
                        mat.get(newRow).set(newCol, mat.get(row).get(col) + 1);
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }
        return mat;
    }

}