Problem Description

Given an array A, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.

More formally,

G[i] for an element A[i] = an element A[j] such that

j is maximum possible AND

j < i AND

A[j] < A[i]

Elements for which no smaller element exist, consider the next smaller element as -1.


Problem Constraints
1 <= |A| <= 100000
-109 <= A[i] <= 109




Input Format
The only argument given is integer array A.


Output Format
Return the integar array G such that G[i] contains the nearest smaller number than A[i]. If no such element occurs G[i] should be -1.


Example Input
Input 1:
A = [4, 5, 2, 10, 8]

Input 2:
A = [3, 2, 1]


Example Output
Output 1:
[-1, 4, -1, 2, 2]

Output 2:
[-1, -1, -1]


=========================================================================================================================================

public class Solution {

    class Stack<T>{

        class Node<T>{
            T value;
            Node<T> next;
            public Node(T value){
                this.value = value;
                this.next = null;
            }
        }

        private int size;
        private Node<T> front;

        public Stack(){

            this.size = 0;
            this.front = null;
        }

        public void push(T value){
            Node<T> newNode = new Node(value);
            newNode.next = front;
            front = newNode;
            size++;
        }

        public T pop(){
            if(isEmpty()){
                throw new RuntimeException("stack is empty");
            }
            T temp = front.value;
            front = front.next;
            size--;
            return temp;
        }

        public boolean isEmpty(){
            return front==null;
        }

        public T top(){
            if(isEmpty()){
                throw new RuntimeException("stack is empty");
            }
            return front.value;
        }

    }



    public int[] prevSmaller(int[] A) {

        Stack<Integer> s = new Stack<>();

        int[] B = new int[A.length];

        s.push(0);

        B[0] = -1;

        for(int i = 1; i < A.length; i++){

            while( !s.isEmpty() && A[s.top()] >= A[i]){
                s.pop();
            }

            if(s.isEmpty()){
                B[i] = -1;
            }
            else{
                B[i] = s.top();
            }

            s.push(i);
        }

        return B;

    }
}


========================================================================================================================================
import java.util.*;

public class NearestSmallerElement {

    // Function to find Nearest Smaller Element to the Left (NSL)
    public static int[] nearestSmallerToLeft(int[] arr) {
        int n = arr.length;
        int[] result = new int[n]; // Result array to store NSL
        Stack<Integer> stack = new Stack<>(); // Stack to track indices or values

        for (int i = 0; i < n; i++) {
            // Pop elements from the stack while they are greater or equal to the current element
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            // If stack is empty, no smaller element on the left
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            // Push the current element onto the stack
            stack.push(arr[i]);
        }
        return result;
    }

    // Function to find Nearest Smaller Element to the Right (NSR)
    public static int[] nearestSmallerToRight(int[] arr) {
        int n = arr.length;
        int[] result = new int[n]; // Result array to store NSR
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            // Pop elements from the stack while they are greater or equal to the current element
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            // If stack is empty, no smaller element on the right
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            // Push the current element onto the stack
            stack.push(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};

        // Nearest Smaller to Left
        int[] NSL = nearestSmallerToLeft(arr);
        System.out.println("Nearest Smaller to Left: " + Arrays.toString(NSL));

        // Nearest Smaller to Right
        int[] NSR = nearestSmallerToRight(arr);
        System.out.println("Nearest Smaller to Right: " + Arrays.toString(NSR));
    }
}
