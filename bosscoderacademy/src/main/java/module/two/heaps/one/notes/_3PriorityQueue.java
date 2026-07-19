package module.two.heaps.one.notes;

import java.util.PriorityQueue;

/**
 * Priority Queue
 * - A priority queue is a data structure that maintains a set of elements.
 * - Each element has an associated priority, and elements with higher priorities are dequeued before elements with lower priorities.
 * - It allows operations like the insertion of elements with priority and the removal of the highest priority element.
 * <p>
 * Applications: Priority queues are used in algorithms like Dijkstra's shortest path algorithm, Prim's minimum spanning tree
 * algorithm, and task scheduling in operating systems.
 * <p>
 * Priority Queue in Java:
 * - Java provides a PriorityQueue class in java.util package which is a min heap by default.
 * - Elements are dequeued in ascending order (lowest element first).
 * Max Heap: To create a max heap, a custom comparator that reverses the natural order can be used.
 * <p>
 * Time and space complexity are similar to Heaps.
 */
public class _3PriorityQueue {

    public static void main(String[] args) {
        int[] values = {10, 20, 15, 40, 50, 100};
        minHeapPriorityQueueExample(values);
        maxHeapPriorityQueueExample(values);
    }

    private static void minHeapPriorityQueueExample(int[] values) {
        System.out.println();
        PriorityQueue<Integer> minHeapPriorityQueue = new PriorityQueue<>();
        for (int value : values) {
            minHeapPriorityQueue.add(value);
            System.out.println(minHeapPriorityQueue);
        }
        System.out.println("Final min heap priority queue after adding all elements: " + minHeapPriorityQueue);
        while (!minHeapPriorityQueue.isEmpty()) {
            System.out.println(minHeapPriorityQueue.remove());
            System.out.println(minHeapPriorityQueue);
        }
        System.out.println();
    }

    private static void maxHeapPriorityQueueExample(int[] values) {
        System.out.println();
        PriorityQueue<Integer> maxHeapPriorityQueue = new PriorityQueue<>((value1, value2) -> value2.compareTo(value1));
        for (int value : values) {
            maxHeapPriorityQueue.add(value);
            System.out.println(maxHeapPriorityQueue);
        }
        System.out.println("Final max heap priority queue after adding all elements: " + maxHeapPriorityQueue);
        while (!maxHeapPriorityQueue.isEmpty()) {
            System.out.println(maxHeapPriorityQueue.remove());
            System.out.println(maxHeapPriorityQueue);
        }
        System.out.println();
    }

}
