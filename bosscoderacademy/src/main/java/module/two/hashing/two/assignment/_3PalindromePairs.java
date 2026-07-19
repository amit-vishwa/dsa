package module.two.hashing.two.assignment;

import java.util.ArrayList;

/**
 * Palindrome Pairs:
 * <p>
 * You are given a 0-indexed array of unique strings words.
 * A palindrome pair is a pair of integers (i, j) such that:
 * 0 <= i, j < words.length,
 * i != j, and
 * words[i] + words[j] (the concatenation of the two strings) is a palindrome.
 * Return an array of all the palindrome pairs of words.
 * <p>
 * Input: words = ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]]
 * Explanation: The palindromes are ["abcddcba","dcbaabcd","slls","llssssll"]
 * <p>
 * Input: words = ["bat","tab","cat"]
 * Output: [[0,1],[1,0]]
 * Explanation: The palindromes are ["battab","tabbat"]
 * <p>
 * Constraints:
 * 1 <= words.length <= 5000
 * 0 <= words[i].length <= 300
 * words[i] consists of lowercase English letters.
 */
public class _3PalindromePairs {

    public static void main(String[] args) {
        System.out.println("Palindrome pairs: " + palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"}));
        System.out.println("Palindrome pairs: " + palindromePairs(new String[]{"bat", "tab", "cat"}));
    }

    /**
     * Approach:
     * - A simple bruteforce approach.
     * - Just iterate over the input array of string and find all the pair combinations.
     * - Check for palindrome and add the pair in the list.
     * - Time complexity: O(N^2) due to nested loop * O(P+Q) for palindrome check = O(N^2 * (P+Q)).
     * - Space complexity: O(1) as not extra space is used for computation, only using for result.
     */
    private static ArrayList<ArrayList<Integer>> palindromePairs(String[] input) {
        ArrayList<ArrayList<Integer>> palindromePairList = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (i == j) {
                    continue;
                }
                if (isPalindrome(input[i] + input[j])) {
                    ArrayList<Integer> palindromePair = new ArrayList<>();
                    palindromePair.add(i);
                    palindromePair.add(j);
                    palindromePairList.add(palindromePair);
                }
            }
        }
        return palindromePairList;
    }

    private static boolean isPalindrome(String str) {
        int l = 0, r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

}