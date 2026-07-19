package module.two.linkedlist.one.assignment;

/**
 * Most Profit Assigning Work:
 * <p>
 * You have n jobs and m workers. You are given three arrays: difficulty, profit, and worker where:
 * - difficulty[i] and profit[i] are the difficulty and the profit of the ith job, and
 * - worker[j] is the ability of jth worker (i.e., the jth worker can only complete a job with difficulty at most worker[j]).
 * Every worker can be assigned at most one job, but one job can be completed multiple times.
 * For example, if three workers attempt the same job that pays $1, then the total profit will be $3. If a worker cannot
 * complete any job, their profit is $0.
 * Return the maximum profit we can achieve after assigning the workers to the jobs.
 */
public class _10MostProfitWork {

    public static void main(String[] args) {
        System.out.println("Maximum profit: " + maxProfit(new int[]{2, 4, 6, 8, 10}, new int[]{10, 20, 30, 40, 50}, new int[]{4, 5, 6, 7}));
        System.out.println("Maximum profit: " + maxProfit(new int[]{85, 47, 57}, new int[]{24, 66, 99}, new int[]{40, 25, 25}));
    }

    /**
     * Approach:
     * - The approach is quite a straightforward bruteforce approach.
     * - We are iterating over the array of workers and finding the index for profit so that can be added in result.
     * - Now to get index, we are checking if current difficulty is less than or equal to current worker.
     * - If it is, then check if difficulty till now is less than current difficulty, if yes just update difficulty and index.
     * - If difficulty is similar to worker then just break the loop and add that to the result.
     * - Perform this for all workers.
     * - Time complexity: O(N*M) as we are iterating over workers and difficulty arrays = O(N^2) when both length are same.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int maxProfit(int[] difficulty, int[] profit, int[] workers) {
        int maxProfit = 0;
        for (int worker : workers) {
            int bestProfit = 0;
            for (int i = 0; i < difficulty.length; i++) {
                if (difficulty[i] <= worker) {
                    bestProfit = Math.max(bestProfit, profit[i]);
                }
            }
            maxProfit += bestProfit;
        }
        return maxProfit;
    }

}