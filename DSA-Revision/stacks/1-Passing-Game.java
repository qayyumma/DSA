Problem Description
There is a football event going on in your city. In this event, you are given A passes and players having ids between 1 and 106.
Initially, some player with a given id had the ball in his possession. You have to make a program to display the id of the player who possessed the ball after exactly A passes.
There are two kinds of passes:
1) ID
2) 0
For the first kind of pass, the player in possession of the ball passes the ball "forward" to the player with id = ID.
For the second kind of pass, the player in possession of the ball passes the ball back to the player who had forwarded the ball to him.
In the second kind of pass "0" just means Back Pass.
Return the ID of the player who currently possesses the ball.


Problem Constraints
1 <= A <= 100000
1 <= B <= 100000
|C| = A

Input Format
The first argument of the input contains the number A.
The second argument of the input contains the number B ( id of the player possessing the ball in the very beginning).
The third argument is an array C of size A having (ID/0).

Output Format
Return the "ID" of the player who possesses the ball after A passes.

Example Input

Input 1:
 A = 10
 B = 23
 C = [86, 63, 60, 0, 47, 0, 99, 9, 0, 0]

Input 2:
 A = 1
 B = 1
 C = [2]

public class Solution {

    class Stack<T> {

        class Node<T> {

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

            front= front.next;

            size--;

            return temp;

        }

        public T top() {
            if(isEmpty()){
                throw new RuntimeException("stack is empty");
            }

            return front.value;
        }

        public boolean isEmpty(){
            return front==null;
        }

        public int size(){
            return size;
        }



    }



    public int solve(int A, int B, int[] C) {

        Stack<Integer> s = new Stack<>();

        s.push(B);

        for (int i = 0; i <= A-1; i++){

            if( C[i] != 0){
                s.push(C[i]);
            }
            else{
                s.pop();
            }
        }

        return s.top();

    }
}


