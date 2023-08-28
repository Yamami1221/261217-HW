public class Node {
    public int student_id;
    public String name;
    public double gpa;
    
    Node next;
    Node previous;
    
    // Constructor 1
    public Node(int id, String name, double gpa){
        student_id = id; // เอา id ที่รับมาใส่ใน student_id ของ Node
        this.name = name; // เอา name ที่รับมาใส่ใน name ของ Node
        this.gpa = gpa; // เอา gpa ที่รับมาใส่ใน gpa ของ Node
    }
    // Constructor 2
    public Node(String name){
        this.name = name; // เอา name ที่รับมาใส่ใน name ของ Node
    }
    // Constructor 3 (dummy)
    public Node(){
        // You can leave this function blank
    }
    
    public void printIDName(){
        System.out.println("StudentID: " + student_id + " , Name: " + name);
    }

}