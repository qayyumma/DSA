Problem Description

Given an array of integers A with N elements and a target integer B, the task is to find all the indices at which B occurs in the array.

Note: The problem encourages recursive logic for learning purposes. Although the online judge doesn't enforce recursion, it's recommended to use recursive solutions to align with the question's spirit.


Problem Constraints

1 <= N <= 103
1 <= A[i] <= 103
1 <= B <= 103
It is guaranteed that the target B, exist atleast once in the Array A.


Input Format

First Argument in an Array of Integers, A.
Second Argument is the Target, B.


Output Format

Return the sorted array of indices.
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

public class Solution {
    public int[] allIndices(int[] A, int B) {

        return find(A, B, 0, 0);

    }
    public int[] find(int[] A, int B, int i, int count){

        if(i==A.length){
            return new int[count];
        }

        int[] ans;
        if(A[i]==B){
            ans = find(A, B, i+1, count+1);
            ans[count] = i;
        }
        else{
            ans = find(A, B, i+1, count);
        }
        return ans;

    }
}
