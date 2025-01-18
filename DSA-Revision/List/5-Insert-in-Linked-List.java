Problem Description

You are given A which is the head of a linked list. Also given is the value B and position C. Complete the function that should insert a new node with the said value at the given position.

Notes:
In case the position is more than length of linked list, simply insert the new node at the tail only.
In case the pos is 0, simply insert the new node at head only.
Follow 0-based indexing for the node numbering.


Problem Constraints
0 <= size of linked list <= 105
1 <= value of nodes <= 109
1 <= B <= 109
0 <= C <= 105


Input Format
The first argument A is the head of a linked list.
The second argument B is an integer which denotes the value of the new node
The third argument C is an integer which denotes the position of the new node


Output Format
Return the head of the linked list


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode solve(ListNode A, int B, int C) {

        ListNode temp = A;

        ListNode newNode = new ListNode(B);

        if(C==0 || A== null){

            newNode.next = A;

            A = newNode;

            return A;

        }

        int ind = 0;

        while(temp.next != null && ind < (C-1) ){

            ind++;

            temp = temp.next;

        }

        newNode.next = temp.next;

        temp.next = newNode;

        return A;

    }
}





