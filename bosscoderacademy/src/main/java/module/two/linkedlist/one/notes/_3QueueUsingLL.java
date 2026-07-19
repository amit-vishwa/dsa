package module.two.linkedlist.one.notes;

/**
 * Implementation of Queue using Linked List:
 * <p>
 * To Solve this Problem we will maintain two pointers front and rear. A queue is a linear data structure that follows the
 * First in, First out principle(FIFO). Queue supports operations like enqueue and dequeue. It can be implemented using an array
 * and linked list. The benefit of implementing a queue using a linked list over arrays is that it allows the growth of the
 * queue as per the requirements, i.e., memory can be allocated dynamically.
 * <p>
 * Time Complexity: O(1)
 * Space Complexity: O(N)
 */
public class _3QueueUsingLL<T> {

    private _1CustomLinkedList<T> list;

    public _3QueueUsingLL() {
        this.list = new _1CustomLinkedList<>();
    }

    public void enqueue(T val) {
        this.list.insertAtEnd(val);
    }

    public T dequeue() {
        if (empty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        return this.list.deleteAtStart();
    }

    public T peek() {
        if (empty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        return this.list.getFirst();
    }

    public boolean empty() {
        return this.list.empty();
    }

    public int size() {
        return this.list.size();
    }

    public static void main(String[] args) {
        _3QueueUsingLL<Integer> queue = new _3QueueUsingLL<>();
        System.out.println("Empty? " + queue.empty());
        System.out.println("Size: " + queue.size());
        queue.enqueue(5);
        queue.enqueue(10);
        queue.enqueue(15);
        System.out.println("Empty? " + queue.empty());
        System.out.println("Size: " + queue.size());
        System.out.println("Front of the queue: " + queue.peek());
        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Front of the queue after dequeue: " + queue.peek());
        System.out.println("Empty? " + queue.empty());
        System.out.println("Size: " + queue.size());
    }

}
