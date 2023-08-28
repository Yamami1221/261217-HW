public class Node {
    int shares;
    double price;
    Node next;

    public Node(int shares, double price) {
        this.shares = shares;
        this.price = price;
    }
}

interface List {
    public void push(Node node);

    public void pop();

    public Node top();
}