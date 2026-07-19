package module.two.tries.assignment;

/**
 * Count Substrings That Differ by One Character:
 * <p>
 * Given two strings s and t, find the number of ways you can choose a non-empty substring of s and replace a single character
 * by a different character such that the resulting substring is a substring of t. In other words, find the number of substrings
 * in s that differ from some substring in t by exactly one character.
 * For example, the underlined substrings in "computer" and "computation" only differ by the 'e'/'a', so this is a valid way.
 * Return the number of substrings that satisfy the condition above.
 * A substring is a contiguous sequence of characters within a string.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aba", t = "baba"
 * Output: 6
 * <p>
 * Example 2:
 * Input: s = "ab", t = "bb"
 * Output: 3
 * <p>
 * Refer: https://leetcode.com/problems/count-substrings-that-differ-by-one-character/description/
 */
public class _4CountSubstrings {

    public static void main(String[] args) {
        System.out.println("Count of substrings that differ by one character is " + substringsCount("aba", "baba"));
        System.out.println("Count of substrings that differ by one character is " + substringsCount("ab", "bb"));
    }

    /**
     * Approach:
     * - The approach is quite different.
     * - First iterate over string 1 and 2 in parallel.
     * - If both chars are same, then skip and check for other char.
     * - For each char in string 1, string 2 should be traversed.
     * - Now, take indexes of both strings and start traversing in left side.
     * - Check if both chars are same, if yes the increment left value, else break.
     * - Do the same for right side.
     * - After that just cumulatively add the product of left + 1 and right + 1 in the count and return it after traversals.
     * - Time complexity: O(M) traversing string 1 * O(N) traversing string 2 * O(Min(M,N)) for left right traversals = O(N^3) is
     * of same length
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int substringsCount(String s, String t) {
        int count = 0;
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            for (int j = 0; j < ct.length; j++) {
                if (cs[i] == ct[j]) {
                    continue;
                }
                int left = 0;
                int x = i - 1, y = j - 1;
                while (x >= 0 && y >= 0) {
                    if (cs[x--] == ct[y--]) {
                        left++;
                    } else {
                        break;
                    }
                }
                int right = 0;
                x = i + 1;
                y = j + 1;
                while (x < cs.length && y < ct.length) {
                    if (cs[x++] == ct[y++]) {
                        right++;
                    } else {
                        break;
                    }
                }
                count += (left + 1) * (right + 1);
            }
        }
        return count;
    }

}