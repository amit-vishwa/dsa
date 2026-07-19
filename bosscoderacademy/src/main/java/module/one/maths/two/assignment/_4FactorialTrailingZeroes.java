package module.one.maths.two.assignment;

/**
 * Factorial Trailing Zeroes:
 * <p>
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.
 * <p>
 * Input 1: n = 3
 * Output 1: 0
 * Explanation 1: 3! = 6, no trailing zero.
 * <p>
 * Input 2: n = 5
 * Output 2: 1
 * <p>
 * Constraints:
 * 0 <= n <= 104
 */
public class _4FactorialTrailingZeroes {

    public static void main(String[] args) {
        printZeroesCount(3);
        printZeroesCount(5);
        printZeroesCount(20);
        printZeroesCount(251);
    }

    private static void printZeroesCount(int n) {
        System.out.println("Approach 1 - Trailing zeroes count : " + approach1(n));
        System.out.println("Approach 2 - Trailing zeroes count : " + approach2(n));
        System.out.println("Approach 3 - Trailing zeroes count : " + approach3(n));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce approach
     * - Here, we are applying the bruteforce approach to solve the factorial of number first.
     * - Then, after getting the factorial we are counting the zeroes from units place.
     * - Will increment the counter after getting zero, else not getting zero then breaking and returning the result.
     * - Time complexity: O(N) to find the factorial + O(M) to count trailing zeroes = O(N + M) = O(N)
     * - Space complexity: O(1) as we are using iterative approach.
     */
    private static int approach1(int n) {
        int count = 0;
        long fact = getFactorial(n);
        while (fact > 0) {
            int rem = (int) (fact % 10);
            if (rem == 0) {
                count++;
            } else {
                break;
            }
            fact /= 10;
        }
        return count;
    }

    private static long getFactorial(int n) {
        long fact = 1;
        while (n > 0) {
            fact *= n;
            n--;
        }
        return fact;
    }

    /**
     * Approach 2 - Optimal approach
     * - Here, we are iterating from 5 till N and increasing the i by multiplying it to 5.
     * - As per number system theory, only multiples of 2 and 5 will have numbers with trailing zeroes.
     * - As 2's multiples are in large number, we can consider 5 only and continue dividing N by 5 exponentially.
     * - Time complexity: O(log(N)/log(5)) as base is 5, we are multiplying by 5 = O(log5(N)) = O(log(N))
     * - Space complexity: O(1)
     */
    private static int approach2(int n) {
        int count = 0;
        for (int i = 5; i <= n; i *= 5) {
            count += n / i;
        }
        return count;
    }

    /**
     * Approach 3 - Same as approach 2 but here we are dividing n by 5 and storing cumulative count until n becomes 0.
     */
    private static int approach3(int n) {
        int count = 0;
        while (n / 5 > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }

}