package module.one.arrays_and_maths.assignment;

import java.util.Arrays;

/**
 * 1. Fizz Buzz: [Leetcode 412. Fizz Buzz]
 * Given an integer n, return a string array answer (1-indexed) where:
 * answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
 * answer[i] == "Fizz" if i is divisible by 3.
 * answer[i] == "Buzz" if i is divisible by 5.
 * answer[i] == i (as a string) if none of the above conditions are true.
 */
public class _1FizzBuzz {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(3)));
        System.out.println(Arrays.toString(solve(5)));
        System.out.println(Arrays.toString(solve(8)));
        System.out.println(Arrays.toString(solve(10)));
        System.out.println(Arrays.toString(solve(15)));
    }

    private static String[] solve(int n) {
        String[] res = new String[n];
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                res[i - 1] = "FizzBuzz";
            } else if (i % 3 == 0) {
                res[i - 1] = "Fizz";
            } else if (i % 5 == 0) {
                res[i - 1] = "Buzz";
            } else {
                res[i - 1] = String.valueOf(i);
            }
        }
        return res;
    }

}