import java.util.LinkedList;
import java.util.Iterator;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Stack;

@SuppressWarnings("unchecked")
public class JavaCollectionTest {

    public static void linkedlistTest() {
        // Create a LinkedList object that can contain Integer
        LinkedList<Integer> linkedlist = new LinkedList<Integer>();
        // Name the variable to list

        for (int i = 1; i < 10; i += 2) {
            // Add keys to the LinkedList object (list)
            linkedlist.add(i);
        }

        // Check if 5 is contained in the list
        boolean check = linkedlist.contains(5); // Fix this
        System.out.println("5 is in the list = " + check);

        // Check if 6 is contained in the list
        check = linkedlist.contains(6); // Fix this
        System.out.println("6 is in the list = " + check);

        // Show all elements in the list
        // Fix all of these
        // int e = 0;
        // System.out.print(e + ", ");
        // System.out.println();
        Iterator<Integer> it = linkedlist.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + ", ");
        }
        System.out.println();
    }

    public static void queueTest() {
        // Create a queue object that can contain String's
        Queue<String> queue = new PriorityQueue<String>();
        // Name the varible to q

        String[] names = { "Abraham", "Andrew", "Benjamin", "Claudia", "Gabriel" };
        for (int i = 0; i < names.length; i++) {
            // Add names[i] to the queue object (q)
            queue.add(names[i]);
        }

        System.out.println("Top = " + queue.peek()); // Fix this
        System.out.println("1st Pop = " + queue.remove()); // Fix this
        System.out.println("2nd Pop = " + queue.remove()); // Fix this
        System.out.println("3rd Pop = " + queue.remove()); // Fix this
    }

    public static void stackTest() {
        // Create a stack of object that can contain String's
        // Name the varible to s
        Stack<String> stack = new Stack<String>();

        String[] names = { "Abraham", "Andrew", "Benjamin", "Claudia", "Gabriel" };
        for (int i = 0; i < names.length; i++) {
            // Push names[i] into the stack object (s)
            stack.push(names[i]);
        }

        System.out.println("Top = " + stack.peek()); // Fix this
        System.out.println("1st Pop = " + stack.pop()); // Fix this
        System.out.println("2nd Pop = " + stack.pop()); // Fix this
        System.out.println("3rd Pop = " + stack.pop()); // Fix this
    }

    public static void arrayOfListTest() {
        // This part is to create an array of LinkedList (each LinkedList contains
        // String's)
        // This section is complete, no need to edit
        // Your task is to understand my code
        LinkedList<String>[] arr = new LinkedList[5];
        String[] names = { "Abraham", "Andrew", "Benjamin", "Claudia", "Gabriel" };
        for (int i = 0; i < 5; i++) {
            LinkedList<String> list = new LinkedList<String>();
            for (int j = 0; j <= i; j++) {
                list.add(names[j]);
            }
            arr[i] = list;
        }

        // Once you understand the above section, pls fix the following code to correct
        // the results

        // Show all elements for each list
        for (int i = 0; i < arr.length; i++) {

            // Fix these lines
            System.out.print("arr[" + i + "] = ");
            Iterator<String> it = arr[i].iterator();
            while (it.hasNext()) {
                System.out.print(it.next() + ", ");
            }
            System.out.println("");
        }

        // Check if "Benjamin" is contained in any list
        for (int i = 0; i < arr.length; i++) {
            // Do something
            boolean check = arr[i].contains("Benjamin");
            System.out.println("Benjamin is contained in arr[" + i + "]? = " + check); // Fix this
        }
    }
}