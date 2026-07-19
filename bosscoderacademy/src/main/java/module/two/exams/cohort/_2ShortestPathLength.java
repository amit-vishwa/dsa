package module.two.exams.cohort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Refer _2ShortestPathLength.java from package module.two.graph.assignment.
public class _2ShortestPathLength {

    private static List<List<Integer>> grid1() {
        List<Integer> row1 = new ArrayList<>(List.of(0, 1));
        List<Integer> row2 = new ArrayList<>(List.of(1, 0));
        return new ArrayList<>(List.of(row1, row2));
    }

    private static List<List<Integer>> grid2() {
        List<Integer> row1 = new ArrayList<>(List.of(0, 0, 0));
        List<Integer> row2 = new ArrayList<>(List.of(1, 1, 0));
        List<Integer> row3 = new ArrayList<>(List.of(1, 1, 0));
        return new ArrayList<>(List.of(row1, row2, row3));
    }

    public static void main(String[] args) {
        System.out.println("Shortest path length: " + shortestPathLength(grid1()));
        System.out.println("Shortest path length: " + shortestPathLength(grid2()));
    }

    private static int shortestPathLength(List<List<Integer>> grid) {
        int m = grid.size(), n = grid.getFirst().size();
        if (grid.get(0).get(0) == 1 || grid.get(m - 1).get(n - 1) == 1) {
            return -1;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        grid.get(0).set(0, 1);
        int pathLength = 1;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] dir = queue.poll();
                int r = dir[0], c = dir[1];
                if (r == m - 1 && c == n - 1) {
                    return pathLength;
                }
                for (int[] d : directions) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if (nr >= 0 && nc >= 0 && nr < m && nc < n && grid.get(nr).get(nc) == 0) {
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
