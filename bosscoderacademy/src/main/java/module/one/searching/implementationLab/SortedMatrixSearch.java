package module.one.searching.implementationLab;

import java.util.Arrays;

/**
 * Sorted matrix search: [Leetcode 74. Search a 2D Matrix]
 * <p>
 * Given a 2D sorted array where elements are sorted i.e. each cell will be greater than its previous cell.
 * Return the index of the target element.
 * <p>
 * Approaches:
 * 1. Bruteforce - traverse matrix in O(M*N) time.
 * 2. Optimal - traverse row col in negative diagonal manner in O(M+N) time.
 * 2. Better Optimal - traverse row and perform binary search if target lies there in O(M+logN) time.
 * 3. Most Optimal - consider 2D array as 1D array and perform simple binary search logic in O(log(M*N)) time.
 */
public class SortedMatrixSearch {

    public static void main(String[] args) {
        printIndex(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        }, 3);
        printIndex(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        }, 1);
        printIndex(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        }, 20);
        printIndex(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        }, 60);
        printIndex(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        }, 300);
    }

    private static void printIndex(int[][] mat, int t) {
        System.out.println("Index by approach 1: " + Arrays.toString(approach1(mat, t)));
        System.out.println("Index by approach 2: " + Arrays.toString(approach2(mat, t)));
        System.out.println("Index by approach 3: " + Arrays.toString(approach3(mat, t)));
        System.out.println("Index by approach 4: " + Arrays.toString(approach4(mat, t)));
        System.out.println();
    }

    private static int[] approach1(int[][] mat, int t) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == t) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    private static int[] approach2(int[][] mat, int t) {
        int row = 0, col = mat[0].length - 1;
        while (row < mat.length && col >= 0) {
            if (mat[row][col] == t) {
                return new int[]{row, col};
            }
            if (mat[row][col] < t) {
                row++;
            } else {
                col--;
            }
        }
        return new int[]{-1, -1};
    }

    private static int[] approach3(int[][] mat, int t) {
        int[] index = {-1, -1};
        for (int row = 0; row < mat.length; row++) {
            if (t >= mat[row][0] && t <= mat[row][mat[row].length - 1]) {
                int col = binarySearch(mat[row], t);
                return col == -1 ? index : new int[]{row, col};
            }
        }
        return index;
    }

    private static int binarySearch(int[] arr, int t) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == t) {
                return m;
            }
            if (arr[m] < t) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    private static int[] approach4(int[][] mat, int t) {
        int m = mat.length, n = mat[0].length;
        int l = 0, r = m * n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mat[mid / n][mid % n] == t) {
                return new int[]{mid / n, mid % n};
            }
            if (mat[mid / n][mid % n] < t) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }

}
