public class Heap {

    int capacity;
    Node[] arr;
    int size;

    boolean isMinHeap; // true if minHeap, false if maxHeap

    int timer; // For each push, the timer will increase by 1

    public Heap(boolean isMinHeap, int cap) {
        // Initialize the heap here
        // Don't forget that we will build the binary heap using...
        // ... the concept of "Complete binary tree based on the array implementation"
        // ... The 0 index will not be used, The index starts from 1 (remember?)
        this.isMinHeap = isMinHeap;
        capacity = cap;
        arr = new Node[capacity + 1];
    }

    public Node top() {
        // Return the root node
        return arr[1];
    }

    public void push(Node node) {
        // Increase timer each time you push something into the Queue
        timer++;
        node.timestamp = timer; // Stamp the time number to the node

        // To do:
        // 1. Push the new node at the end of the array (via back pointer)
        // 2. Sift (percolate) it up the heap
        // * Check priority of the current node with its parent
        // * Swap the current node if the priority is higher than the parent
        // * Repeat the process until reaching the root or there is no swap (Pls use
        // while loop)
        // 3. Increase the heap size
        node.isMinHeap = isMinHeap;
        int current = ++size;
        arr[current] = node;
        while (current > 1) {
            if (node.compare(arr[current/2])) {
                swap(current, current / 2);
            }
            current /= 2;
        }
    }

    public Node pop(){
        
        // To do:
        // 1. Mark the root for return (Don't forget to return this node)
        // 2. Move the last node to the root (change pointer, set null)
        // 3. Decrease the heap size
        // 4. Sift (percolate) it down the heap
        //      * Check priority of the current node with both children
        //      * Swap the current node with the lower priority child
        //      * Repeat the process until the node has no child or there is no swap (Pls use while loop)

        Node root = arr[1];
        arr[1] = arr[size--];
        arr[size+1] = null;
        int current = 1;
        int left = current * 2;
        int right = (current * 2) + 1;
        while(arr[left] != null) {
            if (arr[right] != null) {
                if (arr[left].compare(arr[right])) {
                    if (arr[left].compare(arr[current])) {
                        swap(current, left);
                        current = left;
                    } else {
                        break;
                    }
                } else {
                    if (arr[right].compare(arr[current])) {
                        swap(current, right);
                        current = right;
                    } else {
                        break;
                    }
                }
            } else {
                if (arr[left].compare(arr[current])) {
                    swap(current, left);
                    current = left;
                } else {
                    break;
                }
            }
            left = current * 2;
            right = (current * 2) + 1;
        }
        return root;
    }

    // This is an optional function, you may use it if you know what it is
    // This function is complete, no need to edit
    public void swap(int index1, int index2) {
        Node temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}
