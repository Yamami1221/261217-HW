public class DoublyLinkedList {
    Node head;
    Node tail;
    String listName;
    
    public DoublyLinkedList(String name){
        listName = name; // เอา name ที่รับมาใส่ใน listName ของ DoublyLinkedList
    }
    
    public void popBack() { // ให้ tail ย้ายไปชี้ตัวก่อนหน้าแล้วตัดตัวสุดท้ายทิ้ง
        if (isEmpty()){
            System.out.println("ERROR"); // ถ้าหาก list ว่างเปล่าให้ print ERROR
        }else{
            tail = tail.previous; 
            if (tail != null) tail.next = null;
            else head = head.next;
        }
    }
    
    public void popFront(){ // ให้ head ย้ายไปชี้ตัวถัดไปแล้วตัดตัวก่อนหน้าทิ้ง
        if (isEmpty()){
            System.out.println("ERROR");
        }else{
            head = head.next;
            if (head != null)head.previous = null;
            else tail = tail.previous;
        }
    }
    
    public Node topFront(){ // ถ้า list ว่างให้ print ERROR และ return Node ที่ชื่อว่า Empty List แต่ถ้าไม่ว่างให้ return ตัวแรกสุด(Head)
        if (isEmpty()){
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            return head;
        }
    }
    
    public Node topBack(){ // ถ้า list ว่างให้ print ERROR และ return Node ที่ชื่อว่า Empty List แต่ถ้าไม่ว่างให้ return ตัวท้ายสุด(Tail)
        if (isEmpty()){
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            return tail;
        }
    }
    
    public void pushFront(Node node){ // ถ้า list ว่างให้เอา head และ tail มาชี้ที่ node ที่รับเข้ามาแต่ถ้าไม่ว่างให้นำ node เชื่อมกับ head แล้วนำ head มาชี้ที่ node นั้น
        if (isEmpty()){
            head = node;
            tail = node;
        }else{
            node.next = head;
            head.previous = node;
            head = node;
        }
    }
    
    public void pushBack(Node node) { // ถ้า list ว่างให้เอา head และ tail มาชี้ที่ node ที่รับเข้ามาแต่ถ้าไม่ว่างให้นำ node เชื่อมกับ tail แล้วนำ tail มาชี้ที่ node นั้น
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            node.previous = tail;
            tail.next = node;
            tail = node;
        }
    }

    public Node findNode(int id){ // ถ้าว่างให้ return Node ที่มีชื่อว่า Empty List แต่ถ้าไม่ว่างให้ current เริ่มที่ head แล้วไล่ไปเรื่อยๆจนถึงตัวที่มี student_id เท่ากับ id ที่รับมา
        if (isEmpty()){
            return new Node("Empty List!");
        } else {
            Node current = head;
            while (current != null){
                if (current.student_id == id){
                    return current;
                }
                current = current.next;
            }
            return new Node("Student Not Found!");
        }
    }
    
    public Node eraseNode(int id){ // ถ้าว่างให้ print ERROR และ return Node ที่มีชื่อว่า Empty List แต่ถ้าไม่ว่างให้ current เริ่มที่ head แล้วไล่ไปเรื่อยๆจนถึงตัวที่มี student_id เท่ากับ id ที่รับมาแล้วตัดสายสัมพันธ์ Node นั้นกับ Node ข้างๆแล้ว return Node นั้น
        if (isEmpty()){
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            Node current = head;
            while (current != null){
                if (current.student_id == id){
                    if (current.previous != null) current.previous.next = current.next;
                    else {
                        head = current.next;
                        head.previous = null;
                    }
                    if (current.next != null) current.next.previous = current.previous;
                    else {
                        tail = current.previous;
                        tail.next = null;
                    }
                    return current;
                }
                current = current.next;
            }
            return new Node("Student Not Found!");
        }
    }
    
    public void addNodeAfter(Node node1, Node node2){ // เอา node2 เชื่อมกับ node1.next แล้วเอา node1 เชื่อมกับ node2
        if (node1.next != null) node1.next.previous = node2;
        else tail = node2;
        node2.previous = node1;
        node2.next = node1.next;
        node1.next = node2;
    }
    
    public void addNodeBefore(Node node1, Node node2){ // เอา node2 เชื่อมกับ node1.previous แล้วเอา node1 เชื่อมกับ node2
        if (node1.previous != null) node1.previous.next = node2;
        else head = node2;
        node2.next = node1;
        node2.previous = node1.previous;
        node1.previous = node2;
    }
    
    public boolean isEmpty(){
        return head == null && tail == null;
    }
    public void merge(DoublyLinkedList list){ // เชื่อม tail กับ head ของ list ที่รับมา แล้วย้าย tail ไปชี้ที่ tail ของ list ที่รับมา
        tail.next = list.head;
        list.head.previous = tail;
        tail = list.tail;
        list.head = null;
        list.tail = null;
    }
    
    public void printStructure(){
        Node current=head;
        System.out.print(listName + ": head <-> ");
        while(current!=null){
            System.out.print("{" + current.student_id + "} <-> ");
            current = current.next;
        }
        System.out.println("tail");
    }
    
    // This may be useful for you for implementing printStructure()
    public void printStructureBackward(){
        Node current=tail;
        System.out.print(listName + ": tail <-> ");
        while(current!=null){
            System.out.print("{" + current.student_id + "} <-> ");
            current = current.previous;
        }
        System.out.println("head");
    }
    
    public Node whoGotHighestGPA(){ // ถ้าว่างให้ return Node ที่มีชื่อว่า Empty List แต่ถ้าไม่ว่างให้ current และ topS เริ่มที่ head แล้วไล่ current ไปเรื่อยๆถ้า gpa ของ current มากกว่า gpa ของ topS ให้ย้าย topS มาชี้ที่ current พอสิ้นสุดแล้ว return topS
        if (isEmpty()) {
            return new Node("Empty List!");
        } else {
            Node current = head;
            Node topS = head;
            while (current != null) {
                if (current.gpa >= topS.gpa) {
                    topS = current;
                }
                current = current.next;
            }
            return topS;
        }
    }
}