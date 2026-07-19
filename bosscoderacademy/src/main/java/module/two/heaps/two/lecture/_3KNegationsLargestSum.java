package module.two.heaps.two.lecture;

import java.util.PriorityQueue;

// Refer _4KNegationsLargestSum.java from package module.two.heaps.one.assignment.
public class _3KNegationsLargestSum {

    public static void main(String[] args) {
        printKNegationsLargestSum(new int[]{4, 2, 3}, 1);
        printKNegationsLargestSum(new int[]{3, -1, 0, 2}, 3);
        printKNegationsLargestSum(new int[]{2, -3, -1, 5, -4}, 2);
    }

    private static void printKNegationsLargestSum(int[] nums, int k) {
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
        System.out.println(k + " negations largest sum is " + sum);
    }

}
