package module.one._1d_and_2d_array.lecture.day2;

/**
 * Print Matrix Spirally: [Leetcode 54. Spiral Matrix]
 * Given a matrix, print the elements spirally.
 * <p>
 * Only one approach is there which simply takes O(M*N) time complexity and O(1) space complexity.
 */
public class MatrixSpiralPrint {

    public static void main(String[] args) {
        printMatrixSpirally(new int[][]{
                {1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}
        });
        System.out.println();
        printMatrixSpirally(new int[][]{
                {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}
        });
    }

    private static void printMatrixSpirally(int[][] mat) {
        int m = mat.length;
        if (m == 0) {
            return;
        }
        int n = mat[0].length;
        int minr = 0, minc = 0, maxr = m - 1, maxc = n - 1;
        int cnt = 0;
        while (cnt < m * n) {
            for (int i = minc; i <= maxc && cnt < m * n; i++) {
                System.out.print(mat[minr][i] + " ");
                cnt++;
            }
            minr++;
            for (int i = minr; i <= maxr && cnt < m * n; i++) {
                System.out.print(mat[i][maxc] + " ");
                cnt++;
            }
            maxc--;
            for (int i = maxc; i >= minc && cnt < m * n; i--) {
                System.out.print(mat[maxr][i] + " ");
                cnt++;
            }
            maxr--;
            for (int i = maxr; i >= minr && cnt < m * n; i--) {
                System.out.print(mat[i][minc] + " ");
                cnt++;
            }
            minc++;
        }
    }

}
