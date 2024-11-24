import java.util.Stack;

class QueueUsingStacks {
    private Stack<Integer> stack1; // Stack for enqueue
    private Stack<Integer> stack2; // Stack for dequeue

    // Constructor
    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue operation (push to stack1)
    public void enqueue(int x) {
        stack1.push(x);
    }

    // Dequeue operation (pop from stack2)
    public int dequeue() {
        if (stack2.isEmpty()) {
            // Transfer all elements from stack1 to stack2 if stack2 is empty
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        // If stack2 is still empty, queue is empty
        if (stack2.isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }

        // Pop the top element from stack2 (FIFO order)
        return stack2.pop();
    }

    // Peek operation (get the front element without removing it)
    public int peek() {
        if (stack2.isEmpty()) {
            // Transfer all elements from stack1 to stack2 if stack2 is empty
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        // If stack2 is still empty, queue is empty
        if (stack2.isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }

        // Peek the top element from stack2
        return stack2.peek();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();

        // Enqueue elements
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Dequeue elements and display them
        System.out.println(queue.dequeue()); // 1
        System.out.println(queue.peek());    // 2
        System.out.println(queue.dequeue()); // 2
        System.out.println(queue.isEmpty()); // false
        System.out.println(queue.dequeue()); // 3
        System.out.println(queue.isEmpty()); // true
    }
}
