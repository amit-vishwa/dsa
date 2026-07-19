package module.two.heaps.two.assignment;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Last Stone Weight:
 * <p>
 * You are given an array of integers stones where stones[i] is the weight of the ith stone.
 * We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together.
 * Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:
 * - If x == y, both stones are destroyed, and
 * - If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x. At the end of the game, there is at most one stone left.
 * Return the weight of the last remaining stone. If there are no stones left, return 0.
 * <p>
 * Input: stones = [2,7,4,1,8,1]
 * Output: 1
 * <p>
 * Input: stones = [1]
 * Output: 1
 * <p>
 * Constraints:
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 */
public class _3LastStoneWeight {

    public static void main(String[] args) {
        System.out.println("Last stone weight is " + lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println("Last stone weight is " + lastStoneWeight(new int[]{1}));
    }

    /**
     * Approach:
     * - The approach is quite straightforward and simple.
     * - We just have to insert all stones in the max heap so that largest ones are at top.
     * - Then we have to iterate over heap until the size left is 1.
     * - While iterating pop 2 stones, get their positive difference and insert again in the heap.
     * - Repeat the process until heap is traversed successfully.
     * - At last, just return 0 is heap is empty, else return the last stone weight that is left.
     * - Time complexity: O(N) iterating over all stones * O(log(N)) due to insertion in heap = O(N*log(N))
     * - Space complexity: O(N) due to heap.
     */
    private static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            maxPQ.offer(stone);
        }
        while (maxPQ.size() > 1) {
            int y = maxPQ.poll();
            int x = maxPQ.poll();
            if (x != y) {
                maxPQ.offer(y - x);
            }
        }
        return maxPQ.isEmpty() ? 0 : maxPQ.poll();
    }

}