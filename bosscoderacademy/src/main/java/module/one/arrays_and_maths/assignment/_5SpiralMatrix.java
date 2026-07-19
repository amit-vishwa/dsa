package module.one.arrays_and_maths.assignment;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * 5. Spiral Matrix: [Leetcode 59. Spiral Matrix II]
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 * <p>
 * Input 1: n = 3
 * Output 1: [[1,2,3],[8,9,4],[7,6,5]]
 * Explanation 1:
 * <p>
 * Input 2: n = 1
 * Output 2: [[1]]
 */
public class _5SpiralMatrix {

    public static void main(String[] args) {
        printSpiralMatrix(1);
        printSpiralMatrix(2);
        printSpiralMatrix(3);
        printSpiralMatrix(4);
        printSpiralMatrix(5);
        List<List<Integer>> mat = solve(5);
        for (List<Integer> row : mat) {
            System.out.println(row);
        }
    }

    /**
     * Not a perfect solution, I was only able to code properly till 3x3 matrix.
     */
    private static void printSpiralMatrix(int n) {
        int c = 1;
        int[][] mat = new int[n][n];
        int top = 0, left = 0, bottom = n - 1, right = n - 1;
        while (top <= bottom && left <= right) {
            int i = left;
            while (i <= right) {
                mat[top][i++] = c++;
            }
            top++;
            i = top;
            while (i <= bottom) {
                mat[i++][right] = c++;
            }
            right--;
            i = right;
            while (i >= left && bottom >= top) {
                mat[bottom][i--] = c++;
            }
            bottom--;
            i = bottom;
            while (i >= top && right >= left) {
                mat[i--][left] = c++;
            }
            left++;
        }
        System.out.println("Matrix: " + Arrays.deepToString(mat));
    }

    // BCA assignment solution, need to understand it thoroughly
    private static List<List<Integer>> solve(int n) {
        List<List<Integer>> ret = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            ret.add(new ArrayList<>(n));
            for (int j = 0; j < n; j++) {
                ret.get(i).add(0);
            }
        }

        int k = 1, i = 0;
        while (k <= n * n) {
            int j = i;
            // Four steps
            while (j < n - i) { // 1. Horizontal, left to right
                ret.get(i).set(j++, k++);
            }
            j = i + 1;
            while (j < n - i) { // 2. Vertical, top to bottom
                ret.get(j++).set(n - i - 1, k++);
            }
            j = n - i - 2;
            while (j > i) { // 3. Horizontal, right to left
                ret.get(n - i - 1).set(j--, k++);
            }
            j = n - i - 1;
            while (j > i) { // 4. Vertical, bottom to top
                ret.get(j--).set(i, k++);
            }
            i++; // Next loop
        }
        return ret;
    }

}