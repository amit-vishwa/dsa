package module.one.backtracking.implementationLab;

import java.util.ArrayList;

/**
 * Palindrome partitioning:
 * <p>
 * Given a string, find the partitions that are palindromes.
 * <p>
 * Approach:
 * - The approach is simple, iterate over the string from index till its length.
 * - Find the prefix string from index 0 to current index.
 * - Now store the remaining string from index 1.
 * - The check for palindrome should be done for prefix string.
 * - If prefix string is palindrome then add that in palindromes list and explore for remaining string.
 * - Then later remove last from palindromes list as a part of backtracking to explore more answers.
 * - Also, at last when string is empty we can say that we got all palindromes list.
 * - Time complexity: O(2^N) for loops for recursive call * O(N + N + N) for substring functions and palindrome check
 * = O(2^N) + O(3N) = O(2^N) * O(N) = O(N*2^N)
 * - Space complexity: O(N) for recursion stack.
 */
public class _1PalindromePartitioning {

    public static void main(String[] args) {
        printPalindromes("abaaba");
    }

    private static void printPalindromes(String str) {
        partitionedPalindromes(str, new ArrayList<>());
    }

    private static void partitionedPalindromes(String str, ArrayList<String> palindromes) {
        if (str.isEmpty()) {
            System.out.println(palindromes);
            return;
        }
        for (int i = 1; i <= str.length(); i++) {
            String prefix = str.substring(0, i);
            String remaining = str.substring(i);
            if (isPalindrome(prefix)) {
                palindromes.add(prefix);
                partitionedPalindromes(remaining, palindromes);
                palindromes.removeLast();
            }
        }
    }

    private static boolean isPalindrome(String str) {
        int l = 0, r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l++) != str.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

}
