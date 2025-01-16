Problem Description

Given an integer A, you have to find the Ath Perfect Number.

A Perfect Number has the following properties:

It comprises only 1 and 2.
The number of digits in a Perfect number is even.
It is a palindrome number.
For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.

Problem Constraints

1 <= A <= 100000

Input Format
The only argument given is an integer A.


Output Format
Return a string that denotes the Ath Perfect Number.

Example Input

Input 1:
 A = 2

Input 2:
 A = 3


Example Output

Output 1:
 22
Output 2:
 1111

Example Explanation

Explanation 1:
First four perfect numbers are:
1. 11
2. 22
3. 1111
4. 1221
Return the 2nd Perfect number.

Explanation 2:
First four perfect numbers are:
1. 11
2. 22
3. 1111
4. 1221
Return the 3rd Perfect number.


public class Solution {

    class Queue<T> {

        class Node<T> {
            T value;
            Node<T> next;
            Node<T> pre;

            Node(T value) {
                this.value = value;
                this.next = null;
                this.pre = null;
            }
        }

        private Node<T> front;
        private Node<T> rear;

        Queue() {
            this.front = null;
            this.rear = front;
        }

        public void push(T value) {
            Node<T> newNode = new Node<>(value);
            if (front == null && rear == null) {
                front = newNode;
                rear = newNode;
            } else {
                rear.next = newNode;
                newNode.pre = rear;
                rear = rear.next;
            }
        }

        public boolean isEmpty() {
            return front == null && rear == null;
        }

        public T frontPeek() {
            if (!isEmpty()) {
                return front.value;
            }
            throw new RuntimeException("Queue is empty");
        }

        public T frontPop() {
            if (!isEmpty()) {
                T temp = front.value;
                if (front == rear) {
                    front = rear = null;
                } else {
                    front = front.next;
                    front.pre = null;
                }
                return temp;
            }
            throw new RuntimeException("Queue is empty");
        }
    }

    public String solve(int A) {
        Queue<String> queue = new Queue<>();
        queue.push("1");
        queue.push("2");
        
        String result = "";
        
        // Generate perfect numbers until we reach the A-th one
        for (int i = 0; i < A; i++) {
            // Get the next number in the queue
            String current = queue.frontPop();
            
            // Form its full palindrome
            result = current + new StringBuilder(current).reverse().toString();
            
            // Enqueue the next numbers to form new halves
            queue.push(current + "1");
            queue.push(current + "2");
        }
        
        return result;
    }

}
