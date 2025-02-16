Problem Description

Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).

Problem Constraints

1 <= length of the array <= 105

1 <= A[i] <= 109

Input Format

The only argument given is the integer array A.

Output Format

Return the number of inversions of A modulo (109 + 7).

Example Input

Input 1:
A = [1, 3, 2]

Input 2:
A = [3, 4, 1, 2]


Example Output

Output 1:
1
Output 2:
4

public class Solution {
    private static final int MOD = 1000000007;

    public int solve(int[] A) {
        // Create a temporary array to be used during the merge process
        int[] temp = new int[A.length];
        // Call the modified merge sort function to count inversions
        return mergeSortAndCount(A, temp, 0, A.length - 1);
    }

    // Modified merge sort that returns the number of inversions
    private int mergeSortAndCount(int[] A, int[] temp, int left, int right) {
        int count = 0;
        if (left < right) {
            // Find the mid-point of the array
            int mid = (left + right) / 2;

            // Count inversions in the left half
            count = mergeSortAndCount(A, temp, left, mid) % MOD;

            // Count inversions in the right half
            count = (count + mergeSortAndCount(A, temp, mid + 1, right)) % MOD;

            // Count inversions during the merge step
            count = (count + mergeAndCount(A, temp, left, mid, right)) % MOD;
        }
        return count;
    }

    // Merging two halves and counting the number of inversions
    private int mergeAndCount(int[] A, int[] temp, int left, int mid, int right) {
        int i = left;     // Starting index for left subarray
        int j = mid + 1;  // Starting index for right subarray
        int k = left;     // Starting index to be sorted
        int count = 0;

        while (i <= mid && j <= right) {
            if (A[i] <= A[j]) {
                temp[k++] = A[i++];
            } else {
                // If A[i] > A[j], there are (mid - i + 1) inversions
                temp[k++] = A[j++];
                count = (count + (mid - i + 1)) % MOD;
            }
        }

        // Copy remaining elements of left subarray, if any
        while (i <= mid) {
            temp[k++] = A[i++];
        }

        // Copy remaining elements of right subarray, if any
        while (j <= right) {
            temp[k++] = A[j++];
        }

        // Copy the sorted subarray into original array
        for (i = left; i <= right; i++) {
            A[i] = temp[i];
        }

        return count;
    }
}

