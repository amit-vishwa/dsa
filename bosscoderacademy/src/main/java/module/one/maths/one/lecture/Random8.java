package module.one.maths.one.lecture;

import java.util.Random;

/**
 * Generate random 8 from random 10:
 * Given a function that generates a number between 1 and 10 with equal probability.
 * Create a function that generates a random number between 1 and 8 with equal probability using given function.
 */
public class Random8 {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.print(random8() + " ");
        }
    }

    // Time complexity: O(log(N)) for loop, Space complexity: O(1)
    private static int random8() {
        int num = random10();
        while (num > 8) { // can be infinite with the least probability
            num = random10();
        }
        return num;
    }

    // Time and space complexity: O(1)
    private static int random10() {
        return new Random().nextInt(1, 11);
    }

}
