package module.two.linkedlist.one.notes;

/**
 * Implementation of Stack using Linked List:
 * <p>
 * To implement stack using linked list. Stack uses the LIFO concept. The main advantage of using a linked list over arrays is
 * that it is possible to implement a stack that can shrink or grow as much as needed. Using an array will put a restriction on
 * the maximum capacity of the array which can lead to stack overflow. Here each new node will be dynamically allocated. So
 * overflow is not possible.
 * <p>
 * Time Complexity: O(1)
 * Space Complexity: O(N)
 */
public class _2StackUsingLL<T> {

    private _1CustomLinkedList<T> list;

    public _2StackUsingLL() {
        this.list = new _1CustomLinkedList<>();
    }

    public void push(T val) {
        this.list.insertAtStart(val);
    }

    public T pop() {
        if (empty()) {
            System.out.println("Stack underflow!");
            return null;
        }
        return this.list.deleteAtStart();
    }

    public T peek() {
        if (empty()) {
            System.out.println("Stack underflow!");
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
        _2StackUsingLL<Integer> stack = new _2StackUsingLL<>();
        System.out.println("Empty: " + stack.empty());
        stack.push(5);
        stack.push(10);
        stack.push(15);
        System.out.println("Size: " + stack.size());
        System.out.println("Top of the stack: " + stack.peek());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Top of the stack after pop: " + stack.peek());
        System.out.println("Size: " + stack.size());
        System.out.println("Empty: " + stack.empty());
    }

}
