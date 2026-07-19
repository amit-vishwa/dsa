package module.two.heaps.one.notes;

import java.util.PriorityQueue;

/**
 * Minimum Cost of ropes
 * There are given N ropes of different lengths, we need to connect these ropes into one rope. The cost to connect two ropes is equal
 * to the sum of their lengths. The task is to connect the ropes at a minimum cost. Given N size array arr[] contains the lengths of
 * the ropes.
 * <p>
 * Example
 * Input: n = 4 arr[] = {4, 3, 2, 6}
 * Output: 29
 * <p>
 * Approach
 * The idea is to connect the two lowest-cost ropes first. The resultant rope has a cost equal to the sum of the connected ropes.
 * Repeat the process (with the resultant rope included) until we are left with a single rope. At each iteration of the loop, we will
 * be left with one less rope, and the optimal cost is added to the total cost. The final cost for connecting n ropes will be
 * minimal among all possible combinations. A priority queue implemented using min-heap is best suited for this problem.
 * <p>
 * Time Complexity: o(n*log(n))
 * Space Complexity: O(n)
 */
public class _4MinRopesCost {

    public static void main(String[] args) {
        System.out.println("Minimum cost of ropes after connecting them is " + minCostRopes(new int[]{4, 3, 2, 6}));
        System.out.println("Minimum cost of ropes after connecting them is " + minCostRopes(new int[]{4, 2, 7, 6, 9}));
        System.out.println("Minimum cost of ropes after connecting them is " + minCostRopes(new int[]{10}));
    }

    private static int minCostRopes(int[] ropes) {
        if (ropes.length < 2) {
            return 0;
        }
        PriorityQueue<Integer> minPriorityQueue = new PriorityQueue<>();
        for (int rope : ropes) {
            minPriorityQueue.add(rope);
        }
        int minTotalRopesConnectingCost = 0;
        while (minPriorityQueue.size() > 1) {
            int combinedRopes = minPriorityQueue.remove() + minPriorityQueue.remove();
            minTotalRopesConnectingCost += combinedRopes;
            minPriorityQueue.add(combinedRopes);
        }
        return minTotalRopesConnectingCost;
    }

}
