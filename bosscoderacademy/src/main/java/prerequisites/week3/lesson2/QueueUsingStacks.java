package prerequisites.week3.lesson2;

import java.util.Stack;

/**
 * Implement a queue using 2 stacks with basic queue operations.
 * https://platform.bosscoderacademy.com/prerequisites-editor/queue_impl_using_2stacks?prerequisites=True
 */
public class QueueUsingStacks {

    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) {
        enqueue(1);
        enqueue(2);
        enqueue(3);
        enqueue(4);
        System.out.println(stack1.reversed());
        System.out.println(stack2);
        System.out.println(dequeue() + " " + peek());
    }

    static void enqueue(int n) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack2.push(n);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    static int dequeue() {
        return stack1.pop();
    }

    static int peek() {
        return stack1.peek();
    }

}
