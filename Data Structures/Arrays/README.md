Arrays are a fundamental data structure in Data Structures and Algorithms (DSA). They store elements of the same type in a contiguous block of memory, making them very efficient for random access and certain types of operations. Here’s an overview of arrays in Java within the context of DSA:

### 1. Declaration and Initialization
In Java, arrays can be declared and initialized in several ways:

**Declaration:**
```
int[] arr;      // preferred way
int arr[];      // also valid
```

**itialization:**
```
arr = new int[5];                   // creates an array of size 5
int[] arr = new int[5];             // declaration and initialization
int[] arr = {1, 2, 3, 4, 5};

```


###Important DSA Algorithms in 1D Arrays

**Binary Search**

Description: Searches for an element in a sorted array.
Time Complexity: O(log n)
Space Complexity: O(1)
```
public int binarySearch(int[] arr, int key) {
    int left = 0, right = arr.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] == key)
            return mid;
        if (arr[mid] < key)
            left = mid + 1;
        else
            right = mid - 1;
    }
    return -1;
}
```

**Merge Sort**

Description: A divide-and-conquer algorithm that sorts an array by dividing it into halves, sorting them, and then merging them back.
Time Complexity: O(n log n)
Space Complexity: O(n)
```
public void mergeSort(int[] arr, int left, int right) {
    if (left < right) {
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
}

private void merge(int[] arr, int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;
    int[] L = new int[n1];
    int[] R = new int[n2];
    System.arraycopy(arr, left, L, 0, n1);
    System.arraycopy(arr, mid + 1, R, 0, n2);
    int i = 0, j = 0;
    int k = left;
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            arr[k] = L[i];
            i++;
        } else {
            arr[k] = R[j];
            j++;
        }
        k++;
    }
    while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }
    while (j < n2) {
        arr[k] = R[j];
        j++;
        k++;
    }
}
```

**Quick Sort**

Description: A divide-and-conquer algorithm that selects a pivot and partitions the array around it.
Time Complexity: O(n log n) on average, O(n^2) in the worst case
Space Complexity: O(log n)
```
public void quickSort(int[] arr, int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}

private int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = (low - 1);
    for (int j = low; j < high; j++) {
        if (arr[j] < pivot) {
            i++;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;
    return i + 1;
}
```

**Kadane’s Algorithm**

Description: Finds the maximum sum subarray.
Time Complexity: O(n)
Space Complexity: O(1)
```
public int maxSubArray(int[] nums) {
    int maxSoFar = nums[0], maxEndingHere = nums[0];
    for (int i = 1; i < nums.length; i++) {
        maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
        maxSoFar = Math.max(maxSoFar, maxEndingHere);
    }
    return maxSoFar;
}
```

**Dutch National Flag Algorithm**

Description: Sorts an array of 0s, 1s, and 2s.
Time Complexity: O(n)
Space Complexity: O(1)
```
public void sortColors(int[] nums) {
    int low = 0, mid = 0, high = nums.length - 1;
    while (mid <= high) {
        switch (nums[mid]) {
            case 0:
                swap(nums, low++, mid++);
                break;
            case 1:
                mid++;
                break;
            case 2:
                swap(nums, mid, high--);
                break;
        }
    }
}

private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}
```

