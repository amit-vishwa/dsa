package module.two.heaps.one.lecture;

import java.util.ArrayList;

/**
 * Heaps:
 * <p>
 * Heaps are advanced data structures useful for specific use cases such as sorting and implementing priority queues.
 * Heaps can be thought of as regular binary trees with two special characteristics.
 * - Heaps must be Complete Binary Trees.
 * - The nodes must be ordered according to the Heap order property.
 * <p>
 * Max Heap Property:
 * All the parent node keys must be greater than or equal to their child node keys in max-heaps.
 * So the root node will always contain the largest element in the Heap.
 * If Node A has a child node B, then, key(A)>=key(B)
 * <p>
 * Heapify a Binary Tree
 * Heapify is the process of rearranging the elements to form a tree that maintains the properties of the heap data structure. To Heapify a given tree in max heap follow these steps
 * <p>
 * Visualize all the elements of the list as a complete binary tree
 * Start by comparing the values of children nodes with that of the parent. If the value of the parent is smaller
 * than the value of the children, swap it. Swapping is done with a larger of two children.
 * This process is repeated until every node satisfies the properties of a max-heap.
 * <p>
 * i.Insertion in Heap
 * To insert any element in the max heap follow these steps:
 * - Add the first element
 * - Add the next element to the tree. Compare it with the parent element. If it is greater than its parent element,
 * swap their positions. It is done to ensure that the tree follows heap conditions and that a max heap is
 * maintained each time an element is added.
 * - Repeat the above-given step
 * <p>
 * ii.Deletion from Heap
 * To delete any element from the max heap follow these steps:
 * - Search for the element to be deleted and swap it with the last element in the heap.
 * - Remove the element from the tree.
 * - Heapify the tree again.
 * <p>
 * Time complexity: O(log(N)) for insertion and deletion, O(1) for access
 * Space complexity: O(N)
 */
public class _1MaxHeap {

    ArrayList<Integer> heap;

    public _1MaxHeap() {
        heap = new ArrayList<>();
    }

    public void add(int num) {
        heap.add(num);
        heapifyUp(size() - 1);
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(parentIndex) >= heap.get(index)) {
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
        int maxElement = heap.getFirst();
        heap.set(0, heap.getLast());
        heap.removeLast();
        heapifyDown(0);
        return maxElement;
    }

    private void heapifyDown(int index) {
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
        return size() > 0 ? heap.getFirst() : -1;
    }

    public int size() {
        return heap.size();
    }

    public void display() {
        System.out.println(heap);
    }

    public static void main(String[] args) {
        _1MaxHeap maxHeap = new _1MaxHeap();
        int[] values = {10, 7, 11, 5, 4, 13};
        for (int value : values) {
            maxHeap.add(value);
            maxHeap.display();
        }
        while (maxHeap.size() > 0) {
            System.out.print(maxHeap.remove() + " ");
        }
    }
}