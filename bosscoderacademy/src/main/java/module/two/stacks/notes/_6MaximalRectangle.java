package module.two.stacks.notes;

import java.util.Stack;

/**
 * Maximal Rectangle:
 * <p>
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return
 * its area.
 * <p>
 * Example
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 6
 */
public class _6MaximalRectangle {

    public static void main(String[] args) {
        System.out.println("Maximal rectangle: " + maximalRectangle(new char[][]{
                {'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}
        }));
    }

    /**
     * Approach:
     * - The problem is to find the largest rectangle containing only '1's in a binary matrix.
     * - The solution uses the Histogram + Monotonic Stack approach.
     * - Each matrix row is treated as the base of a histogram.
     * - An array hist[] stores the height of consecutive '1's for each column.
     * - For the first row, hist[j] is set to 1 if the cell is '1', otherwise 0.
     * - For subsequent rows, hist[j] is incremented if the cell is '1', else reset to 0.
     * - After building hist[] for a row, the problem reduces to Largest Rectangle in Histogram.
     * - A monotonic increasing stack stores column indices based on histogram heights.
     * - When a smaller height is encountered, bars are popped to compute rectangle areas.
     * - Rectangle width is calculated using the nearest smaller elements on the left and right.
     * - A sentinel height 0 is added to flush remaining bars from the stack.
     * - The maximum area for each row is compared against the global answer.
     * - Each histogram bar is pushed and popped at most once.
     * - Time Complexity: O(m × n) where m is rows and n is columns.
     * - Space Complexity: O(n) for the histogram array and stack.
     */
    private static int maximalRectangle(char[][] matrix) {
        int maxArea = 0, m = matrix[0].length;
        int[] hist = new int[m];
        for (char[] chars : matrix) {
            for (int c = 0; c < m; c++) {
                // creating the histogram for each row
                hist[c] = chars[c] != '0' ? hist[c] + 1 : 0;
            }
            // calculating area and updating max area
            int area = histogramRectangleArea(hist);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    private static int histogramRectangleArea(int[] heights) {
        int maxArea = 0, n = heights.length;
        Stack<Integer> stack = new Stack<>();
        // iterate over histogram
        for (int i = 0; i <= n; i++) {
            // get current height
            int h = i == n ? 0 : heights[i];
            // stack not empty and current height is less than top most stack index height
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                // get new height and remove top from stack
                int height = heights[stack.pop()];
                // stack empty then take i as index else reduce top most index - 1 from i
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                // calculate max area now
                maxArea = Math.max(maxArea, height * width);
            }
            // push index in stack
            stack.push(i);
        }
        return maxArea;
    }

}
