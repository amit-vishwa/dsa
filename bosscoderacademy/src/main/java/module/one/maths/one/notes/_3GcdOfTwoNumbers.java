package module.one.maths.one.notes;

/**
 * GCD of two numbers:
 * GCD (Greatest Common Divisor) or HCF (Highest Common Factor) of two numbers is the largest number that divides
 * both of them.
 * For example, GCD of 20 and 28 is 4, and GCD of 98 and 56 is 14.
 * */
public class _3GcdOfTwoNumbers {

    public static void main(String[] args) {
        printGcd(20, 28);
        printGcd(98, 56);
    }

    private static void printGcd(int num1, int num2) {
        System.out.println("Gcd of numbers by approach1: " + approach1(num1, num2));
        System.out.println("Gcd of numbers by approach2: " + approach2(num1, num2));
    }

    /**
     * Approach 1: Bruteforce approach
     * - Here, we are iterating over the loop from min(a,b) to 1.
     * - Then, we are simply checking if number i.e. i divides both number a and b.
     * - If yes, then returning that i else at end after loop we are returning 1.
     * - Time complexity: O(min(a,b)) as we will iterate till min number only.
     * - Space complexity: O(1), as we are not utilizing any extra space here.
     * */
    private static int approach1(int num1, int num2) {
        for (int i = Math.min(num1, num2); i > 1; i--) {
            if (num1 % i == 0 && num2 % i == 0) {
                return i;
            }
        }
        return 1;
    }

    /**
     * Approach 2: Optimal approach
     * - Here, we are using Euclid's theorem or Euclidean algorithm.
     * - As per algorithm, we have to take modulo of 2 numbers then store in first number.
     * - And before that, the first number value should be transferred to second number.
     * - We have to repeat this process until number one becomes zero.
     * - And then our answer will be the number two.
     * - Time complexity: it lies between constant and logarithmic, but we take logarithmic i.e. O(log(min(a,b)))
     * as N here is min(a,b)
     * - Space complexity: O(1)
     * */
    private static int approach2(int num1, int num2) {
        while (num1 > 0) {
            int temp = num1;
            num1 = num2 % num1;
            num2 = temp;
        }
        return num2;
    }

}