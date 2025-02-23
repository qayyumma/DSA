Problem Description

Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.

If the answer does not exist return an array with a single integer "-1".

First sub-array means the sub-array for which starting index in minimum.

Problem Constraints

1 <= length of the array <= 100000
1 <= A[i] <= 109
1 <= B <= 109

Input Format

The first argument given is the integer array A.

The second argument given is integer B.

Output Format
Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single integer "-1".

Example Input

Input 1:
 A = [1, 2, 3, 4, 5]
 B = 5
Input 2:
 A = [5, 10, 20, 100, 105]
 B = 110


Example Output
Output 1:
 [2, 3]
Output 2:
 [-1]


public class Solution {
    public int[] solve(int[] A, int B) {

        int sum = A[0];

        int j = 0;

        int i = 0;

        int n = A.length;

        while( j < n){

            if( sum == B){

                int[] ans = new int[j-i+1];

                for(int k = i; k <= j; k++){

                    ans[k-i] = A[k];

                }

                return ans;
            }

            else if( sum < B ){

                j++;

                if( j >= n){
                    return new int[] {-1};
                }

                sum += A[j];

            }

            else{

                sum -= A[i];

                i++;

                if( i >= j ){

                   j = i;

                   if(j < n){
                       sum = A[i];
                   }
                   else break;

                }

            }


        }

        return new int[] {-1};


    }


}


