package module.one.maths.one.notes;

import java.util.Random;

/**
 * Implement rand7() using rand 5():
 * Given a function, rand5() that returns random numbers from 1 to 5 with equal probability, implement the
 * one-liner function rand7() using rand5() which returns random numbers from 1 to 5 with equal probability.
 * <p>
 * Approach:
 * - Here, since input set 5 is lower than output set 7, we have to call rand5 twice to increase input set.
 * - After doing this we are getting 25 combinations which is not a multiple of 7, so after calculating final
 * answer check if it is greater than or equal to 21.
 * - Repeat the process, if yes else return the answer.
 * - However, getting number more than 21 can occur multiple times even infinite in very rarely possibilities.
 */
public class _2ImplementRandom7 {

    private static final Random RAND = new Random();

    public static void main(String[] args) {
        System.out.println(random7());
        System.out.println(random7());
        System.out.println(random7());
        System.out.println(random7());
        System.out.println(random7());
        System.out.println(random7());
        System.out.println(random7());
        System.out.println(random7());
        System.out.println(random7());
        System.out.println(random7());
    }

    // Time complexity: O(probability of num > 21) due to loop else O(1), Space complexity: O(1)
    private static int random7() {
        int num;
        do { // loop can be infinite
            int num1 = random5();
            int num2 = random5();
            num = (num1 - 1) * 5 + (num2 - 1); // 0...24
        } while (num > 20);
        return num % 7 + 1;
    }

    // Time and space complexity: O(1)
    private static int random5() {
        return RAND.nextInt(1, 6);
    }

}