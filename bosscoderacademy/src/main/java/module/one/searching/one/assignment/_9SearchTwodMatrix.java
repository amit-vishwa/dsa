package module.one.searching.one.assignment;

/**
 * Search Twod Matrix:
 * <p>
 * You are given an m x n integer matrix with the following two properties:
 * <p>
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row. Given an integer target, return true
 * if the target is in the matrix or false otherwise.
 * <p>
 * Write a solution in O(log(m * n)) time complexity.
 * <p>
 * Input1: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output1: true
 * Input2: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output2: false
 * <p>
 * Constraints:
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 */
public class _9SearchTwodMatrix {

    public static void main(String[] args) {
        printIfTargetExist(new int[][]{
                {1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}
        }, 3);
        printIfTargetExist(new int[][]{
                {1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}
        }, 13);
    }

    private static void printIfTargetExist(int[][] matrix, int target) {
        System.out.println("Approach 1: Is target found? " + approach1(matrix, target));
        System.out.println("Approach 2: Is target found? " + approach2(matrix, target));
        System.out.println("Approach 3: Is target found? " + approach3(matrix, target));
        System.out.println("Approach 4: Is target found? " + approach4(matrix, target));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce approach
     * - A simple bruteforce approach consist of linear search.
     * - Time complexity: O(N*M) due to nested loop iterating over row and columns
     * - Space complexity: O(1) as no extra space is used.
     */
    private static boolean approach1(int[][] matrix, int target) {
        for (int[] row : matrix) {
            for (int cell : row) {
                if (cell == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Approach 2 - Better approach
     * - This approach is better than the bruteforce approach.
     * - We are performing the search in negative diagonal manner.
     * - We are reducing the column if target is less than cell value.
     * - We are incrementing the row if target is greater than cell value, else returning true.
     * - Time complexity: O(N) increasing row + O(M) decreasing column = O(N + M)
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static boolean approach2(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length, row = 0, col = m - 1;
        while (row < n && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }

    /**
     * Approach 3 - Optimal approach
     * - This approach is more optimal than the above ones.
     * - Here we are iterating over the row and since the rows are sorted we are performing binary search on them.
     * - When target lies in between the start and end cell of a particular row then binary search is performed on that row.
     * - If target found then true is returned else false is returned.
     * - Time complexity: O(N) iterating over row + O(log(M)) binary search on that row = O(N + logM)
     * - Space complexity: O(1) as no extra space is used.
     */
    private static boolean approach3(int[][] matrix, int target) {
        for (int[] row : matrix) {
            if (target >= row[0] && target <= row[row.length - 1]) {
                return binarySearch(row, target);
            }
        }
        return false;
    }

    // Time complexity: O(logM)
    private static boolean binarySearch(int[] arr, int target) {
        int s = 0, e = arr.length - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (arr[m] == target) {
                return true;
            }
            if (arr[m] < target) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return false;
    }

    /**
     * Approach 4 - Expected optimal approach
     * - This is the most optimal approach as matrix is already sorted so binary search can be performed here.
     * - We are considering the 2D array as a single dimensional array.
     * - Then we are calculating mid and finding row and column based on that.
     * - Then we are checking if that cell is equal to target, if yes return true else perform binary search logic.
     * - Time complexity: O(log(N*M)) as it is 2D array so N*M, and log is added for binary search
     * - Space complexity: O(1) as no extra space is used.
     */
    private static boolean approach4(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length, l = 0, r = n * m - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int row = mid / m, col = mid % m;
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }

}