package module.one.arrays_and_maths.assignment;

import java.util.List;

/**
 * 7. Matrix Diagonal Sum: [Leetcode 1572. Matrix Diagonal Sum]
 * Given a square matrix mat, return the sum of the matrix diagonals. Only include the sum of all the elements on
 * the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.
 *
 * Input 1: mat = [[1,2,3], [4,5,6], [7,8,9]]
 * Output 1: 25
 * Explanation 1: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25. Notice that element mat[1][1] = 5 is counted only once.
 *
 * Input 2: mat = [[1,1,1,1], [1,1,1,1], [1,1,1,1], [1,1,1,1]]
 * Output 2: 8
 * */
public class _7DiagonalSum {

    public static void main(String[] args) {
        printSum(List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9)));
        printSum(List.of(List.of(1, 1, 1, 1), List.of(1, 1, 1, 1), List.of(1, 1, 1, 1), List.of(1, 1, 1, 1)));
    }

    private static void printSum(List<List<Integer>> input) {
        int sum = 0;
        int n = input.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || j == n - 1 - i) {
                    sum += input.get(i).get(j);
                }
            }
        }
        System.out.println("Matrix:");
        for (List<Integer> row : input) {
            System.out.println(row);
        }
        System.out.println("Diagonal sum: " + sum + "\n");
    }

}