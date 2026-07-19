package module.one.recursion.one.notes;

/**
 * Multiplication of two numbers using Recursion:
 * <p>
 * Given two numbers x and y find the product using recursion.
 * <p>
 * Example
 * Input: x = 5, y = 6
 * Output: 30
 */
public class _1MultiplyNumbers {

    public static void main(String[] args) {
        System.out.println(multiply(4, 3));
        System.out.println(multiply(19, 6));
    }

    /**
     * Approach:
     * - The approach is simply, just add the number a till number b times.
     * - When b becomes 1 just return the number 'a', this is a base case.
     * - Time complexity: O(b) as we are reducing b till it becomes 1.
     * - Space complexity: O(b) due to recursion stack.
     */
    private static int multiply(int a, int b) {
        if (b == 1) {
            return a;
        }
        return a + multiply(a, b - 1);
    }

}
