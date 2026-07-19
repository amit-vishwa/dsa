package module.two.exams.milestone;

import java.util.PriorityQueue;

// Refer: _4MinRopesCost.java from package module.two.heaps.one.notes.
public class _4MinRopesCost {

    public static void main(String[] args) {
        System.out.println("Minimum cost to connect all ropes: " + minRopesCost(new int[]{4, 3, 2, 6}));
        System.out.println("Minimum cost to connect all ropes: " + minRopesCost(new int[]{1, 2, 3}));
    }

    private static int minRopesCost(int[] ropes) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        for (int rope : ropes) {
            minPQ.offer(rope);
        }
        int minCost = 0;
        while (minPQ.size() > 1) {
            int cost = minPQ.poll() + minPQ.poll();
            minCost += cost;
            minPQ.offer(cost);
        }
        return minCost;
    }

}
