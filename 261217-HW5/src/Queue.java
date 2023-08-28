public class Queue {
    Node[] arr; // circular array
    int capacity;
    int front;
    int back;
    int size;

    public Queue(int cap) {
        arr = new Node[cap];
        capacity = cap;
    }

    public void enqueue(Node node) {
        if (!isFull()) {
            arr[back++] = node;
            size++;
            back = back % capacity;
        } else {
            System.out.println("Queue Overflow!!!");
        }
    }

    public Node dequeue() {
        if (!isEmpty()) {
            Node temp = arr[front++];
            size--;
            front = front % capacity;
            return temp;
        } else {
            System.out.println("Queue Underflow!!!");
        }
        return null; // fix this (out of place)
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void printCircularIndices() {
        System.out.println("Front index = " + front + " Back index = " + back);
    }

    public void printQueue() {
        if (!isEmpty()) {
            System.out.print("[Front] ");
            if (front < back) {
                for (int i = front; i < back; i++) {
                    System.out.print(arr[i].data + " ");
                }
            } else {
                for (int i = front; i < capacity; i++) {
                    System.out.print(arr[i].data + " ");
                }
                for (int i = 0; i < back; i++) {
                    System.out.print(arr[i].data + " ");
                }
            }
            System.out.println("[Back]");
        } else {
            System.out.println("Empty Queue!!!");
        }
    }
}