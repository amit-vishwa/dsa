package module.two.greedy.lecture;

// Refer https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
public class _5BuySellStocks {

    public static void main(String[] args) {
        System.out.println("Maximum profit from buying and selling stocks: " + maxProfitFromStocks(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println("Maximum profit from buying and selling stocks: " + maxProfitFromStocks(new int[]{7, 6, 4, 3, 1}));
    }

    /**
     * Approach:
     * - Keep 2 variables, one for keeping track of lowest price and one for keeping track of max profit.
     * - Initialize min price with Max value and max profit with 0.
     * - Iterate over prices array, update min price if it is less than current price.
     * - Else update max profit by storing max of profit till now and difference of current price and min price.
     * - At last, just return the max profit.
     * - Time complexity: O(N) as we are iterating over the array once.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int maxProfitFromStocks(int[] prices) {
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }
        return maxProfit;
    }

}
