package module.one._1d_and_2d_array.lecture.day2;

import java.util.Arrays;

/**
 * Search an element in 2D array:
 * Given a matrix where elements are sorted in row-wise and column-wise.
 * That is the element will be greater than or equal to previous row and column elements.
 * However, the last column element of previous row can be greater than the current column element of current row.
 * Search a target element in O(M+N) time.
 * <p>
 * Example 1: Mat = [[1,3,5],[2,4,6]], target = 4, ans = [1,1]
 *
 * This can be solved with 3 approaches:
 * 1. Bruteforce - traverse the whole matrix and search the target
 * 2. Binary search row or column wise - perform binary search either row-wise or column-wise
 * 3. Positive or Negative diagonal search - search target traversing by reducing column and increasing row
 */
public class SortedMatrixSearch {

    public static void main(String[] args) {
        int[][] mat = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        printTargetIndex(mat, 5);
        System.out.println();
        printTargetIndex(mat, 150);
    }

    private static void printTargetIndex(int[][] mat, int target) {
        System.out.println("Index by approach1: " + Arrays.toString(approach1(mat, target)));
        System.out.println("Index by approach2: " + Arrays.toString(approach2(mat, target)));
        System.out.println("Index by approach3: " + Arrays.toString(approach3(mat, target)));
    }

    /**
     * Approach 1: Bruteforce approach
     * - Simply traverse the matrix from start to end and search the target element.
     * - Time complexity: O(M*N)
     * - Space complexity: O(1)
     */
    private static int[] approach1(int[][] mat, int target) {
        int[] index = {-1, -1};
        int m = mat.length;
        if (m == 0) {
            return index;
        }
        int n = mat[0].length;
        if (n == 0 || target < mat[0][0] || target > mat[m - 1][n - 1]) {
            return index;
        }
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (mat[r][c] == target) {
                    index = new int[]{r, c};
                    return index;
                }
            }
        }
        return index;
    }

    /**
     * Approach 2: Better approach
     * - Since matrix is sorted row-wise and column-wise, apply binary search on anyone of it.
     * - So the binary search will take O(logN) and repeating it till row or column times will take O(N) or O(M).
     * - So, total time complexity is O(M) * O(logM) = O(M * logM) for row-wise, for column just replace M with N.
     * - Space complexity: O(1)
     */
    private static int[] approach2(int[][] mat, int target) {
        int[] index = {-1, -1};
        int m = mat.length;
        if (m == 0) {
            return index;
        }
        int n = mat[0].length;
        if (n == 0 || target < mat[0][0] || target > mat[m - 1][n - 1]) {
            return index;
        }
        for (int r = 0; r < m; r++) {
            int c = binarySearch(mat[r], target, 0, n - 1);
            if (c != -1) {
                index = new int[]{r, c};
                return index;
            }
        }
        return index;
    }

    // Time complexity: O(logN), Space complexity: O(1)
    private static int binarySearch(int[] arr, int t, int s, int e) {
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (arr[m] == t) {
                return m;
            }
            if (arr[m] > t) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return -1;
    }

    /**
     * Approach 3: Optimal approach
     * - Since matrix is sorted row-wise and column-wise, we can take this advantage and search optimally.
     * - Here we can do the search in negative diagonal manner where column starts from last index and row first.
     * - If target is equal to current cell value then return the index.
     * - If current is greater than target then reduce the column else increase the row.
     * - Time complexity: O(M) for row traversal + O(N) for column traversal = O(M + N)
     * - Space complexity: O(1)
     */
    private static int[] approach3(int[][] mat, int target) {
        int[] index = {-1, -1};
        int m = mat.length;
        if (m == 0) {
            return index;
        }
        int n = mat[0].length;
        if (n == 0 || target < mat[0][0] || target > mat[m - 1][n - 1]) {
            return index;
        }
        int r = 0, c = n - 1;
        while (r < m && c >= 0) {
            if (mat[r][c] == target) {
                index = new int[]{r, c};
                return index;
            }
            if (mat[r][c] > target) {
                c--;
            } else {
                r++;
            }
        }
        return index;
    }

}
