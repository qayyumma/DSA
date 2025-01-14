Problem Description
Find the maximum sum of contiguous non-empty subarray within an array A of length N.

Problem Constraints
1 <= N <= 1e6
-1000 <= A[i] <= 1000


Input Format
The first and the only argument contains an integer array, A.


Output Format
Return an integer representing the maximum possible sum of the contiguous subarray.


public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxSubArray(final int[] A) {

        int ans = Integer.MIN_VALUE;

        int c = 0;

        int N = A.length;

        for(int i = 0; i < N; i++){

            if(c < 0){
            
                c = A[i];
            
            }

            else{

                c += A[i];

            }

            ans = Math.max(ans, c);

        }

        return ans;


    }
}


