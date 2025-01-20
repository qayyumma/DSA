Problem Description

Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.

If the given array contains a sub-array with sum zero return 1, else return 0.

Problem Constraints

1 <= |A| <= 100000

-10^9 <= A[i] <= 10^9

Input Format

The only argument given is the integer array A.

Output Format
Return whether the given array contains a subarray with a sum equal to 0.

Example Input

Input 1:
 A = [1, 2, 3, 4, 5]

Input 2:
 A = [4, -1, 1]


Example Output
Output 1:
 0
Output 2:
 1


public class Solution {
  // Do not write code to include libraries, main() function or accept any input from the console.
  // Initialization code is already written and hidden from you. Do not write code for it again.
  public int solve(int[] A) {
      // Just write your code below to complete the function. Required input is available to you as the function arguments.
      // Do not print the result or any output. Just return the result via this function.

      long[] B = new long[A.length];

      B[0] = A[0];

      for(int i=1; i < A.length; i++){

          B[i] = B[i-1] + A[i];

      }

      HashSet<Long> set = new HashSet<>();

      for(int i = 0; i < A.length; i++){

          if(B[i] == 0){

              return 1;

          }
          set.add(B[i]);

      }

      if(set.size()!=A.length){
          return 1;
      }

      return 0;

  }
}


   
