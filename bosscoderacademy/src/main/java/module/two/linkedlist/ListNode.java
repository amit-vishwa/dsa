package module.two.linkedlist;

public class ListNode {

    public Node head;

    public ListNode() {
    }

    public void insert(int x) {
        if (head == null) {
            head = new Node(x, null);
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(x, null);
        }
    }

    public Node convertToLL(int[] arr) {
        for (int data : arr) {
            this.insert(data);
        }
        this.display();
        return this.head;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void display(Node temp) {
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

}
