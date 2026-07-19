package module.one.exams.milestone;

import java.util.ArrayList;

/**
 * LeetCode 2787. Ways to Express an Integer as Sum of Powers
 * Refer: https://leetcode.com/problems/ways-to-express-an-integer-as-sum-of-powers/description/
 * <p>
 * Approach:
 * - Approach is similar to target sum problem with include exclude approach.
 * - We just have to create an array of powers and then start with 0 index and set target as given N.
 * - Whenever, target is 0 return 1, if target is less than 0 or index exhausted then return 0.
 * - When excluding, just increase the index, when including just check if target is in range then increase pos and reduce
 * the target and add the result in count.
 * - At last, just return the result i.e. different ways.
 * - Time complexity: O(N*logN) for creating powers list + O(2^T) for exploring 2 ways.
 * - Space complexity: O(N) for recursion stack + O(K) for powers list.
 */
public class _6SumOfPowers {

    public static void main(String[] args) {
        printWays(10, 2);
        printWays(4, 1);
    }

    private static void printWays(int n, int x) {
        ArrayList<Integer> powers = new ArrayList<>();
        for (int num = 1; num <= n; num++) {
            int power = binaryExponentiation(num, x);
            if (power > n) {
                break;
            }
            powers.add(power);
        }
        System.out.println(ways(powers, n, 0));
    }

    private static int ways(ArrayList<Integer> powers, int target, int pos) {
        if (target == 0) {
            return 1;
        }
        if (pos == powers.size() || target < 0) {
            return 0;
        }
        int ways = ways(powers, target, pos + 1);
        if (target >= powers.get(pos)) {
            ways += ways(powers, target - powers.get(pos), pos + 1);
        }
        return ways;
    }

    private static int binaryExponentiation(int num, int power) {
        if (power == 0) {
            return 1;
        }
        int res = binaryExponentiation(num, power / 2);
        return power % 2 == 0 ? res * res : res * res * num;
    }

}
