package module.one.sorting.two.assignment;

import java.util.*;

/**
 * K Closest Points To Origin:
 * <p>
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k
 * closest points to the origin (0, 0).
 * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)^2 + (y1 - y2)^2).
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
 * <p>
 * Input: points = [[1,3],[-2,2]], k = 1 Output: [[-2,2]] Explanation: The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8). Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin. We only
 * want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
 * <p>
 * Input: points = [[3,3],[5,-1],[-2,4]], k = 2 Output: [[3,3],[-2,4]]
 * <p>
 * Constraints:
 * 1 <= k <= points.length <= 104
 * -104 < xi, yi < 104
 */
public class _3KClosestPoints {

    public static void main(String[] args) {
        printKClosestPoints(new ArrayList<>(List.of(new ArrayList<>(List.of(1, 3)), new ArrayList<>(List.of(-2, 2)))), 1);
        printKClosestPoints(new ArrayList<>(List.of(new ArrayList<>(List.of(3, 3)), new ArrayList<>(List.of(5, -1)),
                new ArrayList<>(List.of(-2, 4)))), 2);
    }

    private static void printKClosestPoints(List<List<Integer>> points, int k) {
        System.out.println(k + " closest points by approach 1: " + approach1(points, k));
        System.out.println(k + " closest points by approach 2: " + approach2(points, k));
        System.out.println();
    }

    /**
     * Approach 1 - Sorting
     * - The approach is simple, we are performing merge sort first on provided list of points.
     * - We can also use Collections class, the built-in methods for sorting.
     * - After sorting just add first K elements in a new list and return it.
     * - Time and space complexity will be similar to merge sort only.
     */
    private static List<List<Integer>> approach1(List<List<Integer>> points, int k) {
        List<List<Integer>> sortedPoints = mergeSort(points, 0, points.size() - 1);
        List<List<Integer>> closestPoints = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            closestPoints.add(sortedPoints.get(i));
        }
        return closestPoints;
    }

    private static List<List<Integer>> mergeSort(List<List<Integer>> list, int start, int end) {
        if (start == end) {
            return new ArrayList<>(List.of(list.get(start)));
        }
        int mid = start + (end - start) / 2;
        List<List<Integer>> left = mergeSort(list, start, mid);
        List<List<Integer>> right = mergeSort(list, mid + 1, end);
        return merge(left, right);
    }

    private static List<List<Integer>> merge(List<List<Integer>> left, List<List<Integer>> right) {
        int n = left.size(), m = right.size(), i = 0, j = 0;
        List<List<Integer>> merged = new ArrayList<>();
        while (i < n && j < m) {
            int num1 = (left.get(i).get(0) * left.get(i).get(0)) + (left.get(i).get(1) * left.get(i).get(1));
            int num2 = (right.get(j).get(0) * right.get(j).get(0)) + (right.get(j).get(1) * right.get(j).get(1));
            merged.add(num1 <= num2 ? left.get(i++) : right.get(j++));
        }
        while (i < n) {
            merged.add(left.get(i++));
        }
        while (j < m) {
            merged.add(right.get(j++));
        }
        return merged;
    }

    /**
     * Approach 2 - Heap
     * - Here we are using a heap data structure like PriorityQueue.
     * - We have added the custom comparator in PriorityQueue to keep large element list at top.
     * - Then we are adding K list of elements and adding them in reverse order in a linked list and returning it.
     * - Time complexity: O(N*logK) N is to iterate the list and K is for priority queue insertion/deletion.
     * - Space complexity: O(K) for PriorityQueue and LinkedList.
     */
    private static List<List<Integer>> approach2(List<List<Integer>> points, int k) {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((list1, list2) -> {
            int num1 = list1.get(0) * list1.get(0) + list1.get(1) * list1.get(1);
            int num2 = list2.get(0) * list2.get(0) + list2.get(1) * list2.get(1);
            return num2 - num1;
        });
        for (List<Integer> point : points) {
            pq.add(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<List<Integer>> closestPoints = new LinkedList<>();
        while (!pq.isEmpty()) {
            closestPoints.addFirst(pq.poll());
        }
        return closestPoints;
    }

}