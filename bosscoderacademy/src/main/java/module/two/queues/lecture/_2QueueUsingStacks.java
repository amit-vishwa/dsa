package module.two.queues.lecture;

import java.util.Stack;

/**
 * Implement Queue using Stacks:
 * <p>
 * Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of
 * a normal queue (push, peek, pop, and empty).
 * <p>
 * Implement the MyQueue class:
 * - void push(int x) Pushes element x to the back of the queue.
 * - int pop() Removes the element from the front of the queue and returns it.
 * - int peek() Returns the element at the front of the queue.
 * - boolean empty() Returns true if the queue is empty, false otherwise.
 * <p>
 * Notes:
 * You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty
 * operations are valid.
 * Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque
 * (double-ended queue) as long as you use only a stack's standard operations.
 * <p>
 * Refer: https://leetcode.com/problems/implement-queue-using-stacks/description/
 */
public class _2QueueUsingStacks {

    private int size;

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public _2QueueUsingStacks() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
        this.size = 0;
    }

    public void push(int x) {
        while (!this.stack1.empty()) {
            this.stack2.push(this.stack1.pop());
        }
        this.stack1.push(x);
        this.size++;
        while (!this.stack2.empty()) {
            this.stack1.push(this.stack2.pop());
        }
    }

    public int pop() {
        if (this.empty()) {
            return -1;
        }
        this.size--;
        return this.stack1.pop();
    }

    public int peek() {
        if (this.empty()) {
            return -1;
        }
        return this.stack1.peek();
    }

    public boolean empty() {
        return this.size == 0;
    }

    public static void main(String[] args) {
        _2QueueUsingStacks queueUsingStacks = new _2QueueUsingStacks();
        queueUsingStacks.push(1);
        queueUsingStacks.push(2);
        System.out.println("Peek: " + queueUsingStacks.peek());
        System.out.println("Pop: " + queueUsingStacks.pop());
        System.out.println("Is empty: " + queueUsingStacks.empty());
        System.out.println("Peek: " + queueUsingStacks.peek());
        System.out.println("Pop: " + queueUsingStacks.pop());
        System.out.println("Is empty: " + queueUsingStacks.empty());
        System.out.println("Peek: " + queueUsingStacks.peek());
        System.out.println("Pop: " + queueUsingStacks.pop());
        System.out.println("Is empty: " + queueUsingStacks.empty());
    }

}
