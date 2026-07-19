package module.one.maths.two.lecture;

/**
 * Count unique factors of given number N that divides it.
 * Approach: Everything similar for previous factors problem, only here we have to count.
 */
public class UniqueFactorsCount {

    public static void main(String[] args) {
        countFactors(36);
    }

    private static void countFactors(int n) {
        approach1(n);
        approach2(n);
        System.out.println();
    }

    // Time complexity: O(N), Space complexity: O(1)
    private static void approach1(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        System.out.println("Factors count of " + n + " by approach 1: " + count);
    }

    // Time complexity: O(sqrt(N)), Space complexity: O(1)
    private static void approach2(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count = (i != n / i) ? count + 2 : count + 1;
            }
        }
        System.out.println("Factors count of " + n + " by approach 2: " + count);
    }

}
