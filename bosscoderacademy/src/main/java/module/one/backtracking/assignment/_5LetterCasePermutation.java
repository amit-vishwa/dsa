package module.one.backtracking.assignment;

import java.util.List;
import java.util.ArrayList;

/**
 * LeetCode 784. Letter Case Permutation
 * Refer: https://leetcode.com/problems/letter-case-permutation/description/
 */
public class _5LetterCasePermutation {

    public static void main(String[] args) {
        printPermutations("a1b2");
        printPermutations("3z4");
    }

    private static void printPermutations(String s) {
        System.out.println("String permutations by approach 1: " + approach1(s, ""));
        System.out.println("String permutations by approach 2: " + approach2(s, new StringBuilder(s.length()), 0));
        System.out.println();
    }

    /**
     * Approach 1 - Recursion
     * - The approach involves a simple recursion use case where we just have to follow pick unpick approach.
     * - We have make choices of selecting the lower case, upper case and normal letter.
     * - We have to fetch the first character and reduce the string length by 1.
     * - When un processed string is empty then we got our permutation, just return using a list.
     * - Time complexity: O(2^N) as have 2 choices here.
     * - Space complexity: O(N) due to recursion stack.
     */
    private static List<String> approach1(String unProcessed, String processed) {
        if (unProcessed.isEmpty()) {
            return new ArrayList<>(List.of(processed));
        }
        List<String> permutations = new ArrayList<>();
        char c = unProcessed.charAt(0);
        if (Character.isLetter(c)) {
            permutations.addAll(approach1(unProcessed.substring(1), processed + Character.toLowerCase(c)));
            permutations.addAll(approach1(unProcessed.substring(1), processed + Character.toUpperCase(c)));
        } else {
            permutations.addAll(approach1(unProcessed.substring(1), processed + c));
        }
        return permutations;
    }

    /**
     * Approach 2 - Backtracking
     * - This is similar to approach 1 only.
     * - We are just using a string builder instead of a normal string and an index to keep track of elements.
     * - When character is a letter then we have 2 choices of making it a lower case and upper case.
     * - If it is number, then just add it as it is in the string builder by incrementing the index in next recursion.
     * - First we have to add character in string builder, then explore ways and undo what is done.
     * - Time and space complexity is similar to approach 1.
     */
    private static List<String> approach2(String s, StringBuilder sb, int index) {
        if (sb.length() == s.length()) {
            return new ArrayList<>(List.of(sb.toString()));
        }
        List<String> permutations = new ArrayList<>();
        for (int i = index; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                sb.append(Character.toLowerCase(c));
                permutations.addAll(approach2(s, sb, i + 1));
                sb.setLength(sb.length() - 1);
                sb.append(Character.toUpperCase(c));
                permutations.addAll(approach2(s, sb, i + 1));
                sb.setLength(sb.length() - 1);
            } else {
                sb.append(c);
                permutations.addAll(approach2(s, sb, i + 1));
                sb.setLength(sb.length() - 1);
            }
        }
        return permutations;
    }

}