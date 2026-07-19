package module.one.maths.two.notes;

/**
 * Prime Number:
 * For a given number N check if it is prime or not. A prime number is a number which is only divisible by 1 and
 * itself.
 *
 * Approaches:
 * 1. Bruteforce - there can be 2 implementations first where we can simply check if numbers from 2 till n-1 divides
 * given number, second is simply iterate till square root and add a count check that it should not be greater than 2.
 * Both have same time and space complexities.
 * 2. Optimal approach - here we can check if number is 1, 2, 3 or multiple of 2 or 3, and also we can iterate over
 * a loop from 5 till root N and increment counter by 6 and check if N is divisible by i or i+2. It has constant complexity.
 */
public class _3PrimeNumberCheck {

    public static void main(String[] args) {
        printIfPrimeNumber(10);
        printIfPrimeNumber(31);
        printIfPrimeNumber(101);
        printIfPrimeNumber(1051);
        printIfPrimeNumber(1053);
    }

    private static void printIfPrimeNumber(int n) {
        System.out.println("Approach 1: " + n + " is a prime number: " + approach1(n));
        System.out.println("Approach 2: " + n + " is a prime number: " + approach2(n));
        System.out.println("Approach 3: " + n + " is a prime number: " + approach3(n));
        System.out.println();
    }

    /**
     * Approach 1: Bruteforce approach
     * - A naive solution is to iterate through all numbers from 2 to sqrt(n) and for every number check if it
     * divides n. If we find any number that divides, we return false.
     * - Here, we can start from 2 till root of N.
     * - If N is divisible by any number then is not a prime number.
     * - Time complexity: O(sqrt(N)), Space complexity: O(1)
     * */
    private static boolean approach1(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Approach 2: Bruteforce approach
     * - Similar approach like above, here we just added a counter to not check for more than 2 factors.
     * - Time complexity: O(sqrt(N)), even though counter is there but it can till very high root if N is greater
     * - Space complexity: O(1)
     * */
    private static boolean approach2(int n) {
        int count = 0;
        for (int i = 1; i * i <= n && count <= 2; i++) {
            if (n % i == 0) {
                count = (i != n / i) ? count + 2 : count + 1;
            }
        }
        return (count == 2);
    }

    /**
     * Approach 3: Optimal approach
     * - In the previous approach given if the size of the given number is too large then its square root will
     * be also very large, so to deal with large size input we will deal with a few numbers such as 1, 2, 3,
     * and the numbers which are divisible by 2 and 3 in separate cases and for remaining numbers, we will
     * iterate our loop from 5 to sqrt(n) and check for each iteration whether that  (iteration) or
     * (that iteration + 2) divides n or not.
     * - If we find any number that divides, we return false.
     * - Time complexity: O(sqrt(N)), but it skips lots of numbers in between i.e. useful for very high numbers
     * - Space complexity: O(1), no extra space taken.
     * */
    private static boolean approach3(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || (n % (i + 2) == 0)) {
                return false;
            }
        }
        return true;
    }

}