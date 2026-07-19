package module.one.searching.two.assignment;

/**
 * Nth Digit:
 * <p>
 * Given an integer n, return the nth digit of the infinite integer sequence [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...].
 * <p>
 * Input: n = 3
 * Output: 3
 * <p>
 * Input: n = 11
 * Output: 0
 * Explanation: The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 * <p>
 * Constraints:
 * 0 <= num <= 231 - 1
 */
public class _5NthDigit {

    public static void main(String[] args) {
        printNthDigit(3);
        printNthDigit(11);
        printNthDigit(1101);
    }

    private static void printNthDigit(int n) {
        System.out.println(n + "th digit by approach 1: " + approach1(n));
        System.out.println(n + "th digit by approach 2: " + approach2(n));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce approach
     * - This is a simple bruteforce approach.
     * - Here we are adding numbers from 1 till N in a string.
     * - Then at last we are just returning the int value of char at given N - 1 for 0-based indexing.
     * - Time complexity: O(N) iteration from 1 till N.
     * - Space complexity: O(1) as no extra space is used.
     */
    private static int approach1(int n) {
        String numStr = "";
        int num = 1;
        while (num <= n) {
            numStr += num++;
        }
        int digit = Character.getNumericValue(numStr.charAt(n - 1));
        return digit;
    }

    /**
     * Approach 2 - Optimal approach
     * - Here we are checking in which block the Nth digit falls.
     * - The first block consist of numbers from 1 to 9 with digit count as 1 and first number as 1.
     * - When given Nth digit is greater than numbers * digits as we have to check digits then Nth digit not falls in block.
     * - So, reduce numbers * digits from N, update numbers, first and digits values.
     * - Repeat this until N falls under the block.
     * - Once we got the block, we have to check the exact number on which the Nth digit will fall.
     * - For that we can update first number by adding (N-1) / digits to get exact number.
     * - Now, after getting the number we can get the exact character or digit by performing modulo on 0-based indexing.
     * - At last, we can return the digit that we got.
     * - Time complexity: O(logN) as we are reducing the number and searching bigger space.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int approach2(int n) {
        int digits = 1;
        long first = 1, numbers = 9;
        while (n > numbers * digits) {
            n -= (int) (numbers * digits);
            numbers *= 10;
            first *= 10;
            digits++;
        }
        // Find the actual number containing the digit
        long num = first + (n - 1) / digits;
        // Find the digit within that number
        int index = (n - 1) % digits;
        return String.valueOf(num).charAt(index) - '0';
    }

}