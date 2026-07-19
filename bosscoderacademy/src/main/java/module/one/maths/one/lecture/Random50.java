package module.one.maths.one.lecture;

import java.util.Random;

/**
 * Generate random 50 from random 5:
 * Given a function that generates a number between 1 and 5 with equal probability.
 * Create a function that generates a random number between 1 and 50 with equal probability using given function.
 */
public class Random50 {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.print(random50() + " ");
        }
    }

    // Time complexity: O(log(N)) for loop, Space complexity: O(1)
    private static int random50() {
        int num1, num2, num3, num;
        do {
            num1 = random5();
            num2 = random5();
            num3 = random5();
            /**
             * num1 is page, num2 is row and num3 is col
             * num1 - 1, it is done to calculate already visited cells from previous pages,
             * 5 * 5 is cells in a page i.e. matrix,
             * num2, it is row of matrix hence multiplied by column of 5 and minus 1 for already visited cells,
             * num3, it is col which is added at last to reach current cell.
             * */
            num = (num1 - 1) * 5 * 5 + (num2 - 1) * 5 + num3;
        } while (num > 150);
        return num % 50 + 1; // we got result from 0-49, so add 1 to get from 1-50
    }

    // Time and space complexity: O(1)
    private static int random5() {
        return new Random().nextInt(1, 6);
    }

}
