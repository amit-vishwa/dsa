package module.one.maths.one.lecture;

import java.util.Random;

/**
 * Generate random 7 from random 5:
 * Given a function that generates a number between 1 and 5 with equal probability.
 * Create a function that generates a random number between 1 and 7 with equal probability using given function.
 */
public class Random7 {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.print(random7() + " ");
        }
    }

    // Time complexity: O(log(N)) for loop, Space complexity: O(1)
    private static int random7() {
        int num, num1, num2;
        do { // can be infinite with the least probability
            num1 = random5();
            num2 = random5();
            // num1 is row, num2 is col, so already visited cells is num1 - 1 * cols, current cell is plus num2
            num = (num1 - 1) * 5 + num2;
        } while (num > 21);
        return num % 7 + 1; // we got result from 0-6, so add 1 to get from 1-7
    }

    // Time and space complexity: O(1)
    private static int random5() {
        return new Random().nextInt(1, 6);
    }

}
