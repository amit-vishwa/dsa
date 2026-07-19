package module.two.exams.milestone;

import java.util.Comparator;
import java.util.PriorityQueue;

// Refer: _3LastStoneWeight.java from package module.two.heaps.two.assignment.
public class _3LastStoneWeight {

    public static void main(String[] args) {
        System.out.println("Weight of last remaining stone: " + lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println("Weight of last remaining stone: " + lastStoneWeight(new int[]{1}));
    }

    private static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            maxPQ.offer(stone);
        }
        while (maxPQ.size() > 1) {
            int y = maxPQ.poll();
            int x = maxPQ.poll();
            if (y != x) {
                maxPQ.offer(y - x);
            }
        }
        return maxPQ.isEmpty() ? 0 : maxPQ.poll();
    }

}
