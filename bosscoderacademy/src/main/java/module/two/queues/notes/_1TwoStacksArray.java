package module.two.queues.notes;

/**
 * Implement two Stacks in an Array:
 * <p>
 * Create a data structure twoStacks that represent two stacks. Implementation of twoStacks should use only one array, i.e.,
 * both stacks should use the same array for storing elements.
 * <p>
 * Approach:
 * In this approach, the starting index of both stacks is chosen as the extreme corners of the stack, i.e. from the leftmost
 * and rightmost corner indices. Iteration is continued for every element and the array starts to shrink towards the middle
 * while storing elements. The space between the top elements of the stacks is checked and if there is space, the elements are
 * stored in those indices.
 * <p>
 * Time and space complexity: O(N)
 */
public class _1TwoStacksArray {

    int size, top1, top2;
    int[] arr;

    _1TwoStacksArray(int n) {
        this.size = n;
        this.arr = new int[this.size];
        this.top1 = -1;
        this.top2 = this.size;
    }

    void push1(int x) {
        if (this.top1 < this.top2 - 1) {
            this.arr[++this.top1] = x;
        } else {
            System.out.println("Stack overflow by " + x);
        }
    }

    void push2(int x) {
        if (this.top1 < this.top2 - 1) {
            this.arr[--this.top2] = x;
        } else {
            System.out.println("Stack overflow by " + x);
        }
    }

    int pop1() {
        if (this.top1 < 0) {
            System.out.println("Stack underflow");
            return -1;
        }
        return this.arr[this.top1--];
    }

    int pop2() {
        if (this.top2 >= this.size) {
            System.out.println("Stack underflow");
            return -1;
        }
        return this.arr[this.top2++];
    }


    public static void main(String[] args) {
        _1TwoStacksArray twoStacksArray = new _1TwoStacksArray(6);
        twoStacksArray.push1(2);
        twoStacksArray.push2(2);
        twoStacksArray.push1(3);
        twoStacksArray.push2(3);
        twoStacksArray.push1(4);
        twoStacksArray.push2(4);
        twoStacksArray.push1(2);
        for (int i = 0; i < 3; i++) {
            System.out.println(twoStacksArray.pop1());
        }
        for (int i = 0; i < 4; i++) {
            System.out.println(twoStacksArray.pop2());
        }
    }

}
