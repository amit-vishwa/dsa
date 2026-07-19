package module.two.exams.two;

import java.util.PriorityQueue;

// Refer _1MinRopesCost.java from package module.two.heaps.one.assignment.
public class _4MinRopesCost {

    public static void main(String[] args) {
        System.out.println("Minimum cost of ropes when tied together is " + minRopeCost(new int[]{4, 3, 2, 6}));
        System.out.println("Minimum cost of ropes when tied together is " + minRopeCost(new int[]{1, 2, 3}));
    }

    private static int minRopeCost(int[] ropes) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        for (int rope : ropes) {
            minPQ.add(rope);
        }
        int minCost = 0;
        while (minPQ.size() > 1) {
            int ropeCost = minPQ.remove() + minPQ.remove();
            minCost += ropeCost;
            minPQ.add(ropeCost);
        }
        return minCost;
    }

}
