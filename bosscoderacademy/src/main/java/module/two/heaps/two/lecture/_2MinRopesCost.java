package module.two.heaps.two.lecture;

import java.util.PriorityQueue;

// Refer _4MinRopesCost.java from package module.two.heaps.one.notes.
public class _2MinRopesCost {

    public static void main(String[] args) {
        System.out.println("Minimum cost of ropes after connecting them is " + minCostOfRopes(new int[]{4, 3, 2, 6}));
        System.out.println("Minimum cost of ropes after connecting them is " + minCostOfRopes(new int[]{4, 2, 7, 6, 9}));
        System.out.println("Minimum cost of ropes after connecting them is " + minCostOfRopes(new int[]{10}));
    }

    private static int minCostOfRopes(int[] ropes) {
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
