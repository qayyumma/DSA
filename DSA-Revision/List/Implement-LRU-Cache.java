import java.util.HashMap;

class Node {
    int data;
    Node next;
    Node prev;

    // Constructor
    public Node(int x) {
        data = x;
        next = null;
        prev = null;
    }
}

public class LRUCache {
    private Node head;
    private Node tail;
    private HashMap<Integer, Node> hm;
    private int capacity;

    // Constructor to initialize LRU Cache
    public LRUCache(int limit) {
        capacity = limit;
        hm = new HashMap<>();
        head = new Node(-1); // Dummy head
        tail = new Node(-1); // Dummy tail
        head.next = tail;
        tail.prev = head;
    }

    // Access or insert an element into the cache
    public void LRU(int x) {
        if (hm.containsKey(x)) {
            // If the key exists, remove the node and move it to the back
            Node t = hm.get(x);
            deleteNode(t);
            Node nn = new Node(x);
            insertBack(nn);
            hm.put(x, nn);
        } else {
            // If the key doesn't exist, check if capacity is reached
            if (hm.size() == capacity) {
                // Remove the least recently used (first node after head)
                Node t = head.next;
                int val = t.data;
                deleteNode(t);
                hm.remove(val);
            }
            // Insert the new node at the back
            Node nn = new Node(x);
            insertBack(nn);
            hm.put(x, nn);
        }
    }

    // Insert a node at the back (before the tail)
    private void insertBack(Node nn) {
        Node t = tail.prev;
        t.next = nn;
        nn.prev = t;
        nn.next = tail;
        tail.prev = nn;
    }

    // Delete a node from its current position
    private void deleteNode(Node temp) {
        Node t1 = temp.prev;
        Node t2 = temp.next;
        t1.next = t2;
        t2.prev = t1;
        temp.next = null;
        temp.prev = null;
    }

    // Helper function to print the current state of the cache
    public void printCache() {
        Node curr = head.next;
        System.out.print("Cache: ");
        while (curr != tail) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Main method to test the LRU Cache
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);

        // Example operations
        cache.LRU(1);
        cache.printCache(); // Output: Cache: 1
        cache.LRU(2);
        cache.printCache(); // Output: Cache: 1 2
        cache.LRU(3);
        cache.printCache(); // Output: Cache: 1 2 3
        cache.LRU(4);        // 1 gets removed as the cache size is 3
        cache.printCache(); // Output: Cache: 2 3 4
        cache.LRU(2);        // 2 is accessed and moved to the back
        cache.printCache(); // Output: Cache: 3 4 2
        cache.LRU(5);        // 3 gets removed as it is the least recently used
        cache.printCache(); // Output: Cache: 4 2 5
    }
}
