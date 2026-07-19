package module.two.greedy.assignment;

import java.util.PriorityQueue;

// Refer _4KNegationsLargestSum.java from package module.two.heaps.one.assignment.
public class _3KNegationsLargestSum {

    public static void main(String[] args) {
        System.out.println("Largest possible sum of the array after K negations is " + largestPossibleSum(new int[]{4, 2, 3}, 1));
        System.out.println("Largest possible sum of the array after K negations is " + largestPossibleSum(new int[]{3, -1, 0, 2}, 3));
    }

    private static int largestPossibleSum(int[] nums, int k) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        for (int num : nums) {
            minPQ.add(num);
        }
        while (k > 0) {
            int top = minPQ.remove();
            top *= -1;
            minPQ.add(top);
            k--;
        }
        int sum = 0;
        while (!minPQ.isEmpty()) {
            sum += minPQ.remove();
        }
        return sum;
    }

}