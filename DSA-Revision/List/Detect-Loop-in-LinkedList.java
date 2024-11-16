class Node {
    int data;
    Node next;

    // Constructor
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    public boolean hasLoop(Node head) {
        Node slow = head;
        Node fast = head;

        // Traverse the list with slow and fast pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;           // Move slow pointer one step
            fast = fast.next.next;      // Move fast pointer two steps

            if (slow == fast) {         // If slow and fast pointers meet
                return true;            // A loop is detected
            }
        }

        return false; // If fast pointer reaches null, no loop exists
    }

    public static void main(String[] args) {
        // Create a linked list with a loop
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head.next; // Create a loop (4 -> 2)

        LinkedList list = new LinkedList();
        boolean result = list.hasLoop(head);

        if (result) {
            System.out.println("Loop detected in the linked list.");
        } else {
            System.out.println("No loop detected in the linked list.");
        }
    }
}
