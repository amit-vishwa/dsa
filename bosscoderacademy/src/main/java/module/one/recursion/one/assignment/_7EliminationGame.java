package module.one.recursion.one.assignment;

/**
 * Elimination Game:[Leetcode 390. Elimination Game]
 * <p>
 * You have a list arr of all integers in the range [1, n] sorted in a strictly increasing order. Apply the following algorithm on arr:
 * Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.
 * Repeat the previous step again, but this time from right to left, remove the rightmost number and every other number from the remaining numbers.
 * Keep repeating the steps again, alternating left to right and right to left, until a single number remains.
 * Given the integer n, return the last number that remains in arr.
 * Example 1:
 * Input: n = 9
 * Output: 6
 * Explanation:
 * arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
 * arr = [2, 4, 6, 8]
 * arr = [2, 6]
 * arr = [6]
 * Example 2:
 * Input: n = 1
 * Output: 1
 * Constraints:
 * 1 <= n <= 109
 */
public class _7EliminationGame {

    public static void main(String[] args) {
        System.out.println(remainingNumber(9));
        System.out.println(remainingNumber(1));
        System.out.println(remainingNumber(201));
    }

    /**
     * Approach:
     * - We have to take two pointers head and step starting with value 1, remaining variable will have whole number N.
     * - A boolean flag will also be there to start from left and right alternatively.
     * - We can create a loop while remaining number is greater than 1.
     * - If we are starting from left or remaining elements are odd then update head to head+step.
     * - And always increase step twice and decrease remaining by dividing it by 2 and toggle boolean flag.
     * - After loop ends, the head will have a remaining number which is the answer.
     * - Time complexity: O(log(N)) as we are keep on reducing the remaining number by 2.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int remainingNumber(int num) {
        int head = 1, step = 1, remaining = num;
        boolean left = true;
        while (remaining > 1) {
            if (left || ((remaining & 1) == 1)) {
                head += step;
            }
            step *= 2;
            remaining /= 2;
            left = !left;
        }
        return head;
    }

}