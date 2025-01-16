Problem Description

Given an array of integers A.

A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.

Find the area of the largest rectangle formed by the histogram.

Problem Constraints

1 <= |A| <= 100000


1 <= A[i] <= 10000


Input Format
The only argument given is the integer array A.


Output Format
Return the area of the largest rectangle in the histogram.

Example Input
Input 1:
A = [2, 1, 5, 6, 2, 3]

Input 2:
A = [2]


Example Output
Output 1:
 10
Output 2:
 2


// Custom Stack Implementation
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

public class LargestRectangleHistogram {

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;

        // Arrays to store indices of NSL (Nearest Smaller to Left) and NSR (Nearest Smaller to Right)
        int[] NSL = new int[n];
        int[] NSR = new int[n];

        // Custom Stack for finding NSL
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            NSL[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // Clear the stack for finding NSR
        stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            NSR[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // Calculate the maximum area
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int height = heights[i];
            int width = NSR[i] - NSL[i] - 1;
            int area = height * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] histogram = {2, 1, 5, 6, 2, 3};
        System.out.println("Largest Rectangle Area: " + largestRectangleArea(histogram));
    }
}
