package module.two.heaps.one.lecture;

import java.util.ArrayList;

public class _2MinHeap {

    ArrayList<Integer> heap;

    public _2MinHeap() {
        heap = new ArrayList<>();
    }

    public void add(int num) {
        heap.add(num);
        heapifyUp(size() - 1);
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(parentIndex) <= heap.get(index)) {
                break;
            }
            swap(parentIndex, index);
            index = parentIndex;
        }
    }

    public int remove() {
        if (size() == 0) {
            return -1;
        }
        int minElement = heap.get(0);
        heap.set(0, heap.get(size() - 1));
        heap.remove(size() - 1);
        heapifyDown(0);
        return minElement;
    }

    private void heapifyDown(int index) {
        int size = size();
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
            swap(smallest, index);
            index = smallest;
        }
    }

    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public int peek() {
        return size() == 0 ? -1 : heap.get(0);
    }

    public int size() {
        return heap.size();
    }

    public void display() {
        System.out.println(heap);
    }

    public static void main(String[] args) {
        _2MinHeap minHeap = new _2MinHeap();
        int[] values = {10, 7, 11, 5, 4, 13};
        for (int value : values) {
            minHeap.add(value);
            minHeap.display();
        }
        while (minHeap.size() > 0) {
            System.out.print(minHeap.remove() + " ");
        }
    }

}
