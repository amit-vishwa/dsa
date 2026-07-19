package module.two.heaps.one.assignment;

import java.util.PriorityQueue;

/**
 * Minimum Cost Of Ropes:
 * <p>
 * Given are N ropes of different lengths, the task is to connect these ropes into one rope with minimum cost, such that the cost to
 * connect two ropes is equal to the sum of their lengths.
 * <p>
 * Input: arr[] = {4,3,2,6} , N = 4
 * Output: 29
 * Explanation:
 * First, connect ropes of lengths 2 and 3. Now we have three ropes of lengths 4, 6, and 5.
 * Now connect ropes of lengths 4 and 5. Now we have two ropes of lengths 6 and 9.
 * Finally connect the two ropes and all ropes have connected.
 * <p>
 * Input: arr[] = {1, 2, 3} , N = 3
 * Output: 9
 * <p>
 * Constraints:
 * N == arr.length
 * 0 <= N <= 104
 * 1 <= arr[i].length <= 104
 */
public class _1MinRopesCost {

    public static void main(String[] args) {
        System.out.println("Minimum cost of ropes when tied together is " + minRopeCost(new int[]{4, 3, 2, 6}));
        System.out.println("Minimum cost of ropes when tied together is " + minRopeCost(new int[]{1, 2, 3}));
    }

    /**
     * Approach:
     * - The approach is quite simple here.
     * - We are first adding all the ropes in min-heap based priority queue.
     * - Then we are iterating over the queue until size becomes 1.
     * - We are popping the top 2 values and adding their sum to the cumulative sum variable.
     * - After that we are also add the sum to priority queue.
     * - At last, after iteration we are left with the final answer.
     * - Time complexity: O(N + N) as we are iterating over the array and priority queue = O(2N) = O(N)
     * - Space complexity: O(N) as we are storing the N values in priority queue.
     */
    private static int minRopeCost(int[] ropes) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        for (int rope : ropes) {
            minPQ.add(rope);
        }
        int minRopeCost = 0;
        while (minPQ.size() > 1) {
            int ropeCost = minPQ.remove() + minPQ.remove();
            minRopeCost += ropeCost;
            minPQ.add(ropeCost);
        }
        return minRopeCost;
    }

}