package module.two.heaps.two.assignment;

import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * K Closest Points To Origin:
 * <p>
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k
 * closest points to the origin (0, 0).
 * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)^2 + (y1 - y2)^2).
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
 * <p>
 * Input: points = [[1,3],[-2,2]], k = 1 Output: [[-2,2]]
 * Explanation: The distance between (1, 3) and the origin is sqrt(10). The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin. We only want the closest k = 1 points from the origin, so the
 * answer is just [[-2,2]].
 * <p>
 * Input: points = [[3,3],[5,-1],[-2,4]], k = 2 Output: [[3,3],[-2,4]]
 * <p>
 * Constraints:
 * 1 <= k <= points.length <= 104
 * -104 < xi, yi < 104
 */
public class _1KOriginClosestPoints {

    private static List<List<Integer>> input1() {
        return new ArrayList<>(List.of(List.of(1, 3), List.of(-2, 2)));
    }

    private static List<List<Integer>> input2() {
        return new ArrayList<>(List.of(List.of(3, 3), List.of(5, -1), List.of(-2, 4)));
    }

    public static void main(String[] args) {
        printKClosestPoints(input1(), 1);
        printKClosestPoints(input2(), 2);
    }

    private static void printKClosestPoints(List<List<Integer>> points, int k) {
//        System.out.println(k + " closest points by approach 1: " + approach1(points, k));
//        System.out.println(k + " closest points by approach 2: " + approach2(points, k));
        System.out.println(k + " closest points by approach 3: " + approach3(points, k));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce
     * - This is simple bruteforce approach.
     * - We are using bubble sort to sort the list of points in ascending order as per given calculation.
     * - After that, we are just returning the k closest points in new list.
     * - Time complexity: O(N^2) for worst case, O(N) for best case. Here N is number of points or co-ordinates.
     * - Space complexity: O(1) as no extra space is used here for sorting.
     */
    private static List<List<Integer>> approach1(List<List<Integer>> points, int k) {
        List<List<Integer>> kClosestPoints = new ArrayList<>();
        for (int i = 0; i < points.size() - 1; i++) {
            boolean isSwapped = false;
            for (int j = i + 1; j < points.size(); j++) {
                int num1 = (points.get(j - 1).get(0) * points.get(j - 1).get(0)) + (points.get(j - 1).get(1) * points.get(j - 1).get(1));
                int num2 = (points.get(j).get(0) * points.get(j).get(0)) + (points.get(j).get(1) * points.get(j).get(1));
                if (num1 > num2) {
                    List<Integer> temp = points.get(j - 1);
                    points.set(j - 1, points.get(j));
                    points.set(j, temp);
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            }
        }
        for (int i = 0; i < k; i++) {
            kClosestPoints.add(points.get(i));
        }
        return kClosestPoints;
    }

    /**
     * Approach 2 - Better
     * - This is a better approach than the bruteforce one.
     * - We are using the in-built sort function from collections package.
     * - We are just updating the comparator as per required calculation logic.
     * - Time complexity: O(N*log(N)) due to sorting logic, N is number of points here.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static List<List<Integer>> approach2(List<List<Integer>> points, int k) {
        List<List<Integer>> kClosestPoints = new ArrayList<>();
        points.sort((point1, point2) -> (point1.get(0) * point1.get(0) + point1.get(1) * point1.get(1)) - (point2.get(0) * point2.get(0) + point2.get(1) * point2.get(1)));
        for (int i = 0; i < k; i++) {
            kClosestPoints.add(points.get(i));
        }
        return kClosestPoints;
    }

    /**
     * Approach 3 - Optimized
     * - This is an optimized approach using max-heap based PriorityQueue.
     * - We are using the max heap to store largest elements on top and smallest on lower side.
     * - The comparator logic is updated for max heap.
     * - We are iterating over the points and adding them in the heap.
     * - When heap size becomes more than K, then we are just removing or popping up the farthest point.
     * - At last, we will have the K closest points in the heap in reverse order.
     * - So, store them in a new list in reverse order and return the result.
     * - Time complexity: O(N) iterating over points * O(log(K)) inserting in heap = O(N*log(K))
     * - Space complexity: O(K) due to heap.
     */
    private static List<List<Integer>> approach3(List<List<Integer>> points, int k) {
        List<List<Integer>> kClosestPoints = new ArrayList<>();
        PriorityQueue<List<Integer>> maxPQ = new PriorityQueue<>((p1, p2) -> (p2.get(0) * p2.get(0) + p2.get(1) * p2.get(1)) - (p1.get(0) * p1.get(0) + p1.get(1) * p1.get(1)));
        for (List<Integer> point : points) {
            maxPQ.offer(point);
            if (maxPQ.size() > k) {
                maxPQ.poll();
            }
        }
        for (int i = 0; i < k; i++) {
            kClosestPoints.add(new ArrayList<>());
        }
        for (int i = k - 1; i >= 0; i--) {
            kClosestPoints.set(i, maxPQ.poll());
        }
        return kClosestPoints;
    }

}