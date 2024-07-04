## Queue

A queue is a linear data structure that follows the First In, First Out (FIFO) principle. This means that the first element added to the queue is the first one to be removed. Queues are widely used in various applications such as scheduling, buffering, and managing tasks.

### Key Operations on a Queue

**Enqueue:** Adds an element to the end of the queue.

**Dequeue:** Removes the front element from the queue.

**Front (Peek):** Returns the front element without removing it.

**isEmpty:** Checks if the queue is empty.

**size:** Returns the number of elements in the queue.

### Implementing a Queue in Java
Java provides a built-in Queue interface as part of the java.util package, with common implementations such as LinkedList and ArrayDeque. You can also implement a queue manually using an array or a linked list.

Using java.util.Queue

Here's how to use the built-in Queue interface with LinkedList:

```
import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // Enqueue elements
        queue.add(10);
        queue.add(20);
        queue.add(30);

        // Peek the front element
        System.out.println("Front element: " + queue.peek()); // Output: 10

        // Dequeue elements
        System.out.println("Dequeued element: " + queue.poll()); // Output: 10
        System.out.println("Dequeued element: " + queue.poll()); // Output: 20

        // Check if the queue is empty
        System.out.println("Is queue empty? " + queue.isEmpty()); // Output: false

        // Size of the queue
        System.out.println("Queue size: " + queue.size()); // Output: 1
    }
}
```

### Custom Queue Implementation Using an Array

Here's how to implement a queue using an array:

```
class ArrayQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int capacity;
    private int count;

    // Constructor to initialize the queue
    public ArrayQueue(int size) {
        capacity = size;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        count = 0;
    }

    // Enqueue an element
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue Overflow");
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = item;
        count++;
    }

    // Dequeue an element
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        int item = queue[front];
        front = (front + 1) % capacity;
        count--;
        return item;
    }

    // Peek the front element
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front];
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return (count == 0);
    }

    // Check if the queue is full
    public boolean isFull() {
        return (count == capacity);
    }

    // Get the size of the queue
    public int size() {
        return count;
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front element: " + queue.peek()); // Output: 10
        System.out.println("Dequeued element: " + queue.dequeue()); // Output: 10
        System.out.println("Is queue empty? " + queue.isEmpty()); // Output: false
        System.out.println("Queue size: " + queue.size()); // Output: 2
    }
}
```

### Custom Queue Implementation Using a Linked List

Here's how to implement a queue using a linked list:

```
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListQueue {
    private Node front;
    private Node rear;
    private int count;

    // Constructor to initialize the queue
    public LinkedListQueue() {
        front = null;
        rear = null;
        count = 0;
    }

    // Enqueue an element
    public void enqueue(int item) {
        Node newNode = new Node(item);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        count++;
    }

    // Dequeue an element
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        int item = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        count--;
        return item;
    }

    // Peek the front element
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return front.data;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return (front == null);
    }

    // Get the size of the queue
    public int size() {
        return count;
    }

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front element: " + queue.peek()); // Output: 10
        System.out.println("Dequeued element: " + queue.dequeue()); // Output: 10
        System.out.println("Is queue empty? " + queue.isEmpty()); // Output: false
        System.out.println("Queue size: " + queue.size()); // Output: 2
    }
}
```

**Types of Queues**

Simple Queue: Follows the basic FIFO principle.

Circular Queue: The last position is connected back to the first position to make a circle.

Priority Queue: Each element is associated with a priority, and elements are served based on their priority.

Deque (Double-Ended Queue): Elements can be added or removed from both ends.

**Applications of Queue**

Scheduling: Job scheduling in operating systems.

Buffering: Data buffering in networks and IO devices.

Task Management: Managing tasks in task queues.

Breadth-First Search (BFS): BFS traversal of graphs.

Resource Management: Managing resources in resource pools.

**Summary**

Queue: A linear data structure following FIFO principle.

Key Operations: Enqueue, dequeue, peek, isEmpty, size.

Implementation: Can be implemented using built-in java.util.Queue, arrays, or linked lists.

Types: Simple queue, circular queue, priority queue, deque.

Applications: Scheduling, buffering, task management, BFS traversal, resource management.

By understanding and implementing queues in various ways, you can efficiently solve a variety of problems that require ordered processing of elements.
