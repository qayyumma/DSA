// Custom Stack implementation
class Stack<T> {
    private Node<T> top; // Top of the stack
    private int size;    // Size of the stack

    // Node class
    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    // Push element onto the stack
    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // Pop element from the stack
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        T value = top.value;
        top = top.next;
        size--;
        return value;
    }

    // Peek at the top element without removing it
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        return top.value;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Get the size of the stack
    public int size() {
        return size;
    }
}

// Parentheses Validator using the Custom Stack
public class ParenthesesValidator {
    public static boolean isValidParentheses(String sequence) {
        // Initialize custom stack
        Stack<Character> stack = new Stack<>();

        // Iterate through each character in the sequence
        for (char ch : sequence.toCharArray()) {
            // If the character is an opening parenthesis, push it onto the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            // If the character is a closing parenthesis
            else if (ch == ')' || ch == '}' || ch == ']') {
                // If the stack is empty, return false
                if (stack.isEmpty()) {
                    return false;
                }
                // Pop the top element from the stack
                char top = stack.pop();
                // Check if the popped element matches the corresponding opening parenthesis
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // If the stack is not empty, return false
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        // Test cases
        String test1 = "({[]})";
        String test2 = "({[})]";
        String test3 = "((()))";

        System.out.println(isValidParentheses(test1)); // true
        System.out.println(isValidParentheses(test2)); // false
        System.out.println(isValidParentheses(test3)); // true
    }
}
