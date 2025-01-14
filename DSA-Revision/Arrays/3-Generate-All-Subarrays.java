Problem Description

You are given an array A of N integers.
Return a 2D array consisting of all the subarrays of the array

Note : The order of the subarrays in the resulting 2D array does not matter.


Problem Constraints
1 <= N <= 100
1 <= A[i] <= 105


Input Format
First argument A is an array of integers.


Output Format
Return a 2D array of integers in any order.


public class Solution {
    public int[][] solve(int[] A) {
        
        int N = A.length;

        int size = N * (N+1) / 2;

        int ind = 0;

        int[][] ans = new int[size][];

        for(int i = 0; i < size; i++){

            for(int j = i; j < N; j++){

                ans[ind] = new int[j-i+1];

                for(int k = i; k <= j; k++){

                    ans[ind][k-i] = A[k];

                }

                ind++;

            }

        }

        return ans;

    }
}


  
