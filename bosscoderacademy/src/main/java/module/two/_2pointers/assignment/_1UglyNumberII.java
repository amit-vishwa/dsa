package module.two._2pointers.assignment;

import java.util.ArrayList;

/**
 * Ugly Number II:
 * <p>
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 * Given an integer n, return the nth ugly number.
 * <p>
 * Input: n = 10
 * Output: 12
 * Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
 * <p>
 * Input: n = 1
 * Output: 1
 * Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
 * <p>
 * Constraints:
 * 1 <= n <= 1690
 */
public class _1UglyNumberII {

    public static void main(String[] args) {
        System.out.println(10 + "th ugly number is " + uglyNumber(10));
        System.out.println(1 + "st ugly number is " + uglyNumber(1));
    }

    /**
     * Approach:
     * - The approach is quite different than a normal 3 pointer problem.
     * - Here, we have initialized i,j,k pointers and added 1 in ugly number list.
     * - First, consider the current number and multiply if by 2,3,5 and get the min of them.
     * - Now add this number, and which number it is just increase its pointer.
     * - Repeat the process until the list size becomes given number.
     * - At last, just return the last element from the list.
     * - Time complexity: O(N) as we are iterating from 1 to N.
     * - Space complexity: O(N) as we are adding the ugly numbers in the list.
     */
    private static int uglyNumber(int num) {
        int i = 0, j = 0, k = 0;
        ArrayList<Integer> uglyNumberList = new ArrayList<>();
        uglyNumberList.add(1);
        while (uglyNumberList.size() < num) {
            int uglyNumber = Math.min(uglyNumberList.get(i) * 2, Math.min(uglyNumberList.get(j) * 3, uglyNumberList.get(k) * 5));
            uglyNumberList.add(uglyNumber);
            if (uglyNumberList.get(i) * 2 == uglyNumber) {
                i++;
            }
            if (uglyNumberList.get(j) * 3 == uglyNumber) {
                j++;
            }
            if (uglyNumberList.get(k) * 5 == uglyNumber) {
                k++;
            }
        }
        return uglyNumberList.getLast();
    }

}