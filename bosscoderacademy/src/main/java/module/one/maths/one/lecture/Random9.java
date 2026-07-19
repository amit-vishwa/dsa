package module.one.maths.one.lecture;

import java.util.Random;

/**
 * Generate random 9 from random 6:
 * Given a function that generates a number between 1 and 6 with equal probability.
 * Create a function that generates a random number between 1 and 9 with equal probability using given function.
 */
public class Random9 {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.print(random9() + " ");
        }
    }

    // Time and space complexity: O(1)
    private static int random9() {
        int num1 = random6();
        int num2 = random6();
        // num1 is row, num2 is col, so already visited cells is num1 - 1 * cols, current cell is plus num2
        int num = (num1 - 1) * 6 + num2;
        return num % 9 + 1; // we got result from 0-8, so add 1 to get from 1-9
    }

    private static int random6() {
        return new Random().nextInt(1, 7);
    }

}
