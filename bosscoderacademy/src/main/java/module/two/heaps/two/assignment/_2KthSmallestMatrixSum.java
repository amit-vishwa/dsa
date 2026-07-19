package module.two.heaps.two.assignment;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Find The Kth Smallest Sum In Matrix:
 * <p>
 * You are given an m x n matrix mat that has its rows sorted in non-decreasing order and an integer k.
 * You are allowed to choose exactly one element from each row to form an array.
 * Return the kth smallest array sum among all possible arrays.
 * <p>
 * Input: mat = [[1,3,11],[2,4,6]], k = 5
 * Output: 7
 * Explanation: Choosing one element from each row, the first k smallest sum are:
 * [1,2], [1,4], [3,2], [3,4], [1,6]. Where the 5th sum is 7.
 * <p>
 * Input: mat = [[1,3,11],[2,4,6]], k = 9
 * Output: 17
 * <p>
 * Constraints:
 * m == mat.length
 * n == mat.length[i]
 * 1 <= m, n <= 40
 * 1 <= mat[i][j] <= 5000
 * 1 <= k <= min(200, nm)
 * mat[i] is a non-decreasing array.
 */
public class _2KthSmallestMatrixSum {

    private static List<List<Integer>> input1() {
        return new ArrayList<>(List.of(List.of(1, 3, 11), List.of(2, 4, 6)));
    }

    private static List<List<Integer>> input2() {
        return new ArrayList<>(List.of(List.of(1, 3, 11), List.of(2, 4, 6)));
    }

    public static void main(String[] args) {
        printKthSmallestMatrixSum(input1(), 5);
        printKthSmallestMatrixSum(input2(), 9);
    }

    private static void printKthSmallestMatrixSum(List<List<Integer>> mat, int k) {
        System.out.println(k + " th smallest sum in a matrix by approach 1: " + approach1(mat, k));
        System.out.println(k + " th smallest sum in a matrix by approach 2: " + approach2(mat, k));
        System.out.println();
    }

    /**
     * Approach 1:
     * - This is a simple approach using Max Heap.
     * - We are storing the initial sum value as 0 in the main heap.
     * - Then we are traversing each row of a matrix.
     * - For each row, we are creating the max heap and then traversing over current row, col-by-col.
     * - First we are traversing over main heap that will have final answer till now and for each element will check row elements.
     * - Will store the sum of previous main heap value and current cell value in row level heap.
     * - After traversing current row, will remove extra elements from row level heap if size is greater than K.
     * - Now will update the main heap to current row level heap and after traversing whole matrix will return top element.
     * - Time complexity: O(M) matrix size * O(H) main heap size * O(R) row size * O(log(H*R)) insertion in heap H*R times
     * - Space complexity: O(H*R) due to insertion in row level heap.
     *
     * Time Complexity: O(M × k × N × log(k))
     * M iterations (one per row in the matrix)
     * For each row, we iterate through elements in the heap (at most k elements)
     * For each heap element, we iterate through N columns of the current row
     * Each insertion/deletion in the heap is O(log k)
     * After each row, we prune the heap to maintain size ≤ k with O(k × log k) operations
     *
     * Space Complexity: O(k)
     * We maintain a max heap with at most k elements at any time
     * The row-level heap also has at most k × N elements temporarily, but we keep it bounded to k
     */
    private static int approach1(List<List<Integer>> mat, int k) {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        maxPQ.offer(0);
        for (List<Integer> row : mat) {
            PriorityQueue<Integer> next = new PriorityQueue<>(Collections.reverseOrder());
            for (int prev : maxPQ) {
                for (int cell : row) {
                    next.offer(prev + cell);
                }
            }
            while (next.size() > k) {
                next.poll();
            }
            maxPQ = next;
        }
        return maxPQ.poll();
    }

    /**
     * Approach 2:
     * - This is an optimized version using binary search.
     * - We have calculated the lower and upper bounds first then started with the binary search logic.
     * - Now after calculating the mid, we are calculating the count, if count is less than K then increase lower, else
     * new upper will be mid.
     * - For calculating the count, we have to check if sum is greater than mid then count is 0, if row traversed then count is 1.
     * - Now initialise count with 0 and traver current row and recursively call function for next row with new sum.
     * - If count >= K, then return count, also at last after for loop just return the count.
     * - Time complexity: O(log(Max)) due binary search * O(R*C) for matrix traversal
     * - Space complexity: O(R) due to recursive stack, R is number of rows
     *
     * Time Complexity: O(log(Range) × M × N × min(N^M, k))
     * Breaking it down:
     * Binary Search Range: From minSum (sum of first elements) to maxSum (sum of last elements)
     * Log iterations: O(log(maxSum - minSum)) ≈ O(log(5000×40)) ≈ O(18) in worst case
     * For each binary search iteration: countLessEqual() is called
     * M levels of recursion (one per row)
     * N columns per row (try each element)
     * Early termination when count >= k, preventing exploration of all N^M combinations
     * Worst case without pruning: O(N^M) combinations, but pruned to ~O(k) combinations found
     *
     * Space Complexity: O(M)
     * Recursion stack depth = number of rows (M)
     * No additional data structures that scale with input size
     */
    private static int approach2(List<List<Integer>> mat, int k) {
        int minSum = 0, maxSum = 0;
        for (List<Integer> row : mat) {
            minSum += row.getFirst();
            maxSum += row.getLast();
        }
        while (minSum < maxSum) {
            int midSum = minSum + (maxSum - minSum) / 2;
            int count = countLessEqual(mat, midSum, k, 0, 0);
            if (count < k) {
                minSum = midSum + 1;
            } else {
                maxSum = midSum;
            }
        }
        return maxSum;
    }

    private static int countLessEqual(List<List<Integer>> mat, int target, int k, int row, int curSum) {
        if (curSum > target) {
            return 0;
        }
        if (row == mat.size()) {
            return 1;
        }
        int count = 0;
        for (int cell : mat.get(row)) {
            count += countLessEqual(mat, target, k, row + 1, curSum + cell);
            if (count >= k) {
                return count;
            }
        }
        return count;
    }

}