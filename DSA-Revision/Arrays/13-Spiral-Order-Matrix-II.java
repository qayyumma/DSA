Problem Description

Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order and return the generated square matrix.

Problem Constraints
1 <= A <= 1000

Input Format
First and only argument is integer A

Output Format
Return a 2-D matrix which consists of the elements added in spiral order.

Example Input
Input 1:
1

Input 2:
2
  
Input 3:
5


Example Output
Output 1:
[ [1] ]

Output 2:
[ [1, 2], 
  [4, 3] ]

Output 3:
[ [1,   2,  3,  4, 5], 
  [16, 17, 18, 19, 6], 
  [15, 24, 25, 20, 7], 
  [14, 23, 22, 21, 8], 
  [13, 12, 11, 10, 9] ]


public class Solution {
    public int[][] generateMatrix(int A) {

        if (A == 1) return new int[][]{{1}};

        int i = 0;

        int j = 0;

        int[][] ans = new int[A][A];

        int start = 0;

        int end = A-1;

        int num = 1;

        while(start <= end){

            i = start;

            j = start;

            for( j = start; j <= end-1; j++){

                ans[i][j] = num++;
            }

            for( i = start; i <= end-1; i++){

                ans[i][j] = num++;
            }

            for( ;j > start; j--){

                ans[i][j] = num++;

            }
            for( ;i > start; i--){

                ans[i][j] = num++;

            }

            if(start==end){
                ans[start][end] = num++;
            }

            start++;
            end--;

        }

        return ans;

    }
}
