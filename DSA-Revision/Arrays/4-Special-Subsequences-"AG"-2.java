Problem Description

You have given a string A having Uppercase English letters.

You have to find the number of pairs (i, j) such that A[i] = 'A', A[j] = 'G' and i < j.


Problem Constraints
1 <= length(A) <= 105


Input Format
First and only argument is a string A.


Output Format
Return an long integer denoting the answer.


public class Solution {
    public long solve(String A) {

        long Anum = 0L;

        long ans = 0L;

        for(int i = 0; i < A.length(); i++){

            if(A.charAt(i)=='A'){
                Anum++;
            }
            else if(A.charAt(i)=='G'){
                ans = ans + Anum;
            }

        }

        return ans;

    }
}


