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

```
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

```


### O(log n) - Logarithmic Time

The running time grows logarithmically with the input size.

**Example: Binary search in a sorted array.**

```
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
```


### O(n) - Linear Time
The running time grows linearly with the input size.

**Example: Finding the maximum element in an array.**

```
public class LinearTime {
    public static int findMax(int[] arr) {
        int maxElement = arr[0];  // O(1) - Initializing a variable
        for (int element : arr) {  // O(n) - Iterating through the array
            if (element > maxElement) {  // O(1) - Constant time comparison
                maxElement = element;  // O(1) - Constant time assignment
            }
        }
        return maxElement;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(findMax(arr));  // Output: 5
    }
}

// Time Complexity: O(n) - The running time grows linearly with the input size.
// Space Complexity: O(1) - Only a few extra variables are used, regardless of input size.
```

### O(n log n) - Linearithmic Time

The running time grows in proportion to n log n.

**Example: Efficient sorting algorithms like Merge Sort.**

```
public class LinearithmicTime {
    public static void mergeSort(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            int[] leftHalf = new int[mid];  // O(n/2) - Splitting the array
            int[] rightHalf = new int[arr.length - mid];  // O(n/2) - Splitting the array

            System.arraycopy(arr, 0, leftHalf, 0, mid);
            System.arraycopy(arr, mid, rightHalf, 0, arr.length - mid);

            mergeSort(leftHalf);  // O(n log n) - Recursively sorting the left half
            mergeSort(rightHalf);  // O(n log n) - Recursively sorting the right half

            merge(arr, leftHalf, rightHalf);  // O(n) - Merging the two halves
        }
    }

    public static void merge(int[] arr, int[] leftHalf, int[] rightHalf) {
        int i = 0, j = 0, k = 0;
        while (i < leftHalf.length && j < rightHalf.length) {  // O(n) - Merging elements
            if (leftHalf[i] < rightHalf[j]) {
                arr[k++] = leftHalf[i++];
            } else {
                arr[k++] = rightHalf[j++];
            }
        }
        while (i < leftHalf.length) {  // O(n/2) - Copying remaining elements of left half
            arr[k++] = leftHalf[i++];
        }
        while (j < rightHalf.length) {  // O(n/2) - Copying remaining elements of right half
            arr[k++] = rightHalf[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 1, 4};
        mergeSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");  // Output: 1 2 3 4 5
        }
    }
}

// Time Complexity: O(n log n) - The running time grows in proportion to n log n.
// Space Complexity: O(n) - Additional space for the temporary arrays used during merging
```
