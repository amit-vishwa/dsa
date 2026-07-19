package module.two.graph.assignment;

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Rotting Oranges:
 * <p>
 * You are given an m x n grid where each cell can have one of three values:
 * - 0 representing an empty cell,
 * - 1 representing a fresh orange, or
 * - 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 * <p>
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * <p>
 * Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * <p>
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10
 * grid[i][j] is 0, 1, or 2.
 */
public class _2RottingOranges {

    private static List<List<Integer>> getInput1() {
        List<Integer> list1 = new ArrayList<>(List.of(2, 1, 1));
        List<Integer> list2 = new ArrayList<>(List.of(1, 1, 0));
        List<Integer> list3 = new ArrayList<>(List.of(0, 1, 1));
        return new ArrayList<>(List.of(list1, list2, list3));
    }

    private static List<List<Integer>> getInput2() {
        List<Integer> list1 = new ArrayList<>(List.of(2, 1, 1));
        List<Integer> list2 = new ArrayList<>(List.of(0, 1, 1));
        List<Integer> list3 = new ArrayList<>(List.of(1, 0, 1));
        return new ArrayList<>(List.of(list1, list2, list3));
    }

    public static void main(String[] args) {
        System.out.println("Minimum number of minutes: " + minNumOfMinutes(getInput1()));
        System.out.println("Minimum number of minutes: " + minNumOfMinutes(getInput2()));
    }

    /**
     * Approach:
     * - We are using the BFS traversal here.
     * - We are first adding all the indices for rotted oranges in current grid in a queue.
     * - We are also counting all the fresh oranges.
     * - Then we are iterating over the queue and calculating the min number of required minutes to rot all the oranges.
     * - Time complexity: O(M*N) as we are exploring all the oranges.
     * - Space complexity: O(M*N) as we are storing all the oranges in the queue.
     * - DFS is quite complex and not recommended, so skipped it.
     */
    private static int minNumOfMinutes(List<List<Integer>> grid) {
        int rows = grid.size(), cols = grid.get(0).size();
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int cell = grid.get(r).get(c);
                if (cell == 0) {
                    continue;
                }
                if (cell == 2) {
                    queue.offer(new int[]{r, c});
                } else {
                    fresh++;
                }
            }
        }
        if (fresh == 0) {
            return 0;
        }
        int mins = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottedInCurrentMin = false;
            for (int i = 0; i < size; i++) {
                int[] dir = queue.poll();
                int row = dir[0], col = dir[1];
                for (int[] direction : directions) {
                    int newR = row + direction[0];
                    int newC = col + direction[1];
                    if (newR >= 0 && newC >= 0 && newR < rows && newC < cols && grid.get(newR).get(newC) == 1) {
                        queue.offer(new int[]{newR, newC});
                        grid.get(newR).set(newC, 2);
                        rottedInCurrentMin = true;
                        fresh--;
                    }
                }
            }
            if (rottedInCurrentMin) {
                mins++;
            }
        }
        return fresh == 0 ? mins : -1;
    }

}