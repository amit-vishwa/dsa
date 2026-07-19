package module.two.hashing.two.assignment;

import java.util.HashMap;

/**
 * Minimum Window Substring:
 * <p>
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every
 * character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 * The testcases will be generated such that the answer is unique.
 * <p>
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * <p>
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * <p>
 * Constraints:
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s and t consist of uppercase and lowercase English letters.
 */
public class _2MinimumWindowSubstring {

    public static void main(String[] args) {
        printMinimumSubstring("ADOBECODEBANC", "ABC");
        printMinimumSubstring("a", "a");
    }

    private static void printMinimumSubstring(String s, String t) {
        System.out.println("Minimum window substring by approach 1: " + approach1(s, t));
        System.out.println("Minimum window substring by approach 2: " + approach2(s, t));
        System.out.println();
    }

    /**
     * Approach 1 - HashMap
     * - This is a simple approach using hashmap.
     * - We just have to create a HashMap for char count of string t.
     * - Then iterate over the string s, after initializing left, right, min window and remaining chars.
     * - Now, for each character of s just check if it is there in map with occurrence greater than 0.
     * - If yes, then decrease the remaining chars count.
     * - Now, update map by reducing the occurrence count for that character, if not present then take default as 0 then reduce.
     * - If remaining chars are 0, that means we got a valid window and all chars of t are visited.
     * - Then create a while loop and check chars from left in s.
     * - If cur left char occurrence is 0 in map then break, else just increase char occurrence by 1, take default as 0.
     * - Now increase the left pointer to shrink the window.
     * - After completing the while, update our current window by checking difference of right, left and window array.
     * - Now, just reset the values by increasing occurrence count of cur left char in map and remaining chars and left pointer.
     * - Time complexity: O(S + T) as we are traversing t first then s = O(S) as it is max.
     * - Space complexity: O(T) due to hashmap.
     */
    private static String approach1(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        if (sLen < tLen) {
            return "";
        }
        HashMap<Character, Integer> tCharMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            tCharMap.put(ch, tCharMap.getOrDefault(ch, 0) + 1);
        }
        int left = 0, remainingChars = tLen;
        int[] minWindow = {0, sLen};
        // right = expand until you have all required chars.
        for (int right = 0; right < sLen; right++) {
            char curChar = s.charAt(right);
            // increasing window
            if (tCharMap.containsKey(curChar) && tCharMap.get(curChar) > 0) {
                remainingChars--;
            }
            tCharMap.put(curChar, tCharMap.getOrDefault(curChar, 0) - 1);
            // valid window 
            if (remainingChars == 0) {
                // while = discard unnecessary chars from the left to make the current valid window as small as possible.
                while (true) {
                    curChar = s.charAt(left);
                    if (tCharMap.get(curChar) == 0) {
                        break;
                    }
                    tCharMap.put(curChar, tCharMap.getOrDefault(curChar, 0) + 1);
                    left++;
                }
                // update window
                if (right - left < minWindow[1] - minWindow[0]) {
                    minWindow[0] = left;
                    minWindow[1] = right;
                }
                // resetting for other windows
                // reset = drop the required left char to force exploration of windows that start later.
                curChar = s.charAt(left);
                tCharMap.put(curChar, tCharMap.getOrDefault(curChar, 0) + 1);
                remainingChars++;
                left++;
            }
        }
        return minWindow[1] == sLen ? "" : s.substring(minWindow[0], minWindow[1] + 1);
    }

    /**
     * Approach 2 - Hashing
     * - This approach is similar to approach 1, only here we are using hash int array of fixed size to save space.
     * - Time complexity is same but space complexity is O(58) = O(1) i.e. constant.
     */
    private static String approach2(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        if (sLen < tLen) {
            return "";
        }
        int[] tChars = new int[58];
        for (char ch : t.toCharArray()) {
            tChars[ch - 'A']++;
        }
        int left = 0, remainingChars = tLen;
        int[] minWindow = {0, sLen};
        for (int right = 0; right < sLen; right++) {
            char curChar = s.charAt(right);
            // increasing window
            if (tChars[curChar - 'A'] > 0) {
                remainingChars--;
            }
            tChars[curChar - 'A']--;
            // valid window 
            if (remainingChars == 0) {
                while (true) {
                    curChar = s.charAt(left);
                    if (tChars[curChar - 'A'] == 0) {
                        break;
                    }
                    tChars[curChar - 'A']++;
                    left++;
                }
                // update window
                if (right - left < minWindow[1] - minWindow[0]) {
                    minWindow[0] = left;
                    minWindow[1] = right;
                }
                // resetting for other windows
                curChar = s.charAt(left);
                tChars[curChar - 'A']++;
                remainingChars++;
                left++;
            }
        }
        return minWindow[1] >= sLen ? "" : s.substring(minWindow[0], minWindow[1] + 1);
    }

}