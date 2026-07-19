package prerequisites.week3.lesson1;

import java.util.Arrays;

/**
 * Matrix Transpose:
 * Matrix = [1, 2, 3]
 *          [4, 5, 6]
 * Transpose = [1, 4]
 *             [2, 5]
 *             [3, 6]
 * */
public class TransposeMatrix {

    public static void main(String[] args) {
        printTransposeMatrix(new int[][]{{1, 2, 3}, {4, 5, 6}});
    }

    static void printTransposeMatrix(int[][] mat) {
        System.out.println("Matrix: " + Arrays.deepToString(mat));
        int[][] transpose = new int[mat[0].length][mat.length];
        for (int i = 0; i < transpose.length; i++) {
            for (int j = 0; j < transpose[i].length; j++) {
                transpose[i][j] = mat[j][i];
            }
        }
        System.out.println("Transpose: " + Arrays.deepToString(transpose));
    }

}
