package module.one.backtracking.notes;

import java.util.ArrayList;
import java.util.List;

/**
 * Palindrome Partitioning:
 * <p>
 * You are given a string s, and partition it in such a way that every substring is a palindrome. Return all such palindromic
 * partitions of s.
 * <p>
 * Example
 * Input: s = “aab”
 * Output: [ ["a", "a", "b"], ["aa", "b"] ]
 *
 * Approach:
 * - The approach is simple, we are calculating the prefix and checking if it is palindrome.
 * - If yes then will add that to the list, and explore for remaining string, and while backtracking will remove last list entry.
 * - Also, we will check if current string is empty, if it is empty then we got all palindromes then return the list.
 * - Time complexity: O(2^N) similar to subset recursion * O(N + N + N) for substring and palindrome method = O(N*2^N)
 * - Space complexity: O(N) for recursion stack.
 */
public class _5PalindromePartitioning {

    public static void main(String[] args) {
        printPartitions("aab");
        printPartitions("abaaba");
    }

    private static void printPartitions(String str) {
        System.out.println(palindromePartitions(str, new ArrayList<>()));
    }

    private static List<List<String>> palindromePartitions(String str, List<String> palindrome) {
        if (str.isEmpty()) {
            return new ArrayList<>(List.of(new ArrayList<>(palindrome)));
        }
        List<List<String>> palindromeList = new ArrayList<>();
        for (int i = 1; i <= str.length(); i++) {
            String prefix = str.substring(0, i);
            if (isPalindrome(prefix)) {
                palindrome.add(prefix);
                palindromeList.addAll(palindromePartitions(str.substring(i), palindrome));
                palindrome.removeLast();
            }
        }
        return palindromeList;
    }

    private static boolean isPalindrome(String str) {
        int s = 0, e = str.length() - 1;
        while (s < e) {
            if (str.charAt(s++) != str.charAt(e--)) {
                return false;
            }
        }
        return true;
    }

}
