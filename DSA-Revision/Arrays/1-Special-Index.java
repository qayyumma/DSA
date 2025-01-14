Problem Description

Given an array, arr[] of size N, the task is to find the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.

Problem Constraints
1 <= N <= 105
-105 <= A[i] <= 105
Sum of all elements of A <= 109

Input Format
First argument contains an array A of integers of size N


Output Format
Return the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.



public class Solution {
    public int solve(int[] A) {

        int[] pse = new int[A.length];

        int[] pso = new int[A.length];

        pse[0] = A[0];

        pso[0] = 0;

        for(int i = 1; i < A.length; i++){

            if(i%2==0){

                pse[i] = pse[i-1] + A[i];

                pso[i] = pso[i-1]; 
                
            }

            else{
                pso[i] = pso[i-1] + A[i];

                pse[i] = pse[i-1];
            }
        }

        int se = 0;

        int so = 0;

        int N = A.length;

        int count = 0;

        for(int i = 0; i < A.length; i++){

             //Special Index

            if(i==0){

                so = pse[N-1] - pse[0];

                se = pso[N-1] - pso[0];

            }
            else{

                so = pso[i-1] + pse[N-1] - pse[i];

                se = pse[i-1] + pso[N-1] - pso[i];

            }
            if(se == so){
                count++;

            }
        }

        return count;




    }
}
