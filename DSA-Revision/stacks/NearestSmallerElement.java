import java.util.*;

public class NearestSmallerElement {

    // Function to find Nearest Smaller Element to the Left (NSL)
    public static int[] nearestSmallerToLeft(int[] arr) {
        int n = arr.length;
        int[] result = new int[n]; // Result array to store NSL
        Stack<Integer> stack = new Stack<>(); // Stack to track indices or values

        for (int i = 0; i < n; i++) {
            // Pop elements from the stack while they are greater or equal to the current element
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            // If stack is empty, no smaller element on the left
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            // Push the current element onto the stack
            stack.push(arr[i]);
        }
        return result;
    }

    // Function to find Nearest Smaller Element to the Right (NSR)
    public static int[] nearestSmallerToRight(int[] arr) {
        int n = arr.length;
        int[] result = new int[n]; // Result array to store NSR
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            // Pop elements from the stack while they are greater or equal to the current element
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            // If stack is empty, no smaller element on the right
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            // Push the current element onto the stack
            stack.push(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};

        // Nearest Smaller to Left
        int[] NSL = nearestSmallerToLeft(arr);
        System.out.println("Nearest Smaller to Left: " + Arrays.toString(NSL));

        // Nearest Smaller to Right
        int[] NSR = nearestSmallerToRight(arr);
        System.out.println("Nearest Smaller to Right: " + Arrays.toString(NSR));
    }
}
