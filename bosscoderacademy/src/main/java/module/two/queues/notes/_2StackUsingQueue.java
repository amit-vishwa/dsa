package module.two.queues.notes;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement Stack Using Queue:
 * <p>
 * Implement a last-in-first-out (LIFO) stack using  queues. The implemented stack should support all the functions of a normal
 * stack (push, top, pop, and empty).
 * Implement the MyStack class.
 * <p>
 * Example
 * Input: ["MyStack", "push", "push", "top", "pop", "empty"] [[], [1], [2], [], [], []]
 * Output: [null, null, null, 2, 2, false]
 * <p>
 * Approach 1 using 2 queues
 * The idea is to keep newly entered element at the front of ‘q1’ so that pop operation dequeues from ‘q1’. ‘q2’ is used to put
 * every new element in front of ‘q1’.
 * <p>
 * Approach 2 using Single Queue
 * As we know stack follows last in first out, which means we get the most recently inserted element whenever we remove an
 * element from the stack. But queue follows first in first out, which means we get that element which we inserted in the
 * starting at each deletion, it means if we want to use the queue like a stack we have to arrange elements in the queue such
 * that we get the most recent element at each deletion.
 * <p>
 * Time and space complexity is O(N).
 */
public class _2StackUsingQueue {

    private int size;
    private Queue<Integer> queue;

    public _2StackUsingQueue() {
        this.queue = new LinkedList<>();
        this.size = 0;
    }

    public void push(int x) {
        this.queue.offer(x);
        this.size++;
        for (int i = 0; i < this.size - 1; i++) {
            int front = this.queue.poll();
            this.queue.offer(front);
        }
    }

    public int pop() {
        return this.queue.isEmpty() ? -1 : this.queue.poll();
    }

    public int peek() {
        return this.queue.isEmpty() ? -1 : this.queue.peek();
    }

    public boolean empty() {
        return this.queue.isEmpty();
    }

    public static void main(String[] args) {
        _2StackUsingQueue stackUsingQueue = new _2StackUsingQueue();
        stackUsingQueue.push(1);
        stackUsingQueue.push(2);
        stackUsingQueue.push(3);
        System.out.println(stackUsingQueue.peek());
        System.out.println(stackUsingQueue.pop());
        System.out.println(stackUsingQueue.empty());
        System.out.println(stackUsingQueue.peek());
        System.out.println(stackUsingQueue.pop());
        System.out.println(stackUsingQueue.empty());
        System.out.println(stackUsingQueue.peek());
        System.out.println(stackUsingQueue.pop());
        System.out.println(stackUsingQueue.empty());
    }

}
