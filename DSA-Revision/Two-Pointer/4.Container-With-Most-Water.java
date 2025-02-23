Problem Description

Given N non-negative integers A[0], A[1], ..., A[N-1] , where each represents a point at coordinate (i, A[i]).

N vertical lines are drawn such that the two endpoints of line i is at (i, A[i]) and (i, 0).

Find two lines, which together with x-axis forms a container, such that the container contains the most water. You need to return this maximum area.

Note: You may not slant the container. It is guaranteed that the answer will fit in integer limits.

Problem Constraints

1 <= N <= 105

1 <= A[i] <= 105

Input Format
Single Argument representing a 1-D array A.

Output Format
Return single Integer denoting the maximum area you can obtain.

Example Input

Input 1:
A = [1, 5, 4, 3]
Input 2:
A = [1]

Example Output
Output 1:
 6
Output 2:
 0


public class Solution {
    public int maxArea(int[] A) {

        int i = 0;

        int j = A.length-1;

        int ans = 0;

        while(i < j){

            int temp = (j - i ) * Math.min(A[i], A[j]);

            ans = Math.max(temp, ans);

            if(A[i] < A[j]){
                i++;
            }

            else{
                j--;
            }

        }

        return ans;

    }
}

