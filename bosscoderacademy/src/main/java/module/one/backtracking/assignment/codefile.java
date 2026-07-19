package module.one.backtracking.assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class codefile {

    public static void main(String[] args) {
        System.out.println(new codefile().letterCombinations("23"));
        printCombinations("23");
    }

    private static void printCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        System.out.println(backtrack(digits, map, new StringBuilder(digits.length())));
    }

    private static List<String> backtrack(String digits, HashMap<Character, String> map, StringBuilder combination) {
        if (combination.length() == digits.length()) {
            return new ArrayList<>(List.of(combination.toString()));
        }
        List<String> letterCombinations = new ArrayList<>();
        String letters = map.get(digits.charAt(combination.length()));
        for (char letter : letters.toCharArray()) {
            combination.append(letter);
            letterCombinations.addAll(backtrack(digits, map, combination));
            combination.setLength(combination.length() - 1);
        }
        return letterCombinations;
    }

    public List<String> letterCombinations(String digits) {
        return helper("", digits);
    }

    private List<String> helper(String processed, String unProcessed) {
        if (unProcessed.isEmpty()) {
            return new ArrayList<>(List.of(processed));
        }
        List<String> ans = new ArrayList<>();
        int digit = unProcessed.charAt(0) - '0';
        int start = (digit == 8 || digit == 9) ? (digit - 2) * 3 + 1 : (digit - 2) * 3;
        int end = (digit == 9) ? (digit - 1) * 3 + 2 : (digit == 7 || digit == 8) ? (digit - 1) * 3 + 1 : (digit - 1) * 3;
        for (int i = start; i < end; i++) {
            ans.addAll(helper(processed + (char) ('a' + i), unProcessed.substring(1)));
        }
        return ans;
    }

}
