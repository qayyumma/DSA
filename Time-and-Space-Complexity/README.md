# Time and Space Complexity

Time and space complexity are measures used to describe the efficiency of an algorithm. They help to understand the performance of an algorithm in terms of the time it takes to run (time complexity) and the amount of memory it uses (space complexity).

## Time Complexity

Time complexity is a way to represent the amount of time an algorithm takes to run as a function of the length of the input. It helps to estimate the execution time of an algorithm.

## Space Complexity

Space complexity measures the amount of memory an algorithm uses as a function of the length of the input. It includes both the memory used by the variables and the call stack in the case of recursion.

## Common Time Complexities

### O(1) - Constant Time

The running time of the algorithm is constant, regardless of the input size.

**Example: Accessing an element in an array by index.**

```java
public class ConstantTime {
    public static int accessElement(int[] arr, int index) {
        return arr[index];  // O(1) - Accessing an element by index takes constant time
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(accessElement(arr, 2));  // Output: 3
    }
}

// Time Complexity: O(1) - The running time is constant, regardless of the input size.
// Space Complexity: O(1) - No extra space is used relative to input size.



O(log n) - Logarithmic Time
The running time grows logarithmically with the input size.

Example: Binary search in a sorted array.

java
Copy code
public class LogarithmicTime {
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {  // O(log n) - Halving the search space each iteration
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {  // O(1) - Constant time comparison
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(binarySearch(arr, 3));  // Output: 2
    }
}

// Time Complexity: O(log n) - The running time grows logarithmically with the input size.
// Space Complexity: O(1) - No extra space is used relative to input size.
