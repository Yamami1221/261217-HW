public class App {
    public static void main(String[] args) throws Exception {
        // Node test case 1
        Node node;
        node = new Node(5906001, "Matthew", 3.50);
        node.printIDName();

        // Doubly Linked List test case 1
        DoublyLinkedList list1 = new DoublyLinkedList("list1");
        node = new Node(5906001, "Matthew", 3.50);
        list1.pushFront(node);
        node = new Node(5906002, "Mark", 2.75);
        list1.pushFront(node);
        node = new Node(5906003, "Luke", 3.00);
        list1.pushFront(node);
        node = new Node(5906004, "John", 3.75);
        list1.pushFront(node);
        list1.printStructure();
        DoublyLinkedList list2 = new DoublyLinkedList("list2");
        list2.pushBack(new Node(5906005, "James", 3.25));
        list2.pushBack(new Node(5906006, "Peter", 2.85));
        list2.pushBack(new Node(5906007, "John", 2.50));
        list2.pushBack(new Node(5906008, "Jude", 3.15));
        list2.printStructure();
        list1.merge(list2);
        list1.printStructure();

        // Doubly Linked List test case 2
        DoublyLinkedList list = new DoublyLinkedList("list3");
        node = list.topFront();
        node.printIDName();
        node = list.topBack();
        node.printIDName();
        list.pushBack(new Node(5906001, "Matthew", 3.50));
        list.pushBack(new Node(5906002, "Mark", 2.75));
        list.pushBack(new Node(5906003, "Luke", 3.00));
        node = list.topFront();
        node.printIDName();
        node = list.topBack();
        node.printIDName();

        // Doubly Linked List test case 3
        list = new DoublyLinkedList("list4");
        list.printStructure();
        list.popFront();
        list.pushBack(new Node(5906001, "Matthew", 3.50));
        list.pushBack(new Node(5906002, "Mark", 2.75));
        list.pushBack(new Node(5906003, "Luke", 3.00));
        list.pushBack(new Node(5906004, "John", 3.75));
        list.printStructure();
        list.popFront();
        list.printStructure();
        list.popBack();
        list.printStructure();
        list.popFront();
        list.printStructure();
        list.popBack();
        list.printStructure();
        list.popBack();

        // Doubly Linked List test case 4
        list = new DoublyLinkedList("list5");
        node = list.whoGotHighestGPA();
        node.printIDName();
        list.pushBack(new Node(5906001, "Matthew", 3.25));
        list.pushBack(new Node(5906002, "Mark", 2.75));
        list.pushBack(new Node(5906003, "Luke", 3.00));
        list.printStructure();
        node = list.whoGotHighestGPA();
        node.printIDName();
        Node newNode = new Node(5906004, "John", 3.30);
        list.addNodeBefore(node, newNode);
        list.printStructure();
        list.addNodeAfter(list.whoGotHighestGPA(), new Node(5906005, "James", 3.40));
        list.printStructure();
        (list.whoGotHighestGPA()).printIDName();

        // Doubly Linked List test case 5
        list = new DoublyLinkedList("list6");
        list.pushBack(new Node(5906001, "Matthew", 3.00));
        list.pushBack(new Node(5906002, "Mark", 2.75));
        list.pushBack(new Node(5906003, "Luke", 3.25));
        list.printStructure();
        node = list.whoGotHighestGPA();
        node.printIDName();
        newNode = new Node(5906004, "John", 3.30);
        list.addNodeAfter(node, newNode);
        list.printStructure();
        list.addNodeBefore(list.whoGotHighestGPA(), new Node(5906005, "James", 3.30));
        list.printStructure();
        (list.whoGotHighestGPA()).printIDName();

        // Doubly Linked List test case 6
        list = new DoublyLinkedList("list7");
        (list.findNode(5906001)).printIDName();
        (list.eraseNode(5906001)).printIDName();
        list.pushBack(new Node(5906001, "Matthew", 3.50));
        list.pushBack(new Node(5906002, "Mark", 2.75));
        list.pushBack(new Node(5906003, "Luke", 3.00));
        list.pushBack(new Node(5906004, "John", 3.75));
        list.pushBack(new Node(5906005, "James", 3.25));
        list.pushBack(new Node(5906006, "Peter", 2.85));
        list.printStructure();
        (list.findNode(5906001)).printIDName();
        (list.findNode(5906006)).printIDName();
        (list.findNode(5906007)).printIDName();
        node = list.findNode(5906003);
        list.addNodeAfter(node, new Node(5906007, "John", 2.50));
        list.printStructure();
        (list.eraseNode(5906001)).printIDName();
        list.printStructure();
        (list.eraseNode(5906006)).printIDName();
        list.printStructure();
        (list.eraseNode(5906003)).printIDName();
        list.printStructure();
        (list.eraseNode(5906003)).printIDName();
        list.printStructure();

        // Singly Linked List test case 1
        SinglyLinkedList list3 = new SinglyLinkedList("list1");
        node = new Node(5906001, "Matthew", 3.50);
        list3.pushFront(node);
        node = new Node(5906002, "Mark", 2.75);
        list3.pushFront(node);
        node = new Node(5906003, "Luke", 3.00);
        list3.pushFront(node);
        node = new Node(5906004, "John", 3.75);
        list3.pushFront(node);
        list3.printStructure();
        SinglyLinkedList list4 = new SinglyLinkedList("list2");
        list4.pushBack(new Node(5906005, "James", 3.25));
        list4.pushBack(new Node(5906006, "Peter", 2.85));
        list4.pushBack(new Node(5906007, "John", 2.50));
        list4.pushBack(new Node(5906008, "Jude", 3.15));
        list4.printStructure();
        list3.merge(list4);
        list3.printStructure();

        // Singly Linked List test case 2
        list3 = new SinglyLinkedList("list3");
        node = list3.topFront();
        node.printIDName();
        node = list3.topBack();
        node.printIDName();
        list3.pushBack(new Node(5906001, "Matthew", 3.50));
        list3.pushBack(new Node(5906002, "Mark", 2.75));
        list3.pushBack(new Node(5906003, "Luke", 3.00));
        node = list3.topFront();
        node.printIDName();
        node = list3.topBack();
        node.printIDName();

        // Singly Linked List test case 3
        list3 = new SinglyLinkedList("list4");
        list3.printStructure();
        list3.popFront();
        list3.pushBack(new Node(5906001, "Matthew", 3.50));
        list3.pushBack(new Node(5906002, "Mark", 2.75));
        list3.pushBack(new Node(5906003, "Luke", 3.00));
        list3.pushBack(new Node(5906004, "John", 3.75));
        list3.printStructure();
        list3.popFront();
        list3.printStructure();
        list3.popBack();
        list3.printStructure();
        list3.popFront();
        list3.printStructure();
        list3.popBack();
        list3.printStructure();
        list3.popBack();

        // Singly Linked List test case 4
        list3 = new SinglyLinkedList("list5");
        node = list3.whoGotHighestGPA();
        node.printIDName();
        list3.pushBack(new Node(5906001, "Matthew", 3.25));
        list3.pushBack(new Node(5906002, "Mark", 2.75));
        list3.pushBack(new Node(5906003, "Luke", 3.00));
        list3.printStructure();
        node = list3.whoGotHighestGPA();
        node.printIDName();
        newNode = new Node(5906004, "John", 3.30);
        list3.addNodeBefore(node, newNode);
        list3.printStructure();
        list3.addNodeAfter(list3.whoGotHighestGPA(), new Node(5906005, "James", 3.40));
        list3.printStructure();
        (list3.whoGotHighestGPA()).printIDName();

        // Singly Linked List test case 5
        list3 = new SinglyLinkedList("list6");
        list3.pushBack(new Node(5906001, "Matthew", 3.00));
        list3.pushBack(new Node(5906002, "Mark", 2.75));
        list3.pushBack(new Node(5906003, "Luke", 3.25));
        list3.printStructure();
        node = list3.whoGotHighestGPA();
        node.printIDName();
        newNode = new Node(5906004, "John", 3.30);
        list3.addNodeAfter(node, newNode);
        list3.printStructure();
        list3.addNodeBefore(list3.whoGotHighestGPA(), new Node(5906005, "James", 3.30));
        list3.printStructure();
        (list3.whoGotHighestGPA()).printIDName();

        // Singly Linked List test case 6
        list3 = new SinglyLinkedList("list7");
        (list3.findNode(5906001)).printIDName();
        (list3.eraseNode(5906001)).printIDName();
        list3.pushBack(new Node(5906001, "Matthew", 3.50));
        list3.pushBack(new Node(5906002, "Mark", 2.75));
        list3.pushBack(new Node(5906003, "Luke", 3.00));
        list3.pushBack(new Node(5906004, "John", 3.75));
        list3.pushBack(new Node(5906005, "James", 3.25));
        list3.pushBack(new Node(5906006, "Peter", 2.85));
        list3.printStructure();
        (list3.findNode(5906001)).printIDName();
        (list3.findNode(5906006)).printIDName();
        (list3.findNode(5906007)).printIDName();
        node = list3.findNode(5906003);
        list3.addNodeAfter(node, new Node(5906007, "John", 2.50));
        list3.printStructure();
        (list3.eraseNode(5906001)).printIDName();
        list3.printStructure();
        (list3.eraseNode(5906006)).printIDName();
        list3.printStructure();
        (list3.eraseNode(5906003)).printIDName();
        list3.printStructure();
        (list3.eraseNode(5906003)).printIDName();
        list3.printStructure();
    }
}
