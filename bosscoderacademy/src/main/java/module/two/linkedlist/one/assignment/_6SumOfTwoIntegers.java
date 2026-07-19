package module.two.linkedlist.one.assignment;

/**
 * Sum Of Two Integers:
 * <p>
 * Given two integers a and b, return the sum of the two integers without using the operators + and -.
 * <p>
 * Input: a = 1, b = 2
 * Output: 3
 * <p>
 * Input: a = 2, b = 3
 * Output: 5
 * <p>
 * Constraints:
 * -1000 <= a, b <= 1000
 */
public class _6SumOfTwoIntegers {

    public static void main(String[] args) {
        System.out.println("Sum: " + sumOfIntegers(1, 2));
        System.out.println("Sum: " + sumOfIntegers(2, 3));
        System.out.println("Sum: " + sumOfIntegers(100, 234));
    }

    /**
     * Approach:
     * - The approach is simple, here we are storing the result of AND of 2 numbers in c.
     * - Then in 'a', we are storing the XOR both number a and b.
     * - Then updating b by storing the left shift by 1 value of c.
     * - We are repeating this until b becomes 0.
     * - After that, we will have our answer stored in 'a', just return it.
     * - Time complexity: O(log(N)) as we are left shift c by 1.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int sumOfIntegers(int a, int b) {
        int c = 0;
        while (b != 0) {
            c = a & b;
            a = a ^ b;
            b = c << 1;
        }
        return a;
    }

}