package module.one._1d_and_2d_array.assignment;

import java.util.List;

/**
 * Count Negative Number In Sorted Matrix:
 * <p>
 * Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise,
 * return the number of negative numbers in grid.
 * <p>
 * Input 1:
 * grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * Output 1:
 * 8
 * Explanation 1:
 * There are 8 negatives number in the matrix.
 * <p>
 * Input 2:
 * grid = [[3,2],[1,0]]
 * Output 2:
 * 0
 * <p>
 * Constraints:
 * 1 <= grid.length, grid[i].length <= 102
 * -100 <= grid[i][j] <= 100
 * <p>
 * Approaches:
 * 1. Bruteforce: Simply iterate through the matrix and count negative numbers, it will always take O(M*N) time.
 * 2. Better solution: Since matrix is reverse sorted in both row and col wise, we can check row in reverse order,
 * if cell element is not less than 0 then break the loop to avoid unnecessary comparisons. The time complexity will
 * still be O(M*N) but here number of comparisons are reduced.
 */
public class _8CountNegatives {

    public static void main(String[] args) {
        System.out.println("Negative numbers count: " + solve(List.of(
                List.of(4, 3, 2, -1), List.of(3, 2, 1, -1), List.of(1, 1, -1, -2), List.of(-1, -1, -2, -3)
        )));
        System.out.println("Negative numbers count: " + solve(List.of(
                List.of(3, 2), List.of(1, 0)
        )));
    }

    private static int solve(List<List<Integer>> matrix) {
        int count = 0;
        for (int r = 0; r < matrix.size(); r++) {
            for (int c = matrix.get(r).size() - 1; c >= 0; c--) {
                if (matrix.get(r).get(c) >= 0) {
                    break;
                }
                count++;
            }
        }
        return count;
    }

}
