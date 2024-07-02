## Definition of Doubly Linked List

A doubly linked list is a linear data structure where each element, called a node, contains three parts:

Data: The value stored in the node.
Next: A reference to the next node in the sequence.
Prev: A reference to the previous node in the sequence.

### Comparison with Singly Linked List and Other Data Types

**Advantages of Doubly Linked List over Singly Linked List**

**Bidirectional Traversal:**
Problem in Singly Linked List: Traversal is unidirectional. To traverse backward, you would need to start from the head node each time.
Solution in Doubly Linked List: Each node contains a reference to the previous node, allowing bidirectional traversal, making operations like reverse traversal more efficient.

**Efficient Deletion:**
Problem in Singly Linked List: Deleting a node requires a pointer to the previous node to update its next reference.
Solution in Doubly Linked List: With a reference to the node to be deleted, you can easily access the previous node and update pointers directly, making deletions more efficient.

**Ease of Insertion/Deletion:**
Problem in Singly Linked List: Inserting or deleting a node before a given node requires traversal from the head to find the previous node.
Solution in Doubly Linked List: Inserting or deleting nodes is easier because you can access both the next and previous nodes directly, simplifying pointer updates.

**Comparison with Arrays**

**Dynamic Size:**
Arrays: Fixed size, requiring reallocation and copying if resized.
Doubly Linked List: Dynamic size, growing and shrinking as needed without reallocation.

**Memory Utilization:**
Arrays: Require contiguous memory allocation.
Doubly Linked List: Nodes can be scattered in memory, linked via pointers, making it easier to utilize fragmented memory.

**Random Access:**
Arrays: Provide O(1) time complexity for accessing elements by index.
Doubly Linked List: Accessing elements by index requires O(n) time complexity due to sequential traversal.

**Example:** Implementation of Doubly Linked List in Java
Here’s how you can implement a basic doubly linked list in Java:

```
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;

    // Add node at the beginning
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Add node at the end
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Delete the first node
    public void deleteFirst() {
        if (head == null) return;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    // Delete the last node
    public void deleteLast() {
        if (tail == null) return;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    // Delete a node with a specific value
    public void deleteValue(int data) {
        if (head == null) return;
        Node temp = head;
        while (temp != null && temp.data != data) {
            temp = temp.next;
        }
        if (temp == null) return; // Node with data not found
        if (temp == head) {
            deleteFirst();
        } else if (temp == tail) {
            deleteLast();
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }

    // Search for a node with a specific value
    public boolean search(int data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == data) {
                return true;
            }
            temp = temp.next;
        }
        return false;
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

    // Main method to test the linked list
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.printList(); // Output: 1 2 3
        
        list.deleteFirst();
        list.printList(); // Output: 2 3
        
        list.deleteLast();
        list.printList(); // Output: 2
        
        list.addLast(4);
        list.addLast(5);
        list.printList(); // Output: 2 4 5
        
        list.deleteValue(4);
        list.printList(); // Output: 2 5

        System.out.println("Search 2: " + list.search(2)); // Output: true
        System.out.println("Search 4: " + list.search(4)); // Output: false
    }
}
```

### Summary
**Doubly Linked List:**

Contains nodes with references to both the next and previous nodes.

Allows bidirectional traversal.

Efficient insertion and deletion operations, especially when the node to be inserted or deleted is known.

Advantages Over Singly Linked List:

Bidirectional traversal.

Easier and more efficient deletions and insertions.

Comparison with Arrays:

Dynamic size and efficient memory utilization.

Does not provide O(1) random access like arrays but offers more flexibility for dynamic operations.
