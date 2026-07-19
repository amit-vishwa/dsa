package module.one._1d_and_2d_array.notes;

import java.util.List;

public class _1SubMatricesSum {

    public static void main(String[] args) {
        printSum(List.of(List.of(1, 1), List.of(1, 1)));
    }

    private static void printSum(List<List<Integer>> a) {
        approach1(a);
        approach2(a);
    }

    /**
     * Approach 1 - Brutefoce approach:
     * - Here, we are simply setting a starting point from a particular cell which take O(M*N)
     * time.
     * - Also, we have set an endpoint point for all submartices which again takes O(M*N)
     * time.
     * - Then we are iterating from start point to end point to calculate the sum which again
     * takes O(M*N) time.
     * - So, total time complexity becomes:
     * O(M*N) * O(M*N) * O(M*N) = O(M^3 * N^3),
     * - If M is similar to N then, it becomes O(N^3 * N^3) = O(N^(3+3)) = O(N^6), which is
     * worst of all.
     * - Space complexity is O(1), as we are not taking any extra space dependent on input.
     */
    private static void approach1(List<List<Integer>> mat) {
        int m = mat.size();
        if (m == 0) {
            return;
        }
        int n = mat.get(0).size();
        int sum = 0;
        for (int r1 = 0; r1 < m; r1++) {
            for (int c1 = 0; c1 < n; c1++) {
                for (int r2 = r1; r2 < m; r2++) {
                    for (int c2 = c1; c2 < n; c2++) {
                        for (int r = r1; r <= r2; r++) {
                            for (int c = c1; c <= c2; c++) {
                                sum += mat.get(r).get(c);
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Submatrices sum by approach 1: " + sum);
    }

    /**
     * Approach 2 - Optimal approach:
     * - Here, we just to iterate once over the whole matrix and calculate left and right
     * matrices count.
     * - Left matrices will be nothing but the product of row and column from start till that cell.
     * - Right matrices will be nothing but the product of row and columns starting from that
     * cell till the end.
     * - At last, we also have to include the contribution of that cell itself.
     * - So the answer here will be the product of top left matrices, bottom right matrices and
     * the cell itself.
     * - This is the most optimal solution with O(M*N) time complexity and O(1) space
     * complexity as we are not utilizing any extra space.
     * - When M is similar to N then time complexity becomes O(N*N) = O(N^2)
     */
    private static void approach2(List<List<Integer>> mat) {
        int m = mat.size();
        if (m == 0) {
            return;
        }
        int n = mat.get(0).size();
        int sum = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int topLefts = (r + 1) * (c + 1);
                int bottomRights = (m - r) * (n - c);
                sum += topLefts * bottomRights * mat.get(r).get(c);
            }
        }
        System.out.println("Submatrices sum by approach 2: " + sum);
    }

}
