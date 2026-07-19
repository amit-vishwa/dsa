package module.two.heaps.one.notes;

import java.util.ArrayList;

// Refer _1MaxHeap.java from package module.two.heaps.one.lecture.
public class _1MaxHeap {

    ArrayList<Integer> heap;

    public _1MaxHeap() {
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
            if (heap.get(parent) >= heap.get(index)) {
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
        int index = 0;
        int size = size();
        while (index < size) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int largest = index;
            if (leftChild < size && heap.get(leftChild) > heap.get(largest)) {
                largest = leftChild;
            }
            if (rightChild < size && heap.get(rightChild) > heap.get(largest)) {
                largest = rightChild;
            }
            if (largest == index) {
                break;
            }
            swap(largest, index);
            index = largest;
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
        _1MaxHeap maxHeap = new _1MaxHeap();
        int[] values = {10, 20, 15, 40, 50, 100};
        for (int value : values) {
            maxHeap.add(value);
            maxHeap.display();
        }
        System.out.println();
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.remove());
            maxHeap.display();
        }
    }

}
