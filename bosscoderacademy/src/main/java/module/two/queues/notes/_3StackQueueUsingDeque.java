package module.two.queues.notes;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Implement Stack and Queue using Deque:
 * <p>
 * Deque also known as a double-ended queue, as the name suggests is a special kind of queue in which insertions and deletions
 * can be done at the last as well as at the beginning.
 * <p>
 * Approach
 * Deque is a double-ended queue, i.e. a special kind of queue in which insertion and deletion can be done at the both rear as
 * well as the front end of the queue.
 * <p>
 * Some Functions of deque work the same as the functions of stack and queue.
 * <p>
 * Operations of Deque: *
 * 1. size(): This function returns the size of the deque.
 * 2. isEmpty(): This function returns true if the deque is empty else false.
 * 3. Insert_First(element): This function will insert an element in the deque at the front end.
 * 4. Insert_Last(element): This function will insert an element in the deque at the rear end.
 * 5. Remove_First(): This function will remove the element from the deque which is present at the front end.
 * 6. Remove_Last(): This function will remove the element from the deque which is present at the rear end.
 * <p>
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class _3StackQueueUsingDeque {

    public static void main(String[] args) {
        stackOperations();
        queueOperations();
    }

    private static void stackOperations() {
        System.out.println("\nStack operations:");
        StackUsingDeque stack = new StackUsingDeque();
        stack.push(3);
        stack.push(2);
        stack.push(4);
        stack.push(1);

        System.out.println("Top of the stack: " + stack.peek());
        System.out.println("Size of the stack: " + stack.size());

        stack.pop();
        System.out.println("Top of the stack after pop: " + stack.peek());
        System.out.println("Size of the stack after pop: " + stack.size());
    }

    private static void queueOperations() {
        System.out.println("\nQueue operations:");
        QueueUsingDeque queue = new QueueUsingDeque();
        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(4);
        queue.enqueue(1);

        System.out.println("Front of the queue: " + queue.front());
        System.out.println("Size of the queue: " + queue.size());

        queue.dequeue();
        System.out.println("Front of the queue after dequeue: " + queue.front());
        System.out.println("Size of the queue after dequeue: " + queue.size());
    }

}

class StackUsingDeque {
    Deque<Integer> stack;

    public StackUsingDeque() {
        stack = new ArrayDeque<>();
    }

    public void push(int x) {
        stack.offerLast(x);
    }

    public int pop() {
        return this.empty() ? -1 : this.stack.pollLast();
    }

    public int peek() {
        return this.empty() ? -1 : this.stack.peekLast();
    }

    public boolean empty() {
        return this.stack.isEmpty();
    }

    public int size() {
        return this.stack.size();
    }
}

class QueueUsingDeque {
    Deque<Integer> queue;

    public QueueUsingDeque() {
        queue = new ArrayDeque<>();
    }

    public void enqueue(int x) {
        queue.offerLast(x);
    }

    public int dequeue() {
        return this.empty() ? -1 : this.queue.pollFirst();
    }

    public int front() {
        return this.empty() ? -1 : this.queue.peekFirst();
    }

    public boolean empty() {
        return this.queue.isEmpty();
    }

    public int size() {
        return this.queue.size();
    }
}