package module.two.dp.two.notes;

import java.util.Arrays;

/**
 * Decode Ways:
 * <p>
 * A message containing letters from A-Z can be encoded into numbers using the following mapping:
 * 'A' -> "1" 'B' -> "2" ... 'Z' -> "26"
 * <p>
 * To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping
 * above (there may be multiple ways). For example, "11106" can be mapped into:
 * "AAJF" with the grouping (1 1 10 6)
 * "KJF" with the grouping (11 10 6)
 * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
 * <p>
 * Given a string s containing only digits, return the number of ways to decode it. The test cases are generated so that the
 * answer fits in a 32-bit integer.
 * <p>
 * Example
 * Input: s = "12"
 * Output: 2
 */
public class _4DecodeWays {

    public static void main(String[] args) {
        printDecodedWays("12");
        printDecodedWays("226");
    }

    private static void printDecodedWays(String s) {
        System.out.println("Decoded ways using recursion: " + approach1(s));
        System.out.println("Decoded ways using memoization: " + approach2(s));
        System.out.println("Decoded ways using tabulation: " + approach3(s));
        System.out.println("Decoded ways using space optimization: " + approach4(s));
        System.out.println();
    }

    /**
     * Approach 1 - Recursion
     * - This is the simplest bruteforce approach.
     * - We have to iterate over the string and add base cases for recursion.
     * - If index becomes equal to string length, then return 1.
     * - If current character digit is 0, then return 0, this is most important to handle few edge cases.
     * - Now get count from next digit recursive call.
     * - After that, check if index + 1 < string length, then take 2 characters and compare them.
     * - Add the result in count from next of next index exploration.
     * - At last, just return the count.
     * - Time complexity: O(2^N) as we are recursively exploring 2 ways.
     * - Space complexity: O(N) due to recursion stack.
     */
    private static int approach1(String s) {
        return recursion(s, 0);
    }

    private static int recursion(String s, int index) {
        int n = s.length();
        if (index == n) {
            return 1;
        }
        if (s.charAt(index) == '0') {
            return 0;
        }
        int count = recursion(s, index + 1);
        if (index + 1 < n) {
            char c1 = s.charAt(index);
            char c2 = s.charAt(index + 1);
            if (c1 == '1' || (c1 == '2' && c2 <= '6')) {
                count += recursion(s, index + 2);
            }
        }
        return count;
    }

    /**
     * Approach 2 - Memoization
     * - This is better approach than the bruteforce one.
     * - Here, we have optimized the time complexity, but space complexity is increased as we require extra array.
     * - Time complexity: O(N) as we are iterating the string at most twice.
     * - Space complexity: O(N) due to additional array + O(N) for recursion stack.
     */
    private static int approach2(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return memoization(s, dp, 0);
    }

    private static int memoization(String s, int[] dp, int index) {
        int length = s.length();
        if (index == length) {
            return 1;
        }
        if (s.charAt(index) == '0') {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int count = memoization(s, dp, index + 1);
        if (index + 1 < length) {
            char c1 = s.charAt(index);
            char c2 = s.charAt(index + 1);
            if (c1 == '1' || (c1 == '2' && c2 <= '6')) {
                count += memoization(s, dp, index + 2);
            }
        }
        return dp[index] = count;
    }

    /**
     * Approach 3 - Tabulation
     * - This is better approach as it uses bottom up logic to calculate the answer.
     * - We have to set the state of last element as 1, as we traverse string then we return 1.
     * - Now, traverse the string in reverse order and check if current digit is not zero then add previous state.
     * - Also, check for 2 digits and add previous to previous state in current state if true.
     * - Time complexity: O(N) as we are iterating the string once.
     * - Space complexity: O(N) due to dp array.
     */
    private static int approach3(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
//        dp[i] = number of ways to decode substring starting from index i
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                dp[i] += dp[i + 1];
            }
            if (i + 1 < n) {
                char c1 = s.charAt(i);
                char c2 = s.charAt(i + 1);
                if (c1 == '1' || (c1 == '2' && c2 <= '6')) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }

    /**
     * Approach 4 - Space optimization
     * - This is the most optimal approach.
     * - This is similar to approach 3, only here we have optimized the space.
     * - We have to store initial 2 states in 2 variables.
     * - Then perform similar iteration as of approach 3 and at last just return the next1 as answer.
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    private static int approach4(String s) {
        int n = s.length();
        int next1 = 1; // dp[i+1]
        int next2 = 0; // dp[i+2]
        for (int i = n - 1; i >= 0; i--) {
            int cur = 0;
            if (s.charAt(i) != '0') {
                cur += next1;
            }
            if (i + 1 < n) {
                char c1 = s.charAt(i);
                char c2 = s.charAt(i + 1);
                if (c1 == '1' || (c1 == '2' && c2 <= '6')) {
                    cur += next2;
                }
            }
            next2 = next1;
            next1 = cur;
        }
        return next1;
    }

}
