package module.one.backtracking.assignment;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * LeetCode 17. Letter Combinations of a Phone Number
 * Refer: https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */
public class _2LetterCombinations {

    public static void main(String[] args) {
//        printLetterCombinations("2345");
//        printLetterCombinations("234");
        printLetterCombinations("23");
        printLetterCombinations("2");
    }

    private static void printLetterCombinations(String digits) {
        System.out.println("Letter combinations by approach 1: " + approach1(digits));
        System.out.println("Letter combinations by approach 2: " + approach2(digits));
        System.out.println();
    }

    /**
     * Approach 1 - Recursion
     * - The approach involves recursively calling the function and using pick unpick or processed unprocessed logic,
     * solve the problem.
     * - We are first taking the first character and converting that to number.
     * - Then we are calculating the start index, it is digit - 2 as we are starting from 2 i.e. 2 - 9 numbers are there,
     * and multiplying the result by 3 as all numbers have 3 letters for numbers 8 and 9 consider adding 1 more.
     * - Now, calculate end index by reducing 1 to digit and multiplying by 3, for number 9 add 2 to it, for 7 and 8 add 1,
     * no changes for rest of the numbers.
     * - Then create a loop and iterate from start index to end index and reduce un processed string by 1 and update the
     * processed string by adding a character with digit + 'a'.
     * - When un processed is empty, we got our answer, just return it in a list.
     * - Time complexity: O(4^N) for 7 and 9, rest O(3^N).
     * - Space complexity: O(N) for recursion stack.
     */
    private static List<String> approach1(String digits) {
        return recursion(digits, "");
    }

    private static List<String> recursion(String unProcessed, String processed) {
        if (unProcessed.isEmpty()) {
            return new ArrayList<>(List.of(processed));
        }
        List<String> letterCombinations = new ArrayList<>();
        int digit = unProcessed.charAt(0) - '0';
        // formula: digit - (startingNumber) * 3, end index will be starting number - 1
        int start = (digit > 7) ? (digit - 2) * 3 + 1 : (digit - 2) * 3;
        int end = (digit == 9) ? (digit - 1) * 3 + 2 : digit > 6 ? (digit - 1) * 3 + 1 : (digit - 1) * 3;
        for (int i = start; i < end; i++) {
            letterCombinations.addAll(recursion(unProcessed.substring(1), processed + (char) ('a' + i)));
        }
        return letterCombinations;
    }

    /**
     * Approach 2 - Backtracking
     * - The approach is little different from the above approach.
     * - Here, we are using map and string builder of adding the result.
     * - First we are creating a map of fixed size with letter 2 to 9 as key and relevant string as value.
     * - Now, we have to fetch the letters on a number which is nothing by char at length of result string.
     * - After this, we are iterating over the letters and adding each character in result string then exploring.
     * - Then we are removing that letter from the result as a part of backtracking.
     * - When result length is equal to given string length then we have one combination, just return it inside a list.
     * - Time and space complexity is similar to approach 1.
     */
    private static List<String> approach2(String digits) {
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        return backtrack(digits, map, new StringBuilder(digits.length()));
    }

    private static List<String> backtrack(String digits, HashMap<Character, String> map, StringBuilder combination) {
        if (combination.length() == digits.length()) {
            return new ArrayList<>(List.of(combination.toString()));
        }
        List<String> combinationList = new ArrayList<>();
        String letters = map.get(digits.charAt(combination.length()));
        for (char letter : letters.toCharArray()) {
            combination.append(letter);
            combinationList.addAll(backtrack(digits, map, combination));
            combination.setLength(combination.length() - 1);
        }
        return combinationList;
    }

}