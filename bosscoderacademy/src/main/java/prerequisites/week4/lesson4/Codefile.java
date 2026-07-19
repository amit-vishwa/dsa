package prerequisites.week4.lesson4;

public class Codefile {

    public static void main(String[] args) {
        System.out.println(new Codefile().createLLandPrint(new int[]{2, 1, 0, 1, 2}));
        System.out.println(new Codefile().createLLandPrint(new int[]{0, 1, 2}));
    }

    Node createLLandPrint(int[] input) {
        // code here
        Node head = null;
        for (int i = 0; i < input.length; i++) {
            Node node = new Node(input[i]);
            if (head == null) {
                head = node;
                continue;
            }
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
        return head;
    }

}

