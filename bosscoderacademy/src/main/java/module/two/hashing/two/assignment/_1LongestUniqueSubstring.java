package module.two.hashing.two.assignment;

import java.util.HashSet;

// Refer _3LongestUniqueSubstring.java from package module.two.hashing.two.lecture;
public class _1LongestUniqueSubstring {

    public static void main(String[] args) {
        System.out.println("Longest substring length without repeating characters is " + longestSubstring("abcabcdbb"));
        System.out.println("Longest substring length without repeating characters is " + longestSubstring("bbbbb"));
        System.out.println("Longest substring length without repeating characters is " + longestSubstring("pwwkew"));
    }

    private static int longestSubstring(String str) {
        int longestSubstringLength = 0, leftIndex = 0, rightIndex = 0, strlen = str.length();
        HashSet<Character> strCharSet = new HashSet<>();
        while (rightIndex < strlen) {
            while (strCharSet.contains(str.charAt(rightIndex))) {
                strCharSet.remove(str.charAt(leftIndex));
                leftIndex++;
            }
            strCharSet.add(str.charAt(rightIndex));
            rightIndex++;
            longestSubstringLength = Math.max(longestSubstringLength, strCharSet.size());
        }
        return longestSubstringLength;
    }

}