Problem Description

You are using Google Maps to help you find your way around a new place. But, you get lost and end up walking in a circle. Google Maps has a way to keep track of where you've been with the help of special sensors.These sensors notice that you're walking in a loop, and now, Google wants to create a new feature to help you figure out exactly where you started going in circles.

Here's how we can describe the challenge in simpler terms: You have a Linked List A that shows each step of your journey, like a chain of events. Some of these steps have accidentally led you back to a place you've already been, making you walk in a loop. The goal is to find out the exact point where you first started walking in this loop, and then you want to break the loop by not going in the circle just before this point.

Problem Constraints

1 <= number of nodes <= 1000

Input Format

The first of the input contains a LinkedList, where the first number is the number of nodes N, and the next N nodes are the node value of the linked list.
The second line of the input contains an integer which denotes the position of node where cycle starts.

Output Format
return the head of the updated linked list.



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
