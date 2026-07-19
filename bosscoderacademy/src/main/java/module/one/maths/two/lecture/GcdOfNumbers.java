package module.one.maths.two.lecture;

/**
 * GCD of two numbers:
 */
public class GcdOfNumbers {

    public static void main(String[] args) {
        printGcd(25, 10);
        printGcd(27, 20);
        printGcd(20, 40);
    }

    private static void printGcd(int n1, int n2) {
        System.out.println("Gcd of " + n1 + " and " + n2 + " by approach1: " + approach1(n1, n2));
        System.out.println("Gcd of " + n1 + " and " + n2 + " by approach2: " + approach2(n1, n2));
        System.out.println("Gcd of " + n1 + " and " + n2 + " by recursion: " + recursiveApproach(n1, n2));
        System.out.println();
    }

    /**
     * 1. Bruteforce:
     * - Simply iterate from min(a,b) to 1 and find GCD.
     * - Time complexity: O(min(a,b)), Space complexity: O(1)
     */
    private static int approach1(int n1, int n2) {
        for (int n = Math.min(n1, n2); n > 1; n--) {
            if (n1 % n == 0 && n2 % n == 0) {
                return n;
            }
        }
        return 1;
    }

    /**
     * 2.1. Optimal:
     * - Find the GCD using Euclid's algorithm.
     * - Time complexity: O(log(min(a,b))), Space complexity: O(1)
     */
    private static int approach2(int n1, int n2) {
        while (n1 != 0) {
            int temp = n1;
            n1 = n2 % n1;
            n2 = temp;
        }
        return n2;
    }

    /**
     * 2.2. Optimal:
     * - Find the GCD using Euclid's algorithm using recursion.
     * - Time complexity: O(log(min(a,b))), Space complexity: O(log(min(a,b)))
     */
    private static int recursiveApproach(int n1, int n2) {
        return n1 == 0 ? n2 : recursiveApproach(n2 % n1, n1);
    }

}
