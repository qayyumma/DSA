Problem Description

Given a grid of size n * m, lets assume you are starting at (1,1) and your goal is to reach (n, m). 
At any instance, if you are on (x, y), you can either go to (x, y + 1) or (x + 1, y).

Now consider if some obstacles are added to the grids. 
Return the total number unique paths from (1, 1) to (n, m).

Note: 
1. An obstacle is marked as 1 and empty space is marked 0 respectively in the grid.
2. Given Source Point and Destination points are 1-based index.



Problem Constraints

1 <= n, m <= 100
A[i][j] = 0 or 1


Input Format

Firts and only argument A is a 2D array of size n * m.


Output Format

Return an integer denoting the number of unique paths from (1, 1) to (n, m).

---------------------------------------------------------------------------------------------------------------------------------------------------------------------


public class Solution {
    public int uniquePathsWithObstacles(int[][] A) {

        int N = A.length;

        int M = A[0].length;

        int[][] r = new int[N][M];

        for(int i = 0; i < M; i++){
            if(A[0][i]==1){
               // r[0][i] = 0;
                break;
            }
            else{
                r[0][i] = 1;
            }
        }


        for(int i = 0; i < N; i++){
            if(A[i][0]==1){
              // r[i][0] = 0;
               break;
            }
            else{
                r[i][0] = 1;
            }
        }



        for(int i = 1; i < N; i++){

            for(int j = 1; j < M; j++){

                if(A[i][j] == 1){
                    r[i][j] = 0;
                   // break;
                }

                else{
                    r[i][j] = (r[i][j-1] + r[i-1][j]);
                }

            }
        }

        return r[N-1][M-1];

    }
}




