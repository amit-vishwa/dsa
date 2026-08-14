package module.one.backtracking.assignment;

import java.util.ArrayList;

/**
 * 24 Game: [Leetcode 679. 24 Game]
 *
 * You are given an integer array cards of length 4. You have four cards, each containing a number in the range [1, 9]. You
 * should arrange the numbers on these cards in a mathematical expression using the operators ['+', '-', '*', '/'] and the
 * parentheses '(' and ')' to get the value 24.
 *
 * You are restricted with the following rules:
 * The division operator '/' represents real division, not integer division. For example, 4 / (1 - 2 / 3) = 4 / (1 / 3) = 12.
 * Every operation done is between two numbers. In particular, we cannot use '-' as a unary operator. For example,
 * if cards = [1, 1, 1, 1], the expression "-1 - 1 - 1 - 1" is not allowed.
 * You cannot concatenate numbers together For example, if cards = [1, 2, 1, 2], the expression "12 + 12" is not valid.
 *
 * Return true if you can get such expression that evaluates to 24, and false otherwise.
 *
 * Example 1:
 * Input: cards = [4,1,8,7]
 * Output: true
 * Explanation: (8-4) * (7-1) = 24
 *
 * Example 2:
 * Input: cards = [1,2,1,2]
 * Output: false
 *
 * Constraints:
 * cards.length == 4
 * 1 <= cards[i] <= 9
 */
public class _1The24Game {

    private static final Double EPSILON = 0.000001;

    public static void main(String[] args) {
        System.out.println(solve(new int[]{4, 1, 8, 7}));
        System.out.println(solve(new int[]{1, 2, 1, 2}));
    }

    private static boolean solve(int[] cards) {
        ArrayList<Double> cardList = new ArrayList<>();
        for (int card : cards) {
            cardList.add((double) card);
        }
        return evaluate(cardList);
    }

    /**
     * Approach:
     * - The approach involves converting of integer cards array to list of double.
     * - Then we are checking each number with other different combinations or pairs.
     * - We are skipping first two numbers and adding rest in a new cards list.
     * - Then for the first 2 numbers, we are getting the candidate list which is nothing but all specified operations.
     * - After that we are adding each candidate in new cards list and exploring the answer.
     * - If we are left with a single element in the list and subtracting that with 24 is less than or equal to epsilon,
     * then return true else false.
     * - Epsilon is mathematical term which means nearest to 0, usually 10^(-6) is considered but other can also be taken.
     * - Time complexity: O(N^3) for 3 loops, but in the problem card size is 4 i.e. fixed hence constant.
     * - Space complexity: O(N) for recursion stack, since size is fixed so it will be constant i.e. O(4).
     */
    private static boolean evaluate(ArrayList<Double> cards) {
        int n = cards.size();
        if (n == 1) {
            return Math.abs(cards.get(0) - 24) <= EPSILON;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                ArrayList<Double> newCards = new ArrayList<>();
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    newCards.add(cards.get(k));
                }
                Double num1 = cards.get(i);
                Double num2 = cards.get(j);
                for (Double candidate : candidates(num1, num2)) {
                    newCards.add(candidate);
                    if (evaluate(newCards)) {
                        return true;
                    }
                    newCards.removeLast();
                }
            }
        }
        return false;
    }

    private static ArrayList<Double> candidates(Double num1, Double num2) {
        ArrayList<Double> candidates = new ArrayList<>();
        candidates.add(num1 + num2);
        candidates.add(num1 * num2);
        candidates.add(num1 - num2);
        candidates.add(num2 - num1);
        if (num2 > EPSILON) {
            candidates.add(num1 / num2);
        }
        if (num1 > EPSILON) {
            candidates.add(num2 / num1);
        }
        return candidates;
    }

}