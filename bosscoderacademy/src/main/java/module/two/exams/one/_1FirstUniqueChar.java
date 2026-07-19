package module.two.exams.one;

import java.util.HashMap;

/**
 * First Unique Character in a String:
 * <p>
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 * <p>
 * Example 1:
 * Input: s = "leetcode"
 * Output: 0
 * Explanation:
 * The character 'l' at index 0 is the first character that does not occur at any other index.
 * <p>
 * Example 2:
 * Input: s = "loveleetcode"
 * Output: 2
 * <p>
 * Example 3:
 * Input: s = "aabb"
 * Output: -1
 * <p>
 * Constraints:
 * 1 <= s.length <= 105
 * s consists of only lowercase English letters.
 * <p>
 * Refer: https://leetcode.com/problems/first-unique-character-in-a-string/description/
 */
public class _1FirstUniqueChar {

    public static void main(String[] args) {
        printFirstUniqueCharacterIndex("leetcode");
        printFirstUniqueCharacterIndex("loveleetcode");
        printFirstUniqueCharacterIndex("aabb");
    }

    private static void printFirstUniqueCharacterIndex(String str) {
        System.out.println("Index of first unique character by approach 1: " + approach1(str));
        System.out.println("Index of first unique character by approach 2: " + approach2(str));
        System.out.println("Index of first unique character by approach 3: " + approach3(str));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce
     * - This is simple bruteforce approach using nested loops.
     * - We are keeping counter for current character, if there are other similar characters just increase the counter.
     * - After iterating over the array for a character, just check if count is 1.
     * - If it is 1, then just return the index.
     * - Else, at last, just return -1 as no unique character exist in the string.
     * - Time complexity: O(N^2) due to nested loops.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int approach1(String str) {
        int n = str.length();
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (str.charAt(i) == str.charAt(j)) {
                    count++;
                }
            }
            if (count == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Approach 2 - Optimal
     * - This is an optimal approach using HashMap.
     * - First we are creating the hashmap for characters and their occurrence.
     * - After that we are again iterating over the string and checking if current character occurrence is 1 in hashmap.
     * - If it is 1, then just return the index.
     * - Else, at end just return -1 as no unique character exist for the given string.
     * - Time complexity: O(N) as we are traversing the string twice.
     * - Space complexity: O(N) due to hashmap, but problem consist of 26 alphabets only so it is O(26) = O(1) constant space.
     */
    private static int approach2(String str) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (charMap.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Approach 3 - Optimal
     * - This is similar to approach 2, only here we are using hash array.
     * - Time and space complexity is similar to approach 2 only.
     */
    private static int approach3(String str) {
        int[] charArray = new int[26];
        for (char c : str.toCharArray()) {
            charArray[c - 'a']++;
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (charArray[c - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

}
