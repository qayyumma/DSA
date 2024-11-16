class LinkedList {
    Node head; // Head of the list

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to find the middle of the linked list
    public void findMiddle() {
        Node slow = head;
        Node fast = head;

        // Traverse the list
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer by 1 step
            fast = fast.next.next; // Move fast pointer by 2 steps
        }

        // Slow pointer is now at the middle node
        if (slow != null) {
            System.out.println("Middle element is: " + slow.data);
        }
    }

    // Function to add a new node to the list
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Print the linked list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main method to test the code
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
        // Adding elements to the linked list
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // Printing the list
        System.out.print("Linked List: ");
        list.printList();

        // Finding and printing the middle element
        list.findMiddle();
    }
}
