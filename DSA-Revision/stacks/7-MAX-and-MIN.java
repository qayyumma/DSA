Problem Description

Given an array of integers A.

The value of an array is computed as the difference between the maximum element in the array and the minimum element in the array A.

Calculate and return the sum of values of all possible subarrays of A modulo 109+7.

Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 1000000


Input Format
The first and only argument given is the integer array A.


Output Format
Return the sum of values of all possible subarrays of A modulo 109+7.


Example Input

Input 1:
A = [1]

Input 2:
A = [4, 7, 3, 8]

Example Output
Output 1:
 0
Output 2:
 26

Example Explanation
Explanation 1:
Only 1 subarray exists. Its value is 0.

Explanation 2:
value ( [4] ) = 4 - 4 = 0
value ( [7] ) = 7 - 7 = 0
value ( [3] ) = 3 - 3 = 0
value ( [8] ) = 8 - 8 = 0
value ( [4, 7] ) = 7 - 4 = 3
value ( [7, 3] ) = 7 - 3 = 4
value ( [3, 8] ) = 8 - 3 = 5
value ( [4, 7, 3] ) = 7 - 3 = 4
value ( [7, 3, 8] ) = 8 - 3 = 5
value ( [4, 7, 3, 8] ) = 8 - 3 = 5
sum of values % 10^9+7 = 26



public class Solution {

    class Stack<T>{

       class Node<T>{
            T value;
            Node next;
           
           public Node(T value){
               this.value = value;
               this.next = next;
           }
        }

        private int size;

        private Node<T> front;

        public Stack(){

            this.size = 0;
            this.front = null;

        }

        public void push(T value){

            Node<T> NewNode = new Node(value);

            if(front==null){

                front = NewNode;
            }
            else{

                NewNode.next = front;
                front = NewNode;
            }

            size++;
        }

        public T pop(){

            if(front==null){

                throw new RuntimeException("stack is empty");
            }

            T temp = front.value;

            front = front.next;

            size--;

            return temp;

        }

        public int size(){
            return size;
        }

        public boolean isEmpty(){
            return front==null;
        }

        public void clear(){
            front = null;
        }

        public T top(){
            return front.value;
        }
    }




    public int solve(int[] A) {

        Stack<Integer> s = new Stack();

        int N = A.length;

//------------Nearest Smallest on Left-------------------------------
        int[] NSL = new int[A.length]; 

        NSL[0] = -1;

        s.push(0);
        
        for(int i = 1; i < N; i++){

            while(!s.isEmpty() && A[s.top()] >= A[i]){
                s.pop();
            }

            if(s.isEmpty()){
                NSL[i] = -1;
            }
            else{
                NSL[i] = s.top();
            }
            s.push(i);

        }
//------------Nearest Smallest on Right-------------------------------

        s.clear();

        int[] NSR = new int[A.length]; 

        NSR[N-1] = N;

        s.push(N-1);
        
        for(int i = N-2; i >= 0; i--){

            while(!s.isEmpty() && A[s.top()] >= A[i]){
                s.pop();
            }

            if(s.isEmpty()){
                NSR[i] = N;
            }
            else{
                NSR[i] = s.top();
            }
            s.push(i);

        }
//------------Nearest Greatest on Left-------------------------------

        s.clear();

        int[] NGL = new int[A.length]; 

        NGL[0] = -1;

        s.push(0);
        
        for(int i = 1; i < N; i++){

            while(!s.isEmpty() && A[s.top()] <= A[i]){
                s.pop();
            }

            if(s.isEmpty()){
                NGL[i] = -1;
            }
            else{
                NGL[i] = s.top();
            }
            s.push(i);

        }

//------------Nearest Greatest on Right-------------------------------

        s.clear();

        int[] NGR = new int[A.length]; 

        NGR[N-1] = N;

        s.push(N-1);
        
        for(int i = N-2; i >= 0; i--){

            while(!s.isEmpty() && A[s.top()] <= A[i]){
                s.pop();
            }

            if(s.isEmpty()){
                NGR[i] = N;
            }
            else{
                NGR[i] = s.top();
            }
            s.push(i);

        }

    long ans = 0;

    for(int i = 0; i < N; i++){

        long min = ((long)i - NSL[i]) * (NSR[i]-i);

        long max = ((long)i - NGL[i]) * (NGR[i]-i);

        long count = max - min;

        ans += A[i] * count;
    }

    return (int) (ans%1000000007);


    }
}


