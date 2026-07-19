package module.two.stacks.notes;

import java.util.ArrayList;

/**
 * Stack:
 * <p>
 * Stack is a linear data structure in which the element inserted last is the element to be deleted first.It is also called
 * Last In First Out (LIFO).In a stack, the last inserted element is at the top. *
 * Operations of the stack are:
 * 1. push(): inserts an element into the stack at the end
 * 2. pop(): deletes and returns the last inserted element from the stack
 * 3. top(): returns the last inserted element
 * <p>
 * Implement a stack using an array.
 * Example
 * push(): Insert the element in the stack.
 * pop(): Remove and return the topmost element of the stack.
 * top(): Return the topmost element of the stack
 * size(): Return the number of remaining elements in the stack.
 * <p>
 * Approach
 * As we know stack works on the principle of last in first out, so we have to put elements in an array such that it keeps track
 * of the most recently inserted element. Hence we can think of using a Top variable which will help in keeping track of recent
 * elements inserted in the array.
 * <p>
 * Stack operations have O(1) time complexities.
 */
public class _1StackUsingArray {

    private int size;
    private ArrayList<Integer> list;

    public _1StackUsingArray() {
        this.size = -1;
        this.list = new ArrayList<>();
    }

    public void push(int val) {
        this.list.add(++this.size, val);
    }

    public int pop() {
        int val = this.top();
        if (val != -1) {
            this.size--;
        }
        return val;
    }

    public int top() {
        return this.size >= 0 ? this.list.get(this.size) : -1;
    }

    public int size() {
        return this.size + 1;
    }

    public static void main(String[] args) {
        _1StackUsingArray stack = new _1StackUsingArray();
        stack.push(6);
        stack.push(3);
        stack.push(7);
        System.out.println("Top element: " + stack.top());
        System.out.println("Size before deleting any element: " + stack.size());
        System.out.println("The element deleted is: " + stack.pop());
        System.out.println("Size after deleting an element: " + stack.size());
        System.out.println("Top element: " + stack.top());
    }

}
