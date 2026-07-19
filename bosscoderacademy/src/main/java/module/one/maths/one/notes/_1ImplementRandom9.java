package module.one.maths.one.notes;

import java.util.Random;

/**
 * Given rand6() implement rand9():
 * Given a function, rand6() that returns random numbers from 1 to 6 with equal probability, implement the
 * one-liner function rand9() using rand6() which returns random numbers from 1 to 9 with equal probability.
 * <p>
 * Approach:
 * - A simple approach here is to call random6 twice so that input set can be increased as output is greater.
 * - So after calling twice we have 36 combinations if considered 6x6 matrix.
 * - Now, consider the first result as row and second as col.
 * - So index for current cell can be found as (row - 1) * totalCol + col.
 * - Now here getting random number from 1 to 9, we can use modulo of 9 plus 1, as modulo will give 0 to 8.
 * - And we want 1 to 9, so adding 1 to the result.
 */
public class _1ImplementRandom9 {

    private static final Random RAND = new Random();

    public static void main(String[] args) {
        System.out.println(random9());
        System.out.println(random9());
        System.out.println(random9());
        System.out.println(random9());
        System.out.println(random9());
        System.out.println(random9());
        System.out.println(random9());
        System.out.println(random9());
        System.out.println(random9());
        System.out.println(random9());
        System.out.println(random9());
    }

    // Time and space complexity: O(1)
    private static int random9() {
        int num1 = random6();
        int num2 = random6();
        int num = (num1 - 1) * 6 + (num2 - 1);
        return num % 9 + 1;
    }

    // Time complexity: O(1) in Java, Space complexity: O(1)
    private static int random6() {
        return RAND.nextInt(1, 7);
    }

}