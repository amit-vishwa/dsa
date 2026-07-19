package module.one.recursion.one.lecture;

/**
 * Find factorial of a number:
 *
 * The logic is simple, we have to multiply the number with number less than it.
 * That is factorial of a number is the product of numbers from 1 to N.
 * Time complexity: O(N) as we are iterating till number.
 * Space complexity: O(N) due to stack space.
 * */
public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    private static int factorial(int num) {
        if (num == 1) {
            return num;
        }
        return num * factorial(num - 1);
    }

}
