Problem Description

Design and implement a Linked List data structure.
A node in a linked list should have the following attributes - an integer value and a pointer to the next node.

It should support the following operations:

insert_node(position, value) - To insert the input value at the given position in the linked list.
delete_node(position) - Delete the value at the given position from the linked list.
print_ll() - Print the entire linked list, such that each element is followed by a single space (no trailing spaces).
Note:

If an input position does not satisfy the constraint, no action is required.
Each print query has to be executed in a new line.


Problem Constraints

1 <= value <= 105
1 <= position <= n where, n is the size of the linked-list.



Input Format

First line contains an integer denoting number of cases, let's say t. Next t line denotes the cases.


Output Format

When there is a case of print_ll(), Print the entire linked list, such that each element is followed by a single space.

There should not be any trailing space.

NOTE: You don't need to return anything.    


static class Node{

        int val;
        Node next;

        Node(int val){

            this.val = val;
            this.next = null;

        }

    }
    
    private static Node head = null;
    
    public static void insert_node(int position, int value) {
        // @params position, integer
        // @params value, integer
        Node newNode = new Node(value);

        if(head == null){
            //newNode.next = head;
            head = newNode;
        }

        else if(position==1){
            newNode.next = head;
            head = newNode;
        }

        else{

            int ind = 1;

            Node temp = head;

            while( ind < (position-1) && temp.next != null){

                temp = temp.next;
                ind++;

            }

            newNode.next = temp.next;

            temp.next = newNode;

        }

    }


    public static void delete_node(int position) {
        // @params position, integer
        if(head==null){
           throw new RuntimeException("Linked list is null");
        }
        else if(position==1){
            head = head.next;
        }
        else{
            int ind = 1;

            Node temp = head;

            while( temp.next != null && ind < (position-1) ){
                temp = temp.next;
                ind++;
            }
            if(ind==(position-1)){

                if(temp.next==null){
                    return;
                }

                else if(temp.next.next != null){
                    temp.next = temp.next.next;
                }
                else{
                    temp.next = null;
                }

            }

        }
    }

    public static void print_ll() {
        // Output each element followed by a space
        if(head != null){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.val);
            temp = temp.next;
            if(temp != null){
                System.out.print(" ");
            }
        }

       // System.out.println("");
        }
    }

===========================================================================================================================================

static class LinkedList {
    int value;
    LinkedList pointer;
    static LinkedList head = null;
    LinkedList(int value) {
        this.value = value;
        this.pointer = null;
    }
}
    public static void insert_node(int position, int value) {
        // @params position, integer
        // @params value, integer
        // System.out.println("insert_node :: position = " +position + " value = "+ value);
        if(position == 1) {
            LinkedList temp = new LinkedList(value);
            temp.pointer = LinkedList.head;
            LinkedList.head = temp;
        }
        else {
            LinkedList node = new LinkedList(value);
            LinkedList temp = LinkedList.head;
            int index = 1;
            while(temp != null) {
                if(index == position - 1) {
                    node.pointer = temp.pointer;
                    temp.pointer = node;
                    break;
                }
                index++;
                temp = temp.pointer;
            }
        }
    }
    public static void delete_node(int position) {
        // @params position, integer
        int size = 0;

        LinkedList temp = LinkedList.head;

        while(temp != null) {
            size++;
            temp = temp.pointer;
        }

        temp = LinkedList.head;

        int currPosition = 1;

        if(position > size) {
               return;
        }

        else if(position == 1) {
                LinkedList.head = LinkedList.head.pointer;
                //TODO clarify if GC happens for node which points to other,
                // but we stop pointing it - GC should happen??
                //temp.pointer = null;

                return;
        }

        else{

            while(temp != null) {

                if(currPosition == position - 1) {
                    LinkedList node = temp.pointer;
                    temp.pointer = node.pointer;
                    return;
                }
                 currPosition++;
                 temp = temp.pointer;
            }



            }


    }
    public static void print_ll() {
        // Output each element followed by a space
        LinkedList temp = LinkedList.head;
        while(temp != null) {
            System.out.print(temp.value);
            if(temp.pointer != null) {
                System.out.print(" ");
            }
            temp = temp.pointer;
        }
    }

