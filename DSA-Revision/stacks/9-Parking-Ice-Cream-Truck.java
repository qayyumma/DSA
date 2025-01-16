Problem Description

Imagine you're an ice cream truck driver in a beachside town. The beach is divided into several sections, and each section has varying numbers of beachgoers wanting ice cream given by the array of integers A.

For simplicity, let's say the beach is divided into 8 sections. One day, you note down the number of potential customers in each section: [5, 12, 3, 4, 8, 10, 2, 7]. This means there are 5 people in the first section, 12 in the second, and so on.

You can only stop your truck in B consecutive sections at a time because of parking restrictions. To maximize sales, you want to park where the most customers are clustered together.

For all B consecutive sections, identify the busiest stretch to park your ice cream truck and serve the most customers. Return an array C, where C[i] is the busiest section in each of the B consecutive sections. Refer to the given example for clarity.

NOTE: If B > length of the array, return 1 element with the max of the array.

Problem Constraints
1 <= |A|, B <= 106


Input Format
The first argument given is the integer array A.
The second argument given is the integer B.


Output Format
Return an array C, where C[i] is the maximum value from A[i] to A[i+B-1].


Example Input

Input 1:
 A = [1, 3, -1, -3, 5, 3, 6, 7]
 B = 3

Input 2:
 A = [1, 2, 3, 4, 2, 7, 1, 3, 6]
 B = 6


Example Output

Output 1:
[3, 3, 5, 5, 6, 7]

Output 2:
[7, 7, 7, 7]


Example Explanation
Explanation 1:

 Window position     | Max
 --------------------|-------
 [1 3 -1] -3 5 3 6 7 | 3
 1 [3 -1 -3] 5 3 6 7 | 3
 1 3 [-1 -3 5] 3 6 7 | 5
 1 3 -1 [-3 5 3] 6 7 | 5
 1 3 -1 -3 [5 3 6] 7 | 6
 1 3 -1 -3 5 [3 6 7] | 7
Explanation 2:

 Window position     | Max
 --------------------|-------
 [1 2 3 4 2 7] 1 3 6 | 7
 1 [2 3 4 2 7 1] 3 6 | 7
 1 2 [3 4 2 7 1 3] 6 | 7
 1 2 3 [4 2 7 1 3 6] | 7



public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY

    class Queue<T>{


        class Node<T>{
            T value;
            Node<T> next;
            Node<T> pre;
            Node(T value){
                this.value = value;
                this.next = null;
                this.pre = null;
            }
        }


        private Node<T> front;
        private Node<T> rear;

        Queue(){
            this.front = null;
            this.rear = front;
        }

        public void push(T value){

            Node<T> NewNode = new Node(value);

            if(front==null && rear==null){
                front = NewNode;
                rear = NewNode;
            }
            else{
                rear.next = NewNode;
                NewNode.pre = rear;
                rear = rear.next;
            }

        }

        public boolean isEmpty(){
            return front==null && rear==null;
        }

        public T frontPeek(){
            if(!isEmpty()){
                return front.value;
            }
            throw new RuntimeException("stack is empty");
        }


        public T rearPeek(){
            if(!isEmpty()){
                return rear.value;
            }
            throw new RuntimeException("stack is empty");
        }


        public T frontPop(){
            if(!isEmpty()){

                T temp = front.value;
                if(front==rear){
                    front = rear = null;
                }
                else{
                    front = front.next;
                    front.pre = null;
                }

                return temp;
            }

            throw new RuntimeException("stack is empty");
        }

        public T rearPop(){
            if(!isEmpty()){

                T temp = rear.value;
                if(front==rear){
                    front = rear = null;
                }
                else{
                    rear = rear.pre;
                    rear.next = null;
                }

                return temp;
            }

            throw new RuntimeException("stack is empty");
        }

    }


    public int[] slidingMaximum(final int[] A, int B) {

        Queue<Integer> que = new Queue<>();

        int[] ans = new int[A.length-B+1];

        int index = 0;

      //  que.push(0);

        for(int i = 0; i < B; i++){

            while(!que.isEmpty() && A[que.rearPeek()] <= A[i]){
                que.rearPop();
            }

            que.push(i);
        }

        ans[index++] = A[que.frontPeek()];

        for(int i = B; i < A.length; i++){

            if( !que.isEmpty() && i-B==que.frontPeek()){
                que.frontPop();
            }

            while(!que.isEmpty() && A[que.rearPeek()] <= A[i]){
                que.rearPop();
            }

            que.push(i);

            ans[index++] = A[que.frontPeek()];

            
        }

        return ans;

    }
}

