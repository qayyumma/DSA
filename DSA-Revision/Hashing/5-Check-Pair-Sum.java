Problem Description

Given an Array of integers B, and a target sum A.

Check if there exists a pair (i,j) such that Bi + Bj = A and i!=j.

Problem Constraints
1 <= Length of array B <= 105
0 <= Bi <= 109
0 <= A <= 109

Input Format
First argument A is the Target sum, and second argument is the array B

Output Format
Return an integer value 1 if there exists such pair, else return 0.

Example Input
Input 1:
A = 8   
B = [3, 5, 1, 2, 1, 2]
Input 2:
A = 21   
B = [9, 10, 7, 10, 9, 1, 5, 1, 5]


Example Output
Output 1:
1
Output 2:
0


public class Solution {
    public int solve(int A, int[] B) {

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < B.length; i++){

            int r = A - B[i];

            if(set.contains(r)){
                return 1;
            }

            set.add(B[i]);

        }

        return 0;

    }
}

