package module.two.dp.one.assignment;

import java.util.Queue;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Minimum Jumps To Reach Home:
 * <p>
 * A certain bug's home is on the x-axis at position x. Help them get there from position 0.
 * The bug jumps according to the following rules:
 * - It can jump exactly a positions forward (to the right).
 * - It can jump exactly b positions backward (to the left).
 * - It cannot jump backward twice in a row.
 * - It cannot jump to any forbidden positions.
 * - The bug may jump forward beyond its home, but it cannot jump to positions numbered with negative integers.
 * Given an array of integers forbidden, where forbidden[i] means that the bug cannot jump to the position forbidden[i], and
 * integers a, b, and x, return the minimum number of jumps needed for the bug to reach its home. If there is no possible
 * sequence of jumps that lands the bug on position x, return -1.
 * <p>
 * Input: forbidden = [14,4,18,1,15], a = 3, b = 15, x = 9
 * Output: 3
 * Explanation: 3 jumps forward (0 -> 3 -> 6 -> 9) will get the bug home.
 * <p>
 * Input: forbidden = [8,3,16,6,12,20], a = 15, b = 13, x = 11
 * Output: -1
 * <p>
 * Constraints:
 * 1 <= forbidden.length <= 1000
 * 1 <= a, b, forbidden[i] <= 2000
 * 0 <= x <= 2000
 * All the elements in forbidden are distinct.
 * Position x is not forbidden.
 */
public class _2MinJumpsForHome {

    public static void main(String[] args) {
        System.out.println("Min jumps required to reach home is " + minJumps(new int[]{14, 4, 18, 1, 15}, 3, 15, 9));
        System.out.println("Min jumps required to reach home is " + minJumps(new int[]{8, 3, 16, 6, 12, 20}, 15, 13, 11));
    }

    /**
     * Approach:
     * - The approach is quite non-intuitive.
     * - We are using BFS here using queue.
     * - First add forbidden indexes in a set get access them in O(1) time.
     * - Create a 2D boolean for position and backward or forward indicator.
     * - Set a forward limit to 6000, and first visited forward position to true.
     * - Add an array value in queue that have index, jump count and last step backward as values.
     * - Proceed with the BFS, if current position is x then return jump count.
     * - Else calculate for forward jumps and backward and add them in queue.
     * - Return -1 if not able to reach home.
     * - Time complexity: O(N) N is the limit i.e. 6000 max here
     * - Space complexity: O(N) + O(F) forbidden length
     */
    private static int minJumps(int[] forbidden, int a, int b, int x) {
        HashSet<Integer> forbiddenSet = new HashSet<>();
        for (int index : forbidden) {
            forbiddenSet.add(index);
        }
        int limit = 6000;
        boolean[][] visited = new boolean[limit + 1][2];
        visited[0][0] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0});
        while (!queue.isEmpty()) {
            int[] data = queue.poll();
            int position = data[0];
            int jumps = data[1];
            int backUsed = data[2];
            if (position == x) {
                return jumps;
            }
            int forward = position + a;
            if (forward <= limit && !forbiddenSet.contains(forward) && !visited[forward][0]) {
                visited[forward][0] = true;
                queue.offer(new int[]{forward, jumps + 1, 0});
            }
            int backward = position - b;
            if (backUsed == 0 && backward >= 0 && !forbiddenSet.contains(backward) && !visited[backward][1]) {
                visited[backward][1] = true;
                queue.offer(new int[]{backward, jumps + 1, 1});
            }
        }
        return -1;
    }

}