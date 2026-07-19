package module.two.bst;

public class BinarySearchTree {

    public Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public Node insert(Node node, int val) {
        if (node == null) {
            return new Node(val);
        }
        if (val < node.data) {
            node.left = insert(node.left, val);
        } else {
            node.right = insert(node.right, val);
        }
        return node;
    }

    public Node delete(Node node, int val) {
        if (node == null) {
            return null;
        }
        if (val < node.data) {
            node.left = delete(node.left, val);
        } else if (val > node.data) {
            node.right = delete(node.right, val);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                Node temp = node.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                node.data = temp.data;
                node.right = delete(node.right, node.data);
            }
        }
        return node;
    }

    public void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.data + " -> ");
        inorder(node.right);
    }

    public void preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " -> ");
        preorder(node.left);
        preorder(node.right);
    }

    public static void display(Node node, int traversal) {
        if (traversal == 1) {
            new BinarySearchTree().inorder(node);
        } else if (traversal == 2) {
            new BinarySearchTree().preorder(node);
        }
        System.out.println("null");
    }

}
