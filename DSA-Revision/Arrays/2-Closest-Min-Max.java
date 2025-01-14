Problem Description

Given an array A, find the size of the smallest subarray such that it contains at least one occurrence of the maximum value of the array

and at least one occurrence of the minimum value of the array.


Problem Constraints
1 <= |A| <= 2000

Input Format
First and only argument is vector A


Output Format
Return the length of the smallest subarray which has at least one occurrence of minimum and maximum element of the array



public class Solution {
    public int solve(int[] A) {

        int min = A[0];

        int max = A[0];

        int i = 1;

        int j = A.length-1;

        while(i <= j){


            min =   Math.min(Math.min( min, A[i]) , A[j] );
            max =   Math.max(Math.max( max, A[i]) , A[j] );

            i++;
            j--;

        }

        if(min == max){
            return 1;
        }

        int size = Integer.MAX_VALUE;

        int count = 0;

        int last = -1;

        for(int k = 0; k < A.length; k++){

            if(A[k]==min || A[k]==max){

                if(A[k]==last || last == -1){

                    count = 1;

                    last = A[k];

                }
                else{

                    size = Math.min(size, count);

                    last = A[k];

                    count = 1;


                }

            }

            count++;


        }

        return size;

    }
}

