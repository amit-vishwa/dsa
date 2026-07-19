package module.one.maths.implementationLab;

/**
 * Given number a and b, find the highest factor of a that is the co-prime with b.
 * Approaches:
 */
public class CoprimeFactor {

    public static void main(String[] args) {
        coprimeFactor(42, 81);
    }

    private static void coprimeFactor(int a, int b) {
        System.out.println("Approach 1: Highest factor of " + a + " that is coprime with " + b + ": " + approach1(42, 81));
        System.out.println("Approach 2: Highest factor of " + a + " that is coprime with " + b + ": " + approach2(42, 81));
        System.out.println();
    }

    /**
     * Approach 1: Bruteforce approach
     * - Simply iterate from A till 1 and check if it is a factor of A and coprime of B i.e. its gcd with B is 1.
     * - This will take O(A*log(min(a,b))) time complexity and O(1) space complexity.
     */
    private static int approach1(int a, int b) {
        for (int i = a; i >= 1; i--) {
            if (a % i == 0) {
                if (gcd(i, b) == 1) {
                    return i;
                }
            }
        }
        return 1;
    }

    /**
     * Approach 2: Optimal approach
     * - Here, we are dividing the A with gcd(A,B).
     * - Will repeat the process until gcd is 1.
     * - Time complexity: O(log(A)*log(min(A,B))), Space complexity: O(1), if not used recursion
     */
    private static int approach2(int a, int b) {
        int gcd = gcd(a, b);
        while (gcd > 1) {
            a /= gcd;
            gcd = gcd(a, b);
        }
        return a;
    }

    // Time and space complexity: O(log(min(a,b)))
    private static int gcd(int a, int b) {
        return (a == 0) ? b : gcd(b % a, a);
    }

}
