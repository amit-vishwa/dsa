package module.two.dp.one.notes;

import java.util.Arrays;

/**
 * Minimum Cost to Cut a Stick:
 * <p>
 * Given a wooden stick of length n units. The stick is labeled from 0 to n. Given an integer array cuts where cuts[i] denotes
 * a position you should perform a cut at. You should perform the cuts in order, you can change the order of the cuts as you
 * wish. The cost of one cut is the length of the stick to be cut, the total cost is the sum of the costs of all cuts. When
 * you cut a stick, it will be split into two smaller sticks (i.e. the sum of their lengths is the length of the stick before
 * the cut). Return the minimum total cost of the cuts.
 * <p>
 * Example
 * Input: n = 7, cuts = [1,3,4,5]
 * Output: 16
 */
public class _2MinCostToCutStick {

    public static void main(String[] args) {
        printMinCostToCutStick(7, new int[]{1, 3, 4, 5});
        printMinCostToCutStick(9, new int[]{5, 6, 1, 4, 2});
    }

    private static void printMinCostToCutStick(int n, int[] cuts) {
        System.out.println("Min cost to cut stick using recursion: " + approach1(n, cuts));
        System.out.println("Min cost to cut stick using memoization: " + approach2(n, cuts));
        System.out.println("Min cost to cut stick using tabulation: " + approach3(n, cuts));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce
     * - This is a bruteforce approach using recursion.
     * - We have to sort the cuts array first, then create extended cuts array with len+2 and add 0 at start and N at end.
     * - Now, just pass start index as 1, end as cuts array length and extended cuts array.
     * - Base case is start greater than end, then return 0 as no more cuts possible.
     * - Set the min cost to max int value, iterate over the loop from start to end.
     * - Calculate the current segment cost, left and right segment and add them all to get actual cost.
     * - Compare it with min cost and update the min cost if current cost is less.
     * - At last just return the min cost.
     * - Time Complexity: O(C^C) - Exponential
     * At each recursive call, we try all possible cuts and branch without memoization
     * Massive overlapping subproblems solved repeatedly
     * - Space Complexity: O(C) for recursion stack depth
     */
    private static int approach1(int n, int[] cuts) {
        int c = cuts.length;
        Arrays.sort(cuts);
        int[] extendedCuts = new int[c + 2];
        extendedCuts[0] = 0;
        extendedCuts[c + 1] = n;
        for (int i = 1; i <= c; i++) {
            extendedCuts[i] = cuts[i - 1];
        }
        return recursion(1, c, extendedCuts);
    }

    private static int recursion(int start, int end, int[] extendedCuts) {
        if (start > end) {
            return 0;
        }
        int minCost = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            int currentSegment = extendedCuts[end + 1] - extendedCuts[start - 1];
            int leftSegment = recursion(start, i - 1, extendedCuts);
            int rightSegment = recursion(i + 1, end, extendedCuts);
            int cost = currentSegment + leftSegment + rightSegment;
            minCost = Math.min(minCost, cost);
        }
        return minCost;
    }

    /**
     * Approach 2 - Better (Top-Down approach)
     * - This is better version of recursion approach.
     * - Here, we are using memoization technique to restrict not required calls.
     * - This reduces the time complexity, but also increases the space complexity due to 2D array.
     * - Time Complexity: O(C³)
     * Number of unique subproblems: O(C²) (all pairs of start and end)
     * Work per subproblem: O(C) (loop through all possible cuts)
     * Total: O(C²) × O(C) = O(C³)
     * - Space Complexity: O(C²)
     * Memoization table: O(C²)
     * Recursion stack: O(C)
     * Total: O(C²)
     */
    private static int approach2(int n, int[] cuts) {
        int c = cuts.length;
        Arrays.sort(cuts);
        int[] extendedCuts = new int[c + 2];
        extendedCuts[0] = 0;
        extendedCuts[c + 1] = n;
        System.arraycopy(cuts, 0, extendedCuts, 1, c);
//        System.out.println("Array: " + Arrays.toString(extendedCuts));
        int[][] memo = new int[c + 2][c + 2];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
//        System.out.println("Memo: " + Arrays.deepToString(memo));
        return memoization(1, c, extendedCuts, memo);
    }

    private static int memoization(int start, int end, int[] extendedCuts, int[][] memo) {
        if (start > end) {
            return 0;
        }
        if (memo[start][end] != -1) {
            return memo[start][end];
        }
        int minCost = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            int currentSegment = extendedCuts[end + 1] - extendedCuts[start - 1];
            int leftSegment = memoization(start, i - 1, extendedCuts, memo);
            int rightSegment = memoization(i + 1, end, extendedCuts, memo);
            int cost = currentSegment + leftSegment + rightSegment;
            minCost = Math.min(minCost, cost);
        }
        return memo[start][end] = minCost;
    }

    /**
     * Approach 3 - Optimal (Bottom-Up approach)
     * - This is the best approach for this problem.
     * - We are using the tabulation technique of DP here.
     * - We have created a 2D array to store already encountered answers.
     * - We are iterating over extended cuts array with cuts array length.
     * - Inside loop starts with 0 till index + external index.
     * - We also have j index that will store last index information.
     * - Now we have a loop of k from i+1 till j - 1, we are checking the cost here and updating dp array.
     * - At last, after loops, we are returning the last col of first row of dp array.
     * - Time Complexity: O(C³)
     * Same as memoization - O(C²) states with O(C) work per state
     * Three nested loops: len, i, and k
     * - Space Complexity: O(C²)
     * DP table: O(C²)
     * No recursion stack
     */
    private static int approach3(int n, int[] cuts) {
        int c = cuts.length;
        Arrays.sort(cuts);
        int[] extendedCuts = new int[c + 2];
        extendedCuts[0] = 0;
        extendedCuts[c + 1] = n;
        System.arraycopy(cuts, 0, extendedCuts, 1, c);
        int[][] dp = new int[c + 2][c + 2];
        // proceeding to cut the stick of length c
        for (int len = 2; len < c + 2; len++) {
            // try for cut from i to current length
            for (int i = 0; i + len < c + 2; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                // trying every possible cuts
                for (int k = i + 1; k < j; k++) {
                    int currentSegment = extendedCuts[j] - extendedCuts[i];
                    int leftSegment = dp[i][k];
                    int rightSegment = dp[k][j];
                    int cost = currentSegment + leftSegment + rightSegment;
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
                if (dp[i][j] == Integer.MAX_VALUE) {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[0][c + 1];
    }

}
