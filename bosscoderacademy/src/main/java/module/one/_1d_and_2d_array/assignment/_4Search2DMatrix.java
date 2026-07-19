package module.one._1d_and_2d_array.assignment;

import java.util.List;

/**
 * Search Twod Matrix:
 * You are given an m x n integer matrix with the following two properties:
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row. Given an integer target,
 * return true if the target is in the matrix or false otherwise.
 * Write a solution in O(log(m * n)) time complexity.
 * <p>
 * Input1: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output1: true
 * <p>
 * Input2: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output2: false
 * <p>
 * Constraints:
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 * <p>
 * Approaches: Please check SortedMatrixSearch.java from module.one._1d_and_2d_array.lecture.day2 package
 */
public class _4Search2DMatrix {

    public static void main(String[] args) {
        List<List<Integer>> mat = List.of(
                List.of(1, 4, 7, 11, 15),
                List.of(2, 5, 8, 12, 19),
                List.of(3, 6, 9, 16, 22),
                List.of(10, 13, 14, 17, 24),
                List.of(18, 21, 23, 26, 30)
        );
        System.out.println("Target found: " + targetFound(mat, 5));
        System.out.println("Target found: " + targetFound(mat, 150));
    }

    private static boolean targetFound(List<List<Integer>> mat, int target) {
        int m = mat.size(), n = mat.get(0).size(), r = 0, c = n - 1;
        while (r < m && c >= 0) {
            if (mat.get(r).get(c) == target) {
                return true;
            }
            if (mat.get(r).get(c) > target) {
                c--;
            } else {
                r++;
            }
        }
        return false;
    }

}