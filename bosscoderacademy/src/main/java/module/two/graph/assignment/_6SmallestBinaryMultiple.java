package module.two.graph.assignment;

import java.util.Queue;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Find The Smallest Binary Digit Multiple Of A Given Number:
 * <p>
 * A decimal number is called a binary digit number if its digits are binary. For example, 102 is not a binary digit number
 * and 101 is.
 * We are given a decimal number N, we need to find the smallest multiple of N which is a binary digit number,
 * <p>
 * Input : N = 2
 * Output: 10
 * Explanation: 10 is a multiple of 2.
 * Note that 5 * 2 = 10
 * <p>
 * Input : N = 17
 * Output : 11101
 * Explanation: 11101 is a multiple of 17.
 * Note that 653 * 17 = 11101
 * <p>
 * Constraints: 1<=N<=10
 */
public class _6SmallestBinaryMultiple {

    public static void main(String[] args) {
        System.out.println("Smallest multiple of number which is a binary digit: " + smallestBinaryMultiple(2));
        System.out.println("Smallest multiple of number which is a binary digit: " + smallestBinaryMultiple(17));
    }

    /**
     * Approach:
     * - This is quite simple bruteforce approach using string.
     * - We can use the more optimized one using remainder only, so that whole string is not added in the Queue again and again.
     * - The logic is simple, we have to add 1 in queue first and iterate over the queue.
     * - Now, poll the queue string and calculate the modulo with given number.
     * - If modulo is 0, then we got the answer, return the string from queue.
     * - Else, just check if modulo is visited using set, if not then mark it as visited and explore for 0 and 1 bits again.
     * - At last if nothing found, just return -1.
     * - Time complexity: O(N^2) since we are checking for 1 and 0 for whole string again and again.
     * - Space complexity: O(N) due to queue.
     */
    private static int smallestBinaryMultiple(int num) {
        Queue<String> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        queue.offer("1");
        while (!queue.isEmpty()) {
            String binaryString = queue.poll();
            int remainder = modulo(binaryString, num);
            if (remainder == 0) {
                return Integer.parseInt(binaryString);
            }
            if (!set.contains(remainder)) {
                set.add(remainder);
                queue.offer(binaryString + "0");
                queue.offer(binaryString + "1");
            }
        }
        return -1;
    }

    private static int modulo(String binaryString, int num) {
        int mod = 0;
        for (char bitChar : binaryString.toCharArray()) {
            mod = (mod * 10 + (bitChar - '0')) % num;
        }
        return mod;
    }

}