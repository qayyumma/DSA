Problem Description

Given a singly linked list A, determine if it's a palindrome. Return 1 or 0, denoting if it's a palindrome or not, respectively.


Problem Constraints
1 <= |A| <= 105



Input Format
The first and the only argument of input contains a pointer to the head of the given linked list.


Output Format
Return 0, if the linked list is not a palindrome.
Return 1, if the linked list is a palindrome.


Example Input
Input 1:
A = [1, 2, 2, 1]
Input 2:
A = [1, 3, 2]


Example Output
Output 1:
 1 
Output 2:
 0 


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public int lPalin(ListNode A) {

        ListNode slow = A;

        ListNode fast = A;

        while(fast.next != null && fast.next.next != null){

            slow = slow.next;

            fast = fast.next.next;

        }

        if(fast.next != null){

            slow = slow.next;

        }


        ListNode prevoius = null;

        ListNode curr = slow;

        ListNode lastest = slow;

        while(curr != null){

            lastest = lastest.next;

            curr.next = prevoius;

            prevoius = curr;

            curr = lastest;

        }

        while(A != null && prevoius != null && prevoius.val == A.val){

            A = A.next;
            prevoius = prevoius.next;

        }

        if(A == null || prevoius == null){
            return 1;
        }

        return 0;

    }
}

======================================================================================================


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public int lPalin(ListNode A) {
        if (A == null || A.next == null) {
            // Empty list or single node is a palindrome
            return 1;
        }

        // Find the middle of the list
        ListNode middle = findMiddle(A);

        // Reverse the second half of the list
        ListNode reversedHead = reverseList(middle);

        // Compare the two halves
        ListNode firstHalf = A;
        ListNode secondHalf = reversedHead;

        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return 0; // Not a palindrome
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return 1; // Is a palindrome
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; // Returns the middle node
    }

    private ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }

        return previous; // Returns the head of the reversed list
    }
}

