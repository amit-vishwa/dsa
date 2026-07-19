package module.two.greedy.notes;

import java.util.Arrays;

/**
 * Assign Mice Holes:
 * <p>
 * Given, N Mice and N holes are placed in a straight line. Each hole can accommodate only 1 mouse. A mouse can stay in his
 * position, move one step right from x to x + 1, or move one step left from x to x -1. Any of these moves consumes 1 minute.
 * Write a program to assign mice to holes so that the time when the last mouse gets inside a hole is minimized.
 * <p>
 * Example
 * Input:
 * N = 3
 * M = {4, -4, 2}
 * H = {4, 0, 5}
 * <p>
 * Output:4
 * <p>
 * Approach: Refer _4AssignMiceHoles.java from package module.two.greedy.lecture.
 */
public class _4AssignMiceHoles {

    public static void main(String[] args) {
        System.out.println("Time taken by last mouse to reach hole is " + maxTimeTaken(new int[]{4, -4, 2}, new int[]{4, 0, 5}));
    }

    private static int maxTimeTaken(int[] mice, int[] holes) {
        int maxTime = 0;
        Arrays.sort(mice);
        Arrays.sort(holes);
        for (int i = 0; i < mice.length; i++) {
            int timeTaken = Math.abs(mice[i] - holes[i]);
            maxTime = Math.max(maxTime, timeTaken);
        }
        return maxTime;
    }

}
