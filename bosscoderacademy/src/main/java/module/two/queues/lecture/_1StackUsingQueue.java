package module.two.queues.lecture;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement Stack using Queues:
 * <p>
 * Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of
 * a normal stack (push, top, pop, and empty).
 * <p>
 * Implement the MyStack class:
 * - void push(int x) Pushes element x to the top of the stack.
 * - int pop() Removes the element on the top of the stack and returns it.
 * - int top() Returns the element on the top of the stack.
 * - boolean empty() Returns true if the stack is empty, false otherwise.
 * <p>
 * Notes:
 * You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty
 * operations are valid.
 * Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque
 * (double-ended queue) as long as you use only a queue's standard operations.
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["MyStack", "push", "push", "top", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * Output
 * [null, null, null, 2, 2, false]
 * <p>
 * Explanation
 * MyStack myStack = new MyStack();
 * myStack.push(1);
 * myStack.push(2);
 * myStack.top(); // return 2
 * myStack.pop(); // return 2
 * myStack.empty(); // return False
 * <p>
 * Constraints:
 * 1 <= x <= 9
 * At most 100 calls will be made to push, pop, top, and empty.
 * All the calls to pop and top are valid.
 * <p>
 * Follow-up: Can you implement the stack using only one queue?
 * <p>
 * Refer: https://leetcode.com/problems/implement-stack-using-queues/description/
 */
public class _1StackUsingQueue {

    private Queue<Integer> queue;
    private int size;

    public _1StackUsingQueue() {
        this.queue = new LinkedList<Integer>();
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
        if (this.empty()) {
            return -1;
        }
        this.size--;
        return this.queue.poll();
    }

    public int top() {
        if (this.empty()) {
            return -1;
        }
        return this.queue.peek();
    }

    public boolean empty() {
        return this.size == 0;
    }

    public static void main(String[] args) {
        _1StackUsingQueue stackUsingQueue = new _1StackUsingQueue();
        stackUsingQueue.push(1);
        stackUsingQueue.push(2);
        System.out.println("Top: " + stackUsingQueue.top());
        System.out.println("Popped: " + stackUsingQueue.pop());
        System.out.println("Is empty: " + stackUsingQueue.empty());
        System.out.println("Top: " + stackUsingQueue.top());
        System.out.println("Popped: " + stackUsingQueue.pop());
        System.out.println("Is empty: " + stackUsingQueue.empty());
        System.out.println("Top: " + stackUsingQueue.top());
        System.out.println("Popped: " + stackUsingQueue.pop());
        System.out.println("Is empty: " + stackUsingQueue.empty());
    }

}
