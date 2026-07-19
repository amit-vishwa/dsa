package module.two.heaps.one.notes;

import java.util.ArrayList;

// Refer _2MinHeap.java from package module.two.heaps.one.lecture.
public class _2MinHeap {

    ArrayList<Integer> heap;

    public _2MinHeap() {
        heap = new ArrayList<>();
    }

    public void add(int val) {
        heap.add(val);
        heapifyUp();
    }

    private void heapifyUp() {
        int index = size() - 1;
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(parent) <= heap.get(index)) {
                break;
            }
            swap(parent, index);
            index = parent;
        }
    }

    public int remove() {
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
        return isEmpty() ? -1 : heap.getFirst();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return heap.size();
    }

    public void display() {
        System.out.println(heap);
    }

    public static void main(String[] args) {
        _2MinHeap minHeap = new _2MinHeap();
        int[] values = {10, 20, 15, 40, 50, 100};
        for (int value : values) {
            minHeap.add(value);
            minHeap.display();
        }
        System.out.println();
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.remove());
            minHeap.display();
        }
    }

}
