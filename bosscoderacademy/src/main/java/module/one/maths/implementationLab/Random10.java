package module.one.maths.implementationLab;

import java.util.Random;

/**
 * Generate random 10 using random 7 function.
 * Refer other similar problems related to this from module.one.maths.one.lecture package.
 */
public class Random10 {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.print(random10() + " ");
        }
    }

    // Time complexity: O(log(N)) for loop which can be infinite in rare case, Space complexity: O(1)
    private static int random10() {
        int num1, num2, num;
        do {
            num1 = random7();
            num2 = random7();
            num = (num1 - 1) * 7 + num2;
        } while (num > 40);
        return num % 10 + 1; // num is in between 0 and 9 so added 1 to get numbers between 1 and 10
    }

    // Time and space complexity: O(1) in Java
    private static int random7() {
        return new Random().nextInt(1, 8);
    }

}
