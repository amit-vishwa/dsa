package module.two.heaps.two.lecture;

import module.two.heaps.two.notes._6MedianFinder;

import java.util.Comparator;
import java.util.PriorityQueue;

// Refer https://leetcode.com/problems/find-median-from-data-stream/
public class _5MedianFinder {

    PriorityQueue<Integer> minPQ;
    PriorityQueue<Integer> maxPQ;

    public _5MedianFinder() {
        minPQ = new PriorityQueue<>();
        maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        // add num in any queue first
        if (maxPQ.isEmpty() || num <= maxPQ.peek()) {
            maxPQ.add(num);
        } else {
            minPQ.add(num);
        }
        // balance the queues
        if (maxPQ.size() > minPQ.size() + 1) {
            minPQ.add(maxPQ.remove());
        } else if (minPQ.size() > maxPQ.size()) {
            maxPQ.add(minPQ.remove());
        }
    }

    public double findMedian() {
        if (isSizeSame()) {
            return (maxPQ.peek() + minPQ.peek()) / 2.0;
        }
        return maxPQ.peek();
    }

    private boolean isSizeSame() {
        return minPQ.size() == maxPQ.size();
    }

    public static void main(String[] args) {
        testcase1();
        testcase2();
    }

    private static void testcase1() {
        System.out.println("\n===== Test Case 1: Odd number of elements =====");
        _5MedianFinder obj = new _5MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());

    }

    private static void testcase2() {
        System.out.println("\n===== Test Case 2: Random Order =====");
        _6MedianFinder obj10 = new _6MedianFinder();
        int[] random = {3, 1, 4, 1, 5, 9, 2, 6};
        for (int num : random) {
            obj10.addNum(num);
            System.out.println("After adding " + num + ", median: " + obj10.findMedian());
        }
    }

}
