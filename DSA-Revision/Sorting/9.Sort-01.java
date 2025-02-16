Problem Description

Given an array A of 0s and 1s of length N. Sort this array.

Note - Do not use any sorting algorithm or library's sort method.

Problem Constraints

1 ≤ N ≤ 105

0 ≤ A[i] ≤ 1

Input Format

First argument A is an array of length N.

Output Format

Return the sorted array.

Example Input

Input 1:
A = [0,0,1,0,1,1,0]

Input 2:
A = [1,0]

Example Output

Output 1:
[0,0,0,0,1,1,1]

Output 2:
[0,1]


public class Solution {
    public int[] sort01(int[] A) {

        int pivot = 1;

        int N = A.length;

        int i = 0;

        int j = A.length-1;

        while(i <= j){

            if( A[i] == 0){

                i++;

            }
            else if( A[j] == 1){

                j--;
            }
            else{

                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;            

            }


        }

        return A;

    }
}

==============================================================


public class Solution {
    public int[] sort01(int[] A) {

        int l = 1;

        int r = A.length-1;

        while( l <= r ){

            if( A[l] < 1){
                l++;
            }
            else if( A[r] > 0){
                r--;
            }
            else if( A[r] < 1 && A[l] > 0 ){

                int temp = A[l];

                A[l] = A[r];

                A[r] = temp;

                l++;

                r--;
            }


        }

        int temp = A[0];

        A[0] = A[r];

        A[r] = temp;

        return A;


    }
}


