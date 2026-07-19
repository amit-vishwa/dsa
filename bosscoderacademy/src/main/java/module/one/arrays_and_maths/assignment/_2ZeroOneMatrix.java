package module.one.arrays_and_maths.assignment;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/**
 * Leetcode 542. 01 Matrix
 * Tried to solve the problem with simple bruteforce approach with complexity as O(M*N*(Max(M,N))).
 * Then referred the solution with Dynamic Programming approach with complexity as O(M*N).
 * Here space complexity is O(1) for both approaches.
 */
public class _2ZeroOneMatrix {

    public static void main(String[] args) {
        System.out.println("Output: " + solve(List.of(List.of(0, 0, 0), List.of(0, 1, 0), List.of(0, 0, 0))));
        System.out.println();
        System.out.println("Output: " + solve(List.of(List.of(0, 0, 0), List.of(0, 1, 0), List.of(1, 1, 1))));
        System.out.println();
        List<List<Integer>> input = List.of(List.of(0, 0, 0, 0, 0), List.of(0, 1, 0, 1, 1),
                List.of(1, 1, 0, 0, 1), List.of(1, 0, 0, 0, 1), List.of(1, 1, 1, 1, 1));
        for (List<Integer> row : input) {
            System.out.println(row);
        }
        System.out.println("Output: " + solveOptimally(input));
        System.out.println("Output: " + solveOptimally(List.of(List.of(0, 0, 0), List.of(0, 1, 0), List.of(0, 0, 0))));
        System.out.println();
        System.out.println("Output: " + solveOptimally(List.of(List.of(0, 0, 0), List.of(0, 1, 0), List.of(1, 1, 1))));
        System.out.println();
    }

    /**
     * Optimal solution with Dynamic Programming approach.
     * Time complexity: O(M*N)
     * Space complexity: O(1)
     */
    public static List<List<Integer>> solveOptimally(List<List<Integer>> input) {
        List<List<Integer>> mat = matClone(input);
        int m = mat.size(), n = mat.get(0).size();
        initializeMatrix(mat, m, n);
        updateTopLeft(mat, m, n);
        updateBottomRight(mat, m, n);
        return mat;
    }

    private static List<List<Integer>> matClone(List<List<Integer>> input) {
        List<List<Integer>> mat = new ArrayList<>();
        for (List<Integer> integers : input) {
            mat.add(new ArrayList<>(integers));
        }
        return mat;
    }

    private static void initializeMatrix(List<List<Integer>> mat, int m, int n) {
        int INF = m + n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat.get(i).get(j) != 0) {
                    mat.get(i).set(j, INF);
                }
            }
        }
    }

    private static void updateTopLeft(List<List<Integer>> mat, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat.get(i).get(j) == 0) {
                    continue;
                }
                if (i > 0) {
                    mat.get(i).set(j, Math.min(mat.get(i).get(j), mat.get(i - 1).get(j) + 1));
                }
                if (j > 0)
                    mat.get(i).set(j, Math.min(mat.get(i).get(j), mat.get(i).get(j - 1) + 1));
            }
        }
    }

    private static void updateBottomRight(List<List<Integer>> mat, int m, int n) {
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (mat.get(i).get(j) == 0) {
                    continue;
                }
                if (i < m - 1) {
                    mat.get(i).set(j, Math.min(mat.get(i).get(j), mat.get(i + 1).get(j) + 1));
                }
                if (j < n - 1)
                    mat.get(i).set(j, Math.min(mat.get(i).get(j), mat.get(i).get(j + 1) + 1));
            }
        }
    }

    private static List<List<Integer>> solve(List<List<Integer>> input) {
        System.out.println("Input: " + input + "\n");
        List<List<Integer>> output = new ArrayList<>();
        int row = input.size();
        if (row == 0) {
            return output;
        }
        int col = input.getFirst().size();
        if (col == 0) {
            return output;
        }
        for (int i = 0; i < row; i++) {
            output.add(new ArrayList<>());
        }
        return populateResultMatrix(output, input, row, col);
    }

    private static List<List<Integer>> populateResultMatrix(List<List<Integer>> output,
                                                            List<List<Integer>> input, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int newValue = getUpdatedValue(input, i, j);
                output.get(i).add(newValue);
            }
        }
        return output;
    }

    private static int getUpdatedValue(List<List<Integer>> input, int row, int col) {
        int leftZeroDistance = getDistance(input, row, col, 0);
        int rightZeroDistance = getDistance(input, row, col, 1);
        int topZeroDistance = getDistance(input, row, col, 2);
        int bottomZeroDistance = getDistance(input, row, col, 3);
        int minDistance = Math.min(Math.min(leftZeroDistance, rightZeroDistance),
                Math.min(topZeroDistance, bottomZeroDistance));
        int updatedValue = input.get(row).get(col) + minDistance;
        return updatedValue;
    }

    private static int getDistance(List<List<Integer>> input, int row, int col, int direction) {
        int counter = 0;
        boolean isZeroFound = false;
        switch (direction) {
            case 0 -> {
                col--;
                while (col >= 0) {
                    if (input.get(row).get(col) != 0) {
                        counter++;
                    } else {
                        isZeroFound = true;
                        break;
                    }
                    col--;
                }
            }
            case 1 -> {
                col++;
                while (col < input.get(row).size()) {
                    if (input.get(row).get(col) != 0) {
                        counter++;
                    } else {
                        isZeroFound = true;
                        break;
                    }
                    col++;
                }
            }
            case 2 -> {
                row--;
                while (row >= 0) {
                    if (input.get(row).get(col) != 0) {
                        counter++;
                    } else {
                        isZeroFound = true;
                        break;
                    }
                    row--;
                }
            }
            case 3 -> {
                row++;
                while (row < input.size()) {
                    if (input.get(row).get(col) != 0) {
                        counter++;
                    } else {
                        isZeroFound = true;
                        break;
                    }
                    row++;
                }
            }
        }
        return isZeroFound ? counter : Integer.MAX_VALUE;
    }

}