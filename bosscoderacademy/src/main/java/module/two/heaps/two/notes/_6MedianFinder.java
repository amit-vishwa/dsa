package module.two.heaps.two.notes;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Find the Median from the Data Stream:
 * <p>
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and
 * the median is the mean of the two middle values.
 * For example, for arr = [2,3,4], the median is 3.
 * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 * <p>
 * Implement the MedianFinder class:
 * - MedianFinder() initializes the MedianFinder object.
 * - void addNum(int num) adds the integer num from the data stream to the data structure.
 * - double findMedian() returns the median of all elements so far. Answers within 10-5 the actual answer will be accepted.
 * <p>
 * Example;
 * Input: ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
 * [[], [1], [2], [], [3], []]
 * Output: [null, null, null, 1.5, null, 2.0]
 * <p>
 * Time Complexity - O(n*logn)
 * Space Complexity - O(n)
 * <p>
 * Refer _5MedianFinder.java from package module.two.heaps.two.lecture.
 */
public class _6MedianFinder {

    PriorityQueue<Integer> minPQ;
    PriorityQueue<Integer> maxPQ;

    public _6MedianFinder() {
        minPQ = new PriorityQueue<>();
        maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int val) {
        // add num in queues
        if (maxPQ.isEmpty() || val <= maxPQ.peek()) {
            maxPQ.offer(val);
        } else {
            minPQ.offer(val);
        }
        // balance the queues
        if (maxPQ.size() > minPQ.size() + 1) {
            minPQ.offer(maxPQ.poll());
        } else if (minPQ.size() > maxPQ.size()) {
            maxPQ.offer(minPQ.poll());
        }
    }

    public double findMedian() {
        return isSameSize() ? (minPQ.peek() + maxPQ.peek()) / 2.0 : maxPQ.peek();
    }

    private boolean isSameSize() {
        return minPQ.size() == maxPQ.size();
    }

//    public static void main(String[] args) {
//        _6MedianFinder obj = new _6MedianFinder();
//        obj.addNum(2);
//        obj.addNum(3);
//        System.out.println(obj.findMedian());
//        obj.addNum(4);
//        System.out.println(obj.findMedian());
//    }

    public static void main(String[] args) {
        System.out.println("===== Test Case 1: Single Element =====");
        _6MedianFinder obj1 = new _6MedianFinder();
        obj1.addNum(5);
        System.out.println("Median after adding 5: " + obj1.findMedian()); // Expected: 5.0

        System.out.println("\n===== Test Case 2: Two Elements =====");
        _6MedianFinder obj2 = new _6MedianFinder();
        obj2.addNum(1);
        System.out.println("Median after adding 1: " + obj2.findMedian()); // Expected: 1.0
        obj2.addNum(2);
        System.out.println("Median after adding 2: " + obj2.findMedian()); // Expected: 1.5

        System.out.println("\n===== Test Case 3: Odd Number of Elements =====");
        _6MedianFinder obj3 = new _6MedianFinder();
        obj3.addNum(1);
        obj3.addNum(2);
        obj3.addNum(3);
        System.out.println("Median: " + obj3.findMedian()); // Expected: 2.0

        System.out.println("\n===== Test Case 4: Even Number of Elements =====");
        _6MedianFinder obj4 = new _6MedianFinder();
        obj4.addNum(1);
        obj4.addNum(2);
        obj4.addNum(3);
        obj4.addNum(4);
        System.out.println("Median: " + obj4.findMedian()); // Expected: 2.5

        System.out.println("\n===== Test Case 5: Duplicate Elements =====");
        _6MedianFinder obj5 = new _6MedianFinder();
        obj5.addNum(5);
        obj5.addNum(5);
        obj5.addNum(5);
        System.out.println("Median: " + obj5.findMedian()); // Expected: 5.0

        System.out.println("\n===== Test Case 6: Negative Numbers =====");
        _6MedianFinder obj6 = new _6MedianFinder();
        obj6.addNum(-1);
        obj6.addNum(-2);
        obj6.addNum(-3);
        System.out.println("Median: " + obj6.findMedian()); // Expected: -2.0

        System.out.println("\n===== Test Case 7: Mixed Positive and Negative =====");
        _6MedianFinder obj7 = new _6MedianFinder();
        obj7.addNum(-1);
        System.out.println("Median after adding -1: " + obj7.findMedian()); // Expected: -1.0
        obj7.addNum(1);
        System.out.println("Median after adding 1: " + obj7.findMedian()); // Expected: 0.0
        obj7.addNum(2);
        System.out.println("Median after adding 2: " + obj7.findMedian()); // Expected: 1.0

        System.out.println("\n===== Test Case 8: Already Sorted Sequence =====");
        _6MedianFinder obj8 = new _6MedianFinder();
        int[] sorted = {1, 2, 3, 4, 5};
        for (int num : sorted) {
            obj8.addNum(num);
        }
        System.out.println("Median of [1,2,3,4,5]: " + obj8.findMedian()); // Expected: 3.0

        System.out.println("\n===== Test Case 9: Reverse Sorted Sequence =====");
        _6MedianFinder obj9 = new _6MedianFinder();
        int[] reversed = {5, 4, 3, 2, 1};
        for (int num : reversed) {
            obj9.addNum(num);
        }
        System.out.println("Median of [5,4,3,2,1]: " + obj9.findMedian()); // Expected: 3.0

        System.out.println("\n===== Test Case 10: Random Order =====");
        _6MedianFinder obj10 = new _6MedianFinder();
        int[] random = {3, 1, 4, 1, 5, 9, 2, 6};
        for (int num : random) {
            obj10.addNum(num);
            System.out.println("After adding " + num + ", median: " + obj10.findMedian());
        }

        System.out.println("\n===== Test Case 11: Large Numbers =====");
        _6MedianFinder obj11 = new _6MedianFinder();
        obj11.addNum(Integer.MAX_VALUE);
        System.out.println("Median after adding MAX_VALUE: " + obj11.findMedian()); // Expected: 2.147483647E9
        obj11.addNum(Integer.MIN_VALUE);
        System.out.println("Median after adding MIN_VALUE: " + obj11.findMedian()); // Expected: -1.0

        System.out.println("\n===== Test Case 12: Zero in the Stream =====");
        _6MedianFinder obj12 = new _6MedianFinder();
        obj12.addNum(-1);
        obj12.addNum(0);
        obj12.addNum(1);
        System.out.println("Median of [-1, 0, 1]: " + obj12.findMedian()); // Expected: 0.0

        System.out.println("\n===== Test Case 13: Reference Example from Problem =====");
        _6MedianFinder obj13 = new _6MedianFinder();
        obj13.addNum(1);
        obj13.addNum(2);
        System.out.println("Median after [1, 2]: " + obj13.findMedian()); // Expected: 1.5
        obj13.addNum(3);
        System.out.println("Median after [1, 2, 3]: " + obj13.findMedian()); // Expected: 2.0

        System.out.println("\n===== Test Case 14: Many Elements =====");
        _6MedianFinder obj14 = new _6MedianFinder();
        for (int i = 1; i <= 100; i++) {
            obj14.addNum(i);
        }
        System.out.println("Median of [1 to 100]: " + obj14.findMedian()); // Expected: 50.5

        System.out.println("\n===== Test Case 15: Alternating Add and Find =====");
        _6MedianFinder obj15 = new _6MedianFinder();
        for (int i = 10; i >= 1; i--) {
            obj15.addNum(i);
            System.out.println("After adding " + i + ", median: " + obj15.findMedian());
        }
    }

}
