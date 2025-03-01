Problem Description

The demons had captured the princess and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

Given a 2D array of integers A of size M x N. Find and return the knight's minimum initial health so that he is able to rescue the princess.



Problem Constraints

1 <= M, N <= 500

-100 <= A[i] <= 100



Input Format

First and only argument is a 2D integer array A denoting the grid of size M x N.



Output Format

Return an integer denoting the knight's minimum initial health so that he is able to rescue the princess.


-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

public class Solution {
    public int calculateMinimumHP(int[][] A) {

        int N = A.length;

        int M = A[0].length;

        int[][] arr = new int[N][M];

        int x = 1 - A[N-1][M-1];

        if(x < 1){
            x = 1;
        }

        arr[N-1][M-1] = x;

        for(int i = N-2; i >=0; i--){

            x = arr[i+1][M-1] - A[i][M-1];

            if(x < 1){
                x = 1;
            }

            arr[i][M-1] = x;
        }


        for(int i = M-2; i >=0; i--){

            x = arr[N-1][i+1] - A[N-1][i];

            if(x < 1){
                x = 1;
            }

            arr[N-1][i] = x;
        }


        for(int i = N-2; i >= 0; i--){

            for(int j = M-2; j >= 0; j--){

                x = Math.min(arr[i][j+1], arr[i+1][j]) - A[i][j];

                if(x < 1){
                    x = 1;
                }

                arr[i][j] = x;

            }

        }

        return arr[0][0];

    }
}



