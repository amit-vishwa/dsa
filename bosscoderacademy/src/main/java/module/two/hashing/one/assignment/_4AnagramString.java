package module.two.hashing.one.assignment;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Anagram String:
 * <p>
 * Check whether two Strings are anagram of each other.
 * Note : An anagram of a string is another string that contains the same characters, only the order of characters can be
 * different.
 * <p>
 * Input 1: str1 = “listen” str2 = “silent”
 * Output 1: true
 * Explanation 1: All characters of “listen” and “silent” are the same.
 * <p>
 * Input 2: str1 = “gram” str2 = “arm”
 * Output 2: false
 * <p>
 * Constraints:
 * 1 <= str1.length, str2.length <= 105
 */
public class _4AnagramString {

    public static void main(String[] args) {
        printResult("listen", "silent");
        printResult("gram", "arm");
        printResult("gram", "arms");
    }

    private static void printResult(String str1, String str2) {
        System.out.println("Are given strings anagram by approach 1: " + approach1(str1, str2));
        System.out.println("Are given strings anagram by approach 2: " + approach2(str1, str2));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce
     * - This is a simple bruteforce approach.
     * - We are first checking the length, then creating the sorted character arrays.
     * - Then iterating over the arrays and checking characters in both array, if they are not same then return false.
     * - Else just return true at the end.
     * - Time complexity: O(N*logN) for sorting arrays + O(N) for iterating array = O(N*logN)
     * - Space complexity: O(N) as we are converting the string to arrays.
     */
    private static boolean approach1(String str1, String str2) {
        int n1 = str1.length(), n2 = str2.length();
        if (n1 != n2) {
            return false;
        }
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        for (int i = 0; i < n1; i++) {
            if (charArray1[i] != charArray2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Approach 2 - Optimal
     * - This is the optimal approach.
     * - After checking the string length, we are adding all the characters of one string along with its counts.
     * - Now, we are iterating over the next string and checking if characters with same count are present or not in the map.
     * - If it is not present then return false, else return true.
     * - Time complexity: O(N) as we are iterating over the string and storing characters in the map.
     * - Space complexity: O(N) due to map data structure.
     */
    private static boolean approach2(String str1, String str2) {
        int n1 = str1.length(), n2 = str2.length();
        if (n1 != n2) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : str1.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : str2.toCharArray()) {
            if (!map.containsKey(ch) || map.get(ch) == 0) {
                return false;
            }
            map.put(ch, map.get(ch) - 1);
        }
        return true;
    }

}