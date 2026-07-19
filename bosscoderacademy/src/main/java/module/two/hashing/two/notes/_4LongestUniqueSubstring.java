package module.two.hashing.two.notes;

import java.util.HashSet;

// We can have multiple approaches like using HashMap and hash array
// Refer _3LongestUniqueSubstring.java from package module.two.hashing.two.lecture;
public class _4LongestUniqueSubstring {

    public static void main(String[] args) {
        System.out.println("Longest substring without repeating characters length: " + longestSubstring("ABDEFGABEF"));
        System.out.println("Longest substring without repeating characters length: " + longestSubstring("abcabcbb"));
        System.out.println("Longest substring without repeating characters length: " + longestSubstring("bbbbb"));
        System.out.println("Longest substring without repeating characters length: " + longestSubstring("pwwkew"));
    }

    private static int longestSubstring(String str) {
        int i = 0, j = 0, maxSubstring = 0;
        HashSet<Character> set = new HashSet<>();
        while (j < str.length()) {
            while (set.contains(str.charAt(j))) {
                set.remove(str.charAt(i++));
            }
            set.add(str.charAt(j++));
            maxSubstring = Math.max(maxSubstring, set.size());
        }
        return maxSubstring;
    }

}
