package module.two.stacks.notes;

import java.util.ArrayList;
import java.util.List;

/**
 * Min Stack:
 * <p>
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * Implement the MinStack class:
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * You must implement a solution with O(1) time complexity for each function.
 * <p>
 * Example 1:
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * Output
 * [null,null,null,null,-3,null,0,-2]
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 * <p>
 * Constraints:
 * -2^31 <= val <= 2^31 - 1
 * Methods pop, top and getMin operations will always be called on non-empty stacks.
 * At most 3 * 10^4 calls will be made to push, pop, top, and getMin.
 */
public class _2MinStack {

    int size = -1;
    ArrayList<ArrayList<Integer>> list;
    int min = Integer.MAX_VALUE;

    public _2MinStack() {
        list = new ArrayList<>();
    }

    /**
     * Approach:
     * - We have kept index as -1, min as max and initialized list of list as well.
     * - Now on push, we are incrementing index first then updating min till now and adding val and min val in list i.e. stack.
     * - For pop, we are just reducing the index.
     * - For top, just return the 1st element of current index element from stack list.
     * - Similarly for getMin just return the second element.
     * - All operations take constant time.
     */
    public void push(int val) {
        this.size++;
        this.min = Math.min(this.min, val);
        list.add(this.size, new ArrayList<>(List.of(val, this.min)));
    }

    public void pop() {
        this.size--;
    }

    public int top() {
        return list.get(this.size).get(0);
    }

    public int getMin() {
        return list.get(this.size).get(1);
    }

    public static void main(String[] args) {
        // Your MinStack object will be instantiated and called as such:
        _2MinStack minStack = new _2MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }

}
