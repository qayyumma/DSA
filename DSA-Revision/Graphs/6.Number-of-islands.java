Problem Description

Given a matrix of integers A of size N x M consisting of 0 and 1. A group of connected 1's forms an island. From a cell (i, j) such that A[i][j] = 1 you can visit any cell that shares a corner with (i, j) and value in that cell is 1.

More formally, from any cell (i, j) if A[i][j] = 1 you can visit:

(i-1, j) if (i-1, j) is inside the matrix and A[i-1][j] = 1.
(i, j-1) if (i, j-1) is inside the matrix and A[i][j-1] = 1.
(i+1, j) if (i+1, j) is inside the matrix and A[i+1][j] = 1.
(i, j+1) if (i, j+1) is inside the matrix and A[i][j+1] = 1.
(i-1, j-1) if (i-1, j-1) is inside the matrix and A[i-1][j-1] = 1.
(i+1, j+1) if (i+1, j+1) is inside the matrix and A[i+1][j+1] = 1.
(i-1, j+1) if (i-1, j+1) is inside the matrix and A[i-1][j+1] = 1.
(i+1, j-1) if (i+1, j-1) is inside the matrix and A[i+1][j-1] = 1.
Return the number of islands.

NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.



Problem Constraints
1 <= N, M <= 100
0 <= A[i] <= 1



Input Format
The only argument given is the integer matrix A.


Output Format
Return the number of islands.


public class Solution {
    public int solve(int[][] A) {

        int count = 0;

        for(int i = 0; i < A.length; i++){

            for(int j = 0; j < A[0].length; j++){

                if(A[i][j]==1){

                    count++;

                    dft(A, i, j);

                }
            }
        }

        return count;

    }

    public void dft(int[][] arr, int i, int j){

        if(i < 0 || j < 0 || i > arr.length-1 || j > arr[0].length-1){

            return;
        }

        if(arr[i][j] == 0 || arr[i][j]==2){

            return;
        }

        arr[i][j] = 2;

        dft(arr, i, j+1);
        dft(arr, i, j-1);
        dft(arr, i+1, j);
        dft(arr, i-1, j);
        dft(arr, i-1, j-1);
        dft(arr, i-1, j+1);
        dft(arr, i+1, j-1);
        dft(arr, i+1, j+1);

    }
}


=================================================================================================================================================


public class Solution {

    private int[][] directions = { {0, -1}, {0, 1}, {-1, 0}, {1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1} };

    private void dfs(int[][] A, int i, int j ){

        A[i][j] = 2;

        for(int[] dir: directions ){

            int left = dir[0] + i;

            int rigth = dir[1] + j;

            if(isIsland( left, rigth, A)){

                dfs(A, left, rigth);

            }


        }


    }

    private boolean isIsland( int i, int j, int[][] A ){

        return i >= 0 && j >= 0 && i < A.length && j < A[i].length && A[i][j] == 1;

    }

    public int solve(int[][] A) {

        int ans = 0;

        for(int i = 0; i < A.length; i++){

            for(int j = 0; j < A[i].length; j++){

                if(A[i][j]==1){
                    dfs(A, i, j);
                    ans++;
                }

            }

        }

        return ans;

    }
}


