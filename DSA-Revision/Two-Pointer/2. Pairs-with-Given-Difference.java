Problem Description

Given an one-dimensional integer array A of size N and an integer B.

Count all distinct pairs with difference equal to B.

Here a pair is defined as an integer pair (x, y), where x and y are both numbers in the array and their absolute difference is B.

Problem Constraints

1 <= N <= 104

0 <= A[i], B <= 105

Input Format

First argument is an one-dimensional integer array A of size N.

Second argument is an integer B.

Output Format

Return an integer denoting the count of all distinct pairs with difference equal to B.

Example Input
Input 1:
 A = [1, 5, 3, 4, 2]
 B = 3

Input 2:
 A = [8, 12, 16, 4, 0, 20]
 B = 4

Input 3:
 A = [1, 1, 1, 2, 2]
 B = 0


Example Output
Output 1:
 2
Output 2:
 5
Output 3:
 2

public class Solution {
    public int solve(int[] A, int B) {

        Arrays.sort(A);

        int i = 0;

        int j = 1;

        int n = A.length;

        int count = 0;

        while( j < n){

            int diff = A[j] - A[i];

            if(B == diff){

             //   System.out.print(  diff + "-" + "(" + A[i] + " " + A[j] + ") ");

                count++;

                int copyj = A[j];

                while( j+1 < n && A[j+1] == copyj){
                    j++;
                }

                j++;
                i++;

            }

            else if( diff < B){

                j++;

            }

            else{
                i++;

                if(i >= j){
                    break;
                }
            }



        }

        return count;
    }
}


