package module.two.exams.two;

import java.util.Comparator;
import java.util.PriorityQueue;

// Refer: https://leetcode.com/problems/last-stone-weight/description/
public class _3LastStoneWeight {

    public static void main(String[] args) {
        System.out.println("The weight of the last remaining stone is " + lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println("The weight of the last remaining stone is " + lastStoneWeight(new int[]{1}));
    }

    /**
     * Approach:
     * - The approach is quite simple, just store all the stones in max-heap based priority queue.
     * - Then iterate over the queue till size is greater than 1.
     * - Remove the top 2 stones and check if they are not equal then add their difference in queue.
     * - At last, just check if queue is empty.
     * - If yes, then return 0 else return the last element left in the priority queue.
     * - Time complexity: O(N) as we are iterating over all elements * O(log(N)) due to insertion in heap = O(N*log(N))
     * - Space complexity: O(N) as we are storing all elements in the priority queue.
     */
    private static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxPriorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            maxPriorityQueue.add(stone);
        }
        while (maxPriorityQueue.size() > 1) {
            int y = maxPriorityQueue.remove();
            int x = maxPriorityQueue.remove();
            if (x != y) {
                maxPriorityQueue.add(y - x);
            }
        }
        return maxPriorityQueue.isEmpty() ? 0 : maxPriorityQueue.remove();
    }

}
