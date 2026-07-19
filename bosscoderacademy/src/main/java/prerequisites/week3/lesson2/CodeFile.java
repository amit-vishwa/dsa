package prerequisites.week3.lesson2;

import java.util.Stack;

/**
 * This demonstrates the code to pass testcases for Run button:
 * https://platform.bosscoderacademy.com/prerequisites-editor/queue_impl_using_2stacks?prerequisites=True
 * */
public class CodeFile {

    static Stack<String> s1 = new Stack<>();
    static Stack<String> s2 = new Stack<>();

    static void Enqueue(int value) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s2.push(value + " ");
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    static String Dequeue() {
        return s1.pop();
    }

    static String Peek() {
        return s1.peek();
    }

    public static void main(String[] args) {
        Enqueue(1);
        Enqueue(2);
        System.out.print(Dequeue());
        System.out.print(Dequeue());
        Enqueue(3);
        System.out.print(Peek());
    }

}