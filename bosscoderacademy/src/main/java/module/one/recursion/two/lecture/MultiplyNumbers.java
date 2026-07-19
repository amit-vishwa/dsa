package module.one.recursion.two.lecture;

/**
 * Multiply two numbers:
 * <p>
 * Given 2 numbers, return the product of them using recursion and without using * operator.
 * The logic is simple, just add the number 1 as many times as number 2.
 * Time complexity: O(num2) as we are adding num1 till num2 times.
 * Space complexity: O(num2) due to recursion stack.
 */
public class MultiplyNumbers {

    public static void main(String[] args) {
        System.out.println(multiply(3, 4));
    }

    private static int multiply(int num1, int num2) {
        if (num2 == 1) {
            return num1;
        }
        return num1 + multiply(num1, num2 - 1);
    }

}
