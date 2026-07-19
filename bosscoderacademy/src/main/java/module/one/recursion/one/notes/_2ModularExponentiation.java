package module.one.recursion.one.notes;

/**
 * Modular exponentiation:
 * <p>
 * Given three numbers a, b, and c, we need to find (ab) % c.
 * <p>
 * Example
 * Input: a=2,b=4,c=10
 * Output: 6
 */
public class _2ModularExponentiation {

    public static void main(String[] args) {
        modularExponentiation(2, 4, 10);
    }

    private static void modularExponentiation(int a, int b, int c) {
        System.out.println("Modular exponentiation by approach 1: " + approach1(a, b) % c);
        System.out.println("Modular exponentiation by approach 2: " + approach2(a, b) % c);
    }

    /**
     * Approach 1:
     * - The approach is simple, we are fist calculating the exponent value.
     * - We are multiplying number 'a' till number 'b' becomes 0.
     * - When 'b' becomes 0, we are returning 1, so that all numbers 'a' are multiplied till 'b' times.
     * - Time complexity: O(b+1) we are reducing till it becomes 0 for calculating exponent = O(b).
     * - Space complexity: O(b) due to recursion stack.
     */
    private static int approach1(int a, int b) {
        if (b == 0) {
            return 1;
        }
        return a * approach1(a, b - 1);
    }

    /**
     * Approach 2:
     * - The approach is simple, we are fist calculating the exponent value.
     * - We are multiplying number 'a' till number 'b' becomes 0.
     * - When 'b' becomes 0, we are returning 1, so that all numbers 'a' are multiplied till 'b/2' times.
     * - Time complexity: O(log(b+1)) we are keep reducing b into halves = O(log(b)).
     * - Space complexity: O(log(b)) due to recursion stack.
     */
    private static int approach2(int a, int b) {
        if (b == 0) {
            return 1;
        }
        int res = approach2(a, b / 2);
        return (b & 1) == 1 ? res * res * a : res * res;
    }

}
