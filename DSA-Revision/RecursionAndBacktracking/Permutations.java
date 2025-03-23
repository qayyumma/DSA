Problem Description

Given an integer array A of size N denoting collection of numbers , return all possible permutations.

NOTE:

No two entries in the permutation sequence should be the same.
For the purpose of this problem, assume that all the numbers in the collection are unique.
Return the answer in any order
WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS. 
Example : next_permutations in C++ / itertools.permutations in python.
If you do, we will disqualify your submission retroactively and give you penalty points.


Problem Constraints

1 <= N <= 9



Input Format

Only argument is an integer array A of size N.



Output Format

Return a 2-D array denoting all possible permutation of the array.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

public class Solution {

    int j = 0;

    int[][] ans;    

    public int[][] permute(int[] A) {

        int N = 1;

        for(int i = A.length; i > 1; i--){
            N *= i;
        }

        ans = new int[N][A.length]; 

        rb(A, 0);

        return ans;       
    }

    private void rb(int[] A, int ind){

        if(ind == A.length){

            for(int i = 0; i < A.length; i++){
                ans[j][i] =  A[i];
            }

            j = j+1;

            return;
            
        }

        for(int i = ind; i < A.length; i++){

            swap( A, ind, i);
            rb(A, ind+1);
            swap(A, ind, i);


        }


    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

