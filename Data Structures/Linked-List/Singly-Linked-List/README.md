## Singly Linked List

A singly linked list is a linear data structure where each element, called a node, contains a data part and a reference (or pointer) to the next node in the sequence. The list starts with a head node and ends with a node whose next pointer is null, indicating the end of the list.

### Problems Solved by Singly Linked List

**Dynamic Size:**
Singly linked lists can grow and shrink dynamically, allowing for efficient use of memory without the need for pre-allocating a fixed size.

**Efficient Insertions and Deletions:**
Insertion and deletion of elements are efficient, especially when the position is known. These operations can be performed in O(1) time by adjusting pointers, unlike arrays that may require shifting elements.

**Memory Utilization:**
Singly linked lists do not require contiguous memory allocation. Each node is stored separately and linked using pointers, making it easier to manage memory, especially when dealing with fragmented memory.

**Flexibility in Data Management:**
They provide better flexibility when the data size is not known in advance or when frequent insertions and deletions are required. This flexibility is useful in implementing dynamic data structures like stacks and queues.

**Avoiding Overhead of Array Resizing:**
When using arrays, resizing them to accommodate more elements can be costly (O(n) time complexity). Singly linked lists avoid this overhead by allowing elements to be added or removed without resizing.


**Define the Node Class**

The node class will contain the data and a reference to the next node.

```
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

```

**Define the Singly Linked List Class**

The linked list class will contain a reference to the head node and methods to manipulate the list, such as adding nodes, deleting nodes, searching and printing the list.

```
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    Node head;

    // Add node at the beginning
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Add node at the end
    public void addLast(int data) {
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

    // Delete the first node
    public void deleteFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    // Delete the last node
    public void deleteLast() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node secondLast = head;
        while (secondLast.next.next != null) {
            secondLast = secondLast.next;
        }
        secondLast.next = null;
    }

    // Delete a node with a specific value
    public void deleteValue(int data) {
        if (head == null) {
            return;
        }
        if (head.data == data) {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.data != data) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
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
        SinglyLinkedList list = new SinglyLinkedList();
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


**Explanation**
**Node Class:**

Contains an integer data and a reference to the next node.
Constructor initializes the data and sets the next reference to null.

**SinglyLinkedList Class:**

Contains a reference to the head node.

addFirst(int data): Adds a new node at the beginning of the list.

addLast(int data): Adds a new node at the end of the list.

deleteFirst(): Deletes the first node of the list.

deleteLast(): Deletes the last node of the list.

deleteValue(int data): Deletes the first node with the specified value.

search(int data): Searches for a node with the specified value and returns true if found, false otherwise.

printList(): Prints all the elements in the list.

**Example Usage**
In the main method, we create an instance of SinglyLinkedList, add elements, delete elements, search for elements, and print the list to demonstrate the functionality.


This complete version of the singly linked list class includes basic add, delete, and search operations, making it a comprehensive and functional linked list implementation in Java.
