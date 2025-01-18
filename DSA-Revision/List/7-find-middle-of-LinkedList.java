Problem Description

Given a linked list of integers, find and return the middle element of the linked list.

NOTE: If there are N nodes in the linked list and N is even then return the (N/2 + 1)th element.

Problem Constraints

1 <= length of the linked list <= 100000

1 <= Node value <= 109

Input Format
The only argument given head pointer of linked list.


Output Format
Return the middle element of the linked list.


Example Input

Input 1:
 1 -> 2 -> 3 -> 4 -> 5
Input 2:
 1 -> 5 -> 6 -> 2 -> 3 -> 4


Example Output
Output 1:
 3

Output 2:
 2

==================================================================================================


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public int solve(ListNode A) {

        ListNode slow = A;

        ListNode fast = A;

        while(fast.next != null && fast.next.next != null){

            slow = slow.next;

            fast = fast.next.next;


        }

        if(fast.next != null){
            return slow.next.val;
        }

        return slow.val;


    }
}


===================================================================================================

class LinkedList {
    Node head; // Head of the list

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to find the middle of the linked list
    public void findMiddle() {
        Node slow = head;
        Node fast = head;

        // Traverse the list
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer by 1 step
            fast = fast.next.next; // Move fast pointer by 2 steps
        }

        // Slow pointer is now at the middle node
        if (slow != null) {
            System.out.println("Middle element is: " + slow.data);
        }
    }

    // Function to add a new node to the list
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Print the linked list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main method to test the code
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
        // Adding elements to the linked list
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // Printing the list
        System.out.print("Linked List: ");
        list.printList();

        // Finding and printing the middle element
        list.findMiddle();
    }
}
