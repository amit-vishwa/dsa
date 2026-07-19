package module.two.greedy.assignment;

/**
 * Bulb Switch:
 * <p>
 * There are n bulbs that are initially off. You first turn on all the bulbs, then you turn off every second bulb.
 * On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the ith round, you
 * toggle every i bulb. For the nth round, you only toggle the last bulb.
 * Return the number of bulbs that are on after n rounds.
 * <p>
 * Input 1:
 * n = 3
 * Output 1:
 * 1
 * Explanation 1:
 * At first, the three bulbs are [off, off, off]. After the first round, the three bulbs are [on, on, on]. After the second
 * round, the three bulbs are [on, off, on]. After the third round, the three bulbs are [on, off, off]. So you should return
 * 1 because there is only one bulb is on.
 * <p>
 * Input 2:
 * n = 0
 * Output 2:
 * 0
 * <p>
 * Constraints:
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 */
public class _7BulbSwitch {

    public static void main(String[] args) {
        printOnBulbs(3);
        printOnBulbs(0);
        printOnBulbs(363);
    }

    private static void printOnBulbs(int n) {
        System.out.println("Number of bulbs that are ON after N rounds by approach 1 are " + approach1(n));
        System.out.println("Number of bulbs that are ON after N rounds by approach 2 are " + approach2(n));
        System.out.println();
    }

    /**
     * Approach 1:
     * - The simplest approach is to find the square root of number as only those bulbs will remain switch on at end.
     * - Time complexity: O(sqrt(N))
     * - Space complexity: O(1)
     */
    private static int approach1(int n) {
        return (int) Math.sqrt(n);
    }

    /**
     * Approach 2:
     * - This is similar to approach 1, but here we are counting while iterating the loop from 1 till root of number.
     * - Time complexity: O(sqrt(N))
     * - Space complexity: O(1)
     */
    private static int approach2(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            count++;
        }
        return count;
    }

}