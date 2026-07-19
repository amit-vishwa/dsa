package module.two.linkedlist.one.notes;

/**
 * Linked List:
 * <p>
 * A linked list is a data structure made of one or more nodes. Each node contains a value and a pointer to the previous/next
 * node forming the chain-like structure. These nodes are stored randomly in the system's memory, which improves its space
 * complexity compared to the array. It is a type of Linear Data Structure.
 * A Linked List is a linear data structure where elements are stored in a non-contiguous manner, using nodes.
 * <p>
 * Each node consists of two parts:
 * - Data: Holds the actual value (or payload) of the element.
 * - Next Pointer/Reference: Points to the next node in the sequence.
 * <p>
 * Types of linked list
 * - Singly-linked list: Each node contains data and a reference to the next node.
 * - Doubly linked list: Each node contains data, a reference to the next node, and a reference to the previous node.
 * - Circular linked list: Similar to a singly or doubly linked list, but the last node points back to the first node (circular fashion).
 * <p>
 * Time complexity:
 * - Insertion/Deletion at start - O(1)
 * - Insertion/Deletion at position or end - O(N)
 * Space complexity: O(N)
 */
public class _1CustomLinkedList<T> {

    class Node<T> {
        T data;
        Node<T> next;

        public Node() {
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    Node<T> head;
    int size;

    public _1CustomLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void insertAtStart(T data) {
        Node<T> start = new Node<>(data, null);
        start.next = this.head;
        this.head = start;
        this.size++;
    }

    public T deleteAtStart() {
        if (this.empty()) {
            System.out.println("Data cannot be deleted!");
            return null;
        }
        T data = this.head.data;
        this.head = this.head.next;
        this.size--;
        return data;
    }

    public void insertAtEnd(T data) {
        if (this.head == null) {
            insertAtStart(data);
            return;
        }
        Node<T> temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node<>(data, null);
        this.size++;
    }

    public T deleteAtEnd() {
        if (this.empty()) {
            System.out.println("Data cannot be deleted!");
            return null;
        }
        Node<T> temp = this.head;
        while (temp.next != null && temp.next.next != null) {
            temp = temp.next;
        }
        T data = temp.next.data;
        temp.next = null;
        this.size--;
        return data;
    }

    public void insertAtPosition(T data, int index) {
        if (index > this.size || index < 0) {
            System.out.println("Invalid index provided!");
            return;
        }
        if (index == 0) {
            this.insertAtStart(data);
            return;
        }
        if (index == this.size) {
            this.insertAtEnd(data);
            return;
        }
        int pos = 1;
        Node<T> temp = this.head;
        while (pos < index) {
            temp = temp.next;
            pos++;
        }
        Node<T> node = new Node<>(data, null);
        node.next = temp.next;
        temp.next = node;
        this.size++;
    }

    public T deleteAtPosition(int index) {
        if (index >= this.size || index < 0) {
            System.out.println("Invalid index provided!");
            return null;
        }
        if (index == 0) {
            return this.deleteAtStart();
        }
        if (index == this.size - 1) {
            return this.deleteAtEnd();
        }
        int pos = 1;
        Node<T> temp = this.head;
        while (pos < index) {
            temp = temp.next;
            pos++;
        }
        if (temp.next != null) {
            T data = temp.data;
            temp.data = temp.next.data;
            temp.next = temp.next.next;
            this.size--;
            return data;
        } else {
            return this.deleteAtEnd();
        }
    }

    public T getFirst() {
        return this.empty() ? null : this.head.data;
    }

    public int size() {
        return this.size;
    }

    public boolean empty() {
        return this.size == 0;
    }

    public void display() {
        Node<T> temp = this.head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        integerExample();
        stringExample();
    }

    private static void integerExample() {
        _1CustomLinkedList<Integer> list = new _1CustomLinkedList<>();
        System.out.println("-------------------INSERTION OF INTEGERS--------------------");
        System.out.println(list.size());
        list.insertAtPosition(4, 4);
        list.display();
        list.insertAtPosition(4, 0);
        list.display();
        list.insertAtStart(1);
        list.display();
        list.insertAtPosition(3, 3);
        list.display();
        list.insertAtPosition(3, 2);
        list.display();
        list.insertAtEnd(5);
        list.display();
        list.insertAtPosition(4, 3);
        System.out.println(list.size());
        list.display();
        System.out.println();

        System.out.println("-------------DELETION OF INTEGERS-----------");
        System.out.println("Delete at index 10: " + list.deleteAtPosition(10));
        System.out.println("Delete at start: " + list.deleteAtStart());
        list.display();
        System.out.println(list.size());
        System.out.println(list.empty());
        System.out.println("Delete at end: " + list.deleteAtEnd());
        list.display();
        System.out.println("Delete at index 2: " + list.deleteAtPosition(2));
        list.display();
        System.out.println(list.size());
        System.out.println();
    }

    private static void stringExample() {
        _1CustomLinkedList<String> list = new _1CustomLinkedList<>();
        System.out.println("--------------------INSERTION OF STRINGS------------------------");
        System.out.println(list.size());
        list.insertAtPosition("hello", 4);
        list.display();
        list.insertAtPosition("hi", 0);
        list.display();
        list.insertAtStart("who");
        list.display();
        list.insertAtPosition("you", 3);
        list.display();
        list.insertAtPosition("are", 2);
        list.display();
        list.insertAtEnd("you");
        list.display();
        list.insertAtPosition("now", 3);
        System.out.println(list.size());
        list.display();
        System.out.println();
    }

}
