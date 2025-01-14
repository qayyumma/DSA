Problem Description

Given an array A of length N. Also given are integers B and C.

Return 1 if there exists a subarray with length B having sum C and 0 otherwise


Problem Constraints
1 <= N <= 105
1 <= A[i] <= 104
1 <= B <= N
1 <= C <= 109


Input Format
First argument A is an array of integers.
The remaining arguments B and C are integers


Output Format
Return 1 if such a subarray exist and 0 otherwise


public class Solution {
    public int solve(int[] A, int B, int C) {

        int i = 0;

        int j = 0;

        int sum = 0;

        for( i = 0; i < B; i++){

            sum += A[i];

        }

        if(sum==C){
            return 1;
        }

        while(  j < A.length-B ){

            sum = sum - A[j++] + A[i++];

            if(sum==C){
                return 1;
            }

        }


        return 0;


    }
}

