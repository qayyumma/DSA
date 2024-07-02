## Definition of Circular Linked List

A circular linked list is a variation of a linked list where the last node points back to the first node, forming a circle. This can be applied to both singly and doubly linked lists.

### Comparison with Singly and Doubly Linked Lists

**Advantages of Circular Linked List over Singly Linked List**

**Continuous Traversal:**
Problem in Singly Linked List: Traversal stops at the end of the list.

Solution in Circular Linked List: The last node points to the first node, allowing continuous traversal without needing to stop at the end of the list.

**Efficient Circular Operations:**

Problem in Singly Linked List: Implementing circular operations (e.g., round-robin scheduling) can be cumbersome.

Solution in Circular Linked List: Naturally supports circular operations due to its structure.

**Advantages of Circular Linked List over Doubly Linked List**

**Memory Efficiency:**

Problem in Doubly Linked List: Each node has two pointers (next and prev), which increases memory usage.

Solution in Circular Singly Linked List: Each node has only one pointer (next), reducing memory overhead compared to a doubly linked list.

Implementation of Circular Singly Linked List in Java

Here’s how you can implement a circular singly linked list in Java:
```
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    Node head = null;
    Node tail = null;

    // Add node at the beginning
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
    }

    // Add node at the end
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    // Delete a node with a specific value
    public void deleteValue(int data) {
        if (head == null) return;
        if (head.data == data && head == tail) {
            head = null;
            tail = null;
            return;
        }
        Node current = head;
        Node prev = null;
        do {
            if (current.data == data) {
                if (prev != null) {
                    prev.next = current.next;
                    if (current == tail) {
                        tail = prev;
                    }
                } else {
                    head = head.next;
                    tail.next = head;
                }
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
    }

    // Search for a node with a specific value
    public boolean search(int data) {
        if (head == null) return false;
        Node current = head;
        do {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        } while (current != head);
        return false;
    }

    // Print the circular linked list
    public void printList() {
        if (head == null) return;
        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    // Main method to test the circular linked list
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.printList(); // Output: 1 2 3
        
        list.deleteValue(2);
        list.printList(); // Output: 1 3
        
        list.addFirst(0);
        list.printList(); // Output: 0 1 3

        System.out.println("Search 1: " + list.search(1)); // Output: true
        System.out.println("Search 2: " + list.search(2)); // Output: false
    }
}


```

## Explanation
**Node Class:**

Contains an integer data and a reference to the next node.
Constructor initializes the data and sets the next reference to null.

**CircularLinkedList Class:**

Contains references to the head and tail nodes.

addLast(int data): Adds a new node at the end of the list, ensuring the tail's next pointer points to the head.

deleteValue(int data): Deletes a node with the specified value, handling cases where the node to be deleted is the head or tail.

search(int data): Searches for a node with the specified value, returning true if found, false otherwise.

printList(): Prints all the elements in the list, stopping when it loops back to the head.

**Summary**

**Circular Linked List:**

A linked list where the last node points back to the first node.

Can be implemented as a circular singly linked list or circular doubly linked list.

**Advantages Over Singly Linked List:**

Allows continuous traversal.

Efficient for circular operations like round-robin scheduling.

**Advantages Over Doubly Linked List:**

Uses less memory since each node has only one pointer (next) in a circular singly linked list.

**Use Cases:**

Round-robin scheduling.

Implementing circular buffers.

Real-time systems requiring cyclic data structures.
