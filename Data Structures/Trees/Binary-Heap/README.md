## Binary Heap

A binary heap is a complete binary tree that satisfies the heap property. It can be of two types: Max-Heap and Min-Heap. In a Max-Heap, the key at each node is greater than or equal to the keys of its children, whereas in a Min-Heap, the key at each node is less than or equal to the keys of its children.

**Max-Heap**

In a Max-Heap, the largest element is at the root of the tree. This makes it useful for implementing priority queues where the highest priority element is always served first.

**Properties of a Max-Heap**

Complete Binary Tree: All levels are completely filled except possibly the last level, which is filled from left to right.

Heap Property: The value of each node is greater than or equal to the values of its children.

**Example of Max-Heap**

Consider the following sequence of numbers to be inserted into a Max-Heap: 10, 20, 15, 30, 40

```
Insert 10:

   10

Insert 20:

   20
  /
 10

20 is greater than 10, so they are swapped to maintain the heap property.

Insert 15:

   20
  /  \
 10  15

No need to swap as 20 is greater than 15.

Insert 30:

   30
  /  \
 20  15
/
10

30 is inserted as the left child of 20.

30 is greater than 20, so they are swapped.

Insert 40:

Copy code
   40
  /  \
 30  15
/  \
10  20

40 is inserted as the right child of 30.

40 is greater than 30, so they are swapped.
```

**Operations on Max-Heap**

**Insertion:** Insert the new element at the end of the tree (complete tree property) and then bubble up to maintain the heap property.

**Deletion (Extract Max):** Remove the root element, replace it with the last element, and then bubble down to maintain the heap property.

Max-Heap Implementation in Java

Here is a simple implementation of a Max-Heap in Java:

```
import java.util.Arrays;

public class MaxHeap {
    private int[] heap;
    private int size;
    private int maxSize;

    // Constructor
    public MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.heap = new int[this.maxSize + 1];
        Arrays.fill(this.heap, Integer.MIN_VALUE);
    }

    // Return the position of the parent
    private int parent(int pos) {
        return pos / 2;
    }

    // Return the position of the left child
    private int leftChild(int pos) {
        return (2 * pos);
    }

    // Return the position of the right child
    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    // Swap two nodes
    private void swap(int fpos, int spos) {
        int tmp;
        tmp = this.heap[fpos];
        this.heap[fpos] = this.heap[spos];
        this.heap[spos] = tmp;
    }

    // Heapify the node at pos
    private void maxHeapify(int pos) {
        if (pos >= (size / 2) && pos <= size) {
            return;
        }
        if (this.heap[pos] < this.heap[leftChild(pos)] ||
            this.heap[pos] < this.heap[rightChild(pos)]) {
            if (this.heap[leftChild(pos)] > this.heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            } else {
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }

    // Insert a node into the heap
    public void insert(int element) {
        if (size >= maxSize) {
            return;
        }
        this.heap[++size] = element;
        int current = size;
        while (this.heap[current] > this.heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Print the heap
    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + this.heap[i] + " LEFT CHILD : " +
                             this.heap[2 * i] + " RIGHT CHILD :" + this.heap[2 * i + 1]);
            System.out.println();
        }
    }

    // Remove and return the maximum element (root) from the heap
    public int extractMax() {
        int popped = this.heap[1];
        this.heap[1] = this.heap[size--];
        maxHeapify(1);
        return popped;
    }

    public static void main(String[] args) {
        System.out.println("The Max Heap is ");
        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);
        maxHeap.print();
        System.out.println("The max value is " + maxHeap.extractMax());
    }
}
```

**Explanation of the Code**

Constructor: Initializes the heap with a specified maximum size and fills it with Integer.MIN_VALUE.

parent, leftChild, rightChild: Helper methods to find the parent and children of a given node.

swap: Swaps two elements in the heap.

maxHeapify: Ensures the heap property is maintained starting from the given position.

insert: Inserts a new element into the heap and ensures the heap property is maintained by bubbling up.

print: Prints the heap in a readable format.

extractMax: Removes and returns the maximum element from the heap, then ensures the heap property is maintained by bubbling down.

**Summary**

A Max-Heap is a complete binary tree where the value of each node is greater than or equal to the values of its children.

The root node of a Max-Heap is always the maximum element.

Insertion involves adding the new element at the end and bubbling it up to maintain the heap property.

Deletion involves removing the root element, replacing it with the last element, and bubbling it down to maintain the heap property.

Max-Heaps are commonly used to implement priority queues, where the highest priority element needs to be accessed quickly.
