

Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.

Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).

Problem Constraints

1 <= |A| <= 100000

1 <= A[i] <= 10^9

1 <= B <= 10^9

Input Format
The first argument given is the integer array A.

The second argument given is integer B.

Output Format
Return the number of pairs for which sum is equal to B modulo (10^9+7).

Example Input
Input 1:
A = [1, 1, 1]
B = 2

Input 2:
A = [1, 5, 7, 10]
B = 8


Example Output
Output 1:
 3

Output 2:
 1


public class Solution {
    public int solve(int[] A, int B) {

        int i = 0;

        int j = A.length-1;

        long count = 0L;

        while(i < j){

            int sum = A[j] + A[i];

            if( sum == B ){

                int copyi = A[i];
                long counti = 1L;

                while( i+1 < j && A[i+1] == copyi){
                    counti++;
                    i++;
                }

                int copyj = A[j];
                long countj = 1L;

                while( i < j-1 && A[j-1] == copyj){
                    countj++;
                    j--;
                }

                if( copyi == copyj ){

                    long temp = counti + countj;

                    count += (temp * (temp - 1)) / 2;

                }
                else{

                    count += counti * countj;
                }
                j--;
                i++;


            }


            else if(sum > B){

                j--;

            }
            else{

                i++;
            }


        }

        return (int) (count % 1000000007);

    }
}
