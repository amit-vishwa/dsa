package prerequisites.week4.lesson4;

class Node {
    int data;
    Node next;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return "{ Data: " + this.data + ", Node: " + this.next + " }";
    }
}
