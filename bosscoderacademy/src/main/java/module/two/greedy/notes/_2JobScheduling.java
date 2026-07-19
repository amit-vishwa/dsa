package module.two.greedy.notes;

import java.util.Arrays;

/**
 * Job Scheduling Problem:
 * <p>
 * Given a set of N jobs where each job has a deadline and associated profit. Each job takes 1 unit to complete and only one job
 * can be scheduled at a time. We earn the profit associated with the job if and only if the job is completed by its deadline.
 * Find the number of jobs done and the maximum profit.
 * <p>
 * Example
 * Input: N = 4, Jobs = {(1,4,20),(2,1,10),(3,1,40),(4,1,30)}
 * Output: 2 60
 */
public class _2JobScheduling {

    public static void main(String[] args) {
        System.out.println("Jobs done with max profit: " + Arrays.toString(jobsDoneWithMaxProfit(new int[][]{
                {1, 4, 20}, {2, 1, 10}, {3, 1, 40}, {4, 1, 30}
        })));
        System.out.println("Jobs done with max profit: " + Arrays.toString(jobsDoneWithMaxProfit(new int[][]{
                {1, 2, 100}, {2, 1, 19}, {3, 2, 27}, {4, 1, 25}, {5, 1, 15}
        })));
        System.out.println("Jobs done with max profit: " + Arrays.toString(jobsDoneWithMaxProfit(new int[][]{
                {1, 2, 100}, {2, 1, 19}, {3, 2, 27}, {4, 1, 25}, {5, 3, 15}
        })));
    }

    /**
     * Approach:
     * - The approach is quite trickier.
     * - First, sort the array based on profit.
     * - Then find max deadline given and create a slots array of size max deadline + 1, fill it with -1.
     * - Iterate over jobs array, and for each deadline try to fit it in slots array if available.
     * - Once slot is occupied, increment jobs count and add profit in total profit.
     * - At last, just return the array of jobs count and total profit.
     * - Time complexity: O(N*log(N)) due to sorting + O(N*D) filling slot array = O(N*log(N))
     * - Space complexity: O(S) due to slots array.
     */
    private static int[] jobsDoneWithMaxProfit(int[][] jobs) {
        Arrays.sort(jobs, (j1, j2) -> j2[2] - j1[2]);
        int n = jobs.length;
        int maxDeadline = jobs[0][1];
        for (int i = 1; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, jobs[i][1]);
        }
        int[] slots = new int[maxDeadline + 1];
        Arrays.fill(slots, -1);
        int jobsCount = 0, totalProfit = 0;
        // Iterate over jobs
        for (int[] job : jobs) {
            int id = job[0];
            int deadline = job[1];
            int profit = job[2];
            // Try to fit job in latest possible slot
            while (deadline > 0) {
                if (slots[deadline] == -1) {
                    slots[deadline] = id;
                    jobsCount++;
                    totalProfit += profit;
                    break; // slot filled, break
                }
                deadline--;
            }
        }
        return new int[]{jobsCount, totalProfit};
    }

}
