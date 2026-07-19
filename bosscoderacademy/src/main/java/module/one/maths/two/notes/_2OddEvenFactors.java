package module.one.maths.two.notes;

/**
 * The number of factors of a number is odd or even:
 * Given a number find if the number of factors is odd or even.
 * <p>
 * Example:
 * Input: N=100
 * Output: Odd
 */
public class _2OddEvenFactors {

    public static void main(String[] args) {
        printOddEvenFactors(10);
        printOddEvenFactors(25);
        printOddEvenFactors(50);
        printOddEvenFactors(100);
        printOddEvenFactors(101);
    }

    private static void printOddEvenFactors(int n) {
        approach1(n);
        approach2(n);
        System.out.println();
    }

    /**
     * Approach 1: Bruteforce approach
     * - Count the number of divisors if it is odd then return odd else return even.
     * - Here, we are simply iterating from 1 till square root of number N.
     * - Counting the divisors, if i*i != N, then increment by 2 else increment by 1 only.
     * - Time complexity: O(sqrt(N)), as we are iterating till square root of N only.
     * - Space complexity: O(1), as no extra space is used.
     */
    private static void approach1(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count = (i != n / i) ? count + 2 : count + 1;
            }
        }
        boolean isOdd = (count & 1) == 1;
        System.out.println("Approach 1: Factors of " + n + " are " + (isOdd ? "ODD" : "EVEN"));
    }

    /**
     * Approach 2: Optimal approach
     * - If we observe carefully all the factors of any number are always in pairs except when the number is a
     * perfect square then the count of divisors will be odd.
     * - Here, we are simply calling Math.sqrt() to get square root.
     * - Then we are multiplying the result by itself to check whether it is equal to given number.
     * - If yes, then it is a perfect square, and thus it's factors count will always be odd.
     * - So, simply add the check to print odd and even based on it.
     * - Time complexity: O(log(N)), as built-in takes this time complexity as internally is used binary search.
     * - Space complexity: O(1), as we are not taking extra space.
     */
    private static void approach2(int n) {
        int root = (int) Math.sqrt(n);
        boolean isOdd = (root * root == n);
        System.out.println("Approach 2: Factors of " + n + " are " + (isOdd ? "ODD" : "EVEN"));
    }

}