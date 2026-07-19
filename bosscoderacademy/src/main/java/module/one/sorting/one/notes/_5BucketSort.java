package module.one.sorting.one.notes;

import java.util.*;

/**
 * Bucket Sort Algorithm:
 * <p>
 * Bucket Sort is a sorting algorithm that works by distributing the elements of an array into several "buckets." Each bucket
 * is then sorted individually, either using another sorting algorithm or by recursively applying the bucket sort algorithm.
 * Finally, the sorted buckets are concatenated to form the final sorted array.
 * <p>
 * When to Use Bucket Sort
 * 1. Uniformly Distributed Input:
 * --> Bucket sort is most effective when the input data is uniformly distributed across a range.
 * 2. Floating Point Values:
 * --> Bucket sort is particularly useful for sorting floating-point numbers that lie within a specific range.
 * <p>
 * Steps of the Bucket Sort Algorithm
 * 1. Create Buckets:
 * --> Determine the number of buckets and create them. The number of buckets is typically chosen based on the number of elements
 * in the array (e.g., n buckets for an array of length n).
 * 2. Distribute Elements into Buckets:
 * --> Traverse the input array and distribute the elements into their respective buckets. This distribution is usually based on
 * the element's value (e.g., using a function like floor(value * number_of_buckets) for floating-point values between 0 and 1).
 * 3. Sort Each Bucket:
 * --> Sort each bucket individually. This can be done using any suitable sorting algorithm like insertion sort, quick sort, or
 * even recursively using bucket sort.
 * 4. Concatenate Buckets:
 * --> Concatenate the sorted buckets to form the final sorted array.
 * <p>
 * - Time complexity: O(N^2) for worst case, for rest it is O(N+K) similar to counting sort.
 * - Time complexity: O(N) for creating buckets
 * - It is a comparison based stable sorting algorithm as we are using merge sort on each bucket.
 * - It is not in-place sorting algorithm.
 */
public class _5BucketSort {

    public static void main(String[] args) {
        sort(new int[]{12, 4, 5, 6, 7, 8, 10, 8, 7});
        sort(new int[]{2, 4, 5, 6, 7, 8, 10});
        sort(new int[]{-3, -1, 2, 4, -2, -2, 5, 6});
    }

    private static void sort(int[] arr) {
        System.out.println("Array: " + Arrays.toString(arr));
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, n = arr.length;
        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int range = max - min;
        List<List<Integer>> buckets = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            buckets.add(new ArrayList<>());
        }
        for (int num : arr) {
            int index = ((num - min) / range * (n - 1));
            buckets.get(index).add(num);
        }
        int i = 0;
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (Integer element : bucket) {
                arr[i++] = element;
            }
        }
        System.out.println("Sorted Array: " + Arrays.toString(arr));
        System.out.println();
    }
}
