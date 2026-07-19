package module.two.dp.one.assignment;

/**
 * Decode Ways:
 * <p>
 * A message containing letters from A-Z can be encoded into numbers using the following mapping:
 * <p>
 * 'A' -> "1"
 * 'B' -> "2"
 * ... 'Z' -> "26"
 * <p>
 * To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping
 * above (there may be multiple ways). For example, "11106" can be mapped into:
 * "AAJF" with the grouping (1 1 10 6)
 * "KJF" with the grouping (11 10 6)
 * <p>
 * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
 * Given a string s containing only digits, return the number of ways to decode it.
 * <p>
 * Input: s = "12" Output: 2 Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
 * <p>
 * Input: s = "226" Output: 3 Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 * <p>
 * Constraints:
 * 1 <= s.length <= 100
 * s contains only digits and may contain leading zero(s).
 */
public class _1DecodeWays {

    public static void main(String[] args) {
        printNumberOfWays("12");
        printNumberOfWays("226");
    }

    private static void printNumberOfWays(String s) {
        System.out.println("Number of ways the string can be decoded using recursion: " + approach1(s));
        System.out.println("Number of ways the string can be decoded using memoization: " + approach2(s));
        System.out.println("Number of ways the string can be decoded using tabulation: " + approach3(s));
        System.out.println("Number of ways the string can be decoded using space optimization: " + approach4(s));
        System.out.println();
    }

    /**
     * Approach 1 - Recursion
     * - This is the simplest and bruteforce approach.
     * - Here, we are using an index to iterate over the string using top-down approach.
     * - The base case is if index reaches the string length, that means traversal complete, return 1.
     * - If current char is '0', then return 0.
     * - Now count for next index, also check if it is not last index check for 2 chars, if they are valid then check after that.
     * - At last, just return the count.
     * - Time complexity: O(2^N) as we are exploring 2 ways each time i.e. for single and double digits only.
     * - Space complexity: O(N) due to recursion depth.
     */
    private static int approach1(String s) {
        return recursion(s, 0);
    }

    private static int recursion(String s, int i) {
        int n = s.length();
        if (i == n) {
            return 1;
        }
        if (s.charAt(i) == '0') {
            return 0;
        }
        int count = recursion(s, i + 1);
        if (i + 1 < n) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);
            if (c1 == '1' || (c1 == '2' && c2 <= '6')) {
                count += recursion(s, i + 2);
            }
        }
        return count;
    }

    /**
     * Approach 2 - Memoization
     * - This is better than the bruteforce approach to get better time complexity.
     * - Time complexity: O(N) as we are iterating the string max 2 times.
     * - Space complexity: O(N) due array + O(N) due to recursion depth.
     */
    private static int approach2(String s) {
        int n = s.length();
        int[] memo = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            memo[i] = -1;
        }
        return memoization(s, 0, n, memo);
    }

    private static int memoization(String s, int i, int n, int[] memo) {
        if (i == n) {
            return 1;
        }
        if (s.charAt(i) == '0') {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        int count = memoization(s, i + 1, n, memo);
        if (i + 1 < n) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);
            if (c1 == '1' || (c1 == '2' && c2 <= '6')) {
                count += memoization(s, i + 2, n, memo);
            }
        }
        return memo[i] = count;
    }

    /**
     * Approach 3 - Tabulation
     * - The approach is better than the memoization technique.
     * - Here, we are using the bottom up approach using iteration.
     * - We are starting from end index of the string, and also we have kept the empty string value as 1.
     * - Now for each index, we are checking if character is not '0', if yes then add it to the ans array at i index.
     * - Now check if it is not last index, pop 2 digits and check if they are valid, if yes then add count by exploring
     * next to next index.
     * - At last, just return the first index of answer array.
     * - Time complexity: O(N) as we are iterating over the string at most once.
     * - Space complexity: O(N) as we are using the dp array but without any recursion stack.
     */
    private static int approach3(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
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
     * - This is the best approach, here we have optimized the space from tabulation.
     * - We are using 2 pointers to store the next and next of next answers in it.
     * - Iterate over the string and store cur answer count as cur count + next if single digit is valid.
     * - Check for 2 digits and add next of next to current answer if they are valid.
     * - Later, just update the next and next of next pointers.
     * - At last, just return the next pointer as that will have the answer.
     * - Time complexity: O(N) as we are iterating over the string once.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int approach4(String s) {
        int n = s.length();
        int next1 = 1, next2 = 0;
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