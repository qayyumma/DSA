Problem Description

Farmer John has built a new long barn with N stalls. Given an array of integers A of size N where each element of the array represents the location of the stall and an integer B which represents the number of cows.

His cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, John wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?

Problem Constraints

2 <= N <= 100000
0 <= A[i] <= 109
2 <= B <= N


Input Format
The first argument given is the integer array A.
The second argument given is the integer B.


Output Format
Return the largest minimum distance possible among the cows.


Example Input

Input 1:
A = [1, 2, 3, 4, 5]
B = 3

Input 2:
A = [1, 2]
B = 2


Example Output
Output 1:
 2

Output 2:
 1

public class Solution {
    public int solve(int[] A, int B) {

        Arrays.sort(A);

        int min = Integer.MAX_VALUE;

        int max = A[A.length-1] - A[0]; 

        int N = A.length;

        for(int i = 1; i < N; i++){

            min = Math.min(min, A[i] - A[i-1]);

        }

        int ans= 0;

        while(min <= max){

            int mid = min + (max - min) / 2;

            if(cowSegregation(B, mid, A )){

                ans = mid;

                min = mid + 1;

            }
            else{

                max = mid -1;

            }

        }

        return ans;

    }

    private boolean cowSegregation(int B, int M, int[] A){

        int last = 0;

        int n = 1;

        for(int i = 1; i < A.length; i++){

            if( (A[i] - A[last]) >= M ){

                n++;

                last = i;

            }

            if(n==B){
                return true;
            }

        }

        return false;

    }
}

