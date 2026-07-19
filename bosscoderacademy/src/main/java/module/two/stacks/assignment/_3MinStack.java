package module.two.stacks.assignment;

import java.util.List;
import java.util.Stack;

/**
 * Min Stack:
 * <p>
 * You are given N elements and your task is to Implement a Stack.
 * You are required to complete the three methods push() which takes one argument an integer 'x' to be pushed into the stack,
 * pop() which returns an integer popped out from the stack, and getMin() which returns the min element from the stack.
 * (-1 will be returned if for pop() and getMin() the stack is empty.)
 * <p>
 * Input:
 * push(2)
 * push(3)
 * pop()
 * getMin()
 * push(1)
 * getMin()
 * <p>
 * Output: 2 1
 * <p>
 * Explanation: In the first test case for query
 * <p>
 * push(2) Insert 2 into the stack.
 * The stack will be {2}
 * <p>
 * push(3) Insert 3 into the stack.
 * The stack will be {2 3}
 * <p>
 * pop() Remove top element from stack
 * Poped element will be 3 the stack will be {2}
 * <p>
 * getMin() Return the minimum element
 * min element will be 2
 * <p>
 * push(1) Insert 1 into the stack.
 * The stack will be {2 1}
 * <p>
 * getMin() Return the minimum element
 * min element will be 1
 * <p>
 * Constraints:
 * 1 <= Number of queries <= 100
 * 1 <= values of the stack <= 100
 * <p>
 * Refer _1MinStack.java from package module.two.stacks.lecture;
 */
public class _3MinStack {

    int minEle;
    Stack<List<Integer>> s;

    _3MinStack() {
        this.minEle = Integer.MAX_VALUE;
        this.s = new Stack<>();
    }

    /*returns min element from stack*/
    int getMin() {
        // Your code here
        return s.empty() ? -1 : s.peek().get(1);
    }

    /*returns popped element from stack*/
    int pop() {
        // Your code here
        return s.empty() ? -1 : s.pop().get(0);
    }

    /*push element x into the stack*/
    void push(int x) {
        // Your code here
        minEle = Math.min(minEle, x);
        s.push(List.of(x, minEle));
    }

    public static void main(String[] args) {
        _3MinStack stack = new _3MinStack();
        stack.push(2);
        stack.push(3);
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.getMin());
        stack.push(1);
        System.out.println("Pop: " + stack.getMin());
    }

}
