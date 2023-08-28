public class AdvanceDynamicArray {
    private int[] arr;
    private int capacity;
    private int size; // Last element can be indexed at size-1
    
    public AdvanceDynamicArray(int cap){ // Class Constructor
        arr = new int[cap];
        capacity = cap;
    }
    
    public void pushBack(int data){
        if (size == capacity) {
            int[] temp = new int[capacity * 2];
            for (int i = 0; i < size; i++) {
                temp[i] = arr[i];
            }
            arr = temp;
            capacity *= 2;
        }
        arr[size++] = data;
    }
    public int popBack(){
        if (size == 0) {
            System.out.println("ERROR");
            return 0;
        }
        return arr[--size];
    }

    public int get(int i){
        if (i >= size || i < 0) {
            System.out.println("ERROR");
            return 0;
        }
        return arr[i];
    }
    public void set(int i, int value){
        if (i >= size || i < 0) {
            System.out.println("ERROR");
            return;
        }
        arr[i] = value;
    }
    
    public void remove(int i){
        if (i >= size || i < 0 || size == 0) {
            System.out.println("ERROR");
            return;
        }
        for (int j = i; j < size - 1; j++) {
            arr[j] = arr[j + 1];
        }
        size--;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public int getSize(){
        return size;
    }
    
    public void printStructure(){
        String arrstring = ", arr = [ ";
        for (int i = 0; i < size; i++) {
            arrstring += arr[i];
            if (i != size - 1) {
                arrstring += ", ";
            }
        }
        if (size != 0) arrstring += " ";
        arrstring += "] ";
        System.out.println("Size = " + size + ", Cap = " + capacity + arrstring);
    }
}