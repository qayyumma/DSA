Problem Description

You are given a linked list A
Each node in the linked list contains two pointers: a next pointer and a random pointer
The next pointer points to the next node in the list
The random pointer can point to any node in the list, or it can be NULL
Your task is to create a deep copy of the linked list A
The copied list should be a completely separate linked list from the original list, but with the same node values and random pointer connections as the original list
You should create a new linked list B, where each node in B has the same value as the corresponding node in A
The next and random pointers of each node in B should point to the corresponding nodes in B (rather than A)

Problem Constraints
0 <= |A| <= 106

Input Format
The first argument of input contains a pointer to the head of linked list A.

Output Format
Return a pointer to the head of the required linked list.



/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {

        RandomListNode temp = head;

        while(temp != null){

            RandomListNode newNode = new RandomListNode(temp.label);

            newNode.next = temp.next;

            temp.next = newNode;

            temp = temp.next.next;

        }

       
        RandomListNode first = head;

        RandomListNode second = head.next;

        while(  first != null ){

            second = first.next;

            if(first.random != null){

                second.random = first.random.next;
            }

            first = second.next;

        }

        RandomListNode secondHead = head.next;

        RandomListNode secondTemp = secondHead;

        temp = head;


        while( temp != null ){

            secondTemp = temp.next;

            temp.next = secondTemp.next;

            temp = temp.next;

            if(temp != null){

                secondTemp.next = temp.next;
            }

        }


         return secondHead;

    }



}

=================================================================================================


/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {

        RandomListNode temp = head;

        while(temp != null){

            RandomListNode newRL = new RandomListNode(temp.label);

            newRL.next = temp.next;

            temp.next = newRL;

            temp = temp.next.next;

        }

        temp = head;

        RandomListNode x = head;

        RandomListNode h2 = head.next;

         RandomListNode y = h2;

        while(temp != null){

            if(temp.random != null){

                temp.next.random = temp.random.next;
            }

            temp = temp.next.next;

        }

        while( y.next != null){

         //   x.next = y.next;

            y.next = y.next.next;

            x = x.next;

            y = y.next;


        }

        return h2;

    }
}


