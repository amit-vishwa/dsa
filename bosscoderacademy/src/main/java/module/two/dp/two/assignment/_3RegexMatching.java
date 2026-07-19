package module.two.dp.two.assignment;

/**
 * Regular Expression Matching:
 * <p>
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * <p>
 * The matching should cover the entire input string (not partial).
 * <p>
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * <p>
 * Input: s = "aa", p = "a*"
 * Output: true
 * <p>
 * Constraints:
 * 1 <= s.length <= 20
 * 1 <= p.length <= 20
 * s contains only lowercase English letters.
 * p contains only lowercase English letters, '.', and '*'.
 * It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
 */
public class _3RegexMatching {

    public static void main(String[] args) {
        printRegexMatchingResult("aa", "a");
        printRegexMatchingResult("aa", "a*");
        printRegexMatchingResult("aab", "c*a*b");
    }

    private static void printRegexMatchingResult(String s, String p) {
        System.out.println("Is regex matching the string using recursion?           " + approach1(s, p));
        System.out.println("Is regex matching the string using memoization?         " + approach2(s, p));
        System.out.println("Is regex matching the string using tabulation?          " + approach3(s, p));
        System.out.println("Is regex matching the string using space optimization?  " + approach4(s, p));
        System.out.println();
    }

    /**
     * Approach 1 - Recursion
     * - This is the bruteforce approach using recursion.
     * - We are starting from indices 0, then adding a base case if regex is traversed, then return if string is traversed.
     * - Now, for first match we have to check if current char is '.' or regex char is same as string char for current index.
     * - If regex char is second last or less and next char is '*', then skip next char from regex or proceed with next string
     * char with current regex char for comparison with firstMatch as true.
     * - Else return firstMatch and comparison with next chars from string and regex.
     * - Time complexity: O(2^(M+N)), M is string length and N is regex length.
     * - Space complexity: O(M+N) due to recursion stack.
     */
    private static boolean approach1(String s, String p) {
        int m = s.length(), n = p.length();
        return recursion(s, p, 0, 0, m, n);
    }

    private static boolean recursion(String s, String p, int i, int j, int m, int n) {
        if (j == n) {
            return i == m;
        }
        boolean firstMatch = (i < m && (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)));
        if (j + 1 < n && p.charAt(j + 1) == '*') {
            return (recursion(s, p, i, j + 2, m, n) || (firstMatch && recursion(s, p, i + 1, j, m, n)));
        }
        return (firstMatch && recursion(s, p, i + 1, j + 1, m, n));
    }

    /**
     * Approach 2 - Memoization
     * - This is better than bruteforce approach.
     * - It uses the top-down approach and extra array, rest all logic is same.
     * - Time complexity: O(M*N)
     * - Space complexity: O(M*N) due to 2D array + recursion stack
     */
    private static boolean approach2(String s, String p) {
        int m = s.length(), n = p.length();
        Boolean[][] dp = new Boolean[m + 1][n + 1];
        return memoization(s, p, 0, 0, m, n, dp);
    }

    private static boolean memoization(String s, String p, int i, int j, int m, int n, Boolean[][] dp) {
        if (j == n) {
            return i == m;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        boolean firstMatch = (i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));
        if (j + 1 < n && p.charAt(j + 1) == '*') {
            dp[i][j] = (memoization(s, p, i, j + 2, m, n, dp) || (firstMatch && memoization(s, p, i + 1, j, m, n, dp)));
        } else {
            dp[i][j] = (firstMatch && memoization(s, p, i + 1, j + 1, m, n, dp));
        }
        return dp[i][j];
    }

    /**
     * Approach 3 - Tabulation
     * - This is better than the approach 2, it uses bottom up approach.
     * - We have to create a 2D array and keep first cell value as true.
     * - Now update the first row, if current char is '*' then update current cell value as last of last cell.
     * - After that, fill the values for rest of the cells by traversing them from 1.
     * - If current char at regex is '.' or current regex char is same as string char then update dp cell to previous row col.
     * - Else if current char is '*', then update current cell value of dp array to previous of previous state.
     * - Also check, if previous of previous regex char is '*' or previous of previous regex char is similar to previous string char.
     * - If yes, then or the current state with previous string state.
     * - At last, just return the last state value from dp array.
     * - Time complexity: O(M*N) due to nested loops.
     * - Space complexity: O(M*N) due to 2D array.
     */
    private static boolean approach3(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '.' || (p.charAt(j - 1) == s.charAt(i - 1))) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (p.charAt(j - 2) == '.' || (p.charAt(j - 2) == s.charAt(i - 1))) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[m][n];
    }

    /**
     * Approach 4 - Space optimization
     * - This is similar to approach 3, however here we are using 2 1D arrays instead of a 2D array.
     * - We are considering only previous row and current row and based on that the code logic is implemented.
     * - We are setting the previous row values first, then iterating over nested loops.
     * - Now we are creating new array for current row and updating current row values as per approach 3 logic.
     * - At last of each iteration, we are making current row as previous row and repeating the same steps.
     * - Now, at the end of the function, we are returning the last cell of 1D array of previous row.
     * - Time complexity: O(M*N) due to nested loops.
     * - Space complexity: O(2*N) as we are storing only 2 rows in separate arrays = O(N).
     */
    private static boolean approach4(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[] prev = new boolean[n + 1]; // previous row
        boolean[] curr; // current row
        prev[0] = true;
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                prev[j] = prev[j - 2];
            }
        }
        for (int i = 1; i <= m; i++) {
            curr = new boolean[n + 1];
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '.' || (p.charAt(j - 1) == s.charAt(i - 1))) {
                    curr[j] = prev[j - 1]; // similar to approach 3, get prev row data
                } else if (p.charAt(j - 1) == '*') {
                    curr[j] = curr[j - 2]; // similar to approach 3, skip that character
                    if (p.charAt(j - 2) == '.' || (p.charAt(j - 2) == s.charAt(i - 1))) {
                        curr[j] = curr[j] || prev[j]; // similar to approach 3
                    }
                }
            }
            prev = curr;
        }
        return prev[n];
    }

}