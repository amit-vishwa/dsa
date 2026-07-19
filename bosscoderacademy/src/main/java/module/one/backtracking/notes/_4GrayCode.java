package module.one.backtracking.notes;

import java.util.ArrayList;
import java.util.List;

/**
 * Gray Code:
 * <p>
 * A Gray code is a list of all 2^n bit strings of length n, where any two successive strings differ in exactly one bit
 * (i.e., their Hamming distance is one).
 * Your task is to create a Gray code for a given length n.
 * <p>
 * Example
 * Input: 2
 * Output: 00 01 11 10
 */
public class _4GrayCode {

    public static void main(String[] args) {
        printGrayCodes(2);
        printGrayCodes(3);
    }

    private static void printGrayCodes(int n) {
        System.out.println("Gray codes by approach 1: " + approach1(n));
        System.out.println("Gray codes by approach 2: " + approach2(n));
        System.out.println();
    }

    /**
     * Approach 1 - Bit masking:
     * - The approach is simple using bit masking.
     * - We have to iterate from 0 to 1<<n i.e. 2^n and for each number calculate gray code.
     * - We can get gray code by XORing number and number/2 i.e. number>>1.
     * - We will be getting result in integer format, we can convert that to binary string.
     * - Time complexity: O(2^N) calculating till the power of N * O(N) for binary string method call which is optional.
     * - Space complexity: O(2^N) for storing in list however this cannot be called as axillary space here.
     */
    private static List<String> approach1(int n) {
        List<String> grayCodes = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            grayCodes.add(Integer.toBinaryString(i ^ (i >> 1))); // O(N) for method call
        }
        return grayCodes;
    }

    /**
     * Approach 2 - Backtracking:
     * - The approach is simple, we will reduce the number till it becomes 1.
     * - When we get 1, we are returning 0 and 1 as gray code in the list.
     * - Then we are iterating over the list in increasing order and placing 0 at the front of each element and storing in result list.
     * - After that we are reverse iterating and adding 1 at front of each element and storing in the result list.
     * - At last, we are just returning the gray code list having the final result.
     * - Time complexity: O(2^N) for calculating gray codes * O(N) for string concatenation.
     * - Space complexity: O(N) for recursion stack, with output list of O(N*2^N).
     */
    private static List<String> approach2(int n) {
        if (n == 1) {
            return new ArrayList<>(List.of("0", "1"));
        }
        List<String> res = approach2(n - 1);
        List<String> grayCodes = new ArrayList<>();
        for (String val : res) {
            grayCodes.add("0" + val);
        }
        for (int i = res.size() - 1; i >= 0; i--) {
            grayCodes.add("1" + res.get(i));
        }
        return grayCodes;
    }

}
