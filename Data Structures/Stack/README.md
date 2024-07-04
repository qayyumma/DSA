## Stack

A stack is a linear data structure that follows the Last In, First Out (LIFO) principle. This means that the last element added to the stack is the first one to be removed. Stacks are used in various applications such as expression evaluation, syntax parsing, backtracking algorithms, and more.

### Key Operations on a Stack

**Push:** Adds an element to the top of the stack.

**Pop:** Removes the top element from the stack.

**Peek:** Returns the top element without removing it.

**isEmpty:** Checks if the stack is empty.

**size:** Returns the number of elements in the stack.

### Implementing a Stack in Java

Java provides a built-in Stack class as part of the java.util package, but you can also implement a stack manually using an array or a linked list.

Using java.util.Stack

Here's how to use the built-in Stack class:

```
import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Peek the top element
        System.out.println("Top element: " + stack.peek()); // Output: 30

        // Pop elements from the stack
        System.out.println("Popped element: " + stack.pop()); // Output: 30
        System.out.println("Popped element: " + stack.pop()); // Output: 20

        // Check if the stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: false

        // Size of the stack
        System.out.println("Stack size: " + stack.size()); // Output: 1
    }
}
```

Custom Stack Implementation Using an Array

Here's how to implement a stack using an array:

```
class CustomStack {
    private int[] stack;
    private int top;
    private int capacity;

    // Constructor to initialize the stack
    public CustomStack(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
        top = -1;
    }

    // Push an element onto the stack
    public void push(int value) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        stack[++top] = value;
    }

    // Pop an element from the stack
    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return stack[top--];
    }

    // Peek the top element
    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[top];
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Get the size of the stack
    public int size() {
        return top + 1;
    }

    public static void main(String[] args) {
        CustomStack stack = new CustomStack(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek()); // Output: 30
        System.out.println("Popped element: " + stack.pop()); // Output: 30
        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: false
        System.out.println("Stack size: " + stack.size()); // Output: 2
    }
}
```

Custom Stack Implementation Using a Linked List

Here's how to implement a stack using a linked list:

```
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListStack {
    private Node top;

    // Constructor to initialize the stack
    public LinkedListStack() {
        this.top = null;
    }

    // Push an element onto the stack
    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    // Pop an element from the stack
    public int pop() {
        if (top == null) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int value = top.data;
        top = top.next;
        return value;
    }

    // Peek the top element
    public int peek() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Get the size of the stack
    public int size() {
        int count = 0;
        Node current = top;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek()); // Output: 30
        System.out.println("Popped element: " + stack.pop()); // Output: 30
        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: false
        System.out.println("Stack size: " + stack.size()); // Output: 2
    }
}
```
### Applications of Stack

**Expression Evaluation:** Used in evaluating postfix, prefix, and infix expressions.

**Backtracking:** Used in algorithms like finding paths in a maze, solving puzzles, and more.

**Function Call Management:** The system stack manages function calls and local variables in programming languages.

**Syntax Parsing:** Used in compilers to parse expressions, validate parentheses, and more.

### Summary

**Stack:** A linear data structure following LIFO principle.

**Key Operations:** Push, pop, peek, isEmpty, size.

**Implementation:** Can be implemented using built-in java.util.Stack, arrays, or linked lists.

**Applications:** Expression evaluation, backtracking, function call management, syntax parsing.
