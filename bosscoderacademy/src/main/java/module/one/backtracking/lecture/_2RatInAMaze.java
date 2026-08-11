package module.one.backtracking.lecture;

import java.util.ArrayList;
import java.util.List;

/**
 * Rat in a Maze: [Equivalent Leetcode 980. Unique Paths III]
 * <p>
 * Given a Maze and Rat which is at the start of the Maze.
 * The Rat can move in all directions. There are some obstacles in the Maze that must be avoided by the Rat.
 * Print all the ways by which Rat can go from start to end.
 * <p>
 * Approach:
 * - We can mark the current cell as visited and then proceed with 4 directions from there.
 * - While proceeding we should also do the validation related to rows and cols if can be proceeded then only proceed.
 * - After exploring all 4 directions, simply backtrack so that next cell can do the same.
 * - When we get any obstacles then we just need to return from there.
 * - When we are at last index i.e. last row and col then just print the path and return.
 * - Time complexity: O(4 due to 4 directions ^ (M * N) for row and col) = O(4^(M*N)) = O(4^(N^2)) when M==N
 * - Space complexity: O(M+N) visiting rows & cols with recursion stack, when 2D array is used to mark visited then O(N^2) is added.
 */
public class _2RatInAMaze {

    public static void main(String[] args) {
        System.out.println(printWays(new int[][]{
                {0, -1, -1, 0},
                {0, 0, -1, 0},
                {0, 0, -1, -1},
                {-1, 0, 0, 0}
        }, 0, 0, ""));
    }

    private static List<String> printWays(int[][] maze, int row, int col, String path) {
        if (row == maze.length - 1 && col == maze[row].length - 1) {
            return new ArrayList<>(List.of(path));
        }
        if (maze[row][col] != 0) {
            return new ArrayList<>();
        }
        List<String> paths = new ArrayList<>();
        maze[row][col] = 1;
        if (row < maze.length - 1) {
            paths.addAll(printWays(maze, row + 1, col, path + "D"));
        }
        if (col < maze.length - 1) {
            paths.addAll(printWays(maze, row, col + 1, path + "R"));
        }
        if (row > 0) {
            paths.addAll(printWays(maze, row - 1, col, path + "U"));
        }
        if (col > 0) {
            paths.addAll(printWays(maze, row, col - 1, path + "L"));
        }
        maze[row][col] = 0;
        return paths;
    }

}
