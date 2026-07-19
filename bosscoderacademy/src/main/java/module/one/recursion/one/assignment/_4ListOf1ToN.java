package module.one.recursion.one.assignment;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * One To N:
 * <p>
 * Write a function using recursion which returns a list that stores 1 to N numbers.
 * <p>
 * Input 1: 5
 * Output 1: 1 2 3 4 5
 * Explanation 1: Sequence up to 5 will be 1, 2, 3, 4 and 5
 * <p>
 * Input 2: 2
 * Output 2: 1 2
 * Constraints:
 * 1 <= N <= 103
 */
public class _4ListOf1ToN {

    public static void main(String[] args) {
        printNumbers(5);
        printNumbers(2);
        printNumbers(10);
    }

    private static void printNumbers(int num) {
        System.out.println(numberList(num));
        System.out.println(Arrays.toString(numbers(num)));
        System.out.println();
    }

    /**
     * Approach:
     * - Here, we are going from bottom to up of recursion tree.
     * - After hitting the base case i.e. when num is 1 we are adding that number to list and returning the list.
     * - Then from recursion call we are already getting a list, so just adding the number now.
     * - And at last returning the list.
     * - Time complexity: O(N) for iterating from 1 to N.
     * - Space complexity: O(N) due to recursion stack.
     */
    private static ArrayList<Integer> numberList(int num) {
        if (num == 1) {
            ArrayList<Integer> number = new ArrayList<>();
            number.add(num);
            return number;
        }
        ArrayList<Integer> numbers = numberList(num - 1);
        numbers.add(num);
        return numbers;
    }

    /**
     * Approach:
     * - In this approach, we are creating an array with same size as of number.
     * - Then calling helper function that will populate the array with numbers from 1 to N.
     * - At last, returning the array.
     * - Time and space complexity is O(N).
     */
    private static int[] numbers(int num) {
        int[] res = new int[num];
        helper(res, num);
        return res;
    }

    private static void helper(int[] res, int num) {
        if (num == 1) {
            res[num - 1] = num;
            return;
        }
        helper(res, num - 1);
        res[num - 1] = num;
    }

}