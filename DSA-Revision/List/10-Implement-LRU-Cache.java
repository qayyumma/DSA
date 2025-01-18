Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
The LRUCache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.

Definition of "least recently used" : An access to an item is defined as a get or a set operation of the item. "Least recently used" item is the one with the oldest access time.

NOTE: If you are using any global variables, make sure to clear them in the constructor.

Example :

Input : 
         capacity = 2
         set(1, 10)
         set(5, 12)
         get(5)        returns 12
         get(1)        returns 10
         get(10)       returns -1
         set(6, 14)    this pushes out key = 5 as LRU is full. 
         get(5)        returns -1 
Expected Output
Enter your input as per the following guideline:
There are 1 lines in the input

Line 1 ( Corresponds to arg 1 ) : The line starts with a pair of number numOperations, capacity. capacity is the number your constructor is initialized with. 
Then numOperation operations follow. 
Each operation is either : 
 * G  : This corresponds to a function call get()
 * S   : This corresponds to a function call set(num1, num2)
Note that the function calls are made in order.  



public class Solution {

    class Node{

        int key;
        int value;
        Node previous;
        Node next;

        Node(int key, int value){

            this.key = key;
            this.value = value;
            previous = null;
            next = null;

        }
    }


    private int size;

    private HashMap<Integer, Node> map;
    
    private Node head;

    private Node tail;


    public Solution(int capacity) {

        size = capacity;

        map = new HashMap<>();

        head = new Node(-1, -1);

        tail = new Node(-1, -1);

        head.next = tail;

        tail.previous = head;
        
    }
    
    public int get(int key) {

         if(  map.containsKey(key) ){

            int tempValue =  map.get(key).value;

            delete(key);

            insert(key, tempValue);

            return tempValue;

        }

        return -1;
        
    }
    
    public void set(int key, int value) {

        if(map.containsKey(key)){

            delete(key);

            insert(key, value);

        }


        else{

            if( map.size() == size){

                delete(head.next.key);

            }

            insert(key, value);

        }
        
    }


    private void delete(int key){

        Node temp = map.get(key);

        temp.next.previous = temp.previous;

        temp.previous.next = temp.next;

        map.remove(key);

    }

    private void insert(int key, int value){

        Node newNode = new Node(key, value);

        newNode.previous = tail.previous;

        newNode.next = tail;

        tail.previous.next = newNode;

        tail.previous = newNode;

        map.put(key, newNode);


    }

}


=========================================================================================================================



//import java.util.HashMap;

public class Solution {

    static class Node {
        int key;
        int data;
        Node next;
        Node prev;

        public Node(int key, int data) {
            this.key = key;
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head, tail;
    private int capacity;
    private HashMap<Integer, Node> map; // To quickly access nodes based on the key

    public Solution(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        // Initialize a dummy head and tail
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    // Move the node to the front (after head)
    private void moveToFront(Node node) {
        // Remove the node from its current position
        removeNode(node);

        // Insert the node right after the head
        addNodeAfterHead(node);
    }

    // Remove a node from the list
    private void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    // Add a new node right after the head (most recent)
    private void addNodeAfterHead(Node node) {
        Node nextNode = head.next;
        head.next = node;
        node.prev = head;
        node.next = nextNode;
        nextNode.prev = node;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1; // Key not found
        }
        // Move the accessed node to the front (most recent)
        Node node = map.get(key);
        moveToFront(node);
        return node.data;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            // If the key exists, update the value and move the node to the front
            Node node = map.get(key);
            node.data = value;
            moveToFront(node);
        } else {
            // If the key doesn't exist, create a new node
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addNodeAfterHead(newNode);

            if (map.size() > capacity) {
                // If the cache exceeds capacity, remove the least recently used (LRU) node
                Node lruNode = tail.prev; // The node before the dummy tail is the least recently used
                removeNode(lruNode);
                map.remove(lruNode.key);
            }
        }
    }
}



