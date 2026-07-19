package module.one.maths.two.lecture;

/**
 * Find the factors of given number N.
 * Approaches:
 * 1. Bruteforce - Iterate from 1 till N or N/2 and check if number divides N, complexity is O(N).
 * 2. Optimal - Iterate from 1 till sqrt(N), complexity is O(sqrt(N))
 */
public class Factors {

    public static void main(String[] args) {
        printFactors(36);
    }

    private static void printFactors(int n) {
        approach1(n);
        approach2(n);
        System.out.println();
    }

    // Time complexity: O(N), Space complexity: O(1)
    private static void approach1(int n) {
        System.out.print("Factors of " + n + " by approach 1: ");
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println(n);
    }

    // Time complexity: O(sqrt(N)), Space complexity: O(1)
    private static void approach2(int n) {
        System.out.print("Factors of " + n + " by approach 2: ");
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
                if (i != n / i) { // to skip 6x6 count twice
                    System.out.print((n / i) + " ");
                }
            }
        }
        System.out.println();
    }

}
