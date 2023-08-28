public class Stack {
    Node[] arr; // regular array
    int capacity;
    int size;

    public Stack(int cap) {
        arr = new Node[cap];
        capacity = cap;
    }

    public void push(Node node) {
        if (!isFull()) {
            arr[size++] = node;
        } else {
            System.out.println("Stack Overflow!!!");
        }
    }

    public Node pop() {
        if (!isEmpty()) {
            return arr[--size];
        } else {
            System.out.println("Stack Underflow!!!");
        }
        return null; // fix this (out of place)
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printStack() {
        if (!isEmpty()) {
            System.out.print("[Bottom] ");
            for (int i = 0; i < size; i++) {
                System.out.print((arr[i]).data + " ");
            }
            System.out.println("[Top]");
        } else {
            System.out.println("Empty Stack!!!");
        }
    }
}