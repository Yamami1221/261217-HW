public class SinglyLinkedList {
    Node head;
    String listName;
    
    public SinglyLinkedList(String name){
        listName = name;
    }
    
    public void popBack() { // ไล่ไปเรื่อยๆจนถึงตัวก่อนสุดท้ายแล้วตัดตัวสุดท้ายออก
        if (isEmpty()){
            System.out.println("ERROR");
        }else{
            Node current = head;
            if (current.next == null) {
                head = null;
                return;
            }
            while (current.next.next != null) current = current.next;
            current.next = null;
        }
    }
    
    public void popFront(){ // ย้ายหัวไปชี้ตัวถัดไป
        if (isEmpty()){
            System.out.println("ERROR");
        }else{
            head = head.next;
        }
    }
    
    public Node topFront(){ // return ตัวแรกสุด
        if (isEmpty()){
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            return head;
        }
    }
    
    public Node topBack(){ // ไล่ไปเรื่อยๆจนึงตัวสุดท้ายแล้ว return ตัวนั้น
        if (isEmpty()){
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            Node current = head;
            while (current.next != null) current = current.next;
            return current;
        }
    }
    
    public void pushFront(Node node){ // นำ node ที่รับมาชี้ไปที่ตัวแรกแล้วนำ head มาชี้ที่ node ที่รับมา
        if (isEmpty()){
            head = node;
        }else{
            node.next = head;
            head = node;
        }
    }
    
    public void pushBack(Node node) { // ไล่ไปเรื่อยๆจนถึงตัวสุดท้ายแล้วตัวสุดท้ายชี้ไปที่ node ที่รับมา
        if (isEmpty()){
            head = node;
        } else {
            Node current = head;
            while (current.next != null) current = current.next;
            current.next = node;
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
    
    public Node eraseNode(int id){ // ถ้าว่างให้ print ERROR และ return Node ที่มีชื่อว่า Empty List แต่ถ้าไม่ว่างให้ current เริ่มที่ head แล้วไล่ไปเรื่อยๆจนถึงตัวก่อนหน้าที่มี student_id เท่ากับ id ที่รับมาแล้วสร้าง temp มาเก็บตัวถัดไปแล้วให้ current.next ชี้ไปหา ตัวถัดจากตัวที่ต้องการลบแล้ว return temp
        if (isEmpty()){
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            if (head.student_id == id) {
                Node temp = head;
                head = head.next;
                return temp;
            }
            Node current = head;
            while (current.next != null){
                if (current.next.student_id == id){
                    Node temp = current.next;
                    current.next = current.next.next;
                    return temp;
                }
                current = current.next;
            }
            return new Node("Student Not Found!");
        }
    }
    
    public void addNodeAfter(Node node1, Node node2){ // เอา node2 มาแทรกหลัง node1
        node2.next = node1.next;
        node1.next = node2;
    }
    
    public void addNodeBefore(Node node1, Node node2){ // หา node ก่อนหน้า node1 แล้วเอา node2 ไปแทรกหลัง node นั้น
        if (head == node1) {
            node2.next = node1;
            head = node2;
            return;
        }
        Node current = head;
        while (current.next != node1) current = current.next;
        node2.next = current.next;
        current.next = node2;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    public void merge(SinglyLinkedList list){ // เอาตัวสุดท้ายของ list ไปต่อกับ list ที่รับมา
        Node current = head;
        while (current.next != null) current = current.next;
        current.next = list.head;
        list.head = null;
    }
    
    public void printStructure(){
        Node current=head;
        System.out.print(listName + ": head -> ");
        while(current!=null){
            System.out.print("{" + current.student_id + "} -> ");
            current = current.next;
        }
        System.out.println("null");
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