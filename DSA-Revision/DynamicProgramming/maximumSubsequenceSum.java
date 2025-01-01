Problem Description

You are given an array A of N integers.

Now you are required to determine the maximum sum possible by taking a subsequence such that there are no two consecutive elements taken from array A in the sum.



Problem Constraints

1 ≤ N ≤ 105

1 ≤ A[i] ≤ 2 * 104



Input Format

First argument is the array A of length N.



Output Format

Return an integer equal to the maximum subsequence sum possible according to the problem.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


public class Solution {
    public int maxSubsequenceSum(int[] A) {

        if(A.length == 1){
            return A[0];
        }

        int f1 = A[0];

        int f2 = Math.max(A[0], A[1]);

        int curr = Math.max(A[0], A[1]);

        for(int i = 2; i < A.length; i++){

            curr = Math.max( f1+A[i], f2 );

            f1 = f2;

            f2 = curr;

        }

        return curr; 

    }
}


--------------------------------------------------------------------------------------------------------------------------------------------------------


public class MaxNonAdjacentSubsequenceSum {
    public static int maxSubsetSum(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        if (n == 1) return arr[0];

        int prev2 = arr[0];
        int prev1 = Math.max(arr[0], arr[1]);
        
        for (int i = 2; i < n; i++) {
            int current = Math.max(prev1, arr[i] + prev2);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 10, 7}; // Example array
        System.out.println("Maximum sum of non-adjacent subsequence: " + maxSubsetSum(arr));
    }
}

// time complexity -- N
// space complexity -- 1
