Problem Description

Given an unsorted integer array, A of size N. Find the first missing positive integer.

Note: Your algorithm should run in O(n) time and use constant space.

Problem Constraints
1 <= N <= 1000000

-109 <= A[i] <= 109

Input Format
First argument is an integer array A.

Output Format
Return an integer denoting the first missing positive integer.

Example Input
Input 1:
[1, 2, 0]

Input 2:
[3, 4, -1, 1]

Input 3:
[-8, -7, -6]


Example Output
Output 1:
3

Output 2:
2

Output 3:
1


public class Solution {
    public int firstMissingPositive(int[] A) {

        int N = A.length;

        for(int i = 0; i < N; i++){

            if(A[i] <= 0 || A[i] > N ){

                A[i] = N+2;

            }

        }


        for(int i = 0; i < N; i++){

            int ind = Math.abs(A[i]);

            if(ind > 0 && ind <= N && A[ind-1] > 0 ){

                A[ind-1] = -1 * A[ind-1];

            }

        }


        for(int i = 0; i < N; i++){

            if(A[i] > 0 ){
                return i+1;
            }
        }

        return N+1;


    }
}


