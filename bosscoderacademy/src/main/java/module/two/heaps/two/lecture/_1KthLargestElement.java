package module.two.heaps.two.lecture;

import java.util.PriorityQueue;

// Refer _5KthLargestElement.java from package module.two.heaps.one.notes.
public class _1KthLargestElement {

    public static void main(String[] args) {
        printKthLargestElement(new int[]{3, 2, 1, 5, 6, 4}, 2);
        printKthLargestElement(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
    }

    private static void printKthLargestElement(int[] nums, int k) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        for (int num : nums) {
            minPQ.add(num);
            if (minPQ.size() > k) {
                minPQ.remove();
            }
        }
        System.out.println(k + " th largest element in an array is " + minPQ.peek());
    }

}
