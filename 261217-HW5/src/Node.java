public class Node extends BTreePrinter {
    Node left;
    Node right;
    int data;

    public Node(int data) {
        this.data = data;
    }

    public void printTree() {
        super.printTree(this);
    }

    Node constructTree1() {
        Node root = new Node(3);

        root.left = new Node(7);
        root.right = new Node(5);

        root.left.left = new Node(2);
        root.left.right = new Node(6);

        root.left.right.left = new Node(1);
        root.left.right.right = new Node(8);

        root.right.right = new Node(9);

        root.right.right.left = new Node(4);

        return root;
    }

    Node constructTree2() {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.left.right.left = new Node(7);
        root.left.right.right = new Node(8);

        root.left.right.right.right = new Node(10);

        root.right.right = new Node(6);

        root.right.right.left = new Node(9);

        return root;
    }

    public void printBFT() {
        Queue q = new Queue(50);
        System.out.print("BFT node sequence [ ");

        q.enqueue(this);
        while (!q.isEmpty()) {
            Node node = q.dequeue();
            System.out.print(node.data + " ");
            if (node.left != null)
                q.enqueue(node.left);
            if (node.right != null)
                q.enqueue(node.right);
        }

        System.out.println("]");
    }

    public void printDFT() { // PreOrder
        Stack s = new Stack(50);
        System.out.print("DFT node sequence [ ");

        s.push(this);
        while (!s.isEmpty()) {
            Node node = s.pop();
            System.out.print(node.data + " ");
            if (node.right != null)
                s.push(node.right);
            if (node.left != null)
                s.push(node.left);
        }

        System.out.println("]");
    }
}