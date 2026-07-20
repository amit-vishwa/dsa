package module.one._1d_and_2d_array.assignment;

import java.util.List;

/**
 * [Leetcode 1672. Richest Customer Wealth]
 * You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the ith customer has
 * in the jth bank. Return the wealth that the richest customer has.
 * A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is the
 * customer that has the maximum wealth.
 * <p>
 * Input 1: accounts = [[1,2,3],[3,2,1]]
 * Output 1: 6
 * Explanation 1: 1st customer has wealth = 1 + 2 + 3 = 6
 * 2nd customer has wealth = 3 + 2 + 1 = 6
 * Both customers are considered the richest with a wealth of 6 each, so return 6.
 * <p>
 * Input 2: accounts = [[1,5],[7,3],[3,5]]
 * Output 2: 10
 * <p>
 * Constraints:
 * m == accounts.length
 * n == accounts[i].length
 * 1 <= n,m <= 50
 * 1 <= accounts[i][j] <= 102
 */
public class _1RichestCustomerWealth {

    public static void main(String[] args) {
        System.out.println("Richest customer wealth: " + richestCustomerWealth(List.of(
                List.of(1, 2, 3), List.of(3, 2, 1)
        )));
        System.out.println("Richest customer wealth: " + richestCustomerWealth(List.of(
                List.of(1, 5), List.of(7, 3), List.of(2, 1)
        )));
    }

    /**
     * Simple approach to traverse the 2D array and calculate the wealth.
     * Time complexity: O(M*N)
     * Space complexity: O(1), as not extra input dependent space is taken
     */
    private static int richestCustomerWealth(List<List<Integer>> bank) {
        int maxWealth = 0;
        for (List<Integer> customer : bank) {
            int wealth = 0;
            for (Integer account : customer) {
                wealth += account;
            }
            maxWealth = Math.max(wealth, maxWealth);
        }
        return maxWealth;
    }

}