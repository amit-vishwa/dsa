package module.two.heaps.two.notes;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Heap Sort:
 * <p>
 * A comparison-based sorting method based on the Binary Heap data structure is called heap sort.
 * Heap sort is similar to selection sort but unlike selection sort, heap sort uses a more efficient algorithm in which the
 * maximum element is initially located and put at the end and again this step is followed till the array gets sorted.
 * <p>
 * Approach:
 * - We are using min heap here to get the sorted array in ascending order.
 * - Deletion and insertion takes log(N) time and the heap itself takes O(N) space.
 * - Time Complexity: O(N*logN)
 * - Space Complexity: O(N)
 */
public class _3HeapSort {

    static class MinHeap {
        ArrayList<Integer> heap;

        MinHeap() {
            heap = new ArrayList<>();
        }

        void offer(int val) {
            heap.add(val);
            heapifyUp();
        }

        private void heapifyUp() {
            int index = size() - 1;
            while (index >= 0) {
                int parent = (index - 1) / 2;
                if (heap.get(parent) <= heap.get(index)) {
                    break;
                }
                swap(parent, index);
                index = parent;
            }
        }

        int poll() {
            if (isEmpty()) {
                return -1;
            }
            int top = heap.getFirst();
            heap.set(0, heap.getLast());
            heap.removeLast();
            heapifyDown();
            return top;
        }

        private void heapifyDown() {
            int index = 0, size = size();
            while (index < size) {
                int leftChild = 2 * index + 1;
                int rightChild = 2 * index + 2;
                int smallest = index;
                if (leftChild < size && heap.get(leftChild) < heap.get(smallest)) {
                    smallest = leftChild;
                }
                if (rightChild < size && heap.get(rightChild) < heap.get(smallest)) {
                    smallest = rightChild;
                }
                if (smallest == index) {
                    break;
                }
                swap(index, smallest);
                index = smallest;
            }
        }

        private void swap(int i, int j) {
            int temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }

        boolean isEmpty() {
            return size() == 0;
        }

        private int size() {
            return heap.size();
        }
    }

    public static void main(String[] args) {
        userInput();
        defaultInput();
    }

    private static void userInput() {
        System.out.print("Enter number of elements: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        MinHeap minHeap = new MinHeap();
        while (n > 0) {
            minHeap.offer(sc.nextInt());
            n--;
        }
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
        System.out.println();
    }

    private static void defaultInput() {
        int[] arr = {12, 11, 13, 5, 6, 7};
        MinHeap minHeap = new MinHeap();
        for (int num : arr) {
            minHeap.offer(num);
        }
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
        System.out.println();
    }
}
