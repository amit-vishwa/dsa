package prerequisites.week4.lesson4;

/**
 * https://platform.bosscoderacademy.com/prerequisites-editor/ll_creation_and_traversal?prerequisites=True
 */
public class LinkedListExample {

    public static void main(String[] args) {
        display(efficientLinkedList(new int[]{2, 1, 0, 1, 2}));
        display(efficientLinkedList(new int[]{0, 1, 2}));
        display(linkedList(new int[]{2, 1, 0, 1, 2}));
        display(linkedList(new int[]{0, 1, 2}));
    }

    static Node efficientLinkedList(int[] arr) {
        Node head = new Node(arr[0]); // works for non-empty list
        Node current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }
        return head;
    }

    static Node linkedList(int[] arr) {
        Node head = null;
        for (int n : arr) {
            head = add(n, head);
        }
        return head;
    }

    static Node add(int n, Node head) {
        Node node = new Node(n);
        if (head == null) {
            head = node;
            return head;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        return head;
    }

    static void display(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

}
