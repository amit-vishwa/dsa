package module.one.recursion.one.lecture;

/**
 * Find the Nth fibonacci number:
 * <p>
 * The logic is simple, print the sum of num - 1 and num - 2 for all numbers from 0 till N.
 * If num is 0 or 1, just return the number.
 * Time complexity: O(2^N) as we are iterating for all combinations of N-1 and N-2 for a particular number.
 * Space complexity: O(N) due to recursion stack as only height of recursive tree will be present at a time.
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(6));
        System.out.println(fibonacci(8));
    }

    private static int fibonacci(int num) {
        if (num == 0 || num == 1) {
            return num;
        }
        return fibonacci(num - 1) + fibonacci(num - 2);
    }

}
