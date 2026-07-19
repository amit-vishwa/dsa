package module.one.recursion.one.notes;

/**
 * Program to print all permutations of a given string:
 * <p>
 * Given a string S, the task is to write a program to print all permutations of a given string
 * <p>
 * Example
 * Input: S = “ABC”
 * Output: “ABC”, “ACB”, “BAC”, “BCA”, “CBA”, “CAB”
 */
public class _4StringPermutations {

    public static void main(String[] args) {
        printPermutations("ABC");
    }

    private static void printPermutations(String str) {
        printApproach1(str);
        printApproach2(str);
        System.out.println();
    }

    private static void printApproach1(String str) {
        approach1(str, 0, str.length() - 1);
        System.out.println();
    }

    /**
     * Approach 1:
     * - The approach is simple where we are using backtracking algorithm with repetition.
     * - The logic is simple, we have 2 pointers left and right along with the given string.
     * - The base case is when both pointers are equal then we got our permutation.
     * - We have to iterate over the loop from left to right pointer.
     * - We have to swap index and left pointer first, then explore answers then re-swap for backtracking.
     * - In this manner, when we are done with the loop, we will be having all the permutations with us.
     * - Time complexity: O(N) for loop * O(N!) for permutations
     * - Space complexity: O(N) for recursion stack.
     */
    private static void approach1(String str, int l, int r) {
        if (l == r) {
            System.out.print(str + " ");
            return;
        }
        for (int i = l; i <= r; i++) {
            str = swap(str, l, i);
            approach1(str, l + 1, r);
            str = swap(str, l, i);
        }
    }

    private static String swap(String str, int l, int r) {
        char[] chars = str.toCharArray();
        char temp = chars[l];
        chars[l] = chars[r];
        chars[r] = temp;
        return String.valueOf(chars);
    }

    private static void printApproach2(String str) {
        approach2(str, "");
    }

    /**
     * Approach 2:
     * - The approach is simple where we are using backtracking algorithm without repetition.
     * - The logic is simple, we have one empty string that will store our permutation along with given string.
     * - The base case is when given string is empty, we have visited all characters and found our permutation.
     * - We have to iterate over the loop from 0 to updated string length.
     * - We have to update the string length by removing the current character and adding that in answer string.
     * - In this manner, when we are done with the loop, we will be having all the permutations with us.
     * - Time complexity: O(N) for loop * O(N!) for permutations
     * - Space complexity: O(N) for recursion stack.
     */
    private static void approach2(String str, String answer) {
        if (str.isEmpty()) {
            System.out.print(answer + " ");
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            approach2(str.substring(0, i) + str.substring(i + 1), answer + str.charAt(i));
        }
    }

}
