package module.one.maths.two.notes;

/**
 * Print All Prime Number from 1 to n:
 * Given a number N, the task is to print the prime numbers from 1 to N.
 * <p>
 * Approaches:
 * 1. Bruteforce - a simple bruteforce is to check prime number for all from 1 to N with optimal prime function.
 * 2. Optimal - use the Sieve of Eratosthenes algorithm.
 */
public class _4AllPrimeNumbers {

    public static void main(String[] args) {
        printAllPrimeNumbers(10);
        printAllPrimeNumbers(100);
        printAllPrimeNumbers(101);
        printAllPrimeNumbers(1051);
        printAllPrimeNumbers(1053);
    }

    private static void printAllPrimeNumbers(int n) {
        approach1(n);
        approach2(n);
        System.out.println();
    }

    /**
     * Approach 1: Bruteforce approach
     * - Here, we are iterating from 1 or 2 till N and checking if it is a prime number.
     * - We are printing the number if it is prime else skip.
     * - Time complexity: O(N) iterate from 1 till N * O(log(M)) prime function =  O(N*log(M))
     * - Space complexity: O(1)
     */
    private static void approach1(int n) {
        System.out.print("Approach 1: Prime numbers till " + n + ": ");
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    // Time complexity: O(log(M)), Space complexity: O(1)
    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        // log(M) complexity as we are reducing the space by 6 and checking with condition i*i
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || (n % (i + 2) == 0)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Approach 2: Optimal approach
     * - Here, we are using the algorithm of Sieve of Eratosthenes.
     * - It states that create an additional array that marks the visited numbers.
     * - Visit a number from 2 to N, mark its multiples as visited in additional visited array.
     * - Repeat the process till square root of N, to mark all the numbers in visited array.
     * - Now, at last iterate over the visited array from 1 till N, and print all indices that are not visited.
     * - Time complexity:
     * O(N) to iterate from 2 to N * O(log(log(N))) to create visited array = O(N * log(log(N)))
     * - Space complexity: O(N + 1) = O(N), space occupied by visited array
     */
    private static void approach2(int n) {
        boolean[] visited = new boolean[n + 1];
        for (int i = 2; i * i <= n; i++) { // O(N)
            if (!visited[i]) {
                for (int j = i * i; j <= n; j += i) { // O(log(log(N)))
                    visited[j] = true;
                }
            }
        }
        System.out.print("Approach 2: Prime numbers till " + n + ": ");
        for (int i = 2; i <= n; i++) { // O(N)
            if (!visited[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

}